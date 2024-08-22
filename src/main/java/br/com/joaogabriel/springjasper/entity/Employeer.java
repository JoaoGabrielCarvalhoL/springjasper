package br.com.joaogabriel.springjasper.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Employeer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "data_nascimento")
	private LocalDate birthOfDate;

	@Lob
	@Column(name = "foto")
	private byte[] picture;
	
	@Column(name = "salario")
	private BigDecimal salary;

	@Column(name = "data_admissao")
	private LocalDate dateOfAdmission;
	
	@Column(name = "data_demissao")
	private LocalDate dateOfDismissal;
	
	@JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
	@ManyToOne
	private Role role;
	
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	@ManyToOne
	private Address address;
	
	@JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
	@ManyToOne
	private Level level;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeer")
	private List<Telephone> telephones;
	
	public Employeer() {}

	public Employeer(String name, LocalDate birthOfDate, byte[] picture, BigDecimal salary, LocalDate dateOfAdmission,
			LocalDate dateOfDismissal, Role role, Address address, Level level) {
		super();
		this.name = name;
		this.birthOfDate = birthOfDate;
		this.picture = picture;
		this.salary = salary;
		this.dateOfAdmission = dateOfAdmission;
		this.dateOfDismissal = dateOfDismissal;
		this.role = role;
		this.address = address;
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(LocalDate birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public LocalDate getDateOfDismissal() {
		return dateOfDismissal;
	}

	public void setDateOfDismissal(LocalDate dateOfDismissal) {
		this.dateOfDismissal = dateOfDismissal;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	
	
}
