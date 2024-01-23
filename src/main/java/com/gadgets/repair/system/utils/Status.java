package com.gadgets.repair.system.utils;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gadgets.repair.system.exceptions.InvalidEnumValueException;

import java.util.Arrays;

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
}