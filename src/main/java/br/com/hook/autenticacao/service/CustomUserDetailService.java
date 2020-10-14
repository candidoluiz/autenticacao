package br.com.hook.autenticacao.service;

import br.com.hook.autenticacao.model.User;
import br.com.hook.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByLogin(login))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        List<GrantedAuthority> authorityListAdm = AuthorityUtils.createAuthorityList("ADM");
        return new org.springframework.security.core.userdetails.User
                (user.getLogin(),user.getSenha(),authorityListAdm);
    }
}
