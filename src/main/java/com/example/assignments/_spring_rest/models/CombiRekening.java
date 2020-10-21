package com.example.assignments._spring_rest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class CombiRekening extends Rekening {

    @Size(min = 2, max = 2, message = "Er moeten 2 subrekeningen worden opgegeven.")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rekening> subRekeningen;

    public CombiRekening(List<Rekening> subRekeningen) {
        this.subRekeningen = subRekeningen;
    }
}
