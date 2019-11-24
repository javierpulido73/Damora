package mx.isoft.damora.prototipo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.utils.FuncionesGenerales;
import mx.isoft.damora.prototipo.utils.VariablesSesion;
import mx.isoft.damora.prototipo.view.RealizarPedidoActivity;


public class CompraAdapter extends BaseAdapter {

    private final Context context;
    public CompraAdapter(final Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return VariablesSesion.resultadoDtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_compra, parent, false);
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.fecha = rowView.findViewById(R.id.tv_fecha);
            itemHolder.tipoCombustible = rowView.findViewById(R.id.tv_tipo);
            itemHolder.turno = rowView.findViewById(R.id.tv_turno);
            itemHolder.editar = rowView.findViewById(R.id.ib_editar);
            itemHolder.eliminar = rowView.findViewById(R.id.ib_eliminar);
            rowView.setTag(itemHolder);
        }
        // fill data
        final ItemHolder itemHolder = (ItemHolder) rowView.getTag();
        itemHolder.fecha.setText(FuncionesGenerales.formatearFecha(VariablesSesion.resultadoDtoList.get(position).getFecha()));
        itemHolder.tipoCombustible.setText(VariablesSesion.resultadoDtoList.get(position).getTipoCombustible());
        itemHolder.turno.setText(VariablesSesion.resultadoDtoList.get(position).getTurno());
        itemHolder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, RealizarPedidoActivity.class);
                context.startActivity(intent);
            }
        });
        itemHolder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Se deberá eliminar el registro",Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

    static class ItemHolder {
        public TextView fecha;
        public TextView tipoCombustible;
        public TextView turno;
        public ImageButton editar;
        public ImageButton eliminar;
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
