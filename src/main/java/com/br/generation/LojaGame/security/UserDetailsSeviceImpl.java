package com.br.generation.LojaGame.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.generation.LojaGame.model.Usuario;
import com.br.generation.LojaGame.repository.UsuarioRepository;

@Service
public class UserDetailsSeviceImpl  implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository  userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = userRepository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return (UserDetails) usuario.map(UserDetailsImpl::new).get();
	}

}
