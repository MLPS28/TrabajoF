package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reporte")
public class Reporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CReporte;
	
	@NotEmpty(message = "Debe ingresar la descripción*")
	@Column(name="TDescripcion", length=80, nullable=false)
	private String TDescripcion;
	
	@Column(name="QPuntosReporte", nullable=false)
	private int QPuntosReporte;
	
	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha tiene que ser en el pasado")
	@Temporal(TemporalType.DATE)
	@Column(name="DFecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DFecha;
	
	
	@ManyToOne
	@JoinColumn(name="CDireccion", nullable=false)
	private Direccion direccion;
	
	
	
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Reporte(int cReporte, String tDescripcion, int qPuntosReporte, Date dFecha,
			Direccion direccion) {
		super();
		CReporte = cReporte;
		TDescripcion = tDescripcion;
		QPuntosReporte = qPuntosReporte;
		DFecha = dFecha;
		this.direccion = direccion;
		
	}
	@PrePersist   //sirve para signar valores por default
	public void prePersist() {
		DFecha = new Date();
	}

	public int getCReporte() {
		return CReporte;
	}

	public void setCReporte(int cReporte) {
		CReporte = cReporte;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public int getQPuntosReporte() {
		return QPuntosReporte;
	}

	public void setQPuntosReporte(int qPuntosReporte) {
		QPuntosReporte = qPuntosReporte;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	
	
	
	
}
