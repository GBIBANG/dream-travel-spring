package gar.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import gar.org.entites.Bus;
import gar.org.entites.Client;


@SpringBootApplication
public class DreamTravalApplication implements CommandLineRunner {
	
	@Autowired
	RepositoryRestConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(DreamTravalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		config.exposeIdsFor(Client.class, Bus.class);
		config.setReturnBodyOnCreate(true);
		config.setReturnBodyOnUpdate(true);
		
		
	}

}
