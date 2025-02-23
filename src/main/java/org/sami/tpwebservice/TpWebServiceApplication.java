package org.sami.tpwebservice;

import org.sami.tpwebservice.Entities.Custumer;
import org.sami.tpwebservice.Repository.CustumerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner(CustumerRepo custumerRepo) {
        return args -> {
            Custumer custumer = Custumer.builder().name("sami").email("email@sami.com").build();
            custumerRepo.save(custumer);
            custumerRepo.save(Custumer.builder()
                    .name("Noamane")
                    .email("noamane@sami.com")
                    .build());

            custumerRepo.save(Custumer.builder()
                    .name("Leila")
                    .email("leila@sami.com")
                    .build());

            custumerRepo.findAll().forEach(
                    c-> System.out.println(c.getName())
            );
        };
    }

}
