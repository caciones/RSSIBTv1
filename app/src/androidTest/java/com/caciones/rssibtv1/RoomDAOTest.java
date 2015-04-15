package com.caciones.rssibtv1;

import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.LargeTest;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;
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
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");

        for(int i=1; i<5; i++){
            RoomDomain roomTest = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTest.save();
        }

        assertEquals(4, SugarRecord.count(RoomDomain.class, null, null) );

    }

    // test find by name
    @MediumTest
    public void testFindByNameRoom(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        for(int i=1; i<6; i++){
            RoomDAO.saveRoom(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);

        }

        assertEquals(RoomDAO.findRoomByName("casa3"), new RoomDomain(larTest, "casa3", 7,2, "casaBT3"));
    }
    @MediumTest
    public void testRoomBuilding(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        RoomDomain room = new RoomDomain( "casa", 4, 5, "casaBT");
        room.setBuilding(larTest);
        room.save();

        assertEquals(larTest, room.getBuilding());
    }


    @MediumTest
    public void testListAllRoom(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);


        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }

        List<RoomDomain> list = new ArrayList<>();
        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            list.add(roomTemplate);

        }

        assertEquals(list, SugarRecord.listAll(RoomDomain.class));

    }

    @MediumTest
    public void testUpdateRoom(){

        SugarRecord.deleteAll(RoomDomain.class);
       // SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }

        RoomDAO.updateRoom(RoomDAO.findRoomByName("casa3"), larTest, "upcasa", 4, 5, "upcasaBT");

        assertEquals(new RoomDomain(larTest, "upcasa",4,5,"upcasaBT"),RoomDAO.findRoomByName("upcasa"));
    }

    @MediumTest
    public void testDeleteRoom(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");

        RoomDomain roomTemplate = new RoomDomain(larTest, "casa", 4, 5, "casaBT");
        roomTemplate.save();

        assertEquals(1, SugarRecord.count(RoomDomain.class, null, null));

        RoomDAO.deleteRoom(roomTemplate);

        assertEquals(0, SugarRecord.count(RoomDomain.class, null, null));
    }

    @LargeTest
    public void testIsThereRoom(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();

        }


        RoomDomain testRoomTrue = new RoomDomain(larTest, "casa1", 5, 4, "casaBT1");

        RoomDomain testRoomFalse = new RoomDomain(larTest, "nipp", 1, 1, "nippBT");

        assertTrue(RoomDAO.isThereRoom(testRoomTrue));

        assertFalse(RoomDAO.isThereRoom(testRoomFalse));



    }


    public void testAllRoomFromBuilding(){

        SugarRecord.deleteAll(RoomDomain.class);
        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();

        List<RoomDomain> roomDomainList = new ArrayList<>();
        for(int i=1; i<6; i++){
            RoomDomain roomTemplate = new RoomDomain(larTest, "casa"+i, 4+i, 5-i, "casaBT"+i);
            roomTemplate.save();
            roomDomainList.add(roomTemplate);
        }



        assertEquals(roomDomainList, RoomDAO.getAllRoomsFromBuilding("lar"));

    }
}