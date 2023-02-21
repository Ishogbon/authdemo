package com.authentication.authdemo.AppUser;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_generator")
	 @SequenceGenerator(name="app_user_generator", sequenceName = "app_user_seq", allocationSize=1)
	    
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked = false;
	private Boolean enabled = true;
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param appUserRole
	 * @param locked
	 * @param enabled
	 */
	public AppUser() {}
	public AppUser(String firstName,
	            String lastName,
	            String email,
	            String password,
	            AppUserRole appUserRole) {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.email = email;
		 this.password = password;
		 this.appUserRole = appUserRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 SimpleGrantedAuthority authority =
	         new SimpleGrantedAuthority(appUserRole.name());
	 return Collections.singletonList(authority);
	}

	@Override
    public String getPassword() {
        return password;
    }
	
	public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getAppUserRole() {
    	return appUserRole.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
