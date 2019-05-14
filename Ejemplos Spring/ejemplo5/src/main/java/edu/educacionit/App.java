package edu.educacionit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan({"edu.educacionit"})
@PropertySource("app.properties")
class AppConfig {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer get() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

@PropertySource("app.properties")
class Saludo {
    
    @Value("${path}")
    private String path;
    
    public void saludar() {
        System.out.println("S A L U D O  A  T O D O S ! ! ! ! ");
        System.out.println("path: " + path);
    }
}

@Service("ServicioPermanente")
@Scope("singleton")
class ServicioPermanente {

    public ServicioPermanente() {
        System.out.println("Instanciando ServicioPermanente ");
    }
    
    public void show() {
        System.out.println("ServicioPermanente");
    }
}

@Service("ServicioTransitorio")
@Scope("prototype")
class ServicioTransitorio {
    public ServicioTransitorio() {
        System.out.println("Instanciando ServicioTransitorio");
    }
    
    public void show() {
        System.out.println("ServicioTransitorio");
    }
}

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        appContext.getBean("ServicioPermanente", ServicioPermanente.class).show();
        appContext.getBean("ServicioPermanente", ServicioPermanente.class).show();
        appContext.getBean("ServicioPermanente", ServicioPermanente.class).show();
        
        appContext.getBean("ServicioTransitorio", ServicioTransitorio.class).show();
        appContext.getBean("ServicioTransitorio", ServicioTransitorio.class).show();
        appContext.getBean("ServicioTransitorio", ServicioTransitorio.class).show();
    }
}
