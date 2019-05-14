package edu.educacionit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan({"edu.educacionit"})
class AppConfig {
    
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

class Saludo implements ISaludo {
    public void saludar() {
        System.out.println("S A L U D O  A  T O D O S ! ! ! ! ");
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
