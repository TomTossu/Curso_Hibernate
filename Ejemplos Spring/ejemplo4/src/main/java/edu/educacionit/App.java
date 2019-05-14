package edu.educacionit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
    
    @Bean(name="servicioSaludo")
    public ISaludo obtenerSaludo() {
        // Composicion de objetos que es medio compleja
        // y lo quiero hacer a mano
        return new Saludo();
    }
}

interface ISaludo {
    void saludar();
}

@PropertySource("app.properties")
class Saludo implements ISaludo {
    
    @Value("${path}")
    private String path;
    
    public void saludar() {
        System.out.println("S A L U D O  A  T O D O S ! ! ! ! ");
        System.out.println("path: " + path);
    }
}

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        ISaludo saludo =
                appContext.getBean("servicioSaludo", Saludo.class);
        
        saludo.saludar();
    }
}
