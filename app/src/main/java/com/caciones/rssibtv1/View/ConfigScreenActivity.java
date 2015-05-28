package com.caciones.rssibtv1.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.caciones.rssibtv1.R;


/**
 * Created by Lenovo on 24/04/2015.
 */


public class ConfigScreenActivity extends ActionBarActivity{


    //info sobre o estado da actividade
    private static final String TAG = "activityMessage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_main); //tentativa de fazer tudo em java


        //Button btn_next = (Button)findViewById(R.id.btn_next);


/*


        //Layout
        RelativeLayout configLayout = new RelativeLayout(this);
        configLayout.setBackgroundColor(Color.GRAY);

        RelativeLayout.LayoutParams nextButtonDetails = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        nextButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        nextButtonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //Button
        Button nextButton = new Button(this);
        nextButton.setText("Next");
        nextButton.setBackgroundColor(Color.BLUE);

        //editable combobox



        //add widgets to layout
        configLayout.addView(nextButton, nextButtonDetails);

        //set this activities to this view
        setContentView(configLayout);
*/

        //keep track of it
        Log.i(TAG,"onCreate");
    }



    //botao next
    public void onClickNext(View view){
        Intent next = new Intent(this, ChooseBtScreenActivity.class);
        startActivity(next);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
