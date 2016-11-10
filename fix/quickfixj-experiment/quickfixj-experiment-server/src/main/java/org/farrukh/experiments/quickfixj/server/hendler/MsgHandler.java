package org.farrukh.experiments.quickfixj.server.hendler;

import quickfix.SessionID;
import quickfix.fixt11.Message;

public interface MsgHandler {
	
	void handle(final Message message, final SessionID sessionId);

}
