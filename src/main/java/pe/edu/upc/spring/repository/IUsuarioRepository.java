package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Usuario;

@Repository							   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
	@Query("from Usuario u where u.NUsuario like %:NUsuario%")
	List<Usuario> buscaUsuarios(@Param("NUsuario") String NUsuario);
}
