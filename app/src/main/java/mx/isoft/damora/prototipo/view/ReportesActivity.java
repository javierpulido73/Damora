package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Spinner;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;
import mx.isoft.damora.prototipo.view.adapter.HintAdapter;

public class ReportesActivity extends AppCompatActivity {

    private Spinner reporteSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        reporteSp=findViewById(R.id.spinner_reporte);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));
        //Inicializamos los spinner
        HintAdapter hintAdapter=new HintAdapter(this,R.layout.item_spinner,getResources().getStringArray(R.array.string_array_reportes));
        reporteSp.setAdapter(hintAdapter);
        reporteSp.setSelection(hintAdapter.getCount());
    }
}
