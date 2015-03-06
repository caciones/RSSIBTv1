package com.caciones.rssibtv1.Domain;

import com.orm.SugarRecord;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class MeasurementsDomain extends SugarRecord<MeasurementsDomain>{

    RoomDomain room;
    int coordX;
    int coordY;
    double measurement;

    public MeasurementsDomain(){
    }

    public MeasurementsDomain(RoomDomain room, int coordX, int coordY, double measurement){

        this.room = room;
        this.coordX = coordX;
        this.coordY = coordY;
        this.measurement =  measurement;
    }

    public RoomDomain getRoom() {
        return room;
    }

    public void setRoom(RoomDomain room) {
        this.room = room;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof MeasurementsDomain ){
            if(((MeasurementsDomain) obj).getCoordX() == this.getCoordX() && ((MeasurementsDomain) obj).getCoordY() == this.getCoordY() &&
                    ((MeasurementsDomain) obj).getMeasurement() == this.getMeasurement()  && ((MeasurementsDomain) obj).getRoom().equals(this.getMeasurement())  ){
            return true;
            }else {
                return false;
            }
        }else{
            return false;
        }


    }


    @Override
    public String toString(){
        return this.getRoom().toString() + ' ' + this.getCoordX() + ' ' + this.getCoordY() + ' ' + this.getMeasurement();
    }


}
