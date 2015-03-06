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
        if(obj instanceof RoomDomain && ((RoomDomain) obj).getLength() == this.getLength() && ((RoomDomain) obj).getWidth() == this.getWidth() &&
                ((RoomDomain) obj).getName().equals(this.getName())  && ((RoomDomain) obj).getNameBT().equals(this.getNameBT())){
            /*if(((RoomDomain) obj).getLength() == this.getLength() && ((RoomDomain) obj).getWidth() == this.getWidth() &&
                    ((RoomDomain) obj).getName() == this.getName() && ((RoomDomain) obj).getNameBT() == this.getNameBT()){*/
                return true;
           /* }else {
                return false;
            }*/
        }else{
            return false;
        }


    }


    @Override
    public String toString(){
        return this.getName() + ' ' + this.getLength() + ' ' + this.getWidth() + ' ' + this.getNameBT();
    }

}
