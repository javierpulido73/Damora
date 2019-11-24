package mx.isoft.damora.prototipo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import mx.isoft.damora.prototipo.R;

public class PrincipalActivity extends AppCompatActivity {

    private LinearLayout realizarPedidoLl;
    private LinearLayout consultarPedidoLl;
    private LinearLayout rastearPedidoLl;
    private LinearLayout reportesLl;
    private LinearLayout pagosLl;
    private LinearLayout ayudaLl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        realizarPedidoLl=findViewById(R.id.ll_realizar_pedido);
        consultarPedidoLl=findViewById(R.id.ll_consultar_pedido);
        rastearPedidoLl=findViewById(R.id.ll_rastrear_pedido);
        reportesLl=findViewById(R.id.ll_reportes);
        pagosLl=findViewById(R.id.ll_pagos);
        ayudaLl=findViewById(R.id.ll_ayuda);
        realizarPedidoLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, RealizarPedidoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        consultarPedidoLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//TODO:
            }
        });
        rastearPedidoLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        reportesLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pagosLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ayudaLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
