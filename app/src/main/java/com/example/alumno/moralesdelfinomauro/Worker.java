package com.example.alumno.moralesdelfinomauro;

/**
 * Created by alumno on 06/12/2018.
 */

import android.os.Handler;
import android.os.Message;

import java.net.URL;

/**
 * Created by alumno on 11/10/2018.
 */

public class Worker extends Thread {

  Handler h;
  URL url;
  boolean img,json;
  String conex;
  String urlImg;
  int pos;

  public Worker(Handler h, String url)
  {
    this.h =h;
    this.conex = url;

  }

  public Worker(Handler h,String url, boolean json)
  {
    this.h =h;
    this.conex = url;
    this.json = json;

  }
  @Override
  public void run() {

    try {
      if(json == true)
      {
        HttpConection z = new HttpConection("GET");
        Message m = new Message();
        m.arg1 = 1;
        m.obj = Parser.JASON2(new String(z.getStringData(conex)));
        h.sendMessage(m);

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
