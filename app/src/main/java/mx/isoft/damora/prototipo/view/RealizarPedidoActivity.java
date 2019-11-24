package mx.isoft.damora.prototipo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.utils.VariablesSesion;
import mx.isoft.damora.prototipo.view.adapter.HintAdapter;

public class RealizarPedidoActivity extends AppCompatActivity {
    private ImageButton menuBtn;
    private CalendarView calendarView;
    private Spinner turnoSp;
    private Spinner combustibleSp;
    private Spinner cantidadSp;
    private Button agregarPedidoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_pedido);


        calendarView= findViewById(R.id.calendario);
        calendarView.setDate(System.currentTimeMillis());
        calendarView.setMinDate(System.currentTimeMillis());
        turnoSp=findViewById(R.id.spinner_turno);
        combustibleSp=findViewById(R.id.spinner_combustible);
        cantidadSp=findViewById(R.id.spinner_cantidad);
        agregarPedidoBtn=findViewById(R.id.boton_agregar_pedido);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));

        HintAdapter hintAdapter=new HintAdapter(this,R.layout.item_spinner,getResources().getStringArray(R.array.string_array_turno));
        turnoSp.setAdapter(hintAdapter);
        turnoSp.setSelection(hintAdapter.getCount());
        // Creating adapter for spinner
        HintAdapter hintAdapter2=new HintAdapter(this,R.layout.item_spinner,getResources().getStringArray(R.array.string_array_combustible));
        combustibleSp.setAdapter(hintAdapter2);
        combustibleSp.setSelection(hintAdapter2.getCount());

        HintAdapter hintAdapter3=new HintAdapter(this,R.layout.item_spinner,getResources().getStringArray(R.array.string_array_cantidad));
        cantidadSp.setAdapter(hintAdapter3);
        cantidadSp.setSelection(hintAdapter3.getCount());
        final CalendarView calendarTemp=calendarView;
        agregarPedidoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date dateSelected = new Date(calendarTemp.getDate() * 1000);
                if (dateSelected.getDay()!=new Date().getDay()){
                    VariablesSesion.notification=true;
                    Toast.makeText(RealizarPedidoActivity.this,"Se agregó el pedido correctamente",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RealizarPedidoActivity.this,PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent=new Intent(RealizarPedidoActivity.this,CapturaTirillaActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}
