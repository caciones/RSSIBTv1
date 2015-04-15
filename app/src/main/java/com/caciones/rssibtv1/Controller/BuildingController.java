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


    public List<BuildingDomain> loadAllBuilding(){

        List<BuildingDomain> buildingDomainList = new ArrayList<BuildingDomain>();

        Iterator<BuildingDomain> buildingDomainIterator = BuildingDAO.getAllBuilding();

        while (buildingDomainIterator.hasNext()){
            buildingDomainList.add(buildingDomainIterator.next());
        }

         return buildingDomainList;
    }



}
