package com.caciones.rssibtv1;

import android.test.suitebuilder.annotation.MediumTest;

import com.caciones.rssibtv1.Domain.BuildingDomain;
import com.orm.SugarRecord;

import junit.framework.TestCase;

/**
 * Created by Lenovo on 10/04/2015.
 */
public class BuildingDAOTest extends TestCase{

    //TODO testar a lista de buildings

    @MediumTest
    public void testSaveBuilding(){


        SugarRecord.deleteAll(BuildingDomain.class);

        BuildingDomain larTest = new BuildingDomain("lar");
        larTest.save();
        BuildingDomain larTest1 = new BuildingDomain("casa");
        larTest1.save();
        BuildingDomain larTest2 = new BuildingDomain("escola");
        larTest2.save();


        assertEquals(larTest, SugarRecord.find(BuildingDomain.class, "name_Building = ?", "lar").get(0));

    }

    //TODO testar se a cada building da' uma lista de room

}
