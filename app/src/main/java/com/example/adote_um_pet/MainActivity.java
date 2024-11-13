package com.example.adote_um_pet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public ImageView logoPrincipal;
    public TextView tvLogin;
    public EditText edtLogin;
    public TextView tvSenha;
    public EditText edtSenha;
    public Button btEntrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        logoPrincipal = findViewById(R.id.LogoPrincipal);
        tvLogin = findViewById(R.id.tvLogin);
        edtLogin = findViewById(R.id.edtLogin);
        tvSenha = findViewById(R.id.tvSenha);
        edtSenha = findViewById(R.id.edtSenha);
        btEntrar = findViewById(R.id.btEntrar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Função para entrar na segunda tela
    public void telaDois(View view) {
        Intent in = new Intent(MainActivity.this, SegundaTela.class);

        //Verificar se os EditTexts estão vazios
        if(TextUtils.isEmpty(edtLogin.getText())){
            edtLogin.setError("Usuário vazio.");
        }else if(TextUtils.isEmpty(edtSenha.getText())){
            edtSenha.setError("Senha vazia.");
        }else{
            startActivity(in);
        }

    }
}