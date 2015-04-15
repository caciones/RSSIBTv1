package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.MeasurementsDAO;
import com.caciones.rssibtv1.Domain.MeasurementsDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.List;

/**
 * Created by Lenovo on 27/03/2015.
 */
public class MeasurementsController {



    //receber os paramentros do Measurement

    public void createMeasurement(RoomDomain room, int coordX, int coordY, double measurement){
        MeasurementsDAO.saveMeasure(room, coordX, coordY, measurement);
    }

    public List<MeasurementsDomain> loadMeasurements(String name){

        return MeasurementsDAO.findAllMeasurementsAtRoom(name);

    }

    public List<MeasurementsDomain> loadAllMeasurements(String nameRoom){

        List<MeasurementsDomain> measurementsDomainList = MeasurementsDAO.findAllMeasurementsAtRoom(nameRoom);

        return measurementsDomainList;
    }

}
