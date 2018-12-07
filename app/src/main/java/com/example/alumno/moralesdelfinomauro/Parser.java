package com.example.alumno.moralesdelfinomauro;

/**
 * Created by alumno on 06/12/2018.
 */

import android.util.Log;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 11/10/2018.
 */

public class Parser {

  public static List<JSONObject> JASON(String s) throws JSONException {

    JSONObject usuarios = new JSONObject(s);
    JSONArray listaJson = new JSONArray(s);
    List<JSONObject> a = new ArrayList<>();
    for(int i=0; i< listaJson.length();i++)
    {
      try {
        JSONObject o = listaJson.getJSONObject(i);
        a.add(o);
      } catch (JSONException e) {
        e.printStackTrace();
      }

    }
    return a;
  }
  public static JSONObject JASON2(String s) throws JSONException {

    Log.d("JSON2","JSON2");
    JSONObject usuarios = new JSONObject(s);

    return usuarios;
  }

//public static String json(String stringXML)


}
