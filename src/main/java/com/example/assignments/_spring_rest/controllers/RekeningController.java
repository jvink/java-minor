package com.example.assignments._spring_rest.controllers;

import com.example.assignments._spring_rest.models.RekeningDTO;
import com.example.assignments._spring_rest.models.RekeningHouderDTO;
import com.example.assignments._spring_rest.services.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/rekening")
@RestController
public class RekeningController {
    private RekeningService rekeningService;

    @Autowired
    public RekeningController(RekeningService rekeningService) {
        this.rekeningService = rekeningService;
    }

    @PostMapping
    @RequestMapping("addRekeningHouder")
    public @ResponseBody
    void addRekeningHouderToRekening(@RequestBody RekeningHouderDTO rekeningHouderDTO, Long rekeningId) {
        rekeningService.addRekeningHouderToRekening(rekeningHouderDTO, rekeningId);
    }

    @PostMapping
    @RequestMapping("removeRekeningHouder")
    public @ResponseBody
    void removeRekeningHouderFromRekening(@RequestBody String rekeningHouderId, Long rekeningId) {
        rekeningService.removeRekeningHouderFromRekening(rekeningHouderId, rekeningId);
    }

    @PostMapping
    @RequestMapping("block")
    public @ResponseBody
    void blockRekening(@RequestBody Long rekeningId) {
        rekeningService.blockRekening(rekeningId);
    }

    @PostMapping
    @RequestMapping("unBlock")
    public @ResponseBody
    void unBlockRekening(@RequestBody Long rekeningId) {
        rekeningService.unBlockRekening(rekeningId);
    }

    public @ResponseBody
    Optional<RekeningDTO> getRekening(@RequestBody Long rekeningId) {
        return rekeningService.getRekening(rekeningId);
    }

    @RequestMapping("all")
    public @ResponseBody
    List<RekeningDTO> getRekeningen() {
        return rekeningService.getRekeningen();
    }
}
