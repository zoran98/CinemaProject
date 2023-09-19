package cinema.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import cinema.enumerations.KorisnickaUloga;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private KorisnickaUloga role;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Projekcija> projekcije = new ArrayList<Projekcija>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Karta> karte = new ArrayList<Karta>();

    public User(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public KorisnickaUloga getRole() {
		return role;
	}


	public void setRole(KorisnickaUloga role) {
		this.role = role;
	}

    

}
