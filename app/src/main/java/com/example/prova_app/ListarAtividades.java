package com.example.prova_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarAtividades extends AppCompatActivity {
    ArrayList<AtividadeComplementar> atividadesComplementares = new ArrayList<>();
    ListView listaDeAtividadesLV;
    ArrayList<String> atividades = new ArrayList<>();;
    ArrayAdapter<String> arrayAdapter;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividades);
        Intent i = getIntent();
        if (i.getExtras() != null){
            atividadesComplementares = (ArrayList<AtividadeComplementar>) i.getSerializableExtra("atividadesComplementares");
        }

        voltar = findViewById(R.id.voltarL);
        listaDeAtividadesLV = findViewById(R.id.listaDeAtividadesL);

        for (AtividadeComplementar atividadeComplementar : atividadesComplementares) {
            atividades.add(atividadeComplementar.toString());
        }

        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                atividades
        );
        listaDeAtividadesLV.setAdapter(arrayAdapter);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(ListarAtividades.this, MainActivity.class);
                ii.putExtra("atividadesComplementares", atividadesComplementares);
                startActivity(ii);
            }
        });
    }
}