package com.example.cantiello3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

public class AggiungiEditEvento extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.cantiello3.EXTRA_ID";
    public static final String EXTRA_NOME_CLIENTE =
            "com.example.cantiello3.EXTRA_NOME_CLIENTE";
    public static final String EXTRA_SELECT_MENU =
            "com.example.cantiello3.EXTRA_SELECT_MENU";
    public static final String EXTRA_SELECT_OPZIONE =
            "com.example.cantiello3.EXTRA_SELECT_OPZIONE";
    public static final String EXTRA_DATAEVENTO =
            "com.example.cantiello3.EXTRA_DATAEVENTO";
    public static final String EXTRA_TIPO_FESTA =
            "com.example.cantiello3.EXTRA_TIPO_FESTA";
    public static final String EXTRA_OSPITI =
            "com.example.cantiello3.EXTRA_OSPITI";


    private DatePickerDialog dpd;
    FloatingActionButton tasto_data;
    Calendar calendario;
    String dataevento;
    EditText tipo_festa;
    String selectMenù;
    String selectOpzione;
    String ospitiSerata;
    EditText Nomecliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_evento);
        Nomecliente = findViewById(R.id.nomecliente);
        tasto_data = findViewById(R.id.Buttondata);
        tipo_festa=findViewById(R.id.categoria_2);


        Spinner spinnermenu = findViewById(R.id.spinnermenu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menù, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnermenu.setAdapter(adapter);

        spinnermenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectMenù = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinnerextra = findViewById(R.id.spinnerextra);

        ArrayAdapter<CharSequence> adapterextra = ArrayAdapter.createFromResource(this,
                R.array.special_guest, android.R.layout.simple_spinner_item);

        adapterextra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerextra.setAdapter(adapterextra);

        spinnerextra.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectOpzione = (String) parent.getItemAtPosition(position);

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

                dpd = new DatePickerDialog(AggiungiEditEvento.this, new DatePickerDialog.OnDateSetListener() {
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
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent =getIntent();

        if(intent.hasExtra(EXTRA_ID))
        {
            setTitle("Modifica Prenotazione");
            Nomecliente.setText(intent.getStringExtra(EXTRA_NOME_CLIENTE));
            tasto_data.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    calendario = Calendar.getInstance();
                    String setcurrentdate = DateFormat.getDateInstance().format(calendario.getTime());
                    final int day = calendario.get(Calendar.DAY_OF_MONTH);
                    final int month = calendario.get(Calendar.MONTH);
                    final int year = calendario.get(Calendar.YEAR);

                    dpd = new DatePickerDialog(AggiungiEditEvento.this, new DatePickerDialog.OnDateSetListener() {
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


        }else
        {
            setTitle("Aggiungi Prenotazione");//sto facendo la schermata in cui salvo la prenotazione e la aggiungo alla lista
        }


    }

    private void savePrenotazione()
    {
        String nomecliente= Nomecliente.getText().toString();
        String data= dataevento;
        String extra= selectOpzione;
        String menu=selectMenù;
        String tipoFesta=tipo_festa.getText().toString();

        if (nomecliente.trim().isEmpty())
        {
            Toast.makeText(this,"Compilare i campi",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent info =new Intent();
        if(info!=null) {
            info.putExtra(EXTRA_NOME_CLIENTE, nomecliente);
            info.putExtra(EXTRA_SELECT_MENU, menu);
            info.putExtra(EXTRA_SELECT_OPZIONE, extra);
            info.putExtra(EXTRA_DATAEVENTO, data);
            info.putExtra(EXTRA_TIPO_FESTA, tipoFesta);
        }

        int id =getIntent().getIntExtra(EXTRA_ID,1);
        if(id != -1)
        {
            info.putExtra(EXTRA_ID,id);
        }
        setResult(RESULT_OK,info);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_prenotazione_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_prenotazione:
                savePrenotazione();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
