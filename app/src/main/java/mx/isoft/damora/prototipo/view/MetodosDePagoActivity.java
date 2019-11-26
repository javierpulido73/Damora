package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;

public class MetodosDePagoActivity extends AppCompatActivity {

    private Button agregarMetodoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_de_pago);
        agregarMetodoBtn=findViewById(R.id.boton_agregar_metodo);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));
        agregarMetodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MetodosDePagoActivity.this);
                LayoutInflater inflater = MetodosDePagoActivity.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.alert_dialog_agregar_tarjeta, null);
                dialogBuilder.setView(dialogView);
                final Button cancelar=dialogView.findViewById(R.id.boton_cancelar);
                final Button aceptar=dialogView.findViewById(R.id.boton_agregar);
                final TextView numeroTarjeta=dialogView.findViewById(R.id.tv_numero_tarjeta);
                final TextView mes=dialogView.findViewById(R.id.tv_mes);
                final TextView cvv=dialogView.findViewById(R.id.tv_cvv);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                alertDialog.setCancelable(false);
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        alertDialog.cancel();
                    }
                });
                aceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!numeroTarjeta.getText().toString().isEmpty()&&!mes.getText().toString().isEmpty()&&!cvv.getText().toString().isEmpty()){
                            alertDialog.dismiss();
                            alertDialog.cancel();
                        }else{
                            Toast.makeText(MetodosDePagoActivity.this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });
    }
}
