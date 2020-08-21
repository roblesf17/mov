package com.example.app_taex_1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, LocationListener {

    GoogleMap gMap;
    LocationManager lm;
    Location location;


    int tipo_mapa = 0 ;



    double longitude = 0;
    double latitude = 0;


    public static String Ciudad = "" ;


    public static double latitud_a = 0;
    public static double longitud_a =0;

    public static String direccion_temporal = "";

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);


        mapFragment.getMapAsync( (OnMapReadyCallback) this );

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        String[] letra = {" 1) DANZA FOLKCLORICA" , " 2) TEATRO" , " 3) CANTO" , " 4) GUITARRA" , "  5) LATIN DANCE" ," 6) MARINERA"," 7) BALLET CLÁSICO"," 8) MANUALIDADES CON MATERIAL RECICLABLE"," 9) FOTOGRAFÍA"," 10) CINE"};


        ArrayAdapter adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, letra);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item;
                item = (String) parent.getItemAtPosition(position);
                if(item.equals(" 1) DANZA FOLKCLORICA")){
                    latitude = -18.026125344870394;
                    longitude = -70.26246414372487;

                    direccion_temporal = "Direccion Danza";

                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula Laboratorio Salón de Ballet Pabellón C" ;
                    onMapReady(gMap);

                    //Toast.makeText(getContext(),  "Av. Aviación 985 . 2do Piso , frente al Restaurant Cuzco , Cerca al hospital de la Solidaridad",
                            //Toast.LENGTH_LONG).show();
                }
                if(item.equals(" 2) TEATRO")){
                    latitude = -17.1875481;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 3) CANTO")){
                    latitude = -17.1875481;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 4) GUITARRA")){
                    latitude = -17.1875410;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 5) LATIN DANCE")){
                    latitude = -17.1875420;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 6) MARINERA")){
                    latitude = -17.1875430;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 7) BALLET CLÁSICO")){
                    latitude = -17.1875440;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 8) MANUALIDADES CON MATERIAL RECICLABLE")){
                    latitude = -17.1875450;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 9) FOTOGRAFÍA")){
                    latitude = -17.1875460;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }
                if(item.equals(" 10) CINE")){
                    latitude = -17.1875470;
                    longitude = -70.9368857;
                    tipo_mapa = 1 ;
                    //tipo_mapa = 3 ;
                    Ciudad = "Aula C-303 Ex FAING" ;
                    onMapReady(gMap);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.v("Location Changed", latitude + " and " + longitude);
            lm.removeUpdates(this);
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        gMap.setMapType(mMapTypes[tipo_mapa]);

        lm = (LocationManager) getContext().getSystemService( Context.LOCATION_SERVICE);

        if (getActivity().checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
    /*lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
    location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

    longitude = location.getLongitude();
    latitude = location.getLatitude();*/

        LatLng aqui = new LatLng(latitude, longitude);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(aqui)
                .zoom(17)//zoom
                .bearing(30)//inclinacion
                .build();

        gMap.addMarker(new MarkerOptions().position(aqui).title(direccion_temporal));
        gMap.animateCamera( CameraUpdateFactory.newCameraPosition(cameraPosition));

        Toast.makeText(getContext(),  Ciudad,
                Toast.LENGTH_SHORT).show();

        try {

            Location location = new Location("localizacion 1");
            location.setLatitude(latitude);  //latitud
            location.setLongitude(longitude); //longitud
            Location location2 = new Location("localizacion 2");
            location2.setLatitude(latitud_a);  //latitud
            location2.setLongitude(longitud_a); //longitud
            double distance = location.distanceTo(location2);

            /*
            Toast.makeText(getContext(),"Existe una distancia de :  " + Double.toString(distance) + " de distancia ",
                    Toast.LENGTH_SHORT).show();
*/
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }
    }


    private int mMapTypes[] = {
            GoogleMap.MAP_TYPE_NONE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN
    };
}
