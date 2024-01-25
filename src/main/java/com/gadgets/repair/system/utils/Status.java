package com.gadgets.repair.system.utils;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gadgets.repair.system.exceptions.InvalidEnumValueException;

public enum Status {
    OPEN("open"),
    IN_PROGRESS("in progress"),
    COMPLETED("completed");
    private String statusCode;

    private Status(String statusCode) {
        this.statusCode = statusCode;
    }

    @JsonValue
    public String getStatus() {
        return statusCode;
    }

    @JsonCreator
    public static Status forValues(String statusStr) {
        for (Status status : Status.values()) {
            if (status.statusCode.equalsIgnoreCase(statusStr)) {
                return status;
            }
        }
        throw new InvalidEnumValueException("Invalid status value! ");
    }
}