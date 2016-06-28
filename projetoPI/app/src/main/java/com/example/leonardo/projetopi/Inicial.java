package com.example.leonardo.projetopi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Leonardo on 13/06/2016.
 */
public class Inicial extends Activity {

    Intent i;
    Cadastro cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial);
        i = getIntent();
        cadastro = (Cadastro) i.getSerializableExtra("Cadastro");

    }

    public void clickouCadastrar(View view){
        Intent uc1 = new Intent();
        uc1.setClass(this , UC1.class);
        startActivity(uc1);
        finish();
    }
    public void clickouLogin(View view){
            Intent uc2 = new Intent();
            uc2.setClass(this , UC2.class);
            uc2.putExtra("Cadastro" , cadastro);
            startActivity(uc2);
            finish();
    }
    public void clickouAgoraNao(View view){
        Intent uc7 = new Intent();
        uc7.setClass(this , UC7.class);
        startActivity(uc7);

    }
}
