package com.caciones.rssibtv1;

import com.caciones.rssibtv1.DAO.MeasurementsDAO;
import com.caciones.rssibtv1.Domain.MeasurementsDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import junit.framework.TestCase;

/**
 * Created by Lenovo on 06/03/2015.
 */

public class MeasurementsDAOTest extends TestCase {


    public void testCreateMeasurements(){

        RoomDomain roomTest = new RoomDomain("casa2", 6,7, "casaBT2");
        roomTest.save();

        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, 4, 5, 5.0);
        measureTest.save();



        assertEquals(measureTest, MeasurementsDAO.loadMeasure(1));
    }

}