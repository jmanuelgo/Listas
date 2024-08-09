package com.example.notaslistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListviewNotas extends AppCompatActivity {
    ListView notas;
    ArrayList<NotasEstudiante>notasEst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview_notas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        notas=findViewById(R.id.lwNotas);
        notasEst= (ArrayList<NotasEstudiante>) getIntent().getSerializableExtra("ListaNotas");

        if (notasEst!=null){
            ArrayAdapter<NotasEstudiante> adapter=new ArrayAdapter<>(this,R.layout.listviewpersonalizado,notasEst);
            notas.setAdapter(adapter);
        }
        notas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NotasEstudiante selectedNota = notasEst.get(i);
                double nota1 = selectedNota.getNota1();
                double nota2 = selectedNota.getNota2();
                double nota3 = selectedNota.getNota3();

                String toastMessage = "Nota1: " + nota1 + ", Nota2: " + nota2 + ", Nota3: " + nota3 + " - " + adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ListviewNotas.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}