package com.spring.loteria.Repository;

import com.spring.loteria.Model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoteriaRepository extends JpaRepository<Aposta, Long> {
    List<Aposta> findByemail(String email);
}
