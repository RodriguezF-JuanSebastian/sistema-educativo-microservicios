package com.edu.usuariosservice.controladores;

import com.edu.usuariosservice.dto.UsuarioDto;
import com.edu.usuariosservice.modelos.Rol;
import com.edu.usuariosservice.modelos.Usuario;
import com.edu.usuariosservice.repositorios.RolRepository;
import com.edu.usuariosservice.repositorios.UsuarioRepository;
import com.edu.usuariosservice.seguridad.servicio.JwtService;
import com.edu.usuariosservice.seguridad.servicio.UsuarioDetailsServiceImpl;

import java.util.HashSet;
import java.util.Set;  // Importa Set

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")  // Ruta base para autenticación
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    private final RolRepository rolRepository;

    // Constructor
    public AuthController(JwtService jwtService, UsuarioDetailsServiceImpl usuarioDetailsService, AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository,
    PasswordEncoder passwordEncoder, RolRepository rolRepository) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolRepository = rolRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        // Autenticar al usuario con email y password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    
        // Obtener roles como texto, separados por comas
        String roles = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .reduce((a, b) -> a + "," + b) // Combina roles separados por coma
                .orElse(""); // En caso de que no tenga roles
    
        // Generar el JWT con username y roles
        String token = jwtService.generarToken(authentication.getName(), roles);
    
        return token;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuarioDto dto) {
    // Validar que no exista el usuario
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
        return ResponseEntity.badRequest().body("El email ya está registrado.");
    }

    // Crear nuevo usuario y codificar contraseña
    Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setNombre(dto.getNombre());
    nuevoUsuario.setEmail(dto.getEmail());
    nuevoUsuario.setPassword(passwordEncoder.encode(dto.getPassword()));
    nuevoUsuario.setTelefono(dto.getTelefono());
    nuevoUsuario.setDireccion(dto.getDireccion());
    nuevoUsuario.setFechaNacimiento(dto.getFechaNacimiento());
    nuevoUsuario.setEstado(dto.getEstado());
    nuevoUsuario.setTipoUsuario(dto.getTipoUsuario());

    // Asignar el rol basado en el DTO (puedes crear un método para manejar la conversión)
    Set<Rol> roles = new HashSet<>();
    if ("ROLE_ESTUDIANTE".equals(dto.getRol())) {
        // Obtener el rol de la base de datos o crear uno si no existe
        Rol rolEstudiante = rolRepository.findByNombre("ROLE_ESTUDIANTE")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        roles.add(rolEstudiante);
    }
    // Asume que ya manejas otros roles de manera similar

    nuevoUsuario.setRoles(roles); // Aquí asignas el Set de roles al usuario

    usuarioRepository.save(nuevoUsuario);
    return ResponseEntity.ok("Usuario registrado correctamente.");
    }
    
}
