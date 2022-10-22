package com.familiaescolar.cadastroalunos.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
