package com.example.prova_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AtividadeComplementar> atividadesComplementares = new ArrayList<>();
    Button cadAtv, conAtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent ii = getIntent();
        if (ii.getExtras() != null){
            atividadesComplementares = (ArrayList<AtividadeComplementar>) ii.getSerializableExtra("atividadesComplementares");
        }

        cadAtv = findViewById(R.id.cadAtvL);
        conAtv = findViewById(R.id.conAtvL);

        cadAtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("cadastrar funciona?", "É funciona!");
                Intent i = new Intent(MainActivity.this, CadastrarAtividade.class);
                i.putExtra("atividadesComplementares", atividadesComplementares);
                startActivity(i);
            }
        });

        conAtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("listar funciona?", "É funciona!");
                Intent iii = new Intent(MainActivity.this, ListarAtividades.class);
                iii.putExtra("atividadesComplementares", atividadesComplementares);
                startActivity(iii);
            }
        });
    }
}