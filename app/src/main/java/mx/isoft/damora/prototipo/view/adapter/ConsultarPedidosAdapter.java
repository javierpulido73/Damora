package mx.isoft.damora.prototipo.view.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

import mx.isoft.damora.prototipo.R;
import mx.isoft.damora.prototipo.model.CompraDto;
import mx.isoft.damora.prototipo.model.RegistrosPedidosModel;
import mx.isoft.damora.prototipo.utils.FuncionesGenerales;
import mx.isoft.damora.prototipo.utils.SharedPref;
import mx.isoft.damora.prototipo.view.DetallePedidoActivity;


public class ConsultarPedidosAdapter extends BaseAdapter {

    private final Context context;
    private List<CompraDto> listRegistros;
    public ConsultarPedidosAdapter(final Context context) {
        this.context=context;
        RegistrosPedidosModel registrosPedidosModel= SharedPref.extraerRegistrosPedidos(context);
        if(registrosPedidosModel!=null){
            listRegistros=registrosPedidosModel.getCompraDtos();
        }else {
            listRegistros=new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return listRegistros.size();
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
            rowView = inflater.inflate(R.layout.item_pedido, parent, false);
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.fecha = rowView.findViewById(R.id.tv_fecha);
            itemHolder.tipoCombustible = rowView.findViewById(R.id.tv_tipo);
            itemHolder.turno = rowView.findViewById(R.id.tv_turno);
            itemHolder.cancelar = rowView.findViewById(R.id.ib_cancelar);
            itemHolder.detallePedido=rowView.findViewById(R.id.ll_detalle_pedido);
            rowView.setTag(itemHolder);
        }
        // fill data
        final ItemHolder itemHolder = (ItemHolder) rowView.getTag();
        itemHolder.fecha.setText(FuncionesGenerales.formatearFecha(listRegistros.get(position).getFecha()));
        itemHolder.tipoCombustible.setText(listRegistros.get(position).getTipoCombustible());
        itemHolder.turno.setText(listRegistros.get(position).getTurno());
        itemHolder.cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Cancelar pedido")
                        .setMessage("¿Estás seguro que deseas cancelarlo?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                listRegistros.remove(position);
                                SharedPref.guardarRegistroPedidos(context,new RegistrosPedidosModel(listRegistros));
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        itemHolder.detallePedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetallePedidoActivity.class);
                context.startActivity(intent);
            }
        });
        return rowView;
    }

    static class ItemHolder {
        public TextView fecha;
        public TextView tipoCombustible;
        public TextView turno;
        public ImageButton cancelar;
        public LinearLayout detallePedido;
    }

}
