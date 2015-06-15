package com.caciones.rssibtv1.Controller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.util.Log;

import com.caciones.rssibtv1.RO.BTDeviceRO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by Lenovo on 17/03/2015.
 */
public class BTController extends Activity{

    private static final String TAG = "activityMessage";
    private static final int TURN_ON = 0;

    private BluetoothAdapter BA;

    private static Map<String, Integer> listBTDevices;

    public BTController(){
        this.BA = BluetoothAdapter.getDefaultAdapter();
    }

    public void on(Activity a){
        if (!this.BA.isEnabled()){
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            a.startActivityForResult(turnOn, TURN_ON);
        }
        return ;
    }

    public ArrayList<String> list(){
        Set<BluetoothDevice> deviceSet = this.BA.getBondedDevices();
        ArrayList<String> list = new ArrayList<>();
        for(BluetoothDevice bt : deviceSet){
            list.add(bt.getName());
        }
        return list;
    }


    public static void putBTDevices(String name, int rssi){
        listBTDevices.put(name, rssi);
    }

}


