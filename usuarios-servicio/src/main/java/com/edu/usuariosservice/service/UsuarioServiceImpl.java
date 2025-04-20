package com.edu.usuariosservice.service;

import com.edu.usuariosservice.model.Usuario;
import com.edu.usuariosservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        //usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setTipoUsuario(usuarioActualizado.getTipoUsuario());

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuariosPorTipoUsuario(String tipoUsuario) {
        return usuarioRepository.findByTipoUsuario(tipoUsuario);
    }
    /*
    @Override
    public void actualizarPassword(Long id, String nuevaPassword) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        usuario.setPassword(nuevaPassword);
        usuarioRepository.save(usuario);
    } */
}