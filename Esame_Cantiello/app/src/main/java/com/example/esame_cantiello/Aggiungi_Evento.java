package com.example.esame_cantiello;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

public class Aggiungi_Evento extends AppCompatActivity {
    FloatingActionButton tasto_data;
    Calendar calendario;
    String dataabb;
    String tipoMenù;
    String tipoOpzione;
    private DatePickerDialog dpd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi__evento);
        tasto_data=(FloatingActionButton) findViewById(R.id.tasto_data);
        Spinner spinner1 = (Spinner) findViewById(R.id.Spinner_Menu);
        Spinner spinner2= (Spinner) findViewById(R.id.Spinner_ExtraOpzioni);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.varianti__menù, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoMenù= (String) parent.getItemAtPosition(position);

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
                tipoOpzione= (String) parent.getItemAtPosition(position);

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
                        dataabb=(gg + "/" + mm + "/" + aa);


                    }
                }, day, month, year);
                dpd.show();

            }
        });
    }
}
