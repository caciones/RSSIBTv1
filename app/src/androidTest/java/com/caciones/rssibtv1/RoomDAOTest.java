package com.caciones.rssibtv1;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.RoomDomain;

import junit.framework.TestCase;



/**
 * Created by Lenovo on 02/03/2015.
 */
public class RoomDAOTest extends TestCase {

    //@Test
    public void testCreateRoom(){

        RoomDomain roomTest = new RoomDomain("casa",4,5,"casaBT");
        RoomDAO.saveRoom("casa",4,5,"casaBT");

        assertEquals(RoomDAO.loadRoom(0L), roomTest );
    }

}