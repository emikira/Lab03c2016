package mandarine.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usuario on 08/09/2016.
 */
public class MiAdapter extends BaseAdapter{
    LayoutInflater inflater;


    MiAdapter(Context context, List<Trabajo> items){
        super();
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return getCount();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.listview_layout,parent,false);
        //Los elementos los toma del layout del listview, por eso hacemos row.
        TextView nombreTrabajo = (TextView) row.findViewById(R.id.textViewNombreTrabajo);
        TextView categoriaTrabajo = (TextView) row.findViewById(R.id.categoria);
        TextView horasMax = (TextView) row.findViewById(R.id.textViewHoras);
        TextView precioHoras = (TextView) row.findViewById(R.id.textViewPrecioHora);
        TextView fechaEntrega = (TextView) row.findViewById(R.id.fechaFin);
        CheckBox requiereIngles = (CheckBox) row.findViewById(R.id.checkBox);

        requiereIngles.setEnabled(((Trabajo)this.getItem(position)).getRequiereIngles());


        return(row);
    }
}
