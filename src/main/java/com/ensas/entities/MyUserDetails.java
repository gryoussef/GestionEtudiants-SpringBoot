package com.ensas.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class MyUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7071074108004160726L;
	private Long id;
	private String cne;
	private String nom;
	private String prenom;
	private String userName;
	private String email;
	private String password;
	private Filiere filiere;
	private String roles;
	private List<GrantedAuthority> authorities;
	private Boolean active;
	
	
	public MyUserDetails(User user) {
		super();
		System.out.println(user.getRoles());
		System.out.println(user.getEmail());
		this.id = user.getId();
		this.cne =  user.getCne();
		this.nom =  user.getNom();
		this.prenom =  user.getPrenom();
		this.userName =  user.getUserName();
		this.email =  user.getEmail();
		this.password =  "{noop}"+user.getPassword();
		this.filiere = user.getFiliere();
		this.active=user.getActive();
		System.out.println(user.getRoles());
		this.authorities=Arrays.stream(user.getRoles().split(","))
                          .map(SimpleGrantedAuthority::new)
                          .collect(Collectors.toList());
		
		System.out.println(authorities.toString());
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}



	

	
	
	
}
