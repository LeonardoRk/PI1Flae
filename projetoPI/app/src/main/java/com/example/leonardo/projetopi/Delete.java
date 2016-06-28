package com.example.leonardo.projetopi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Leonardo on 13/06/2016.
 */
public class Delete extends Activity {

    Intent i;
    Cadastro cadastro;
    TextView nome, email, cpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        i = getIntent();
        cadastro = (Cadastro) i.getSerializableExtra("Cadastro");
        nome = (TextView) findViewById(R.id.textView34);
        email = (TextView) findViewById(R.id.textView36);
        cpf = (TextView) findViewById(R.id.textView38);
        try {
            nome.setText(cadastro.getNome());
            email.setText(cadastro.getEmail());
            cpf.setText(cadastro.getCpf());
        } catch (NullPointerException ex) {
            Toast.makeText(this, "Nenhum cadastro realizado", Toast.LENGTH_SHORT).show();
            Intent inicial = new Intent();
            inicial.setClass(this, Inicial.class);
            startActivity(inicial);
            finish();
        }


    }


    public void clickouDelete(View view){
        cadastro.setBairro(""); cadastro.setSenha(""); cadastro.setCpf(""); cadastro.setSaude("");
        cadastro.setCep(""); cadastro.setNome(""); cadastro.setNascimento("");
        cadastro.setCidade(""); cadastro.setEndereco("");
        cadastro.setComplemento(""); cadastro.setEmail("");

        Toast.makeText(this , "Cadastro deletado com sucesso" , Toast.LENGTH_SHORT).show();
        Intent uc3 = new Intent();
        uc3.setClass(this , UC3.class);
        startActivity(uc3);
        finish();
    }
}
