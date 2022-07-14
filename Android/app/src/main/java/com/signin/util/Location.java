package com.signin.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.signin.MainActivity;

import java.io.IOException;
import java.util.List;

public class Location {
    public static void getLocationPermissions(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }
    }
    public static String getAddress(Context context) {
        String addrGet = "定位失败";
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            getLocationPermissions(context);
        } else {
            LocationManager locManger = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            android.location.Location loc = locManger.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc == null) {
                loc = locManger.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
            List<Address> addressList = null;
            if (loc != null) {
                double latitude = loc.getLatitude();
                double longitude = loc.getLongitude();
                Geocoder geocoder = new Geocoder(context);
                try {
                    addressList = geocoder.getFromLocation(latitude, longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addressList != null) {
                    for (Address address : addressList) {
                        addrGet = address.getAddressLine(0);
                        break;
                    }
                }
            }
        }
        return addrGet;
    }
}
