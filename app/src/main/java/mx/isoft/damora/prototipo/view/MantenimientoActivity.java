package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;

public class MantenimientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        //Inicializamos el menú
        new MenuPresenter(this,(ImageButton) findViewById(R.id.boton_menu));
    }
}
