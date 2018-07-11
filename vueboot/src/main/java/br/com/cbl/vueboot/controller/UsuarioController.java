package br.com.cbl.vueboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbl.vueboot.model.Usuario;
import br.com.cbl.vueboot.repository.UsuarioRepository;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@PostMapping
	public Usuario inserir(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping
	public Usuario alterar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		
		usuarioRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> buscarPorId(@PathVariable("id") Integer id) {
		
		return usuarioRepository.findById(id);
	}
	
	@GetMapping
	public List <Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/q/{nome}")
	public List<Usuario> buscarPorNome(@PathVariable("nome") String nome){
		return usuarioRepository.findByNomeIgnoreCase(nome);
	}
	
	@GetMapping("/q")
	public List<Usuario> buscarPorNomeESenha(@RequestParam("nome") String nome, @RequestParam("senha") String senha){
		return usuarioRepository.findByNomeIgnoreCaseAndSenha(nome, senha);
	}
}

