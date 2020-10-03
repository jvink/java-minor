package com.example.assignments._spring_rest.controllers;

import com.example.assignments._spring_rest.models.RekeningDTO;
import com.example.assignments._spring_rest.models.RekeningHouderDTO;
import com.example.assignments._spring_rest.services.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RekeningController {
    private RekeningService rekeningService;

    @Autowired
    public RekeningController(RekeningService rekeningService) {
        this.rekeningService = rekeningService;
    }

    @PostMapping
    @RequestMapping("addRekeningHouderToRekening")
    public @ResponseBody
    void addRekeningHouderToRekening(@RequestBody RekeningHouderDTO rekeningHouderDTO, String rekeningId) {
        rekeningService.addRekeningHouderToRekening(rekeningHouderDTO, rekeningId);
    }

    @PostMapping
    @RequestMapping("removeRekeningHouderFromRekening")
    public @ResponseBody
    void removeRekeningHouderFromRekening(@RequestBody String rekeningHouderId, String rekeningId) {
        rekeningService.removeRekeningHouderFromRekening(rekeningHouderId, rekeningId);
    }

    @PostMapping
    @RequestMapping("blockRekening")
    public @ResponseBody
    void blockRekening(@RequestBody String rekeningId) {
        rekeningService.blockRekening(rekeningId);
    }

    @PostMapping
    @RequestMapping("unBlockRekening")
    public @ResponseBody
    void unBlockRekening(@RequestBody String rekeningId) {
        rekeningService.unBlockRekening(rekeningId);
    }

    @RequestMapping("getRekening")
    public @ResponseBody
    RekeningDTO getRekening(@RequestBody String rekeningId) {
        return rekeningService.getRekening(rekeningId);
    }

    @RequestMapping("getRekeningen")
    public @ResponseBody
    List<RekeningDTO> getRekeningen() {
        return rekeningService.getRekeningen();
    }
}
