package com.gadgets.repair.system.exceptions;

import java.util.Arrays;

public class InvalidEnumValueException extends RuntimeException{
    public InvalidEnumValueException(String message){
        super(message);
    }
}
