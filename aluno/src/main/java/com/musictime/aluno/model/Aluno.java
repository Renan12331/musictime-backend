package com.musictime.aluno.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String matricula;

    @Column(length = 200, nullable = false)
    private String cpf;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 10, nullable = false)
    private String curso;
}
