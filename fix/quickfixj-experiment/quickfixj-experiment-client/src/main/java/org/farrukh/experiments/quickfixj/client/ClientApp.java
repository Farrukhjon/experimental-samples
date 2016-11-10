package org.farrukh.experiments.quickfixj.client;

import java.util.concurrent.CountDownLatch;

import org.farrukh.experiments.quickfixj.client.data.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.client.data.RefDataMessageHandler;
import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;
import quickfix.field.MsgType;
import quickfix.field.Password;
import quickfix.field.Username;
import quickfix.fixt11.Logon;

/**
 * Fix Client Engine App.
 *
 */
public class ClientApp extends ApplicationAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ClientApp.class);

	private static final String USER_NAME = "super_user";

	private static final String CONFIG_FILE = "client.cfg";

	private static final CountDownLatch shutdown_latch = new CountDownLatch(1);

	private final Initiator initiator;

	private final RefDataMessageHandler refDataMessageHandler;

	private final MarketDataMessageHandler marketDataMessageHandler;

	public ClientApp() {
		SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
		LogFactory logFactory = new CompositeLogFactory(
				new LogFactory[] { new FileLogFactory(settings), new SLF4JLogFactory(settings) });
		try {
			initiator = new SocketInitiator(this, new FileStoreFactory(settings), settings, logFactory, new DefaultMessageFactory());
		} catch (ConfigError e) {
			throw new FixException(e);
		}
		refDataMessageHandler = new RefDataMessageHandler();
		marketDataMessageHandler = new MarketDataMessageHandler();
	}

	@Override
	public void onCreate(SessionID sessionId) {
		String targetSubID = sessionId.getTargetSubID();
		if(targetSubID.equals("SERVER-REF-DATA")) {
			Session.lookupSession(sessionId).send(new Logon());
		}
	}

	@Override
	public void toApp(Message message, SessionID sessionId) {
		try {
			String msgType = message.getHeader().getField(new MsgType()).getValue();
			if(Logon.MSGTYPE.equals(msgType)) {
				message.setField(new Username(USER_NAME));
				message.setField(new Password("super_password"));
				logger.debug(msgType);
			}
		} catch (FieldNotFound e) {
			e.printStackTrace();
		}
	}
	
/*	@Override
	public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		refDataMessageHandler.handle(message, sessionId);
	}
	*/

	private void start() {
		try {
			initiator.start();
		} catch (RuntimeError | ConfigError e) {
			throw new FixException(e);
		}
	}

	public static void main(String[] args) {
		ClientApp clientApp = new ClientApp();
		clientApp.start();
		try {
			shutdown_latch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
