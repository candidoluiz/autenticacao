package br.com.hook.autenticacao.repository;

import br.com.hook.autenticacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
