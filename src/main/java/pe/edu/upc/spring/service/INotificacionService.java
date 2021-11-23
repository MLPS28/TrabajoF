package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Notificacion;

public interface INotificacionService {
	
	public boolean grabar(Notificacion notificacion);
	public void eliminar(int CNotificacion);
	public Optional<Notificacion> listarId(int CNotificacion);
	public Optional<Notificacion> buscarId(int CNotificacion);
	public List<Notificacion> listar();
	

}

