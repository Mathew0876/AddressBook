package TheBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            AddressBook addressBook = new AddressBook("book1");
            BuddyInfo buddy = new BuddyInfo("Fred", "Carleton", "865");
            addressBook.addBuddy(buddy);

            log.info("-Before save---");
            log.info(addressBook.toString());
            log.info("----------------");

            repository.save(addressBook);

            //AddressBook t = repository.findById(1);

            BuddyInfo buddy1 = new BuddyInfo("Testing", "Carleton", "865");
            addressBook.addBuddy(buddy1);

            repository.save(addressBook);


            log.info("Address Books found with findAll():");
            log.info("-----------------");
            for (AddressBook book : repository.findAll()) {
                log.info(book.toString());
            }
            log.info("-----------------");


        };

    }
}