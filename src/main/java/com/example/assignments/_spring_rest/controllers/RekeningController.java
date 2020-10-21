package com.example.assignments._spring_rest.controllers;

import com.example.assignments._spring_rest.annotations.Measured;
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
    @Measured(message = "Add rekening")
    public void addRekening(@Valid @RequestBody Rekening rekening) {
        rekeningService.addRekening(rekening);
    }

    @PostMapping("/combi")
    @Measured(message = "Add combirekening")
    public void addCombiRekening(@Valid @RequestBody CombiRekening combiRekening) {
        combiRekeningService.addRekening(combiRekening);
    }

    @PutMapping
    @Measured(message = "Update rekening")
    public void updateRekening(@Valid @RequestBody Rekening rekening) {
        rekeningService.updateRekening(rekening);
    }

    @DeleteMapping(path = "/{rekeningId}")
    @Measured(message = "Remove rekening")
    public void removeRekening(@PathVariable Long rekeningId) {
        rekeningService.removeRekening(rekeningId);
    }

    @GetMapping(path = "/{rekeningId}")
    @Measured(message = "Get rekening")
    public Optional<Rekening> getRekening(@PathVariable Long rekeningId) {
        return rekeningService.getRekening(rekeningId);
    }

    @GetMapping
    @Measured(message = "Get rekeningen")
    public List<Rekening> getRekeningen() {
        return rekeningService.getRekeningen();
    }
}
