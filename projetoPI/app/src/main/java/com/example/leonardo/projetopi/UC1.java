package com.example.leonardo.projetopi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Leonardo on 06/06/2016.
 */
public class UC1 extends Activity {

    private List<String> estados = new ArrayList<> ();
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> spinnerArrayAdapter;
    private Spinner listaEstados;
    String nome, dataNascimento, email, senha, cpf , cep , cidade , bairro , endereco , compl , mat;
    private TextView texto5 , texto9 , texto13 , texto17, texto21, texto23, texto25 ,
                     texto30 , texto31, texto32, texto33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc1);
        listaEstados = (Spinner) findViewById(R.id.spinner);


        estados = fillStates(estados);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estados);
        spinnerArrayAdapter = arrayAdapter;
        listaEstados.setAdapter(arrayAdapter);
        listaEstados.setSelection(6);

        texto5 = (TextView) findViewById(R.id.textView5);  texto5.setClickable(true);
        texto9 = (TextView) findViewById(R.id.textView9);  texto9.setClickable(true);
        texto13 = (TextView) findViewById(R.id.textView13);  texto13.setClickable(true);
        texto17 = (TextView) findViewById(R.id.textView17);  texto17.setClickable(true);
        texto21 = (TextView) findViewById(R.id.textView21);  texto21.setClickable(true);
        texto23 = (TextView) findViewById(R.id.textView23);   texto23.setClickable(true);
        texto25 = (TextView) findViewById(R.id.textView25);   texto25.setClickable(true);
        texto30  = (TextView) findViewById(R.id.textView30);   texto30.setClickable(true);
        texto31 = (TextView) findViewById(R.id.textView31);   texto31.setClickable(true);
        texto32 = (TextView) findViewById(R.id.textView32);   texto32.setClickable(true);
        texto33 = (TextView) findViewById(R.id.textView33);   texto33.setClickable(true);

    }

    public void clickou5(View v){
        texto5.setText("");
        texto5.setFocusable(true);
    }
    public void clickou9(View v){
        texto9.setText("");
        texto9.setFocusable(true);
    }
    public void clickou13(View v){
        texto13.setText("");
        texto13.setFocusable(true);
    }
    public void clickou17(View v){
        texto17.setText("");
    }
    public void clickou21(View v){
        texto21.setText("");
    }
    public void clickou23(View v){
        texto23.setText("");
    }
    public void clickou25(View v){
        texto25.setText("");
    }public void clickou30(View v){
        texto30.setText("");
    }
    public void clickou31(View v){
        texto31.setText("");
    }
    public void clickou32(View v){
        texto32.setText("");
    }
    public void clickou33(View v){
        texto33.setText("");
    }

    public void clicouCadastrar(View view){
        nome = texto9.getText() + "";
        dataNascimento = texto5.getText() + "";
        email = texto13.getText() + "";
        senha =  texto17.getText() + "";
        cpf =  texto21.getText() + "";
        cep =  texto23.getText() + "";
        cidade = texto25.getText() + "";
        bairro =  texto30.getText() + "";
        endereco =  texto31.getText() + "";
        compl =  texto32.getText() + "";
        mat =  texto33.getText() + "";

        if(!nome.trim().isEmpty() && !dataNascimento.trim().isEmpty() && !email.trim().isEmpty() && !senha.trim().isEmpty() &&
                !cpf.trim().isEmpty() && !cep.trim().isEmpty() && !cidade.trim().isEmpty() && !bairro.trim().isEmpty() &&
                !endereco.trim().isEmpty() && !compl.trim().isEmpty()){
            Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_LONG).show();
            Cadastro cadastro = new Cadastro(nome, dataNascimento , email , senha , cpf , cep , cidade , bairro , endereco ,
                    compl);
            cadastro.setSaude(mat);
            Intent uc2 = new Intent();
            uc2.setClass(this , UC2.class);
            Log.i("senha" , cadastro.getSenha());
            uc2.putExtra("Cadastro" ,  cadastro);
            startActivity(uc2);
        }else
            new AlertDialog.Builder(UC1.this)
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
