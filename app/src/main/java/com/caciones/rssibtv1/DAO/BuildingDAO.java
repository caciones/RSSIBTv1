package com.caciones.rssibtv1.DAO;

import com.caciones.rssibtv1.Domain.BuildingDomain;
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

    public static void saveBuilding(String nameBuilding){
        BuildingDomain building = new BuildingDomain(nameBuilding);
        building.save();
    }

    public static BuildingDomain loadBuilding(long id){

        return SugarRecord.findById(BuildingDomain.class, id);
    }

    public static void deleteBuilding(String buildingName){
        List<BuildingDomain> buildingList = findBuildingsByName(buildingName);
        BuildingDomain building = buildingList.get(0);
        building.delete();
    }

    public static BuildingDomain updateBuilding(BuildingDomain building, String nameBuilding) {

        building.setNameBuilding(nameBuilding);
        building.save();

        return building;
    }

    // rever isto visto ter deixado de haver room
    public static List<BuildingDomain> findBuildingsByName(String buildingName){

        List<BuildingDomain> queryBuilding = BuildingDomain.find(BuildingDomain.class, "buildingName= ?", buildingName.toString() );

        return queryBuilding;

    }


    public static boolean isThereBuilding(String nameBuilding){

       return !findBuildingsByName(nameBuilding).isEmpty();

    }




}
