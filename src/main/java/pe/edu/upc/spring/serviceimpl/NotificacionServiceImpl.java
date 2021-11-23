package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Notificacion;
import pe.edu.upc.spring.repository.INotificacionRepository;
import pe.edu.upc.spring.service.INotificacionService;

@Service
public class NotificacionServiceImpl implements INotificacionService {

	@Autowired
	private INotificacionRepository dNoti;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Notificacion notificacion) {
		Notificacion objNotificacion = dNoti.save(notificacion);
		if (objNotificacion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CNotificacion) {
		dNoti.deleteById(CNotificacion); //solo necesita el id que se desea eliminar
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Notificacion> buscarId(int CNotificacion) {
		return dNoti.findById(CNotificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Notificacion> listarId(int CNotificacion) {
		return dNoti.findById(CNotificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Notificacion> listar() {
		return dNoti.findAll(); //devuelve todo en una lista
	}

	

}