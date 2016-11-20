package com.example.quickcoding06;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuickCoding06 extends AppCompatActivity implements SensorEventListener {

    TextView text1, steps, text2;
    int count = 0;
    String str;
    private long lasttime;
    private float speed;
    private float valueX;
    private float valueY;
    private float valueZ;
    private float x,y,z;

    private static final int shake = 800;
    private static final int dataX = SensorManager.DATA_X;
    private static final int dataY = SensorManager.DATA_Y;
    private static final int dataZ = SensorManager.DATA_Z;
    private SensorManager sm;
    private Sensor accelero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding06);

        text1 = (TextView)findViewById(R.id.text1);
        steps = (TextView)findViewById(R.id.steps);
        text2 = (TextView)findViewById(R.id.text2);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelero = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void onStart() {
        super.onStart();

        if(accelero != null)
            sm.registerListener(this, accelero,SensorManager.SENSOR_DELAY_GAME);
    }

    public void onStop() {
        super.onStop();

        if(sm != null)
            sm.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor s, int a){
    }

    public void onSensorChanged(SensorEvent e) {
        if(e.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currenttime = System.currentTimeMillis();
            long gapTime = (currenttime - lasttime);

            if(gapTime > 100) {
                lasttime = currenttime;

                x = e.values[SensorManager.DATA_X];
                y = e.values[SensorManager.DATA_Y];
                z = e.values[SensorManager.DATA_Z];

                speed = Math.abs(x+y+z - valueX - valueY - valueZ) / gapTime * 10000;

                if(speed > shake) {
                    count++;
                    str = Integer.toString(count);
                    steps.setText(str);
                }

                valueX = e.values[dataX];
                valueY = e.values[dataY];
                valueZ = e.values[dataZ];
            }
        }
    }
}
