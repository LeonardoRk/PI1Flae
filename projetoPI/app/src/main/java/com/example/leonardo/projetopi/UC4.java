package com.example.leonardo.projetopi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 12/06/2016.
 */
public class UC4  extends Activity {

    private List<String> estados = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> spinnerArrayAdapter;
    private Spinner listaEstados;
    String nome, dataNascimento, email, senha, cpf , cep , cidade , bairro , endereco , compl , mat;
    private TextView texto98 , texto99 , texto97 , texto96, texto95, texto94, texto93 ,
            texto92 , texto91, texto90, texto89;
    Intent i;
    Cadastro cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc4);
        listaEstados = (Spinner) findViewById(R.id.spinner);
        i = getIntent();
        cadastro = (Cadastro) i.getSerializableExtra("Cadastro");

        estados = fillStates(estados);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estados);
        spinnerArrayAdapter = arrayAdapter;
        listaEstados.setAdapter(arrayAdapter);
        listaEstados.setSelection(6);

        texto98 = (TextView) findViewById(R.id.textView98);  texto98.setClickable(true);
        texto99 = (TextView) findViewById(R.id.textView99);  texto99.setClickable(true);
        texto97 = (TextView) findViewById(R.id.textView97);  texto97.setClickable(true);
        texto96 = (TextView) findViewById(R.id.textView96);  texto96.setClickable(true);
        texto95 = (TextView) findViewById(R.id.textView95);  texto95.setClickable(true);
        texto94 = (TextView) findViewById(R.id.textView94);   texto94.setClickable(true);
        texto93 = (TextView) findViewById(R.id.textView93);   texto93.setClickable(true);
        texto92  = (TextView) findViewById(R.id.textView92);   texto92.setClickable(true);
        texto91 = (TextView) findViewById(R.id.textView91);   texto91.setClickable(true);
        texto90 = (TextView) findViewById(R.id.textView90);   texto90.setClickable(true);
        texto89 = (TextView) findViewById(R.id.textView89);   texto89.setClickable(true);
        try{
            fillFieds();
        }catch (NullPointerException ex){
            Toast.makeText(UC4.this , "Não existe nenhum cadastro" , Toast.LENGTH_SHORT).show();
            Intent uc1 = new Intent();
            uc1.setClass(UC4.this , Inicial.class);
            startActivity(uc1);
            finish();
        }


    }

    public void fillFieds(){
        texto98.setText(cadastro.getNascimento());
        texto99.setText(cadastro.getNome());
        texto97.setText(cadastro.getEmail());
        texto96.setText(cadastro.getSenha());
        texto95.setText(cadastro.getCpf());
        texto94.setText(cadastro.getCep());
        texto93.setText(cadastro.getCidade());
        texto92.setText(cadastro.getBairro());
        texto91.setText(cadastro.getEndereco());
        texto90.setText(cadastro.getComplemento());
        texto89.setText(cadastro.getSaude());
    }

    public void clickou5(View v){
        texto98.setText("");
        texto98.setFocusable(true);
    }
    public void clickou9(View v){
        texto99.setText("");
        texto99.setFocusable(true);
    }
    public void clickou13(View v){
        texto97.setText("");
        texto97.setFocusable(true);
    }
    public void clickou17(View v){
        texto96.setText("");
    }
    public void clickou21(View v){
        texto95.setText("");
    }
    public void clickou23(View v){
        texto94.setText("");
    }
    public void clickou25(View v){
        texto93.setText("");
    }public void clickou30(View v){
        texto92.setText("");
    }
    public void clickou31(View v){
        texto91.setText("");
    }
    public void clickou32(View v){
        texto90.setText("");
    }
    public void clickou33(View v){
        texto89.setText("");
    }

    public void clicouAlterar(View view){
        nome = texto99.getText() + "";
        dataNascimento = texto98.getText() + "";
        email = texto97.getText() + "";
        senha =  texto96.getText() + "";
        cpf =  texto95.getText() + "";
        cep =  texto94.getText() + "";
        cidade = texto93.getText() + "";
        bairro =  texto92.getText() + "";
        endereco =  texto91.getText() + "";
        compl =  texto90.getText() + "";
        mat =  texto89.getText() + "";

        Log.i("nome" , nome);

        if(!nome.trim().isEmpty() && !dataNascimento.trim().isEmpty() && !email.trim().isEmpty() && !senha.trim().isEmpty() &&
                !cpf.trim().isEmpty() && !cep.trim().isEmpty() && !cidade.trim().isEmpty() && !bairro.trim().isEmpty() &&
                !endereco.trim().isEmpty() && !compl.trim().isEmpty() ){
            cadastro.setBairro(bairro); cadastro.setSenha(senha); cadastro.setCpf(cpf); cadastro.setSaude(mat);
            cadastro.setCep(cep); cadastro.setNome(nome); cadastro.setNascimento(dataNascimento);
            cadastro.setCidade(cidade); cadastro.setEndereco(endereco);
            cadastro.setComplemento(compl); cadastro.setEmail(email);
            Toast.makeText(this, "Alterações atualizadas", Toast.LENGTH_LONG).show();
            Intent uc3 = new Intent();
            uc3.putExtra("Cadastro" , cadastro);
            uc3.setClass(this, UC3.class);
            startActivity(uc3);
            finish();
        }else
            new AlertDialog.Builder(UC4.this)
                    .setTitle("Informações inválidas")
                    .setMessage("Preencha corretamente os campos vazios")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
    }

    public List<String> fillStates(List<String> estados){
        estados.add("AC"); estados.add("AL");  estados.add("AP");  estados.add("AM");
        estados.add("BA"); estados.add("CE");  estados.add("DF");  estados.add("ES");
        estados.add("GO"); estados.add("MA");  estados.add("MT");  estados.add("MS");
        estados.add("MG"); estados.add("PA");  estados.add("PB");  estados.add("PR");
        estados.add("PE"); estados.add("PI");  estados.add("RJ");  estados.add("RN");
        estados.add("RS"); estados.add("RO");  estados.add("RR");  estados.add("SC");
        estados.add("SP"); estados.add("SE");  estados.add("TO");

        return estados;
    }



}
