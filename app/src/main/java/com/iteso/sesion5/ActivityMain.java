package com.iteso.sesion5;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    Spinner spinner;
    EditText nombre;
    EditText telefono;
    AutoCompleteTextView libros;
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

        spinner = findViewById(R.id.main_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        libros = findViewById(R.id.activity_autocomplete);
        String[] books = getResources().getStringArray(R.array.books);
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, books);
        libros.setAdapter(stringAdapter);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setMessage("Deseas Limpiar?").setPositiveButton("Limpiar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                }
        }

        );


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_save:
                Toast save;
                //save= Toast.makeText(ActivityMain.this, )
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
        boolean check = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.activity_checkbox:
                if(check)
                    sport = "Si";
                else
                    sport = "No";
            default:
                sport = "No";
        }
    }

    public void confirmCleanAction(){
      //  DialogFragment dialogFragment = new ConfirmCleanAction();
    }
}
