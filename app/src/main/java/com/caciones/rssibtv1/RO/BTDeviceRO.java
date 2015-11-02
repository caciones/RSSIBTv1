package com.caciones.rssibtv1.RO;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Lenovo on 27/03/2015.
 */
public class BTDeviceRO {
    //TODO chamar a lista de nomes dos devices e os valores da listBTDevices para depois meter no view(activity2)

    private String btName;
    private int rssiValue;
    private String address;
    private BluetoothDevice device;

    public BTDeviceRO(){

    }

    public BTDeviceRO(String btName, int rssiValue, String address, BluetoothDevice device){
        this.btName = btName;
        this.rssiValue = rssiValue;
        this.address = address;
        this.device = device;
    }
    public BTDeviceRO(BluetoothDevice device, int rssi){
        this.btName = device.getName();
        this.rssiValue = rssi;
        this.address = device.getAddress();
        this.device = device;
    }
    public BTDeviceRO(String btName){
        this.btName = btName;

    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public int getRssiValue() {
        return rssiValue;
    }

    public void setRssiValue(int rssiValue) {
        this.rssiValue = rssiValue;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){
        return "Name: " + this.btName + "; value: " + this.rssiValue;
    }


    public BluetoothDevice getDevice() {
        return device;
    }


}
