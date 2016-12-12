package org.farrukh.experiments.mina.state;

import static org.apache.mina.statemachine.event.IoHandlerEvents.MESSAGE_RECEIVED;
import static org.apache.mina.statemachine.event.IoHandlerEvents.SESSION_CREATED;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.annotation.State;

public class SearchEditor {
    
    @State
    public static final String ROOT = "Root";

    @State(ROOT)
    public static final String START = "Start";
    
    @State(ROOT)
    public static final String SEARCHING = "Searching";

    @State(ROOT)
    public static final String SEARCHING_COMPLETE = "Search complete";

    @State(ROOT)
    public static final String SELECTION = "Selection";

    @State(ROOT)
    public static final String NO_SELECTION = "No selection";

    @State(ROOT)
    public static final String EDITIONG = "Editing";
    
    @IoHandlerTransition(on = SESSION_CREATED, in = START)
    public void search(IoSession session) {
        
    }

    @IoHandlerTransition(on = MESSAGE_RECEIVED, in = START)
    public void select(IoSession session) {
        
    }

    @IoHandlerTransition(on = MESSAGE_RECEIVED, in = START)
    public void deSelect(IoSession session) {
        
    }

    @IoHandlerTransition(on = MESSAGE_RECEIVED, in = START)
    public void edit(IoSession session) {
        
    }
    

}
