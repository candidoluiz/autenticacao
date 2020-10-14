package br.com.hook.autenticacao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

}
