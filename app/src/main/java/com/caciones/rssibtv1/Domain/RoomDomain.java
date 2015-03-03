package com.caciones.rssibtv1.Domain;

import com.orm.SugarRecord;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class RoomDomain extends SugarRecord<RoomDomain>{


    String name;
    double width;
    double length;
    String nameBT;

    public RoomDomain(){
    }

    public RoomDomain(String name, double width, double length, String nameBT){

        this.name = name;
        this.width = width;
        this.length = length;
        this.nameBT = nameBT;


    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getNameBT() {
        return nameBT;
    }

    public void setNameBT(String nameBT) {
        this.nameBT = nameBT;
    }

    public String getName() {
        return name;
    }
}
