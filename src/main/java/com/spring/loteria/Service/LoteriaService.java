package com.spring.loteria.Service;

import com.spring.loteria.Model.Aposta;

import java.util.List;

public interface LoteriaService {
    List<Aposta> findAll();
    List<Aposta> findByemail(String email);
    Aposta save(Aposta aposta);
}
