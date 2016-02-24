package com.learning.examples.resources;

import com.learning.examples.services.PdfGenerationService;
import com.learning.examples.views.ReportView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by ahmadhassan on 21/05/15.
 */

@Path("/")
public class HelloResource {

  @GET
  @Produces({"application/json"})

  public String getGreeting() {

    PdfGenerationService pdf = new PdfGenerationService();
    pdf.generate();
    return "{Has been created}";
  }

  @GET
  @Produces("text/html;charset=UTF-8")
  @Path("/home")
  public ReportView freemarkerUTF8() {
    return new ReportView() {
    };
  }

}
