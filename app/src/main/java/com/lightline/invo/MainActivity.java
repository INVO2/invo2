package com.lightline.invo;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

public class MainActivity extends AppCompatActivity {


    private final String MAPKIT_API_KEY = "b76352f7-8d30-4257-ae53-b5fdb7e77bda";
    //private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);

    private MapView mapView;
    //private Search_fragment search_fragment;
    //private Settings_fragment settings_fragment;
    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        mapView = (MapView)findViewById(R.id.mapview);



        // Перемещение камеры в центр Санкт-Петербурга.
//        mapView.getMap().move(
//                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
//                new Animation(Animation.Type.SMOOTH, 5),
//                null);
    }

    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}
