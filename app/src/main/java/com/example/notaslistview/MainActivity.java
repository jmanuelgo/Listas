
package com.example.notaslistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre,nota1,nota2,nota3;
    Spinner carrera;
    ArrayList<NotasEstudiante>notas=new ArrayList<NotasEstudiante>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.txtNombre);
        nota1=findViewById(R.id.txtNota1);
        nota2=findViewById(R.id.txtNota2);
        nota3=findViewById(R.id.txtNota3);
        carrera=findViewById(R.id.spCarrera);
    }

    public void Registrar(View v){
        NotasEstudiante nt=new NotasEstudiante(nombre.getText().toString(),Double.parseDouble(nota1.getText().toString()),Double.parseDouble(nota2.getText().toString()),Double.parseDouble(nota3.getText().toString()),carrera.getSelectedItem().toString());
        notas.add(nt);
        nombre.setText("");
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
        carrera.setSelection(0);
    }

    public void Mostrar(View v){
        Intent it=new Intent(getApplicationContext(), ListviewNotas.class);
        it.putExtra("ListaNotas",(Serializable) notas);
        startActivity(it);
    }

}