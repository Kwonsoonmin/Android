package com.example.quickcoding05;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class QuickCoding05 extends AppCompatActivity {
    SensorManager sensormanager;
    SensorEventListener se_gravity; // 중력
    SensorEventListener se_accelero; // 가속계
    SensorEventListener se_linear; // 리니어 가속기
    SensorEventListener se_gyro; // 방향의 측정, 유지에 사용
    Sensor gravity_s;
    Sensor accelero_s;
    Sensor linear_s;
    Sensor gyro_s;

    TextView gravity, gravity_x, gravity_y, gravity_z, accelero, accelero_x, accelero_y, accelero_z,
    linear, linear_x, linear_y, linear_z, gyro, gyro_x, gyro_y, gyro_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding05);
        gravity = (TextView)findViewById(R.id.gravity);
        gravity_x = (TextView)findViewById(R.id.gravity_x);
        gravity_y = (TextView)findViewById(R.id.gravity_y);
        gravity_z = (TextView)findViewById(R.id.gravity_z);
        accelero = (TextView)findViewById(R.id.accelero);
        accelero_x = (TextView)findViewById(R.id.accelero_x);
        accelero_y = (TextView)findViewById(R.id.accelero_y);
        accelero_z = (TextView)findViewById(R.id.accelero_z);
        linear = (TextView)findViewById(R.id.linear);
        linear_x = (TextView)findViewById(R.id.linear_x);
        linear_y = (TextView)findViewById(R.id.linear_y);
        linear_z = (TextView)findViewById(R.id.linear_z);
        gyro = (TextView)findViewById(R.id.gyro);
        gyro_x = (TextView)findViewById(R.id.gyro_x);
        gyro_y = (TextView)findViewById(R.id.gyro_y);
        gyro_z = (TextView)findViewById(R.id.gyro_z);

        sensormanager = (SensorManager)getSystemService(SENSOR_SERVICE);

        gravity_s = sensormanager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        accelero_s = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        linear_s = sensormanager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        gyro_s = sensormanager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        se_gravity = new graListener();
        se_accelero = new accListener();
        se_linear = new linearListener();
        se_gyro = new gyListener();
    }

    public void onResume() {
        super.onResume();

        sensormanager.registerListener(se_gravity, gravity_s, SensorManager.SENSOR_DELAY_NORMAL);
        sensormanager.registerListener(se_accelero, accelero_s, SensorManager.SENSOR_DELAY_NORMAL);
        sensormanager.registerListener(se_linear, linear_s, SensorManager.SENSOR_DELAY_NORMAL);
        sensormanager.registerListener(se_gyro, gyro_s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause() {
        super.onPause();

        sensormanager.unregisterListener(se_gyro);
        sensormanager.unregisterListener(se_linear);
        sensormanager.unregisterListener(se_accelero);
        sensormanager.unregisterListener(se_gravity);
    }

    private class graListener implements SensorEventListener { // gravity
        public void onSensorChanged(SensorEvent e) {
            int x = (int)e.values[0];
            int y = (int)e.values[1];
            int z = (int)e.values[2];

            gravity_x.setText(Integer.toString(x));
            gravity_y.setText(Integer.toString(y));
            gravity_z.setText(Integer.toString(z));

            Log.i("Sensor", "gravity_changed");
        }

        public void onAccuracyChanged(Sensor s, int a) {
        }
    }

    private class accListener implements SensorEventListener { // accelero
        public void onSensorChanged(SensorEvent e) {
            int x = (int)e.values[0];
            int y = (int)e.values[1];
            int z = (int)e.values[2];

            accelero_x.setText(Integer.toString(x));
            accelero_y.setText(Integer.toString(y));
            accelero_z.setText(Integer.toString(z));

            Log.i("Sensor", "accelero_changed");
        }

        public void onAccuracyChanged(Sensor s, int a) {
        }
    }

    private class linearListener implements SensorEventListener { // linear_accel
        public void onSensorChanged(SensorEvent e) {
            int x = (int)e.values[0];
            int y = (int)e.values[1];
            int z = (int)e.values[2];

            linear_x.setText(Integer.toString(x));
            linear_y.setText(Integer.toString(y));
            linear_z.setText(Integer.toString(z));

            Log.i("Sensor", "linear_changed");
        }

        public void onAccuracyChanged(Sensor s, int a) {
        }
    }

    private class gyListener implements SensorEventListener { // gyro
        public void onSensorChanged(SensorEvent e) {
            int x = Math.round(e.values[0] * 1000);
            int y = Math.round(e.values[1] * 1000);
            int z = Math.round((int) e.values[2] * 1000);

            gyro_x.setText(Integer.toString(x));
            gyro_y.setText(Integer.toString(y));
            gyro_z.setText(Integer.toString(z));

            Log.i("Sensor", "gyro_changed");
        }

        public void onAccuracyChanged(Sensor s, int a) {
        }
    }
}
