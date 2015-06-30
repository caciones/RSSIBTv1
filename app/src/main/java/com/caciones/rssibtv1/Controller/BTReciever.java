package com.caciones.rssibtv1.Controller;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Faisco on 29-05-2015.
 */
public class BTReciever extends BroadcastReceiver{

    private static final boolean D = true;
    private static final String TAG = "activityMessage";
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
                        this.doDiscovery();
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.i(TAG, "BT_Turning_ON_BCR" );
                        break;
                }
                /*
                EXTRA_DEVICE and EXTRA_CLASS. Can contain the extra fields EXTRA_NAME and/or EXTRA_RSSI if
                 */
            }/* if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                String extraName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
                int extraRSSI= intent.getIntExtra(BluetoothDevice.EXTRA_RSSI, BluetoothDevice.ERROR);



                //em cada action conferir, acrescentar e retirar ou alterar um nome e rssi 'a lista de btdevices



                List<BTDeviceRO> btDeviceROList = BTController.getListBTDevices(extraName, extraRSSI); //lista de BTRO

                Log.i(TAG, "Ola " );

            }*/


        }


    private void doDiscovery() {

        if (D) Log.d(TAG, "doDiscovery()");

        // If we're already discovering, stop it
        if (ba.isDiscovering()) {
            ba.cancelDiscovery();
        }
        // Request discover from BluetoothAdapter
        ba.startDiscovery();
    }
}
