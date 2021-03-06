package com.caciones.rssibtv1.Domain;

import com.orm.SugarRecord;

/**
 * Created by Lenovo on 09/04/2015.
 */
public class BuildingDomain extends SugarRecord<BuildingDomain> {


    String nameBuilding;


    public BuildingDomain() {
    }

    public BuildingDomain( String nameBuilding) {

        this.nameBuilding = nameBuilding;


    }

    public void setNameBuilding(String nameBuilding) {
        this.nameBuilding = nameBuilding;
    }

    public String getNameBuilding() {
        return this.nameBuilding;
    }





    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BuildingDomain) {
            if (((BuildingDomain) obj).getNameBuilding().equals(this.nameBuilding)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }


    @Override
    public String toString() {
        return this.getNameBuilding();
    }
}
