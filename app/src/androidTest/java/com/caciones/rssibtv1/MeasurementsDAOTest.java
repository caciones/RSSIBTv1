package com.caciones.rssibtv1;

import android.test.suitebuilder.annotation.MediumTest;

import com.caciones.rssibtv1.DAO.MeasurementsDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.MeasurementsDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;
import com.orm.SugarRecord;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 06/03/2015.
 */

public class MeasurementsDAOTest extends TestCase {

    @MediumTest
    public void testCreateMeasurements(){

       // SugarRecord.deleteAll(BuildingDomain.class);
        SugarRecord.deleteAll(MeasurementsDomain.class);
        SugarRecord.deleteAll(RoomDomain.class);


        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        RoomDomain roomTest = new RoomDomain(larTest, "casa2", 6,7, "casaBT2");
        roomTest.save();

        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, 4, 5, 5.0);
        measureTest.save();



        assertEquals(measureTest, MeasurementsDAO.loadMeasure(measureTest.getId()));
    }

    @MediumTest
    public void testQueryfindAllMeasurementsAtRoom(){
//descobrir qual o problema entre o  SugarRecord.deleteAll(MeasurementsDomain.class) e  RoomDomain.deleteAll(RoomDomain.class) nao se percebe bem o funcionamento

        SugarRecord.deleteAll(MeasurementsDomain.class);
        RoomDomain.deleteAll(RoomDomain.class);
        //SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        int n = 5;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain(larTest,"home", n,n, "homeBT");
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

    @MediumTest
    public void testMeasurementsUpdates(){

        SugarRecord.deleteAll(MeasurementsDomain.class);
        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");


        int i = 5;
        int j = 4;
        int n = 6;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain(larTest,"home", n,n, "homeBT");
        roomTest.save();

        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, j, i, measurement+i+j);
        measureTest.save();

        MeasurementsDAO.updateMeasure(measureTest, roomTest, 4, 5, 6.0);

        assertEquals(new MeasurementsDomain(roomTest,4,5,6.0),measureTest);

    }

    @MediumTest
    public void testDeleteRoom(){

        SugarRecord.deleteAll(MeasurementsDomain.class);
        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");

        int i = 5;
        int j = 4;
        int n = 6;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain(larTest, "home", n,n, "homeBT");
        roomTest.save();

        MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, j, i, measurement+i+j);
        measureTest.save();

        assertEquals( 1, SugarRecord.count(MeasurementsDomain.class, null, null));

        MeasurementsDAO.deleteMeasure(measureTest);

        assertEquals(0, SugarRecord.count(MeasurementsDomain.class, null, null));

    }

    @MediumTest
    public void testSaveAllMeasurements(){

        SugarRecord.deleteAll(MeasurementsDomain.class);
        RoomDomain.deleteAll(RoomDomain.class);
        BuildingDomain.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        int n = 5;
        double measurement = 0.0;

        RoomDomain roomTest = new RoomDomain(larTest, "home", n,n, "homeBT");
        roomTest.save();

        List<MeasurementsDomain> list = new ArrayList<>();

        for(int i = 1; i<=n ; i++){
            for(int j = 1 ; j<=n ; j++){
                MeasurementsDomain measureTest = new MeasurementsDomain(roomTest, j, i, measurement+i+j);

                list.add(measureTest);
            }
        }

        MeasurementsDAO.saveListOfMeasurements(list);

        assertEquals(list, MeasurementsDAO.findAllMeasurementsAtRoom("home"));

    }
    //teste para ver se o delete apaga tudo e o count fica a 0
}