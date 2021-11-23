package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Autoridad")
public class Autoridad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CAutoridad;
	
	@Column(name="NAutoridad", length=60, nullable=false)
	private String NAutoridad;

	@Column(name="NumTelefono", nullable=false)
	private int NumTelefono;
	
	@Column(name="NDNI", length=60, nullable=false)
	private String NDNI;

	public Autoridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autoridad(int cAutoridad, String nAutoridad, int numTelefono, String nDNI) {
		super();
		CAutoridad = cAutoridad;
		NAutoridad = nAutoridad;
		NumTelefono = numTelefono;
		NDNI = nDNI;
	}

	public int getCAutoridad() {
		return CAutoridad;
	}

	public void setCAutoridad(int cAutoridad) {
		CAutoridad = cAutoridad;
	}

	public String getNAutoridad() {
		return NAutoridad;
	}

	public void setNAutoridad(String nAutoridad) {
		NAutoridad = nAutoridad;
	}

	public int getNumTelefono() {
		return NumTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		NumTelefono = numTelefono;
	}

	public String getNDNI() {
		return NDNI;
	}

	public void setNDNI(String nDNI) {
		NDNI = nDNI;
	}
	
	
	
}
