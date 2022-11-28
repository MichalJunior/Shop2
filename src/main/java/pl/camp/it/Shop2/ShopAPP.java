package pl.camp.it.Shop2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.Shop2.configuration.AppConfiguration;
import pl.camp.it.Shop2.core.Engine;

import java.io.*;

public class ShopAPP {
    public static void main(String[] args) {
        try {
            ApplicationContext pudeleczko = new AnnotationConfigApplicationContext(AppConfiguration.class);
            Engine engine = pudeleczko.getBean(Engine.class);
            engine.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
