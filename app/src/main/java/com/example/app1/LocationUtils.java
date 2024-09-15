package com.example.app1;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationUtils {

    private FusedLocationProviderClient fusedLocationProviderClient;

    private Context context;

    public interface LocationListener{
        void onLocationRecieved(Location location);
        void  onLocationError(String errorMessage);
        void onAddressRecieved(String city, String postalCode, String locality,String road);
    }

    public LocationUtils(Context context){
        this.context = context;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }
    public void requestLocationUpdates(final LocationListener listener){
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(1000);


        fusedLocationProviderClient.requestLocationUpdates(locationRequest, new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult){
                super.onLocationResult(locationResult);
                Location location = locationResult.getLastLocation();
                if(location !=null){
                    listener.onLocationRecieved(location);
                    getAddressFromLocation(location,listener);
                }else{
                    listener.onLocationError("Failed to get location.");
                }
            }
        }, Looper.getMainLooper());
    }

    private void getAddressFromLocation(final Location location, final LocationListener listener ){
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
            if(addresses !=null && addresses.size()>0){
                Address address = addresses.get(0);
                String city = address.getLocality();
                String locality = address.getAddressLine(0);
                String postalCode = address.getPostalCode();
                String road = address.getSubLocality();
                listener.onAddressRecieved(city,postalCode,locality,road);
            }else {
                listener.onAddressRecieved("","","","");
            }

        }catch (IOException e){
            listener.onLocationError("Failed to get Address.");
            e.printStackTrace();
        }
    }



    public void stopLocationUpdates(){
        fusedLocationProviderClient.removeLocationUpdates(new LocationCallback() {
            @Override
            public void onLocationAvailability(@NonNull LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);
            }
        });
    }
}
