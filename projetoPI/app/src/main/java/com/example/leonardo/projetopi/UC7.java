package com.example.leonardo.projetopi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewParentCompatICS;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by Leonardo on 08/06/2016.
 */
public class UC7 extends FragmentActivity implements OnMapReadyCallback , View.OnClickListener  {
    GoogleMap mMap;
    Intent i;
    final String PRACA =  "Praça da Igreja" , ESCACIONAMENTO = "Estacionamento da Igreja" , PRACACENTRAL = "Praça central" ,
                COLEGIO = "Colégio dos irmãos" , MERCADO = "Mercado da Dona Rosa";
    Cadastro cadastro;
    Button voce , classificar , addFoto ;
    ImageView info , iconSearch;
    LatLng userLatLng , userLatLng1 , userLatLng2 , userLatLng3, userLatLng4 , userLatLng5;
    ArrayList<String> nomeLugares;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uc7);
        voce = (Button) findViewById(R.id.botaoVoce);

        addFoto = (Button) findViewById(R.id.botaoAddFoto);
        addFoto.setVisibility(View.INVISIBLE);
        addFoto.setOnClickListener(this);
        classificar = (Button) findViewById(R.id.botaoClassificar);
        classificar.setVisibility(View.INVISIBLE);
        classificar.setOnClickListener(this);

        info = (ImageView) findViewById(R.id.infoIcon);
        info.setOnClickListener(this);
        iconSearch = (ImageView) findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(this);

        nomeLugares = new ArrayList<>();
        nomeLugares = preencheNomeLugares(nomeLugares);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mMap = mapFragment.getMap();
        i = getIntent();
        cadastro = (Cadastro) i.getSerializableExtra("Cadastro");
    }

    public void clickouconfigurações(View view){
        Intent configuracoes = new Intent();
        configuracoes.setClass(UC7.this , UC3.class);
        configuracoes.putExtra("Cadastro" , cadastro);
        startActivity(configuracoes);
        finish();
    }

    public void clickouVoce(View view){
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(userLatLng.latitude, userLatLng.longitude), 10.0f));
    }

    public ArrayList<String> preencheNomeLugares(ArrayList<String> nomeLugares){
        nomeLugares.add(ESCACIONAMENTO);
        nomeLugares.add(MERCADO);
        nomeLugares.add(PRACACENTRAL);
        nomeLugares.add(COLEGIO);
        nomeLugares.add(PRACA);
        return nomeLugares;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botaoClassificar){
                new AlertDialog.Builder(UC7.this)
                        .setTitle("Classifique")
                        .setMessage("O local foi visitado?")
                        .setPositiveButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("LocalVisitado", "nao");
                            }
                        })
                        .setNegativeButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("LocalVisitado", "sim");
                            }
                        })
                        .setNeutralButton("Sim, Reincidente", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("LocalVisitado", "reincidente");
                            }
                        })
                        .show();

        }
        if(v.getId() == R.id.infoIcon){
            Intent infoPage = new Intent();
            infoPage.setClass(UC7.this , UC14.class);
            startActivity(infoPage);
        }

        if(v.getId() == R.id.botaoAddFoto){
            new AlertDialog.Builder(UC7.this)
                    .setTitle("Adicionar foto")
                    .setNeutralButton("Selecionar foto", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(UC7.this , "Abriu galeria" , Toast.LENGTH_SHORT ).show();
                        }
                    })
                    .setNegativeButton("Tirar foto", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(UC7.this , "Abriu câmera" , Toast.LENGTH_SHORT ).show();
                        }
                    })
                    .show();
        }
        if(v.getId() == R.id.iconSearch){
            Intent UC11 = new Intent();
            UC11.setClass(UC7.this , UC11.class);
            UC11.putExtra("NomeLugares" , nomeLugares);
            startActivity(UC11);
        }
        voce.setVisibility(View.VISIBLE);
        classificar.setVisibility(View.INVISIBLE);
        addFoto.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        userLatLng = new LatLng(-15.6577966, -48.1322276); // brazlandia location
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(userLatLng).title("Sua posição")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(userLatLng.latitude, userLatLng.longitude), 10.0f));

        // area de foco
        userLatLng1 = new LatLng(-15.6134, -48.3201);
        mMap.addMarker(new MarkerOptions().position(userLatLng1).title("FOCO").snippet(PRACA)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        userLatLng2 = new LatLng(-15.6034, -48.2401);
        mMap.addMarker(new MarkerOptions().position(userLatLng2).title("FOCO").snippet(PRACACENTRAL)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        userLatLng3 = new LatLng(-15.7034, -48.1401);
        mMap.addMarker(new MarkerOptions().position(userLatLng3).title("FOCO").snippet(ESCACIONAMENTO)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        userLatLng4 = new LatLng(-15.4034, -48.2401);
        mMap.addMarker(new MarkerOptions().position(userLatLng3).title("FOCO").snippet(COLEGIO)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        userLatLng5 = new LatLng(-15.9134, -48.3701);
        mMap.addMarker(new MarkerOptions().position(userLatLng3).title("FOCO").snippet(MERCADO)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                voce.setVisibility(View.INVISIBLE);

                classificar.setVisibility(View.VISIBLE);
                addFoto.setVisibility(View.VISIBLE);


            }
        });



    }





}

