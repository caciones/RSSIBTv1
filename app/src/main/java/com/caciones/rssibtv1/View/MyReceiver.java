package com.caciones.rssibtv1.View;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.caciones.rssibtv1.Controller.BTController;

/**
 * Created by Lenovo on 16/06/2015.
 */
class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "activityMessage";

    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();


        if(BluetoothDevice.ACTION_FOUND.equals(action) ) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String address = device.getAddress();
            String name = device.getName();
            //String extraName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
            short extraRSSI = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, (short) -1);

            Log.i(TAG, address + " BT____FOUND " + name + " " + extraRSSI);

            BTController.putBTDevices(name, extraRSSI);


        }

       /* if (action.equals(BluetoothDevice.ACTION_FOUND)) {
            Log.i(TAG, "BT____FOUND");
            String extraName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
            Log.i(TAG, "BT____FOUND_Name: " + extraName);
            short extraRSSI = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, (short) -1);
            BTController.putBTDevices(extraName, extraRSSI);
            Log.i(TAG, "BT____FOUND");


        }*/
    }
}