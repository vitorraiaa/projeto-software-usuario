package br.insper.iam.login;

import br.insper.iam.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }


}
