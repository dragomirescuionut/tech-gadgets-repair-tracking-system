package com.gadgets.repair.system.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gadgets.repair.system.exceptions.InvalidEnumValueException;

public enum Manufacturer {
    ASUS("asus"),
    CORSAIR("corsair"),
    DELL("dell"),
    INTEL("intel"),
    AMD("amd");

    private String manufacturerName;

    private Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @JsonValue
    public String getManufacturerName() {
        return manufacturerName;
    }

    @JsonCreator
    public static Manufacturer forValues(String manufacturerNameStr) {
        for (Manufacturer manufacturer : Manufacturer.values()) {
            if (manufacturer.manufacturerName.equalsIgnoreCase(manufacturerNameStr)) {
                return manufacturer;
            }
        }
        throw new InvalidEnumValueException("Invalid manufacturer value!");
    }
}