package com.caciones.rssibtv1;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.RoomDomain;

import junit.framework.TestCase;



/**
 * Created by Lenovo on 02/03/2015.
 */
public class RoomDAOTest extends TestCase {


    public void testCreateRoom(){

        RoomDomain roomTest = new RoomDomain("casa",4,5,"casaBT");
        roomTest.save();



        assertEquals(roomTest, RoomDAO.loadRoom(1));
    }

}