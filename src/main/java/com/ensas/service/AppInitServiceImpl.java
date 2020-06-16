package com.ensas.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ensas.dao.UserRepository;
import com.ensas.dao.FiliereRepository;
import com.ensas.entities.User;
import com.ensas.entities.Filiere;

@Service
public class AppInitServiceImpl implements IAppInitService {
	@Autowired
	private FiliereRepository filiereRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initAdmin() {

		//adminRepository.save(new Admin(null,"admin","admin","admin","admin"));

	}

	@Override
	public void initFiliere() {
		/*filiereRepository.save(new Filiere(null,"GENIE INFORMATIQUE",null));
		filiereRepository.save(new Filiere(null,"GENIE INDUSTRIEL",null));
		filiereRepository.save(new Filiere(null,"GENIE TELECOME&RESEAUX",null));*/

	}

}
