package br.com.joaogabriel.springjasper.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargos")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo")
	private Long id;
	
	@Column(name = "titulo")
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<Employeer> employeers;
	
	@ManyToMany(mappedBy = "roles")
	private List<Department> departments;
	
	public Role() {}

	public Role(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Employeer> getEmployeers() {
		return employeers;
	}

	public void setEmployeers(List<Employeer> employeers) {
		this.employeers = employeers;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	

}
