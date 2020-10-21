package com.example.assignments._spring_rest.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class RekeningDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.AUTO)
    private Long id;

    @Min(value = 8, message = "Een iban moet minimaal 8 tekens bevatten")
    @NotBlank(message = "Iban is verplicht")
    private String iban;

    @Min(value = 0, message = "Er kan geen saldo onder de nul zijn.")
    private Double saldo;
    @CreationTimestamp
    private Date createdAt;

    public RekeningDTO(Long id, String iban, Double saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }
}
