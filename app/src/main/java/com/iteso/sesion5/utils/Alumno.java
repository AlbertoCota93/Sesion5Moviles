package com.iteso.sesion5.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.sesion5.R;


public class Alumno  {
    public static void showStudentToast (
            Context context,
            String nombre,
            String telefono,
            String grado,
            String libro,
            String genero,
            String deportes,
            int duration){
        if (context instanceof Activity){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            View layout = inflater.inflate(R.layout.studenttoast,
                    (ViewGroup) ((AppCompatActivity)context).findViewById(R.id.student_layout));

            TextView name = layout.findViewById(R.id.student_name);
            name.setText(nombre);

            TextView phone = layout.findViewById(R.id.student_phone);
            phone.setText(telefono);

            TextView grade = layout.findViewById(R.id.student_scholarship);
            grade.setText(grado);

            TextView book= layout.findViewById(R.id.student_book);
            book.setText(libro);

            TextView gender= layout.findViewById(R.id.student_gender);
            gender.setText(genero);

            TextView sport= layout.findViewById(R.id.student_sport);
            sport.setText(deportes);

            Toast alumno = new Toast(context);
            alumno.setGravity(Gravity.CENTER_VERTICAL,0,0 );
            alumno.setDuration(duration);
            alumno.setView(layout);
            alumno.show();
        }
    }
}
