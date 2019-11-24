package mx.isoft.damora.prototipo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.utils.VariablesSesion;

public class PrincipalActivity extends AppCompatActivity {
    private FloatingActionButton confirmarCompraFab;
    private LinearLayout notificationLl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        confirmarCompraFab=findViewById(R.id.fb_confirmar_compra);
        notificationLl=findViewById(R.id.ll_notification);

        //Construimos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));
        confirmarCompraFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrincipalActivity.this,ConfirmarCompraActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Hacemos visible o invisible la notifiación
        notificationLl.setVisibility(VariablesSesion.notification?View.VISIBLE:View.INVISIBLE);
    }


}
