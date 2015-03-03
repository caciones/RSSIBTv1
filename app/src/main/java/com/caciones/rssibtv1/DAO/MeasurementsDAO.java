package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.MeasurementsDomain;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class MeasurementsDAO {


    public void create(){}
    public void read(){}
    public void update(MeasurementsDomain measurement){
        measurement.save();
    }
    public void delete(MeasurementsDomain measurement){
        measurement.delete();
    }
}
