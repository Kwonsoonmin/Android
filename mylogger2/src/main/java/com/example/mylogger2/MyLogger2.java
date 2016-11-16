package com.example.mylogger2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skp.Tmap.TMapGpsManager;
import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import java.util.LinkedList;

public class MyLogger2 extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback{
    private TMapGpsManager tmapgps = null;
    private Context mContext = null;
    private boolean m_bTrackingMode = true;
    private TMapView tMapView = null;
    private static int markerid ;
    int count = 0;

    private LinkedList<TMapPoint> tmappoint_linked = new LinkedList<TMapPoint>();
    private LinkedList<String> markerid_linked = new LinkedList<String>();
    private LinkedList<MapPoint> mappoint_linked = new LinkedList<MapPoint>();

    @Override
    public void onLocationChange(Location location) {
        if (m_bTrackingMode) {
            tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_logger2);

        mContext = this;

        Button statistic = (Button)findViewById(R.id.statistic);
        Button marker = (Button)findViewById(R.id.marker);

        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyLogger2.this,"Statistic From DataBase!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(), statistic.class);
                startActivity(intent2);
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.map_view);
        tMapView = new TMapView(this);

        linearLayout.addView(tMapView);
        tMapView.setSKPMapApiKey("1c8a592b-0020-3f67-bf6c-9a31367ccea1");

        marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentLocation cl = new CurrentLocation(MyLogger2.this);
                double latitude = 0;
                double longitude = 0;

                if(cl.isGetLocation()) {
                    latitude = cl.getLat();
                    longitude = cl.getLongi();

                    Toast.makeText(MyLogger2.this, "Marking!",Toast.LENGTH_SHORT).show();
                    addpoint(latitude, longitude);
                    showmarkerpoint(count);
                }

                count++;
            }
        });

        tMapView.setCompassMode(true);

        tMapView.setIconVisibility(true);

        tMapView.setZoomLevel(15);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);

        tmapgps = new TMapGpsManager(MyLogger2.this);
        tmapgps.setMinTime(1000);
        tmapgps.setMinDistance(5);
        tmapgps.setProvider(tmapgps.NETWORK_PROVIDER);
        //tmapgps.setProvider(tmapgps.GPS_PROVIDER);
        tmapgps.OpenGps();

        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);

        tMapView.setOnCalloutRightButtonClickListener(new TMapView.OnCalloutRightButtonClickCallback(){
            public void onCalloutRightButton(TMapMarkerItem markerItem) {
                CurrentLocation cl1 = new CurrentLocation(MyLogger2.this);
                double lat_i = 0;
                double longi_i = 0;
                String lat_i_s = "";
                String longi_i_s = "";

                if(cl1.isGetLocation()) {
                    lat_i = cl1.getLat();
                    longi_i = cl1.getLongi();

                    lat_i_s = String.valueOf(lat_i);
                    longi_i_s = String.valueOf(longi_i);

                    Intent intent1 = new Intent(getApplicationContext(), record.class);
                    intent1.putExtra("lat",lat_i_s);
                    intent1.putExtra("long", longi_i_s);
                    startActivity(intent1);
                }
            }
        });
    }

    public void addpoint(double lat, double longi) {
        mappoint_linked.add(new MapPoint("Record info about here",lat, longi));
    }

    public void showmarkerpoint(int count) {
        TMapPoint point = new TMapPoint(mappoint_linked.get(count).getLatitude(),mappoint_linked.get(count).getLongitude());
        TMapMarkerItem item1 = new TMapMarkerItem();
        Bitmap bitmap = null;
        bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.poi_dot);

        item1.setTMapPoint(point);
        item1.setName(mappoint_linked.get(count).getName());
        item1.setVisible(item1.VISIBLE);
        item1.setIcon(bitmap);

        bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.poi_dot);

        item1.setCalloutTitle(mappoint_linked.get(count).getName());
        item1.setCanShowCallout(true);
        item1.setAutoCalloutVisible(true);

        Bitmap bitmapigo = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.i_go);
        item1.setCalloutRightButtonImage(bitmapigo);

        String strid = String.format("marker%d", markerid++);

        tMapView.addMarkerItem(strid, item1);
        markerid_linked.add(strid);
    }
}
