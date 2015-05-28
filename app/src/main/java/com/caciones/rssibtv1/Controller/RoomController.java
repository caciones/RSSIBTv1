package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.RoomDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.ArrayList;
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

    public static List<String> loadAllRooms(String nameBuilding){

        List<String> roomStringList = new ArrayList<String>();

        List<RoomDomain> roomDomainList = RoomDAO.getAllRoomsFromBuilding(nameBuilding);



        for(RoomDomain roomDomain : roomDomainList ){
            roomStringList.add(roomDomain.getName());
        }

        return roomStringList;

    }

//TODO save room (nao sei se e' necessario devido ao create)
    //TODO isThereRoom(se houver room carrega a sala com aquele nome)

    public void isThereRoom(RoomDomain room){

        if(RoomDAO.isThereRoom(room)){
            loadRoom(room.getName());
        }else{
            //this.createRoom(room); //tem que esperar ate ter os dados todos para ser salvo
        }

    }
}
