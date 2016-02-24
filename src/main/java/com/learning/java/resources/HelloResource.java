package com.learning.java.resources;

import com.learning.java.services.PdfGenerationService;

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


}
