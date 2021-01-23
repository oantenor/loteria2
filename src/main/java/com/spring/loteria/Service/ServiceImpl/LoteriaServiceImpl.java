package com.spring.loteria.Service.ServiceImpl;

import com.spring.loteria.Model.Aposta;
import com.spring.loteria.Repository.LoteriaRepository;
import com.spring.loteria.Service.LoteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteriaServiceImpl implements LoteriaService {

    @Autowired
    LoteriaRepository loteriaRepository;

    @Override
    public List<Aposta> findAll() {
        return loteriaRepository.findAll();
    }

    @Override
    public List<Aposta> findByemail(String email) {
        return loteriaRepository.findByemail(email);
    }

    @Override
    public Aposta save(Aposta aposta) {
        return loteriaRepository.save(aposta);
    }
}
