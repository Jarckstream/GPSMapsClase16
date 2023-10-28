package com.example.gpsmaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLong, txtLati;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLati = findViewById(R.id.txtLatitud);
        txtLong = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng Chile = new LatLng(-35.775147, -71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("ChileLindo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));

    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLati.setText(""+latLng.latitude);
        txtLong.setText(""+latLng.longitude);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLati.setText(""+latLng.latitude);
        txtLong.setText(""+latLng.longitude);

    }
}