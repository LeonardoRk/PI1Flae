package com.example.leonardo.projetopi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Leonardo on 16/06/2016.
 */
public class UC14 extends Activity implements View.OnClickListener {

    private Button transmissor , transmitidas , prevencao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc14);
        transmissor = (Button) findViewById(R.id.botaoTransmissor);
        transmissor.setOnClickListener(this);
        transmitidas = (Button) findViewById(R.id.botaoTrasmitidos);
        transmitidas.setOnClickListener(this);
        prevencao = (Button) findViewById(R.id.botaoPrevencao);
        prevencao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botaoTransmissor){
            Intent transmissor = new Intent();
            transmissor.setClass(UC14.this , Transmissor.class);
            startActivity(transmissor);
        }
        if(v.getId() == R.id.botaoTrasmitidos){
            Intent transmitidas = new Intent();
            transmitidas.setClass(UC14.this , Transmitidas.class);
            startActivity(transmitidas);
        }
        if(v.getId() == R.id.botaoPrevencao){
            Intent prevencao = new Intent();
            prevencao.setClass(UC14.this , Prevencao.class);
            startActivity(prevencao);
        }
    }
}
