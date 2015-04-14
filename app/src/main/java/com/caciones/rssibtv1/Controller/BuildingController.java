package com.caciones.rssibtv1.Controller;

import com.caciones.rssibtv1.DAO.BuildingDAO;
import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.caciones.rssibtv1.Domain.RoomDomain;

import java.util.List;

/**
 * Created by Lenovo on 10/04/2015.
 */
public class BuildingController {

    //receber os paramentros do Measurement

    public void createBuilding(RoomDomain room, String nameBuilding){
        BuildingDAO.saveBuilding(room, nameBuilding);
    }

    //TODO load buildings by name
    public List<BuildingDomain> loadBuilding(String nameBuilding){


    return null;
    }

    //TODO LoadAllBuildings

}
