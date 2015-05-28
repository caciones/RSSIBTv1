package com.caciones.rssibtv1.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.caciones.rssibtv1.R;

/**
 * Created by Lenovo on 29/04/2015.
 */
public class ChooseBtScreenActivity extends Activity {

    TextView out;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_bt_screen);



/*
       // out = (TextView) findViewById(R.id.out);

        // Getting the Bluetooth adapter
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        out.append("\nAdapter: " + adapter);

        // Check for Bluetooth support in the first place
        // Emulator doesn't support Bluetooth and will return null
        if(adapter==null) {
            out.append("\nBluetooth NOT supported. Aborting.");
            return;
        }

        // Starting the device discovery
        out.append("\nStarting discovery...");
        adapter.startDiscovery();
        out.append("\nDone with discovery...");

        // Listing paired devices
        out.append("\nDevices Pared:");
        Set<BluetoothDevice> devices = adapter.getBondedDevices();
        for (BluetoothDevice device : devices) {
            out.append("\nFound device: " + device);
        }*/
    }
}

