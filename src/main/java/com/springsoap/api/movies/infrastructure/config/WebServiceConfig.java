package com.springsoap.api.movies.infrastructure.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/movies/*");
  }

  @Bean(name = "movies")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema movieSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("MoviesPort");
    wsdl11Definition.setLocationUri("/movies/search");
    wsdl11Definition.setTargetNamespace("http://springsoap.com/api/movies");
    wsdl11Definition.setSchema(movieSchema);
    return wsdl11Definition;
  }

  @Bean
  public XsdSchema moviesSchema() {
    return new SimpleXsdSchema(new ClassPathResource("/wsdl/movies.xsd"));
  }
}