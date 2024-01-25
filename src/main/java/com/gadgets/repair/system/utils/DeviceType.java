package com.gadgets.repair.system.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gadgets.repair.system.exceptions.InvalidEnumValueException;

public enum DeviceType {
    SMARTPHONE("smartphone"),
    LAPTOP("laptop"),
    TABLET("tablet"),
    DESKTOP("desktop"),
    SMARTWATCH("smartwatch"),
    OTHER("other");

    private String deviceType;

    private DeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonValue
    public String getDeviceType() {
        return deviceType;
    }

    @JsonCreator
    public static DeviceType forValues(String deviceType) {
        for (DeviceType deviceType1 : DeviceType.values()) {
            if (deviceType1.deviceType.equalsIgnoreCase(deviceType)) {
                return deviceType1;
            }
        }
        throw new InvalidEnumValueException("Invalid device type value! ");
    }
}