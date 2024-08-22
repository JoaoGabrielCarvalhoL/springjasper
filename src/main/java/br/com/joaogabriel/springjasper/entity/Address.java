package br.com.joaogabriel.springjasper.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	
	@Column(name = "logradouro")
	private String publicPlace;
	
	@Column(name = "numero")
	private int number;
	
	@Column(name = "complemento")
	private String complement;
	
	@Column(name = "bairro")
	private String neighborhood;
	
	@Column(name = "cidade")
	private String city;
	
	@Column(name = "uf")
	private String federativeUnit;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
	private List<Employeer> employeers;
	
	public Address() {}

	public Address(Long id, String publicPlace, int number, String complement, String neighborhood, String city,
			String federativeUnit) {
		super();
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.federativeUnit = federativeUnit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFederativeUnit() {
		return federativeUnit;
	}

	public void setFederativeUnit(String federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	public List<Employeer> getEmployeers() {
		return employeers;
	}

	public void setEmployeers(List<Employeer> employeers) {
		this.employeers = employeers;
	}

	

}
