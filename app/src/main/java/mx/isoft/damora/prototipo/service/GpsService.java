package mx.isoft.damora.prototipo.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mx.isoft.damora.prototipo.R;

import static mx.isoft.damora.prototipo.utils.Constantes.TAM_ICON_PARTNER_INT;

/**
 * Description:
 * Created by EX383473 on 27/06/2019.
 */
public class GpsService implements OnMapReadyCallback {
    private GoogleMap mMap;

    private Context context;

    public GpsService(Context context) {
        this.context = context;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.524151, -99.194689);
        Bitmap bmIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_car);
        bmIcon = Bitmap.createScaledBitmap(bmIcon,
                TAM_ICON_PARTNER_INT,
                TAM_ICON_PARTNER_INT,
                false);
        BitmapDescriptor bmdIcon = BitmapDescriptorFactory.fromBitmap(bmIcon);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(bmdIcon));
        mMap.setMaxZoomPreference(20);
        mMap.setMinZoomPreference(15);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private MarkerOptions getMark(final float latitud, final float longitud) {
        return null;
    }
}
