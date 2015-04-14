package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;
import com.orm.SugarRecord;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Lenovo on 09/04/2015.
 */
public class BuildingDAO {

    public static Iterator<BuildingDomain> getAllBuilding(){

        Iterator<BuildingDomain> Buildings = BuildingDomain.findAll(BuildingDomain.class);

        return Buildings;
    }

    public static void saveBuilding(RoomDomain room, String nameBuilding){
        BuildingDomain building = new BuildingDomain(room, nameBuilding);
        building.save();
    }

    public static BuildingDomain loadBuilding(long id){

        return SugarRecord.findById(BuildingDomain.class, id);
    }

    public static void deleteBuilding(BuildingDomain building){
        building.delete();
    }

    public static BuildingDomain updateBuilding(BuildingDomain building, RoomDomain room, String nameBuilding) {

        building.setRoom(room);
        building.setNameBuilding(nameBuilding);

        building.save();

        return building;
    }

    public static List<BuildingDomain> findBuildingsByName(String buildingName){

        List<RoomDomain> query = RoomDomain.find(RoomDomain.class, "buildingName = ?", buildingName);

        RoomDomain room = query.get(0);

        List<BuildingDomain> queryBuilding = BuildingDomain.find(BuildingDomain.class, "room = ?", room.getId().toString() );

        return queryBuilding;

    }


    //TODO isThereBuilding




}
