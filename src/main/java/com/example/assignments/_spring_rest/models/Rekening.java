package com.example.assignments._spring_rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Rekening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Min(value = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rekeningNummer;

    private String iban;

    @Min(value = 0, message = "Er kan geen saldo onder de nul zijn.")
    private Double saldo = 0.0;
    @CreationTimestamp
    private Date createdAt;

    public Rekening(String iban, Double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }
}
