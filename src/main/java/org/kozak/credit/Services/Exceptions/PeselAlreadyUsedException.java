package org.kozak.credit.Services.Exceptions;

public class PeselAlreadyUsedException extends Exception{
    public PeselAlreadyUsedException(String message){
        super(message);
    }
}
