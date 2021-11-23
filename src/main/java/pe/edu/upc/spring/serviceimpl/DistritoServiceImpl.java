package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.repository.IDistritoRepository;
import pe.edu.upc.spring.service.IDistritoService;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired //ya no es inject
	private IDistritoRepository dDistrito;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public Integer grabar(Distrito distrito) {
		int rpta = dDistrito.buscarNombreDistrito(distrito.getNDistrito());
		if (rpta == 0) {
			dDistrito.save(distrito);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void eliminar(int CDistrito) {
		dDistrito.deleteById(CDistrito); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Distrito> listarId(int CDistrito) {
		return dDistrito.findById(CDistrito);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Distrito> listar() {
		return dDistrito.findAll(); //devuelve todo en una lista
	}

	@Override
	@Transactional(readOnly = true)
	public List<Distrito> buscarDistrito(String NDistrito) {
		return dDistrito.buscarDistrito(NDistrito); //esto es el único método propio que se hico en IRepository
	}

}
