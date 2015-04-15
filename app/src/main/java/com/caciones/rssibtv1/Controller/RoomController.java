package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.List;

/**
 * Created by Lenovo on 26/03/2015.
 */
public class RoomController {

    //receber os paramentros do objecto Room

    public void createRoom(BuildingDomain building, String name, int width, int length, String nameBT){
        RoomDAO.saveRoom(building, name, width, length, nameBT);
    }

    public RoomDomain loadRoom(String name){

        return RoomDAO.findRoomByName(name);

    }

    public List<RoomDomain> loadAllRooms(String nameBuilding){

        List<RoomDomain> roomDomainList = RoomDAO.getAllRoomsFromBuilding(nameBuilding);

        return roomDomainList;
    }


}
