package com.learning.examples.resources;

import com.google.common.base.Charsets;
import com.google.common.cache.CacheLoader;

import com.learning.examples.services.PdfGenerationService;
import com.learning.examples.views.ReportView;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.dropwizard.views.freemarker.FreemarkerViewRenderer;

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

  private static class TemplateLoader extends CacheLoader<Class<?>, Configuration> {

    private TemplateLoader() {
    }

    public Configuration load(Class<?> key) throws Exception {
      Configuration configuration = new Configuration(new Version(2, 3, 0));
      configuration
          .setObjectWrapper((new DefaultObjectWrapperBuilder(new Version(2, 3, 0)).build()));
      configuration.loadBuiltInEncodingMap();
      configuration.setDefaultEncoding(Charsets.UTF_8.name());
      configuration.setClassForTemplateLoading(key, "/");
      return configuration;
    }
  }

  @GET
  @Produces("text/html;charset=UTF-8")
  @Path("/home")
  public ReportView freemarkerUTF8() throws IOException, TemplateException {
//    ReportView reportView = new ReportView();
//    SreportView.toString();
    ReportView reportView = new ReportView();
    FreemarkerViewRenderer freemarkerViewRenderer = new FreemarkerViewRenderer();

    OutputStream outputStream = new FileOutputStream("out.html");
    freemarkerViewRenderer.render(reportView, new Locale("en"), outputStream);


    //Generate PDF
    PdfGenerationService pdf = new PdfGenerationService();
    pdf.generate();
    return reportView;
  }

}
