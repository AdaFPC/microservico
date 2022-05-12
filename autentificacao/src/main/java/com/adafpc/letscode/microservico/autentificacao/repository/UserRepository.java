package com.adafpc.letscode.microservico.autentificacao.repository;


import com.adafpc.letscode.microservico.autentificacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginAndPassword(String login, String password);

}
