package org.farrukh.experiments.quickfixj.client;

import quickfix.SessionID;

public interface MessageOutboudGateway {
    
    void send(SessionID sessionId);

}
