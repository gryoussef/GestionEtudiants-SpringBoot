package com.ensas.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 55)
	private String cne;
	@Column(length = 55)
	private String nom;
	@Column(length = 55)
	private String prenom;
	@Column(length = 55)
	private String userName;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String password;
	@ManyToOne()
	private Filiere filiere;
	@Column(length = 55)
	private String roles;
	private Boolean active;
}
