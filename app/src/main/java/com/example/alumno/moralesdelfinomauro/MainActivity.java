package com.example.alumno.moralesdelfinomauro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, Handler.Callback{

  Handler h;
  Worker w;
  Thread h1;
  EditText user;
  EditText pass;
  Button boton;
  Intent intento;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
      h = new Handler(this);

     boton = (Button) findViewById(R.id.boton);
    boton.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    //Log.d("Hola","Hola");

    user = (EditText) findViewById(R.id.user);
    pass = (EditText) findViewById(R.id.pass);
    String us = user.getText().toString();
    String ps = pass.getText().toString();
    Log.d(us,ps);

    /*
    * mail: mauro06.1993@gmail.com
    *
    * mauro06_93@hotmail.com
    *
    * */


      Log.d("Hola","Hola");
      w = new Worker(h,"http://192.168.2.159:3000/login/"+us+"/"+ps,true);
      h1= new Thread(w);
      h1.start();








  }

  @Override
  public boolean handleMessage(Message msg) {
    Log.d("handle", "mensaje sagrado");
    JSONObject a = (JSONObject)msg.obj;
    String tipo= null;
    Intent intento = new Intent(this,Main2Activity.class);
    try {
      tipo = a.getString("type");
    } catch (JSONException e) {
      e.printStackTrace();
    }
    Log.d("Objeto:" , a.toString() + tipo);
    if (tipo.equals("User"))
    {
      Log.d("usuarrioo:" ,tipo);

      intento.putExtra("resp",tipo);
      super.startActivity(intento);
    }
    else if(tipo.equals("Admin"))
    {
      Log.d("adddd:" , tipo);
      intento.putExtra("resp",tipo);
      super.startActivity(intento);
    }
    else if(tipo.equals("error"))
    {
      Log.d("erorr:" ,tipo);
      intento.putExtra("resp",tipo);
      super.startActivity(intento);
    }
    return false;



  }
}
