package br.com.hook.autenticacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class User extends AbstractEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    Long id;

    @Column
    String nome;

    @Column(unique = true)
    String login;

    @Column
    String senha;

    public User() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
