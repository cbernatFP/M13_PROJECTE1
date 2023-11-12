package cbm.itic.m12.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Oferta {
	@Id                  //jakarta.persistence.Id
	private long id;

	@Column(nullable = false, unique = true)
	private String lloc;

	@Column(nullable = false)
	private String jornada;

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(long id, String lloc, String jornada) {
		super();
		this.id = id;
		this.lloc = lloc;
		this.jornada = jornada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLloc() {
		return lloc;
	}

	public void setLloc(String lloc) {
		this.lloc = lloc;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", lloc=" + lloc + ", jornada=" + jornada + "]";
	}
	
	

}



