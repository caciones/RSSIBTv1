package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.BuildingDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lenovo on 10/04/2015.
 */
public class BuildingController {

    //receber os paramentros do Measurement

    public void createBuilding( String nameBuilding){
        BuildingDAO.saveBuilding(nameBuilding);
    }


    public static List<String> loadAllBuilding(){

        List<String> buildingStringList = new ArrayList<String>();

        Iterator<BuildingDomain> buildingDomainIterator = BuildingDAO.getAllBuilding();

        while (buildingDomainIterator.hasNext()){
            buildingStringList.add(buildingDomainIterator.next().getNameBuilding());
        }

         return buildingStringList;
    }

    //TODO save building
    public void saveBuilding(String nameBuilding){
        BuildingDAO.saveBuilding(nameBuilding);
    }

    //TODO boolean ifIsThere
//passar isto para o activity para preencher a lista dos rooms
    public void isThereBuilding(String nameBuilding){

        if(BuildingDAO.isThereBuilding(nameBuilding)){
            RoomController.loadAllRooms(nameBuilding);
        } else{
            this.createBuilding(nameBuilding);
        }

    }

    //delete um building e os respectivos rooms e repor a lista sem o referido building
    public void deleteBuilding(String nameBuilding){
        BuildingDAO.deleteBuilding(nameBuilding);
    }

}
