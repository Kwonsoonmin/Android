package com.example.mylocation;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by KwonSoonmin_MobileProgramming on 2016-11-01.
 */

public class LocationList extends AppCompatActivity{
    Intent intent = getIntent();

    int index = 0;
    int k = 0;

    TextView p = (TextView)findViewById(R.id.Present);
    TextView r =(TextView)findViewById(R.id.result);
    TextView s = (TextView)findViewById(R.id.saved);

    ToggleButton e = (ToggleButton)findViewById(R.id.start_end);

    double latitude[] = new double[100]; // 위도
    double longitude[] = new double[100]; // 경도

    String latitude_s[] = new String[100]; // 위도 -> string 형태로 저장
    String longitude_s[] = new String[100]; // 경도 -> string 형태로 저장

    String final_r = "(1) Latitude and Longitude:\n"; // 정보 저장
    Handler h; // 일정 시간마다 위치 정보 업데이트

    private LocationListener LocaListener = new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {
            Log.d("mylocation","Location Changed... Location: "+location);
            double lat = location.getLatitude(); // 위도
            latitude[k] = lat;
            double lo = location.getLongitude(); // 경도
            longitude[k] = lo;
            String provider = location.getProvider(); // 위치 제공자 알려주기.

            String result_p ="Provider: " + provider + "\n" + "Latitude: " + lat + "\n" + "Longitude: "+ lo;

            r.setText(result_p);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d("mylocation","Status Changed... Provider: " +provider+ " Status: " + status + " Extras: " + extras);
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d("mylocation", "Provider Enabled... Provider: "+provider);
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d("mylocation","Provider Disabled... Provider: "+provider);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationlist);

        r.setText("...Non Receipt of Location Information..."); // 위치 정보 없음.

        final LocationManager loc = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        h = new Handler() {
            public void message (Message m){
                index++;

                latitude_s[k] = String.valueOf(latitude[k]);
                longitude_s[k] = String.valueOf(longitude[k]);

                final_r +=latitude_s[k]+"\n" + longitude_s[k]+"\n";

                s.setText(final_r);

                final_r +="("+(k+2)+")"+" "+"Latitude and Longitude:\n";

                k++;

                h.sendEmptyMessageDelayed(0,600000); // 1분 간격으로 배열에 넣어 정보 저장
            }
        };
        h.sendEmptyMessage(0);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(e.isChecked()){
                        r.setText("...Incoming...");
                        loc.requestLocationUpdates(LocationManager.GPS_PROVIDER,300000,5,LocaListener);
                    }

                    else{
                        r.setText("...Non Receipt...");
                        loc.removeUpdates(LocaListener);
                    }
                }catch(SecurityException se) {
                }
            }
        });
    }
}
