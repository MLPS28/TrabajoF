package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CUsuario;
	
	@Column(name="NUsuario", nullable = false, length = 40)
	private String NUsuario;
	
	@Column(name="NUsuarioAP", nullable = false, length = 30)
	private String NUsuarioAP;
	
	@Column(name="NUsuarioAM", nullable = false, length = 30)
	private String NUsuarioAM;
	
	@Column(name="NDNI", nullable = false, length = 8)
	private int NDNI;
	
	@Column(name="NEmail", nullable = false, length = 45)
	private String NEmail;
	
	@Column(name="NPassword", nullable = false, length = 30)
	private String NPassword;
	
	@Column(name="QPuntos", nullable = false, length = 10)
	private int QPuntos;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int cUsuario, String nUsuario, String nUsuarioAP, String nUsuarioAM, int nDNI, String nEmail,
			String nPassword, int qPuntos) {
		super();
		CUsuario = cUsuario;
		NUsuario = nUsuario;
		NUsuarioAP = nUsuarioAP;
		NUsuarioAM = nUsuarioAM;
		NDNI = nDNI;
		NEmail = nEmail;
		NPassword = nPassword;
		QPuntos = qPuntos;
	}

	public int getCUsuario() {
		return CUsuario;
	}

	public void setCUsuario(int cUsuario) {
		CUsuario = cUsuario;
	}

	public String getNUsuario() {
		return NUsuario;
	}

	public void setNUsuario(String nUsuario) {
		NUsuario = nUsuario;
	}

	public String getNUsuarioAP() {
		return NUsuarioAP;
	}

	public void setNUsuarioAP(String nUsuarioAP) {
		NUsuarioAP = nUsuarioAP;
	}

	public String getNUsuarioAM() {
		return NUsuarioAM;
	}

	public void setNUsuarioAM(String nUsuarioAM) {
		NUsuarioAM = nUsuarioAM;
	}

	public int getNDNI() {
		return NDNI;
	}

	public void setNDNI(int nDNI) {
		NDNI = nDNI;
	}

	public String getNEmail() {
		return NEmail;
	}

	public void setNEmail(String nEmail) {
		NEmail = nEmail;
	}

	public String getNPassword() {
		return NPassword;
	}

	public void setNPassword(String nPassword) {
		NPassword = nPassword;
	}

	public int getQPuntos() {
		return QPuntos;
	}

	public void setQPuntos(int qPuntos) {
		QPuntos = qPuntos;
	}

	
}
