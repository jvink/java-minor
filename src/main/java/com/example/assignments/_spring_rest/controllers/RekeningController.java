package com.example.assignments._spring_rest.controllers;

import com.example.assignments._spring_rest.models.CombiRekening;
import com.example.assignments._spring_rest.models.Rekening;
import com.example.assignments._spring_rest.services.CombiRekeningService;
import com.example.assignments._spring_rest.services.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("rekeningen")
@RestController
public class RekeningController {
    private RekeningService rekeningService;
    private CombiRekeningService combiRekeningService;

    @Autowired
    public RekeningController(RekeningService rekeningService, CombiRekeningService combiRekeningService) {
        this.rekeningService = rekeningService;
        this.combiRekeningService = combiRekeningService;
    }

    @PostMapping
    public void addRekening(@Valid @RequestBody Rekening rekening) {
        rekeningService.addRekening(rekening);
    }

    @PostMapping("/combi")
    public void addCombiRekening(@Valid @RequestBody CombiRekening combiRekening) {
        combiRekeningService.addRekening(combiRekening);
    }

    @PutMapping
    public void updateRekening(@Valid @RequestBody Rekening rekening) {
        rekeningService.updateRekening(rekening);
    }

    @DeleteMapping(path = "/{rekeningId}")
    public void removeRekening(@PathVariable Long rekeningId) {
        rekeningService.removeRekening(rekeningId);
    }

    @GetMapping(path = "/{rekeningId}")
    public Optional<Rekening> getRekening(@PathVariable Long rekeningId) {
        return rekeningService.getRekening(rekeningId);
    }

    @GetMapping
    public List<Rekening> getRekeningen() {
        return rekeningService.getRekeningen();
    }
}
