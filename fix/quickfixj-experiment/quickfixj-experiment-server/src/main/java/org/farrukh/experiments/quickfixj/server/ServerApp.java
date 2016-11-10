package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.server.hendler.LogonMsgHandler;
import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Acceptor;
import quickfix.ApplicationAdapter;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RejectLogon;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.field.MsgType;
import quickfix.fixt11.Logon;

/**
 * Fix Engine Server App.
 *
 */
public class ServerApp extends ApplicationAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(ServerApp.class);

    private static final String CONFIG_FILE = "server.cfg";

    private final Acceptor acceptor;

    public ServerApp() {
        try {
            SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
            MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new CompositeLogFactory(new LogFactory[]{new SLF4JLogFactory(settings), new FileLogFactory(settings)});
            MessageFactory messageFactory = new DefaultMessageFactory();
            acceptor = new SocketAcceptor(this, messageStoreFactory, settings, logFactory, messageFactory);
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }

    public void start() {
        try {
            acceptor.start();
        } catch (RuntimeError | ConfigError e) {
            throw new FixException(e);
        }
    }
    
    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
    	String msgType = message.getHeader().getField(new MsgType()).getValue();
		logger.debug(msgType);
        if (Logon.MSGTYPE.equals(msgType)) {
            logger.info("This logon message has been received via session: {} and message: {}", sessionId, message.toString());
            LogonMsgHandler logonMsgHandler = new LogonMsgHandler();
            logonMsgHandler.handle((quickfix.fixt11.Message) message, sessionId);
        }
    }

    public static void main(String[] args) {
        ServerApp app = new ServerApp();
        app.start();
    }

}
