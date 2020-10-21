package com.example.assignments._spring_rest.services;

import com.example.assignments._spring_rest.models.RekeningDTO;
import com.example.assignments._spring_rest.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RekeningService {
    @Autowired
    private RekeningRepository rekeningRepository;

    public List<RekeningDTO> getRekeningen() {
        return rekeningRepository.findAll();
    }

    public Optional<RekeningDTO> getRekening(Long id) {
        return rekeningRepository.findById(id);
    }

    public RekeningDTO addRekening(RekeningDTO rekeningDTO) {
        return rekeningRepository.save(rekeningDTO);
    }

    public RekeningDTO updateRekening(RekeningDTO rekeningDTO) {
        return rekeningRepository.save(rekeningDTO);
    }

    public void removeRekening(Long rekeningId) {
        rekeningRepository.deleteById(rekeningId);
    }
}
