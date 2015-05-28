package com.caciones.rssibtv1.Controller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.caciones.rssibtv1.RO.BTDeviceRO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by Lenovo on 17/03/2015.
 */
public class BTController extends Activity{


    private BluetoothAdapter BA;


    private Map<BluetoothDevice, Integer> listBTDevices;

    public BTController(){
        this.BA = BluetoothAdapter.getDefaultAdapter();
    }


    public void on(Activity a){
        if (!this.BA.isEnabled()){
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            a.startActivityForResult(turnOn, 0);
        }else
            return;

    }

    public ArrayList<String> list(){
        Set<BluetoothDevice> deviceSet = this.BA.getBondedDevices();
        ArrayList<String> list = new ArrayList<>();
        for(BluetoothDevice bt : deviceSet){
            list.add(bt.getName());
        }
        return list;
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView
                int  rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);

                listBTDevices.put(device, rssi);
            }



        }
    };

// fazer uma lista com os nomes tirados da listBTDevices
    // TODO  meter a lista de nomes no view
    public List<BTDeviceRO> getNameFromListBTDevices(){

        List<BTDeviceRO> btNames= new ArrayList<BTDeviceRO>();


        for(Map.Entry<BluetoothDevice, Integer> deviceEntry : this.listBTDevices.entrySet()){

                BTDeviceRO deviceRO = new BTDeviceRO(deviceEntry.getKey().getName(), deviceEntry.getValue() );

                btNames.add(deviceRO);

        }

        return btNames;
    }




}


