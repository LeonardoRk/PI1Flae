package com.example.leonardo.projetopi;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;

public class UC2 extends Activity {

    private TextView campoEmail, campoSenha ;
    Bundle extras;
    String email = "81d675cW&%*(Hx153" , senha = "15ZORTY)(+8/z*ad" ;
    Cadastro cadastro;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc2);

        campoEmail = (TextView) findViewById(R.id.campoEmail); campoEmail.setClickable(true);
        campoSenha = (TextView) findViewById(R.id.campoSenha); campoSenha.setClickable(true);
        try{
            i = getIntent();
            cadastro = (Cadastro) i.getSerializableExtra("Cadastro");
        }catch (NullPointerException ex){
            Toast.makeText(this , "Ninguem cadastrado" , Toast.LENGTH_LONG).show();
            Intent inicial = new Intent();
            inicial.setClass(this , Inicial.class);
            startActivity(inicial);
            finish();
        }

    }



    public void clickouEmail(View v){
        campoEmail.setText("");
    }
    public void clickouSenha(View v){
        campoSenha.setText("");
    }

    public void clicouCadastrar(View view){
        String emailString , senhaString;
        emailString = campoEmail.getText() + "";
        senhaString = campoSenha.getText() + "";
        try{
            if(emailString.compareTo(cadastro.getEmail()) == 0 && senhaString.compareTo(cadastro.getSenha()) == 0){
                Toast.makeText(this , "Logou" , Toast.LENGTH_LONG).show();
                Intent uc7 = new Intent();
                uc7.setClass(this , UC7.class);
                uc7.putExtra("Cadastro" ,  cadastro);
                startActivity(uc7);
                finish();
            }else{
                new AlertDialog.Builder(UC2.this)
                        .setTitle("Informações inválidas")
                        .setMessage("Email ou senha inválidos")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }catch (NullPointerException e){
            Toast.makeText(this , "Ninguém cadastrado ainda " , Toast.LENGTH_SHORT).show();
            Intent inicial = new Intent();
            inicial.setClass(this , Inicial.class);
            startActivity(inicial);
            finish();
        }


    }
}
