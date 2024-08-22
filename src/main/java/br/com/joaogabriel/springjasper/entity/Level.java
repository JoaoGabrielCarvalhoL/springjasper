package br.com.joaogabriel.springjasper.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "niveis")
public class Level implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nivel")
	private Long id;
	
	@Column(name = "nivel")
	private String level;
	
	private BigDecimal bonus;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
	private List<Employeer> employeers;
	
	public Level() {}

	public Level(Long id, String level, BigDecimal bonus) {
		super();
		this.id = id;
		this.level = level;
		this.bonus = bonus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public List<Employeer> getEmployeers() {
		return employeers;
	}

	public void setEmployeers(List<Employeer> employeers) {
		this.employeers = employeers;
	}
	
	
}
