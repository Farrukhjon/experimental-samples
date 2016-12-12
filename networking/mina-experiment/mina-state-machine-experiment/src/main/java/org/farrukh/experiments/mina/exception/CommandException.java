package org.farrukh.experiments.mina.exception;

import org.apache.mina.filter.codec.ProtocolDecoderException;

public class CommandException extends ProtocolDecoderException {
    
    private final String message;
    
    public CommandException(String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }

  
}
