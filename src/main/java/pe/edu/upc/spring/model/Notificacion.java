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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Notificacion")
public class Notificacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CNotificacion;
	
	@Column(name="TDescripcion", length=80, nullable=false)
	private String TDescripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DFechaNotificacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DFechaNotificacion;
	
	@ManyToOne
	@JoinColumn(name="CAutoridad", nullable=false)
	private Autoridad autoridad;
	
	@ManyToOne
	@JoinColumn(name="CReporte", nullable=false)
	private Reporte reporte;

	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(int cNotificacion, String tDescripcion, Date dFechaNotificacion, Autoridad autoridad,
			Reporte reporte) {
		super();
		CNotificacion = cNotificacion;
		TDescripcion = tDescripcion;
		DFechaNotificacion = dFechaNotificacion;
		this.autoridad = autoridad;
		this.reporte = reporte;
	}

	public int getCNotificacion() {
		return CNotificacion;
	}

	public void setCNotificacion(int cNotificacion) {
		CNotificacion = cNotificacion;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public Date getDFechaNotificacion() {
		return DFechaNotificacion;
	}

	public void setDFechaNotificacion(Date dFechaNotificacion) {
		DFechaNotificacion = dFechaNotificacion;
	}

	public Autoridad getAutoridad() {
		return autoridad;
	}

	public void setAutoridad(Autoridad autoridad) {
		this.autoridad = autoridad;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	
	
	
}
