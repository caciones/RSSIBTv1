package com.caciones.rssibtv1.Controller;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Faisco on 29-05-2015.
 */
public class BTReciever extends BroadcastReceiver{

    private static final String TAG = "activityMessage";

        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "received" );

            String action = intent.getAction();
            // When discovery finds a device

            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // Add the name and address to an array adapter to show in a ListView
            int  rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
            Log.i(TAG, "rssi " + rssi  );
            //BTController.put(device, rssi);


        }


}
