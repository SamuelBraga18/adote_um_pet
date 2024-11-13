package com.example.adote_um_pet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class SegundaTela extends AppCompatActivity {
    public Button btVoltar;
    public ImageView img;
    public Button btProximo;
    public Button btAnterior;
    public TextView tvNome;
    public TextView tvRaca;
    public TextView tvIdade;
    public Button btAdotar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);
        btVoltar = findViewById(R.id.btVoltar);
        btProximo = findViewById(R.id.btProximo);
        btAnterior = findViewById(R.id.btAnterior);
        img = findViewById(R.id.img);
        tvNome = findViewById(R.id.tvNome);
        tvRaca = findViewById(R.id.tvRaca);
        tvIdade = findViewById(R.id.tvIdade);
        btAdotar = findViewById(R.id.btAdotar);

        //Vetor que armazena as imagens
        int[] imagens = {
                R.drawable.imagem1,
                R.drawable.imagem2,
                R.drawable.imagem3,
                R.drawable.imagem4,
                R.drawable.imagem5,
                R.drawable.imagem6
        };

        String[] nomes = {
            "Billy",
            "Ambrosio",
            "Luna",
            "Garfield",
            "Teco",
            "Tom"
        };

        String[] racas = {
                "SRD",
                "Persa",
                "Pinscher",
                "Persa",
                "Pinscher",
                "Siamês"
        };

        String[] idades = {
                "7",
                "3",
                "2",
                "10",
                "5",
                "6"
        };

        final int[] index = {0};
        img.setImageResource(imagens[index[0]]);
        tvNome.setText(nomes[index[0]]);
        tvRaca.setText(racas[index[0]]);
        tvIdade.setText(idades[index[0]]);

        //Função do botão para passar para as informações do próximo animal
        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[0] = (index[0] +1)%imagens.length;
                //index[0] = (index[0] + 1)%nomes.length;
                img.setImageResource(imagens[index[0]]);
                tvNome.setText(nomes[index[0]]);
                tvRaca.setText(racas[index[0]]);
                tvIdade.setText(idades[index[0]]);
            }

        });

        //Função do botão para voltar às informações do animal anterior
        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[0] = (index[0] -1+imagens.length)%imagens.length;
                //index[0] = (index[0] - 1+ nomes.length)%nomes.length;
                img.setImageResource(imagens[index[0]]);
                tvNome.setText(nomes[index[0]]);
                tvRaca.setText(racas[index[0]]);
                tvIdade.setText(idades[index[0]]);
            }

        });

        //Função do botão para voltar à tela de login
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void adotar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adoção");
        builder.setMessage("Parabéns, você adotou um pet!");
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}