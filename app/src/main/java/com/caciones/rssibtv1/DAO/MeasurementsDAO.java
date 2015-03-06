package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.MeasurementsDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;
import com.orm.SugarRecord;

import java.util.Iterator;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class MeasurementsDAO {

    public static Iterator<MeasurementsDomain> getAllMeasures(){

        Iterator<MeasurementsDomain> measures = MeasurementsDomain.findAll(MeasurementsDomain.class);

        return measures;
    }

    public static void saveMeasure(RoomDomain room, int coordX, int coordY, double measurement){
        MeasurementsDomain measure = new MeasurementsDomain(room, coordX, coordY, measurement);
        measure.save();

    }

    public static MeasurementsDomain loadMeasure(long id){

        return SugarRecord.findById(MeasurementsDomain.class, id);
    }


    public void read(){}

    public static MeasurementsDomain updateMeasure(MeasurementsDomain measure, RoomDomain room, int coordX, int coordY, double measurement){
        measure.setRoom(room);
        measure.setCoordX(coordX);
        measure.setCoordY(coordY);
        measure.setMeasurement(measurement);

        measure.save();

        return measure;
    }

    public void deleteMeasure(MeasurementsDomain measure){
        measure.delete();
    }
}
