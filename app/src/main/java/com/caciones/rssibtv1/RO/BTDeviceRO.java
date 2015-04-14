package com.caciones.rssibtv1.RO;

/**
 * Created by Lenovo on 27/03/2015.
 */
public class BTDeviceRO {
    //TODO chamar a lista de nomes dos devices e os valores da listBTDevices para depois meter no view(activity2)

    private String btName;
    private int rssiValue;

    public BTDeviceRO(){

    }

    public BTDeviceRO(String btName, int rssiValue){
        this.btName = btName;
        this.rssiValue = rssiValue;
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
}
