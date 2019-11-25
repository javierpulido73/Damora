package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.view.adapter.ConsultarPedidosAdapter;

public class ConsultarPedidoActivity extends AppCompatActivity {
    private ConsultarPedidosAdapter consultarPedidosAdapter;
    private ListView consultarPedidosLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pedido);
        consultarPedidosLv=findViewById(R.id.lv_consultar_pedido);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));

        consultarPedidosAdapter=new ConsultarPedidosAdapter(this);
        consultarPedidosLv.setAdapter(consultarPedidosAdapter);

    }
}
