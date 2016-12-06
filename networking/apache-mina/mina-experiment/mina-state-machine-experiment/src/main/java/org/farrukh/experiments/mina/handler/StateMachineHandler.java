package org.farrukh.experiments.mina.handler;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.statemachine.StateMachine;
import org.apache.mina.statemachine.StateMachineFactory;
import org.apache.mina.statemachine.StateMachineProxyBuilder;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.farrukh.experiments.mina.state.SearchEditor;

public class StateMachineHandler {

    private final IoHandler ioHandler;

    public StateMachineHandler() {
        StateMachine stateMachine = StateMachineFactory.getInstance(IoHandlerTransition.class).create(new SearchEditor());
        ioHandler = new StateMachineProxyBuilder().create(IoHandler.class, stateMachine);
    }

    public IoHandler getIoHandler() {
        return ioHandler;
    }

}
