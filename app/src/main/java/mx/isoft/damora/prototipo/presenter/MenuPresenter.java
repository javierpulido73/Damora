package mx.isoft.damora.prototipo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AlertDialog;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.view.ConfirmarCompraActivity;
import mx.isoft.damora.prototipo.view.ConsultarPedidoActivity;
import mx.isoft.damora.prototipo.view.ContactoActivity;
import mx.isoft.damora.prototipo.view.MantenimientoActivity;
import mx.isoft.damora.prototipo.view.MetodosDePagoActivity;
import mx.isoft.damora.prototipo.view.PrincipalActivity;
import mx.isoft.damora.prototipo.view.RastrearPedidoActivity;
import mx.isoft.damora.prototipo.view.RealizarPedidoActivity;
import mx.isoft.damora.prototipo.view.ReportesActivity;

/**
 * Created by Icom_JP on 2019-11-24.
 * Description:
 */
public class MenuPresenter {
    private final Activity view;
    private final ImageButton menuIb;
    public MenuPresenter(final Activity view,final ImageButton menuIb) {
        this.view = view;
        this.menuIb=menuIb;
        menuIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menuDesp = new PopupMenu(view, v);
                menuDesp.getMenuInflater().inflate(R.menu.menu_principal,menuDesp.getMenu());
                insertMenuItemIcons(view, menuDesp);
                menuDesp.show();
                menuDesp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Class destinoActivity=null;
                        switch (item.getItemId()) {
                            case R.id.itm_principal:
                                destinoActivity= PrincipalActivity.class;
                                break;
                            case R.id.itm_realizar_pedido:
                                destinoActivity=RealizarPedidoActivity.class;
                                break;
                            case R.id.itm_consultar_pedido:
                                destinoActivity= ConsultarPedidoActivity.class;
                                break;
                            case R.id.itm_rastrear_pedido:
                                destinoActivity= RastrearPedidoActivity.class;
                                break;
                            case R.id.itm_reportes:
                                destinoActivity= ReportesActivity.class;
                                break;
                            case R.id.itm_confirmar_compra:
                                destinoActivity= ConfirmarCompraActivity.class;
                                break;
                            case R.id.itm_pagos:
                                destinoActivity= MetodosDePagoActivity.class;
                                break;
                            case R.id.itm_contacto:
                                destinoActivity= ContactoActivity.class;
                                break;
                            case R.id.itm_cerrar_sesion:
                                new AlertDialog.Builder(view)
                                        .setTitle("Cerrar sesión")
                                        .setMessage("¿Estás seguro que deseas cerrar sesión?")
                                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        })
                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                System.exit(0);
                                            }
                                        })
                                        .setNegativeButton(android.R.string.no, null)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                                break;
                        }
                        if(destinoActivity!=null){
                            Intent intent = new Intent(view, destinoActivity);
                            view.startActivity(intent);
                            view.finish();
                        }
                        return true;
                    }
                });
            }
        });
    }
    //Las siguientes funciones son necesarias para agregar íconos al PopupMenu sin AppCompat

    /**
     * Moves icons from the PopupMenu's MenuItems' icon fields into the menu title as a Spannable with the icon and title text.
     */
    public static void insertMenuItemIcons(Context context, PopupMenu popupMenu) {
        Menu menu = popupMenu.getMenu();
        if (hasIcon(menu)) {
            for (int i = 0; i < menu.size(); i++) {
                insertMenuItemIcon(context, menu.getItem(i));
            }
        }
    }

    /**
     * @return true if the menu has at least one MenuItem with an icon.
     */
    private static boolean hasIcon(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).getIcon() != null) return true;
        }
        return false;
    }

    /**
     * Converts the given MenuItem's title into a Spannable containing both its icon and title.
     */
    private static void insertMenuItemIcon(Context context, MenuItem menuItem) {
        Drawable icon = menuItem.getIcon();

        // If there's no icon, we insert a transparent one to keep the title aligned with the items
        // which do have icons.
        if (icon == null) icon = new ColorDrawable(Color.TRANSPARENT);

        int iconSize = context.getResources().getDimensionPixelSize(R.dimen.text_h6);
        icon.setBounds(0, 0, iconSize, iconSize);
        ImageSpan imageSpan = new ImageSpan(icon);

        // Add a space placeholder for the icon, before the title.
        SpannableStringBuilder ssb = new SpannableStringBuilder("       " + menuItem.getTitle());

        // Replace the space placeholder with the icon.
        ssb.setSpan(imageSpan, 1, 2, 0);
        menuItem.setTitle(ssb);
        // Set the icon to null just in case, on some weird devices, they've customized Android to display
        // the icon in the menu... we don't want two icons to appear.
        menuItem.setIcon(null);
    }

}
