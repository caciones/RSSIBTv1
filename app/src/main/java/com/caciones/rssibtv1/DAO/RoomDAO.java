package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Lenovo on 27/02/2015.
 */
public class RoomDAO {

    public static Iterator<RoomDomain> getAllRoom(){

        Iterator<RoomDomain> rooms = RoomDomain.findAll(RoomDomain.class);

        return rooms;
    }

    public static void saveRoom(String name, int width, int length, String nameBT){
        RoomDomain room = new RoomDomain(name, width,length, nameBT);
        room.save();

    }

    public static RoomDomain loadRoom(long id){

        return RoomDomain.findById(RoomDomain.class, id);
    }

    public static void deleteRoom(RoomDomain room){
        room.delete();
    }

    public static RoomDomain updateRoom(RoomDomain room, String name, int width, int length, String nameBT){

        room.setName(name);
        room.setWidth(width);
        room.setLength(length);
        room.setNameBT(nameBT);

        room.save();

        return room;

    }

    public RoomDomain findRoomByName(String name){

        List<RoomDomain> query = RoomDomain.find(RoomDomain.class, "name = ?", name);

        return query.get(0);
    }

    public RoomDomain findByBTName(String nameBT){

        List<RoomDomain> query = RoomDomain.find(RoomDomain.class, "nameBT = ?", nameBT);

        return query.get(0);
    }

}
