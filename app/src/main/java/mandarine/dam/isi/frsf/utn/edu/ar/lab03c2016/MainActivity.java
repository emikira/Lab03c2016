package mandarine.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Trabajo[] trabajos = Trabajo.TRABAJOS_MOCK;

        lista = (ListView) findViewById(R.id.listView);
        MiAdapter adaptador = new MiAdapter(getApplicationContext(), Arrays.asList(trabajos));
        lista.setAdapter(adaptador);

    }
}
