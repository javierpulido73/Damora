package mx.isoft.damora.prototipo.presenter;

import com.google.android.gms.maps.SupportMapFragment;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.service.GpsService;
import mx.isoft.damora.prototipo.view.RastrearPedidoActivity;

/**
 * Description:
 * Created by EX383473 on 27/06/2019.
 */
public class MapPresenter {
    private GpsService gpsService;

    private RastrearPedidoActivity view;

    public MapPresenter(RastrearPedidoActivity view) {
        this.view = view;

    }


}
