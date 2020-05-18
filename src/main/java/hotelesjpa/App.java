package hotelesjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

    		SpringApplication.run(App.class, args);
    	
    }

    @Override
    public void run(String... args) throws Exception {

/*
        Movie movie = new Movie (1L,"La Peli", "Steven Spielberg", 1984, "La peli basicamente un mocazo");

        log.info("Inserting -> {}", repository.save(movie));

        log.info("Movie id 1 -> {}", repository.findById(1L));

        Movie movie2 = new Movie (2L,"Otra Peli", "James Cameron", 1986, "Esta peli tambien es un mocazo");

        log.info("Inserting -> {}", repository.save(movie2));

        log.info("Busco la que coincide con Otra Pe -> {}", repository.findByTitleContainingIgnoreCase("Otra Pe%"));

        log.info("Busco la que coincide con el director Steven-> {}", repository.findByDirectorLike("Steven%"));

        //log.info("Update 10003 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

        //repository.deleteById(10002L);

        log.info("All movies -> {}", repository.findAll());
        */
    }
}
