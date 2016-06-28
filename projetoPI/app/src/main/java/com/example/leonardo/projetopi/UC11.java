package com.example.leonardo.projetopi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 17/06/2016.
 */
public class UC11 extends Activity  implements View.OnClickListener{

    TextView procura , campoNomes ;
    ImageView lupa , procuraLocal;
    ArrayList<String> nomeLocal;
    Intent receive;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc11);
        receive = getIntent();
        nomeLocal = (ArrayList<String>) receive.getSerializableExtra("NomeLugares");

        procuraLocal = (ImageView) findViewById(R.id.procuraLocal);
        procuraLocal.setOnClickListener(this);

        procura = (TextView) findViewById(R.id.campoProcura);
        procura.setOnClickListener(this);

        lupa = (ImageView) findViewById(R.id.procuraLocal);
        procura.setOnClickListener(this);

        list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent map = new Intent();
                    map.setClass(UC11.this, UC7.class);
                    startActivity(map);
                    finish();
            }
        });
    }
    List<String> nomesNaTela= new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.campoProcura){
            procura.setText("");
            nomesNaTela.clear();

        }
        if(v.getId() == R.id.procuraLocal){
            nomesNaTela.clear();
            for(int aux = 0 ; aux < nomeLocal.size() ; aux++){
                if (nomeLocal.get(aux).toUpperCase().contains(procura.getText().toString().toUpperCase())){
                    nomesNaTela.add(nomeLocal.get(aux));
                        adapter = new ArrayAdapter <String> (UC11.this ,
                                android.R.layout.simple_list_item_1,
                                nomesNaTela );

                }
            }

            list.setAdapter(adapter);
        }

    }
}
