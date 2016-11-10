package org.farrukh.experiments.quickfixj.server.hendler;

import org.farrukh.experiments.quickfixj.server.data.InMemoryRefDataProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fixt11.Logon;
import quickfix.fixt11.Logout;
import quickfix.fixt11.Message;
import quickfix.fixt11.MessageCracker;

public class LogonMsgHandler extends MessageCracker implements MsgHandler {

	private final InMemoryRefDataProvider inMemoryRefDataProvider;

	public LogonMsgHandler() {
		this.inMemoryRefDataProvider = new InMemoryRefDataProvider();
	}

	@Override
	public void onMessage(Logon message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
		if (!validateLogonMsg(message)) {
			//Session.lookupSession(sessionID).send(new Logout());
		}
	}

	@Override
	public void handle(Message message, SessionID sessionId) {
		try {
			crack11(message, sessionId);
		} catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
			throw new FixException(e);
		}
	}

	private boolean validateLogonMsg(Logon message) {
		if (message.isSetUsername() && message.isSetPassword()) {
			return inMemoryRefDataProvider.getLogons().contains(message);
		}
		return false;
	}

}
