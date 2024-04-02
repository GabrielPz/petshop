package br.com.gabrielhenrique.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import br.com.gabrielhenrique.petshop.service.AuthService;
import lombok.Data;

@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity<Map> login(@RequestBody AuthRequest authRequest){
        return authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
    }

    @Data
    public static class AuthRequest{
        private String username;
        private String password;
    }
}
