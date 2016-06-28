package com.example.leonardo.projetopi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Leonardo on 13/06/2016.
 */
public class UC3 extends Activity {

    Intent i;
    Cadastro cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc3);
        i = getIntent();
        cadastro = (Cadastro) i.getSerializableExtra("Cadastro");
    }

    public void clickouAlterar(View view){
        Intent uc4 = new Intent();
        uc4.setClass(this , UC4.class);
        uc4.putExtra("Cadastro" , cadastro);
        startActivity(uc4);
        finish();
    }

    public void clickouParaDelete(View view){
        Intent delete = new Intent();
        delete.setClass(this , Delete.class);
        delete.putExtra("Cadastro" , cadastro);
        startActivity(delete);
        finish();
    }

    public void clickouSair(View view){
        new AlertDialog.Builder(UC3.this)
                .setTitle("Alerta")
                .setMessage("Voce realmente deseja sair?")
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent uc7 = new Intent();
                        uc7.setClass(UC3.this , UC7.class);
                        startActivity(uc7);
                        finish();
                    }
                })
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

}
