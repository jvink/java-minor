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

//    private List<RekeningDTO> rekeningen = new ArrayList<>(Arrays.asList(
//        new RekeningDTO(
//            "1",
//            "NL91ABNA0417164300",
//            1204.12,
//            false,
//            new ArrayList<>(Arrays.asList(new RekeningHouderDTO("a", "Freek", "Vonk"))
//        )),
//        new RekeningDTO(
//            "1",
//            "NL12ABNA0119344422",
//            2000.00,
//            false,
//            new ArrayList<>(Arrays.asList(new RekeningHouderDTO("b", "Ronald", "de Mast"))
//        ))
//    ));

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

    public void unBlockRekening(String id) {
        RekeningDTO rekening =  rekeningen.stream().filter(filteredRekening -> filteredRekening.getId().equals(id)).findFirst().get();
        if (rekening != null) {
            rekening.setBlocked(false);
        } else {
            throw new Error("Deze rekening bestaat niet.");
        }
    }

    public void addRekeningHouderToRekening(RekeningHouderDTO rekeningHouderDTO, String rekeningId) {
        RekeningDTO rekening =  rekeningen.stream().filter(filteredRekening -> filteredRekening.getId().equals(rekeningId)).findFirst().get();
        rekening.getRekeningHouders().add(rekeningHouderDTO);
    }

    public void removeRekeningHouderFromRekening(String rekeningHouderId, String rekeningId) {
        RekeningDTO rekening =  rekeningen.stream().filter(filteredRekening -> filteredRekening.getId().equals(rekeningId)).findFirst().get();
        RekeningHouderDTO rekeningHouder =  rekening.getRekeningHouders().stream().filter(filteredRekeningHouder -> filteredRekeningHouder.equals(rekeningHouderId)).findFirst().get();
        rekening.getRekeningHouders().remove(rekeningHouder);
    }
}
