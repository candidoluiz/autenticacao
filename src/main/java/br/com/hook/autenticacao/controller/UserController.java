package br.com.hook.autenticacao.controller;

import br.com.hook.autenticacao.model.User;
import br.com.hook.autenticacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "salvar")
    public void salvar(@RequestBody User user) throws Exception {
        //return userService.salvar(user);
       userService.salvar(user);
    }

    @GetMapping(value = "listar")
    public List<User> listar(){
        return userService.listar();
    }

    @RequestMapping("/us")
    public Principal user(Principal user){
        return user;
    }



}
