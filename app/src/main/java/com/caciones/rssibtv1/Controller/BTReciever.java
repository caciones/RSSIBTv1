package com.caciones.rssibtv1.Controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Set;

/**
 * Created by Faisco on 29-05-2015.
 */
public class BTReciever extends BroadcastReceiver{

    private static final String TAG = "activityMessage";

    private Set<BluetoothDevice> pairedDevices;


    private BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();


        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "BroadCast received" );
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_ON:
                        Log.i(TAG, "BT_ON_BCR" );
                        //TODO: Lançar a listagem
                        ba.startDiscovery();


                        Log.i(TAG, "chegou " + ba.toString() );

                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.i(TAG, "BT_Turning_ON_BCR" );
                        break;
                }
            }


        }



}
