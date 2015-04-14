package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lenovo on 26/03/2015.
 */
public class RoomController {

    //receber os paramentros do objecto Room

    public void createRoom(String name, int width, int length, String nameBT){
        RoomDAO.saveRoom(name, width, length, nameBT);
    }

    public RoomDomain loadRoom(String name){

        return RoomDAO.findRoomByName(name);

    }

// rever isto
//TODO meter a lista com todas as Rooms
    public List<RoomDomain> loadAllRooms(){

        List<RoomDomain> roomDomainList = new ArrayList<RoomDomain>();

        Iterator<RoomDomain> roomDomainIterator = RoomDAO.getAllRoom();

        while (roomDomainIterator.hasNext()){
            roomDomainList.add(roomDomainIterator.next());
        }
        return roomDomainList;
    }


}
