package br.com.cbl.vueboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cbl.vueboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public List<Usuario> findByNomeIgnoreCase(String nome);
	public List<Usuario> findByNomeIgnoreCaseAndSenha(String nome, String senha);
	public List<Usuario> findBySenha(String senha);
	
	
}
