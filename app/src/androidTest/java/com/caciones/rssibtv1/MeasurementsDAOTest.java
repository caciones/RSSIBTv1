package com.caciones.rssibtv1;

import com.caciones.rssibtv1.DAO.MeasurementsDAO;
import com.caciones.rssibtv1.Domain.MeasurementsDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 06/03/2015.
 */

public class MeasurementsDAOTest extends TestCase {

    @Override
    public void setUp(){

        MeasurementsDomain.deleteAll(MeasurementsDomain.class);

    }


    public void testCreateMeasurements(){

        RoomDomain roomTest = new RoomDomain("casa2", 6,7, "casaBT2");
        roomTest.save();

        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, 4, 5, 5.0);
        measureTest.save();

        assertEquals(measureTest, MeasurementsDAO.loadMeasure(1));
    }

    public void testQueryfindAllMeasurementsAtRoom(){

        MeasurementsDomain.deleteAll(MeasurementsDomain.class);
        RoomDomain.deleteAll(RoomDomain.class);

        int n = 5;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain("home", n,n, "homeBT");
        roomTest.save();

        List<MeasurementsDomain> list = new ArrayList<>();

        for(int i = 1; i<=n ; i++){
            for(int j = 1 ; j<=n ; j++){
                MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, j, i, measurement+i+j);
                measureTest.save();
                list.add(measureTest);
            }
        }

        assertEquals(list, MeasurementsDAO.findAllMeasurementsAtRoom(roomTest.getName()));

    }

    public void testMeasurementsUpdates(){

        MeasurementsDomain.deleteAll(MeasurementsDomain.class);

        int i = 5;
        int j = 4;
        int n = 6;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain("home", n,n, "homeBT");
        roomTest.save();


        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, j, i, measurement+i+j);
        measureTest.save();



        MeasurementsDAO.updateMeasure(measureTest, roomTest, 4, 5, 6.0);


        assertEquals(new MeasurementsDomain(roomTest,4,5,6.0),measureTest);


    }

    //find all measurements by room
    //teste para ver se o delete apaga tudo e o count fica a 0
}