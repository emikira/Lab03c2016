package mandarine.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    private ArrayList<Trabajo> trabajos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trabajos = new ArrayList<>();
        trabajos.addAll(Arrays.asList(Trabajo.TRABAJOS_MOCK));

        lista = (ListView) findViewById(R.id.listView);
        MiAdapter adaptador = new MiAdapter(this, trabajos);
        lista.setAdapter(adaptador);
        registerForContextMenu(lista);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_floating, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_postularse:

                Toast.makeText(this,getString(R.string.msj_postulado),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_compartir:

                Trabajo trabajo = (Trabajo) lista.getItemAtPosition(((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,trabajo.getDescripcion());

                try {
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "La operación no se pudo completar", Toast.LENGTH_SHORT).show();
                }

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
