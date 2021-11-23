package pe.edu.upc.spring.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Notificacion;

@Repository //siempre indicar que es una interfaz de tipo repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer>{
	
	
}
