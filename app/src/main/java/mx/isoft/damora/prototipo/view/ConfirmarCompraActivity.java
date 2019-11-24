package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.ComprasPresenter;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.utils.VariablesSesion;
import mx.isoft.damora.prototipo.view.adapter.CompraAdapter;
import mx.isoft.damora.prototipo.view.adapter.HintAdapter;

public class ConfirmarCompraActivity extends AppCompatActivity {

    private ListView comprasLv;
    private CompraAdapter compraAdapter;
    private ComprasPresenter presenter;
    private Spinner formaPagoSp;
    private Button confirmarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_compra);
        comprasLv=findViewById(R.id.lv_compras);
        formaPagoSp=findViewById(R.id.spinner_forma_pago);
        confirmarCompra=findViewById(R.id.boton_confirmar_compra);

        HintAdapter hintAdapter=new HintAdapter(this,R.layout.item_spinner,getResources().getStringArray(R.array.string_array_forma_pago));
        formaPagoSp.setAdapter(hintAdapter);
        formaPagoSp.setSelection(hintAdapter.getCount());

        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));
        compraAdapter=new CompraAdapter(this);
        comprasLv.setAdapter(compraAdapter);
        presenter=new ComprasPresenter(this);
        //TODO: esta lista se llena temporalmente ya que se devería llenar de base de datos
        presenter.llenarLista();
        compraAdapter.notifyDataSetChanged();
        confirmarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesSesion.notification=false;
                Toast.makeText(ConfirmarCompraActivity.this, "Se confirmó el pedido exitosamente", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ConfirmarCompraActivity.this,PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
