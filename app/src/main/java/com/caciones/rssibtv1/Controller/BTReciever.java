package com.caciones.rssibtv1.Controller;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Caciones on 29-05-2015.
 */
public abstract class BTReciever extends BroadcastReceiver{

    private static final String TAG = "activityMessage";


        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "Reciever BT");
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                short rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
                onBluetoothFound(device, rssi);
                Log.i(TAG, "Device Found BTReciever\n" + "Name: " + device.getName() + "\n" + "Address: " + device.getAddress() + "\n" + "rssi: " + rssi + " dBm");

            }

        }
    public abstract void onBluetoothFound(BluetoothDevice device, int rssi);
}


