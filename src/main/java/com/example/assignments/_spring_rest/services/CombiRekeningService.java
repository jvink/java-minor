package com.example.assignments._spring_rest.services;

import com.example.assignments._spring_rest.models.CombiRekening;
import com.example.assignments._spring_rest.models.Rekening;
import com.example.assignments._spring_rest.repositories.CombiRekeningRepository;
import com.example.assignments._spring_rest.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombiRekeningService {
    @Autowired
    private CombiRekeningRepository combiRekeningRepository;

    public CombiRekening addRekening(CombiRekening rekening) {
        return combiRekeningRepository.save(rekening);
    }

    public CombiRekening updateRekening(CombiRekening rekening) {
        return combiRekeningRepository.save(rekening);
    }

    public void removeRekening(Long rekeningId) {
        combiRekeningRepository.deleteById(rekeningId);
    }
}
