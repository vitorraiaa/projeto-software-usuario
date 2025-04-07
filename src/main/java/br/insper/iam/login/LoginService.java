package br.insper.iam.login;

import br.insper.iam.usuario.Usuario;
import br.insper.iam.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private UsuarioService usuarioService;

    private HashMap<String, Usuario> tokens = new HashMap<>();

    public String login(LoginDTO loginDTO) {

        Usuario usuario = usuarioService.validateUser(
                loginDTO.email(), loginDTO.password());

        String token = UUID.randomUUID().toString();

        tokens.put(token, usuario);

        return token;

    }

    public void validateToken(String token) {
        if (!tokens.containsKey(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
