package com.ensas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ensas.entities.Filiere;
@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere, Long>  {

}
