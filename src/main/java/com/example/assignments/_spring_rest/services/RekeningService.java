package com.example.assignments._spring_rest.services;

import com.example.assignments._spring_rest.models.RekeningDTO;
import com.example.assignments._spring_rest.models.RekeningHouderDTO;
import com.example.assignments._spring_rest.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RekeningService {
    @Autowired
    private RekeningRepository rekeningRepository;

    public List<RekeningDTO> getRekeningen() {
        return rekeningRepository.findAll();
    }

    public Optional<RekeningDTO> getRekening(Long id) {
        return rekeningRepository.findById(id);
    }

    public void blockRekening(Long id) {
        Optional<RekeningDTO> rekening =  rekeningRepository.findById(id);
        if (rekening != null) {
            rekening.get().setBlocked(true);
        } else {
            throw new Error("Deze rekening bestaat niet.");
        }
    }

    public void unBlockRekening(Long id) {
        Optional<RekeningDTO> rekening =  rekeningRepository.findById(id);
        if (rekening != null) {
            rekening.get().setBlocked(false);
        } else {
            throw new Error("Deze rekening bestaat niet.");
        }
    }

    public void addRekeningHouderToRekening(RekeningHouderDTO rekeningHouderDTO, Long rekeningId) {
        Optional<RekeningDTO> rekening =  rekeningRepository.findById(rekeningId);
        rekening.get().getRekeningHouders().add(rekeningHouderDTO);
    }

    public void removeRekeningHouderFromRekening(String rekeningHouderId, Long rekeningId) {
        Optional<RekeningDTO> rekening =  rekeningRepository.findById(rekeningId);
        RekeningHouderDTO rekeningHouder =  rekening.get().getRekeningHouders().stream().filter(filteredRekeningHouder -> filteredRekeningHouder.equals(rekeningHouderId)).findFirst().get();
        rekening.get().getRekeningHouders().remove(rekeningHouder);
    }
}
