package com.test.app;

import com.test.app.service.HelloService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ComponentScan // component scan mechanismus: abychom nemuseli rucne zapojovat vsechny Spring beany do Spring kontejneru
               // kdyz u @ComponentScan neni definovany balicek, ktery se bude scanovat, tak se bude scanovat aktualni balicek (a jeho podbalicky)
//@ComponentScan("com.test.app") // toto je to same jako @ComponentScan v tomto pripade!!!
public class Main {

    @Bean
    public HikariDataSource dataSource() {
//        System.out.println("dataSource constructed!");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:hsqldb:hsql://localhost:9001/eshop");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate() {
////        System.out.println("jdbcTemplate constructed!");
//        return new JdbcTemplate(dataSource());
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource, @Value("${java.version}") String javaVersion) {
//        System.out.println("java version: " + javaVersion);
////        System.out.println("jdbcTemplate constructed!");
//        return new JdbcTemplate(dataSource);
//    }
//

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        System.out.println("jdbcTemplate constructed!");
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dummy");
        applicationContext.register(Main.class);
        applicationContext.refresh(); // timto se naplni Spring kontejner objekty

        // NEBO NASTAVIT DO VM options: -Dspring.profiles.active="dev"
        // tohle je Spring kontejner, v cele aplikaci je 1x!!!!!!
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        // tohle by take fungovalo:
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloService.class, ItemRepository.class);

        HelloService helloService = applicationContext.getBean(HelloService.class);

        System.out.println(helloService.getCount());

    }

}
