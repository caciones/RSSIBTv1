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
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getNameBT() {
        return this.nameBT;
    }

    public void setNameBT(String nameBT) {
        this.nameBT = nameBT;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof RoomDomain){
            if(((RoomDomain) obj).getLength() == this.length && ((RoomDomain) obj).getWidth() == this.width &&
                ((RoomDomain) obj).getName().equals(this.name)  && ((RoomDomain) obj).getNameBT().equals(this.nameBT)){
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }


    }


    @Override
    public String toString(){
        return this.getName() + ' ' + this.getLength() + ' ' + this.getWidth() + ' ' + this.getNameBT();
    }

}
