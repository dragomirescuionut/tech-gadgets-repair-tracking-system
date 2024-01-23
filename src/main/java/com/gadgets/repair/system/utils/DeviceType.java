package com.gadgets.repair.system.utils;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DeviceType {
    SMARTPHONE("smartphone"),
    LAPTOP("laptop"),
    TABLET("tablet"),
    DESKTOP("desktop"),
    SMARTWATCH("smartwatch"),
    OTHER("other");

    private String deviceType;
    private DeviceType(String deviceType){
        this.deviceType = deviceType;
    }
    @JsonValue
    public String getDeviceType(){
        return deviceType;
    }
}