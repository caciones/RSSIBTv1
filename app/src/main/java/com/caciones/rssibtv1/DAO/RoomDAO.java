package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class RoomDAO {


    public static void saveRoom(BuildingDomain building, String name, int width, int length, String nameBT){
        RoomDomain room = new RoomDomain(building, name, width, length, nameBT);
        room.save();

    }

    public static RoomDomain loadRoom(long id){

        return SugarRecord.findById(RoomDomain.class, id);
    }


    public static void deleteRoom(RoomDomain room){
        room.delete();
    }

    public static RoomDomain updateRoom(RoomDomain room, BuildingDomain building, String name, int width, int length, String nameBT){

        room.setBuilding(building);
        room.setName(name);
        room.setWidth(width);
        room.setLength(length);
        room.setNameBT(nameBT);

        room.save();

        return room;

    }

    public static RoomDomain findRoomByName(String name){

        List<RoomDomain> query = RoomDomain.find(RoomDomain.class, "name = ?", name);


        if(query.isEmpty()){
            return new RoomDomain();
        } else{
            return query.get(0);
        }
    }

// nao sei se este metodo e' necessaio
    public RoomDomain findByBTName(String nameBT){

        List<RoomDomain> query = RoomDomain.find(RoomDomain.class, "nameBT = ?", nameBT);

        if(query.isEmpty()){
            return new RoomDomain();
        } else{
            return query.get(0);
        }

    }

    // verificar se existe Room X
    public static Boolean isThereRoom(RoomDomain room){


        if(findRoomByName(room.getName()).equals(room)){
            return true;
        } else{
            return false;
        }


    }



// allRoomsfromBuilding  - quando a view comunicar com o controller, enviar o index, e deixar o nome do que vai estar escrito na lista

    public static List<RoomDomain> getAllRoomsFromBuilding(String nameBuilding){

        List<BuildingDomain> building = BuildingDomain.find(BuildingDomain.class, "name_building = ?", nameBuilding);
        List<RoomDomain> query = RoomDomain.find(RoomDomain.class,"building = ?", building.get(0).getId().toString());

        if(query.isEmpty()){
            return new ArrayList<RoomDomain>();
            }
        else{
            return query;
        }

    }


}
