package com.example.prova_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastrarAtividade extends AppCompatActivity {
    ArrayList<AtividadeComplementar> atividadesComplementares = new ArrayList<>();
    Spinner categoriaSP;
    EditText nomeET, emailET, descricaoET, horasET;
    String nome, email, descricao, horas, categoria;
    Button salvar;
    ArrayList<String> stringArraylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_atividade);

        nomeET = findViewById(R.id.nomeL);
        emailET = findViewById(R.id.emailL);
        descricaoET = findViewById(R.id.descricaoL);
        horasET = findViewById(R.id.horasL);
        categoriaSP = findViewById(R.id.categoriaL);
        salvar = findViewById(R.id.salvarL);

        stringArraylist.add("Categoria 1 – Cursos");
        stringArraylist.add("Categoria 2 – Projetos");
        stringArraylist.add("Categoria 3 – Pesquisas");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                stringArraylist
        );

        categoriaSP.setAdapter(stringArrayAdapter);
        categoriaSP.setOnItemSelectedListener(mOuvinte);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                atividadesComplementares = (ArrayList<AtividadeComplementar>) i.getSerializableExtra("atividadesComplementares");
                nome = nomeET.getText().toString();
                email = emailET.getText().toString();
                descricao = descricaoET.getText().toString();
                horas = (String) horasET.getText().toString();
                categoria = categoriaSP.getSelectedItem().toString();

                Log.e("Informação", "Nome: " + nome);
                Log.e("Informação", "Email: " + email);
                Log.e("Informação", "Descrição: " + descricao);
                Log.e("Informação", "Horas: " + horas);
                Log.e("Informação", "Categoria: " + categoria);

                if (!nome.isEmpty() && !email.isEmpty() && !descricao.isEmpty() && !horas.isEmpty()) {
                    atividadesComplementares.add(new AtividadeComplementar(nome, email, descricao, horas, categoria));
                    Toast.makeText(getApplicationContext(), "Atividade Cadastrada", Toast.LENGTH_SHORT).show();

                    Intent ii = new Intent(CadastrarAtividade.this, MainActivity.class);
                    ii.putExtra("atividadesComplementares", atividadesComplementares);
                    startActivity(ii);
                } else {
                    Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    AdapterView.OnItemSelectedListener mOuvinte = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String itemSelecionado = categoriaSP.getSelectedItem().toString();
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {}
    };
}