package com.example.assignments._spring_rest.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class RekeningDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Iban is verplicht")
    private String iban;

    @Min(value = 0, message = "Er kan geen saldo onder de nul zijn.")
    private Double saldo;
    private Boolean blocked;
    @CreationTimestamp
    private Date createdAt;
    private List<RekeningHouderDTO> rekeningHouders;

    public RekeningDTO(Long id, String iban, Double saldo, Boolean blocked, List<RekeningHouderDTO> rekeningHouders) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
        this.blocked = blocked;
        this.rekeningHouders = rekeningHouders;
    }

    public Long getId() {
        return id;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public List<RekeningHouderDTO> getRekeningHouders() {
        return rekeningHouders;
    }
}
