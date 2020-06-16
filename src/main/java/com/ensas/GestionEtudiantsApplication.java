package com.ensas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ensas.dao.UserRepository;
import com.ensas.service.AppInitServiceImpl;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class GestionEtudiantsApplication implements CommandLineRunner {
	@Autowired
    private AppInitServiceImpl initApp;
	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initApp.initAdmin();
		initApp.initFiliere();
		
	}

}
