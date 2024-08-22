package br.com.joaogabriel.springjasper.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telephone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private Long id;
	
	@Column(name = "numero")
	private String number;
	
	@Column(name = "tipo_fone")
	private String foneType;
	
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
	@ManyToOne
	private Employeer employeer;

	public Telephone() {}
	
	public Telephone(String number, String foneType) {
		super();
		this.number = number;
		this.foneType = foneType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFoneType() {
		return foneType;
	}

	public void setFoneType(String foneType) {
		this.foneType = foneType;
	}

	public Employeer getEmployeer() {
		return employeer;
	}

	public void setEmployeer(Employeer employeer) {
		this.employeer = employeer;
	}
	
	

}
