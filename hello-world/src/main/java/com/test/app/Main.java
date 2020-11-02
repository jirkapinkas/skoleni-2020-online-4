package com.test.app;

import com.test.app.repository.ItemRepository;
import com.test.app.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // component scan mechanismus: abychom nemuseli rucne zapojovat vsechny Spring beany do Spring kontejneru
               // kdyz u @ComponentScan neni definovany balicek, ktery se bude scanovat, tak se bude scanovat aktualni balicek (a jeho podbalicky)
//@ComponentScan("com.test.app") // toto je to same jako @ComponentScan v tomto pripade!!!
public class Main {

    public static void main(String[] args) {
        // tohle by take fungovalo:
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloService.class, ItemRepository.class);

        // tohle je Spring kontejner, v cele aplikaci je 1x!!!!!!
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        HelloService helloService = applicationContext.getBean(HelloService.class);

        System.out.println(helloService.getCount());

    }

}
