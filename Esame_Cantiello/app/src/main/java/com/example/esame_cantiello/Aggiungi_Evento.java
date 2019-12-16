package com.example.esame_cantiello;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Aggiungi_Evento extends AppCompatActivity {
    FloatingActionButton tasto_data;
    Calendar calendario;
    String dataevento;
    String tipoMenù;
    String tipoOpzione;
    TextInputEditText Nomecliente;
    private DatePickerDialog dpd;
    private Button bottoneMenu;
    public static final String EXTRA_ID =
            "com.example.esame_cantiello.EXTRA_ID";
    public static final String EXTRA_NOME_CLIENTE =
            "com.example.esame_cantiello.EXTRA_NOME_CLIENTE";
    public static final String EXTRA_TIPO_MENU =
            "com.example.esame_cantiello.EXTRA_TIPO_MENU";
    public static final String EXTRA_TIPO_OPZIONE =
            "com.example.esame_cantiello.EXTRA_TIPO_OPZIONE";
    public static final String EXTRA_data =
            "com.example.esame_cantiello.EXTRA_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi__evento);
        tasto_data = (FloatingActionButton) findViewById(R.id.tasto_data);
        Nomecliente = findViewById(R.id.nomecliente);
        bottoneMenu = (Button) findViewById(R.id.buttonSceltaMenu);
        Spinner spinner2 = (Spinner) findViewById(R.id.Spinner_ExtraOpzioni);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_menu);
        bottoneMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_aggiungi_menu = new Intent(Aggiungi_Evento.this, ListaMenu.class);
                startActivity(open_aggiungi_menu);
                // intent mi permette di far interagire un activity con altre , quindi ora da questa activity vado ad interagire con quella aggiungi_evento

            }
        });
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.menù, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoMenù = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.special_guest, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoOpzione = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tasto_data.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calendario = Calendar.getInstance();
                String setcurrentdate = DateFormat.getDateInstance().format(calendario.getTime());
                final int day = calendario.get(Calendar.DAY_OF_MONTH);
                final int month = calendario.get(Calendar.MONTH);
                final int year = calendario.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Aggiungi_Evento.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        String gg = String.valueOf(mDay);
                        String mm = String.valueOf(mMonth);
                        String aa = String.valueOf(mYear);
                        dataevento = (gg + "/" + mm + "/" + aa);


                    }
                }, day, month, year);
                dpd.show();

            }
        });
    }
        private void savePreno() {

            String nome = Nomecliente.getText().toString();
            String menuservito = tipoMenù;
            String dataevento3 = dataevento;
            String opzione = tipoOpzione;


            if (nome.trim().isEmpty() || menuservito.trim().isEmpty() || dataevento3.trim().isEmpty() || opzione.trim().isEmpty()) {
                Toast.makeText(this, "Compila i campi", Toast.LENGTH_SHORT);
                return;
            }
            Intent info = new Intent();

            if (info != null) {
                info.putExtra(EXTRA_NOME_CLIENTE, nome);
                info.putExtra(EXTRA_TIPO_OPZIONE, opzione);
                info.putExtra(EXTRA_TIPO_MENU, menuservito);
                info.putExtra(EXTRA_data, dataevento3);

            }


            int id = getIntent().getIntExtra(EXTRA_ID, 1);
            if (id != -1) {
                info.putExtra(EXTRA_ID, id);
            }
            setResult(RESULT_OK, info);
            finish();

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_preno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.salvapreno:
                savePreno();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
