package com.iteso.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    Spinner spinner;
    EditText nombre;
    EditText telefono;
    RadioButton hombre;
    RadioButton mujer;
    AutoCompleteTextView libros;
    String genere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
