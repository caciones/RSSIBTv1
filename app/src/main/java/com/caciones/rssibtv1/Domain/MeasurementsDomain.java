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



}
