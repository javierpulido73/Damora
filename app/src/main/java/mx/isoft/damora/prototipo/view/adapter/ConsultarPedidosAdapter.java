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


public class ConsultarPedidosAdapter extends BaseAdapter {

    private final Context context;
    public ConsultarPedidosAdapter(final Context context) {
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

}
