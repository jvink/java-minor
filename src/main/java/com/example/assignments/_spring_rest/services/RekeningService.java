package com.example.assignments._spring_rest.services;

import com.example.assignments._spring_rest.annotations.Measured;
import com.example.assignments._spring_rest.models.Rekening;
import com.example.assignments._spring_rest.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RekeningService {
    @Autowired
    private RekeningRepository rekeningRepository;

    @Measured(message = "Get rekeningen database call")
    public List<Rekening> getRekeningen() {
        return rekeningRepository.findAll();
    }

    @Cacheable("rekeningen")
    @Measured(message = "Get rekening database call")
    public Optional<Rekening> getRekening(Long id) {
        return rekeningRepository.findById(id);
    }

    @Measured(message = "Add rekening database call")
    public Rekening addRekening(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    @Measured(message = "Update rekening database call")
    public Rekening updateRekening(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    @Measured(message = "Remove rekening database call")
    public void removeRekening(Long rekeningId) {
        rekeningRepository.deleteById(rekeningId);
    }
}
