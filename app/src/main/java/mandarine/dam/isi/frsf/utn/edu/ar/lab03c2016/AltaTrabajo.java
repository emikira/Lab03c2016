package mandarine.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;

public class AltaTrabajo extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private Button botonGuardar;
    private Spinner spinnerCategoria;

    private TextView nombreNuevaOferta;

    private RadioGroup radioGroup;
    private RadioButton radioButtonAr;
    private RadioButton radioButtonBr;
    private RadioButton radioButtonEu;
    private RadioButton radioButtonUk;
    private RadioButton radioButtonUs;

    private Categoria[] listaCategorias = Categoria.CATEGORIAS_MOCK;
    private ArrayAdapter adaptadorSpinner;

    private Integer monedaElegida;
    private Trabajo nuevoTrabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_trabajo);

        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonGuardar.setOnClickListener(this);

        nombreNuevaOferta = (TextView) findViewById(R.id.editTextOferta);
        radioGroup = (RadioGroup) findViewById((R.id.radioGroup));
        radioGroup.setOnCheckedChangeListener(this);
        radioButtonAr = (RadioButton) findViewById(R.id.radioButtonAr);
        radioButtonBr = (RadioButton) findViewById(R.id.radioButtonBr);
        radioButtonEu = (RadioButton) findViewById(R.id.radioButtonEu);
        radioButtonUk = (RadioButton) findViewById(R.id.radioButtonUk);
        radioButtonUs = (RadioButton) findViewById(R.id.radioButtonUs);

        spinnerCategoria = (Spinner) findViewById(R.id.spinner);
        adaptadorSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCategorias);
        spinnerCategoria.setAdapter(adaptadorSpinner);

        nuevoTrabajo = new Trabajo();


        monedaElegida = 0;
    }

    @Override
    public void onClick(View v){

        int resultCode = 0;
        Intent resultIntent = new Intent();


        if(v.getId() == R.id.botonGuardar) {
            if (nombreOfertaEmpty()) {
                Toast.makeText(this, getString(R.string.msj_ingreseNombre), Toast.LENGTH_SHORT).show();
            } else {

                nuevoTrabajo.setCategoria((Categoria) spinnerCategoria.getSelectedItem());
                nuevoTrabajo.setDescripcion(nombreNuevaOferta.getText().toString());
                nuevoTrabajo.setMonedaPago(monedaElegida);

                resultCode = 1;

                resultIntent.putExtra("nuevo", nuevoTrabajo);
                setResult(resultCode, resultIntent);
                finish();
            }
        }
    }

    private boolean nombreOfertaEmpty() {

        return nombreNuevaOferta.getText().toString().isEmpty();

    }

    public void onCheckedChanged(RadioGroup group, int checkedId){

        switch(checkedId){
            case R.id.radioButtonAr:
                monedaElegida = 3;
                break;
            case R.id.radioButtonBr:
                monedaElegida = 5;
                break;
            case R.id.radioButtonEu:
                monedaElegida = 2;
                break;
            case R.id.radioButtonUk:
                monedaElegida = 4;
                break;
            case R.id.radioButtonUs:
                monedaElegida = 1;
                break;
        }

        Log.i("CheckedId", String.valueOf(monedaElegida));
    }
}
