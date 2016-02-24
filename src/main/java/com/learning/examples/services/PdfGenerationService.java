package com.learning.examples.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ahmad.hassan on 23/02/16.
 */
public class PdfGenerationService {

  public String generate() {
    // step 1
    Document document = new Document();
    // step 2
    String fileName = "monthly_report";
    PdfWriter writer = null;
    try {
      writer =
          PdfWriter
              .getInstance(document, new FileOutputStream("results/" + fileName + ".pdf"));
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // step 3
    document.open();
    // step 4
    try {
      XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                                               new FileInputStream("pdfDesigns/index.ftl"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    //step 5
    document.close();

    return ("PDF Created!");
  }
}
