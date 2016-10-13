package mandarine.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Usuario on 08/09/2016.
 */
public class MiAdapter extends BaseAdapter{
    LayoutInflater inflater;
    private List<Trabajo> items;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
    private NumberFormat formatoNumero = new DecimalFormat("#0.00");

    MiAdapter(Context context, List<Trabajo> items){
        super();
        this.items = items;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Trabajo getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row==null)
            row= inflater.inflate(R.layout.listview_layout,parent,false);
        //Los elementos los toma del layout del listview, por eso hacemos row.
        //Aca se puede usar holder, mejora la performance.

        TextView nombreTrabajo = (TextView) row.findViewById(R.id.textViewNombreTrabajo);
        nombreTrabajo.setText(this.getItem(position).getDescripcion());

        TextView categoriaTrabajo = (TextView) row.findViewById(R.id.textViewCategoria);
        categoriaTrabajo.setText(this.getItem(position).getCategoria().getDescripcion());

        TextView horasMax = (TextView) row.findViewById(R.id.textViewHoras);
        horasMax.setText(this.getItem(position).getHorasPresupuestadas().toString());

        TextView precioHoras = (TextView) row.findViewById(R.id.textViewPrecioHora);
        precioHoras.setText(formatoNumero.format(this.getItem(position).getPrecioMaximoHora()));

        TextView fechaEntrega = (TextView) row.findViewById(R.id.textViewFechaFin);
        fechaEntrega.setText(formatoFecha.format(this.getItem(position).getFechaEntrega()));

        CheckBox requiereIngles = (CheckBox) row.findViewById(R.id.checkBox);
        requiereIngles.setChecked((this.getItem(position)).getRequiereIngles());

        ImageView bandera = (ImageView) row.findViewById(R.id.imagenIdioma);
        //1 US$ 2 Euro 3 AR$- 4 Libra 5 R$
        switch (this.getItem(position).getMonedaPago()){
            case 1:
                bandera.setImageResource(R.drawable.us); break;
            case 2:
                bandera.setImageResource(R.drawable.eu); break;
            case 3:
                bandera.setImageResource(R.drawable.ar); break;
            case 4:
                bandera.setImageResource(R.drawable.uk); break;
            case 5:
                bandera.setImageResource(R.drawable.br); break;
        }


        return(row);
    }
}
