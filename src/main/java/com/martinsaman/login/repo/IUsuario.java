package com.martinsaman.login.repo;

import com.martinsaman.login.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findOneByEmail(String email);
}
