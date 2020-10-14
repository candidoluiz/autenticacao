package br.com.hook.autenticacao.service;

import br.com.hook.autenticacao.model.User;
import br.com.hook.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void salvar(User user) throws Exception{
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        user.setSenha(pass.encode(user.getSenha()));
        User u = user;
       //return new ResponseEntity( userRepository.save(u), HttpStatus.OK);
        userRepository.save(u);
    }

    public List<User> listar(){
        return userRepository.findAll();
    }
}
