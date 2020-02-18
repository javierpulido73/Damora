package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.gms.maps.SupportMapFragment;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MapPresenter;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.service.GpsService;

public class RastrearPedidoActivity extends AppCompatActivity {
    private GpsService gpsService;
    private MapPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rastrear_pedido);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        gpsService = new GpsService(this);
//        mapFragment.getMapAsync(gpsService);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(RastrearPedidoActivity.this,PrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}
