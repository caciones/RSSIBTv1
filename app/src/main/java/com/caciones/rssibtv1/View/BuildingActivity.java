package com.caciones.rssibtv1.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.caciones.rssibtv1.Controller.BuildingController;
import com.caciones.rssibtv1.R;

import java.util.List;

public class BuildingActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    //info sobre o estado da actividade
    private static final String TAG = "activityMessage";

    public final static String BUILDING_EXTRA = "com.caciones.rssibtv1.buildingName";

    // Spinner element
    Spinner spinner;

    // Add button
    Button btnAdd;
    Button btnDelete;
    Button btnNext;

    // building label
    String selectedBuilding;

    // Input text
    EditText inputLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner_building);

        // add button
        btnAdd = (Button) findViewById(R.id.btn_add_building);
        btnDelete = (Button) findViewById(R.id.btn_delete_building);
        btnNext = (Button) findViewById(R.id.btn_next_building);


        //inicializar a string
        this.selectedBuilding = "";

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();


        /**
         * Add new Building button click listener(acho que tneho de alterar isto para todos os botoes)
         * e ainda nao passa para outra activity
         *



        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String label = inputLabel.getText().toString();

                if (label.trim().length() > 0) {


                    // making input filed text to blank
                    inputLabel.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);

                    // loading spinner with newly added data
                    loadSpinnerData();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

         */
        Log.i(TAG, "onCreate");
    }

    /**
     * Function to load the spinner data
     * */
    private void loadSpinnerData() {


        // Spinner Drop down elements -  aqui tb
        List<String> lables = BuildingController.loadAllBuilding();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Log.i(TAG,"loadSpinner");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        this.selectedBuilding = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + this.selectedBuilding,
                Toast.LENGTH_LONG).show();

        Log.i(TAG,"onItemSelected - "+ this.selectedBuilding);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_building, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getBuildingSelectet(){
        return this.selectedBuilding;
    }


    //metodoos para btnext
    public void onClickNextBuilding(View v) {


        Intent iBuilding = new Intent(this, RoomActivity.class);

        iBuilding.putExtra(BUILDING_EXTRA, getBuildingSelectet());
        startActivity(iBuilding);

        Log.i(TAG, "onClickNext");
        Log.i(TAG, iBuilding.getStringExtra(BUILDING_EXTRA));

        Log.i(TAG, "intent building "+ iBuilding);
    }
}
