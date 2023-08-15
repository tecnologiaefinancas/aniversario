package com.ada.aniversario.repository;

import com.ada.aniversario.entity.Aniversario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AniversarioRepository extends JpaRepository<Aniversario, Long> {
    Optional<Aniversario> getAniversarioByNome(String nome);
    Optional<Aniversario> getByNome(String nome);
    Optional<Aniversario> findByNome(String nome);
    Optional<Aniversario> findAniversarioByNome(String nome);

}
