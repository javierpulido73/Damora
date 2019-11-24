package mx.isoft.damora.prototipo.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.presenter.MenuPresenter;

public class PrincipalActivity extends AppCompatActivity {
    private MenuPresenter menuPresenter;
    private ImageButton menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        menuBtn=findViewById(R.id.boton_menu);
        //Construimos el menú
        menuPresenter=new MenuPresenter(this,menuBtn);

    }


}
