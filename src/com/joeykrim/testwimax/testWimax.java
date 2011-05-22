package com.joeykrim.testwimax;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testWimax extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button htcWiMAXOn = (Button)findViewById(R.id.HTCWiMAXOn);
        htcWiMAXOn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent browse = new Intent(FlashImageGUI.this, FileChooser.class);
                //startActivityForResult(browse, FILE_BROWSER);
                htcWimax(true);
            }
        });
        Button htcWiMAXOff = (Button)findViewById(R.id.HTCWiMAXOff);
        htcWiMAXOff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent browse = new Intent(FlashImageGUI.this, FileChooser.class);
                //startActivityForResult(browse, FILE_BROWSER);
                htcWimax(false);
            }
        });

        Button samsungWiMAXOn = (Button)findViewById(R.id.SamsungWiMAXOn);
        samsungWiMAXOn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent browse = new Intent(FlashImageGUI.this, FileChooser.class);
                //startActivityForResult(browse, FILE_BROWSER);
                samsungWimax(true);
            }
        });
        Button samsungWiMAXOff = (Button)findViewById(R.id.SamsungWiMAXOff);
        samsungWiMAXOff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent browse = new Intent(FlashImageGUI.this, FileChooser.class);
                //startActivityForResult(browse, FILE_BROWSER);
                samsungWimax(false);
            }
        });
    }
    public void htcWimax(boolean state) {
        TextView txtObjectResult = (TextView) findViewById(R.id.objectResult);
        Context context = this;
        //http://forum.xda-developers.com/archive/index.php/t-909206.html
        Object htcWimaxManager = context.getSystemService("wimax");
        if (htcWimaxManager != null) {
            Method setWimaxEnabled = null;
            try {
                setWimaxEnabled = htcWimaxManager.getClass().getMethod("setWimaxEnabled",
                        new Class[] { Boolean.TYPE });
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (state) {setWimaxEnabled.invoke(htcWimaxManager, new Object[] { Boolean.TRUE });}
                else {setWimaxEnabled.invoke(htcWimaxManager, new Object[] { Boolean.FALSE });}
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            txtObjectResult.setText("htc WiMAX object toggle to " + state + " successful? Please wait 5-15 seconds for status bar icon to change...");
        }
        else {txtObjectResult.setText("htc wimax object is null");}
        }

    public void samsungWimax(boolean state) {
        TextView txtObjectResult = (TextView) findViewById(R.id.objectResult);
        Context context = this;
        //http://forum.xda-developers.com/archive/index.php/t-909206.html
        Object samsungWimaxManager = context.getSystemService("WiMax");
        if (samsungWimaxManager != null) {
            Method setWimaxEnabled = null;
            try {
                setWimaxEnabled = samsungWimaxManager.getClass().getMethod("setWimaxEnabled",
                        new Class[] { Boolean.TYPE });
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (state) {setWimaxEnabled.invoke(samsungWimaxManager, new Object[] { Boolean.TRUE });}
                else {setWimaxEnabled.invoke(samsungWimaxManager, new Object[] { Boolean.FALSE });}
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            txtObjectResult.setText("samsung WiMAX object toggle to " + state + " successful? Please wait 5-15 seconds for status bar icon to change...");
        }
        else {txtObjectResult.setText("samsung WiMAX object is null");}
        }
}