package com.iteso.sesion5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.iteso.sesion5.utils.Alumno;

public class ActivityMain extends AppCompatActivity {

    Spinner spinner;
    EditText nombre;
    EditText telefono;
    AutoCompleteTextView libros;
    CheckBox deporte;
    String genere;
    String sport;
    Button clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.activity_name);
        telefono = findViewById(R.id.activity_phone);
        clean = findViewById(R.id.activity_clean);
        deporte = findViewById(R.id.activity_checkbox);

        spinner = findViewById(R.id.main_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        libros = (AutoCompleteTextView) findViewById(R.id.activity_autocomplete);
        String[] books = getResources().getStringArray(R.array.books);
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<>
                (this, android.R.layout.select_dialog_item, books);
        libros.setAdapter(stringAdapter);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setMessage("Deseas Limpiar?").setPositiveButton("Limpiar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            comeClean();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                }
        }

        );
        deporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_save:
                Alumno.showStudentToast(ActivityMain.this, nombre.getText().toString(),
                        telefono.getText().toString(), spinner.getSelectedItem().toString(),
                        libros.getText().toString(),genere, sport, Toast.LENGTH_LONG);
                comeClean();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onRadioButtonClicked(View view){
        boolean check = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.activity_radio_women:
                if(check)
                  genere = getString(R.string.women);

            case R.id.activity_radio_men:
                if(check)
                    genere = getString(R.string.man);
                default:
                    genere = "";
        }
    }
    public void onCheckboxClicked (View view){
        boolean check = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.activity_checkbox:
                if(check)
                    sport = "Si";
            default:
                sport = "No";
        }
    }

    public void comeClean(){
        nombre.setText("");
        nombre.setError(null);
        telefono.setText("");
        telefono.setError(null);
        libros.setText("");
        libros.setError(null);
    }

}
