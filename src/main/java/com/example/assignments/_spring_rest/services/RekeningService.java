package com.example.assignments._spring_rest.services;

import com.example.assignments._spring_rest.models.Rekening;
import com.example.assignments._spring_rest.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RekeningService {
    @Autowired
    private RekeningRepository rekeningRepository;

    public List<Rekening> getRekeningen() {
        return rekeningRepository.findAll();
    }

    public Optional<Rekening> getRekening(Long id) {
        return rekeningRepository.findById(id);
    }

    public Rekening addRekening(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    public Rekening updateRekening(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    public void removeRekening(Long rekeningId) {
        rekeningRepository.deleteById(rekeningId);
    }
}
