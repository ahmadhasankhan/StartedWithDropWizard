package com.learning.examples.services;

import java.io.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Locale;

/**
 * Created by ahmad.hassan on 25/02/16.
 */
public class HtmlGenerator {

  public static void main(String[] args)
      throws Exception {
        /*  first, get and initialize an engine  */
    VelocityEngine ve = new VelocityEngine();
    ve.init();
        /*  next, get the Template  */
    Template t = ve.getTemplate("pdfDesigns/index.vm");
        /*  create a context and add data */
    VelocityContext context = new VelocityContext();
    context.put("name", "Ahmad");
        /* now render the template into a StringWriter */
    StringWriter writer = new StringWriter();
    t.merge(context, writer);
        /* show the World */
    System.out.println(writer.toString());

    try {
      File newTextFile = new File("out.html");

      FileWriter fw = new FileWriter(newTextFile);
      fw.write(writer.toString());
      fw.close();

    } catch (IOException iox) {
      //do stuff with exception
      iox.printStackTrace();
    }

  }
}
