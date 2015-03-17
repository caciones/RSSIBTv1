package com.caciones.rssibtv1;

import android.test.suitebuilder.annotation.MediumTest;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.RoomDomain;
import com.orm.SugarRecord;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lenovo on 02/03/2015.
 */
public class RoomDAOTest extends TestCase {


    //apagar a base de dados



    //test save and count rooms
    @MediumTest
    public void testSaveCountRoom(){

        SugarRecord.deleteAll(RoomDomain.class);

        for(int i=1; i<5; i++){
            RoomDomain roomTest = new RoomDomain("casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTest.save();
        }

        assertEquals(4, SugarRecord.count(RoomDomain.class, null, null) );

    }

    // test find by name
    @MediumTest
    public void testFindByNameRoom(){

        SugarRecord.deleteAll(RoomDomain.class);

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain("casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }

        assertEquals(new RoomDomain("casa3", 7,2, "casaBT3"), RoomDAO.findRoomByName("casa3"));
    }


    @MediumTest
    public void testListAllRoom(){

        SugarRecord.deleteAll(RoomDomain.class);

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain("casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }

        List<RoomDomain> list = new ArrayList<>();
        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain("casa"+i, 4+i, 5-i, "casaBT"+i);
            list.add(roomTemplate);

        }



        assertEquals(list, SugarRecord.listAll(RoomDomain.class));

    }

    @MediumTest
    public void testUpdateRoom(){

        SugarRecord.deleteAll(RoomDomain.class);

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain("casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }

        RoomDAO.updateRoom(RoomDAO.findRoomByName("casa3"), "upcasa", 4, 5, "upcasaBT");

        assertEquals(new RoomDomain("upcasa",4,5,"upcasaBT"),RoomDAO.findRoomByName("upcasa"));
    }

    @MediumTest
    public void testDeleteRoom(){

        SugarRecord.deleteAll(RoomDomain.class);

        RoomDomain roomTemplate = new RoomDomain("casa", 4, 5, "casaBT");
        roomTemplate.save();

        assertEquals(1, SugarRecord.count(RoomDomain.class, null, null));

        RoomDAO.deleteRoom(roomTemplate);

        assertEquals(0, SugarRecord.count(RoomDomain.class, null, null));
    }
}