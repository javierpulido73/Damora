package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.darwindeveloper.onecalendar.clases.Day;
import com.darwindeveloper.onecalendar.views.OneCalendarView;

import java.util.Date;
import java.util.Locale;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.view.adapter.HintAdapter;

public class RealizarPedidoActivity extends AppCompatActivity {
    private MenuPresenter menuPresenter;
    private ImageButton menuBtn;
    private CalendarView calendarView;
    private Spinner turnoSp;
    private Spinner combustibleSp;
    private Spinner cantidadSp;
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
        menuBtn=findViewById(R.id.boton_menu);

        menuPresenter=new MenuPresenter(this,menuBtn);

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

    }

}
