package com.familiaescolar.cadastroalunos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_diciplinas")
public class Diciplinas implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Integer semestre;
    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Professor professor;

    public Diciplinas(String nome, Integer semestre, Professor professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }

    public Diciplinas() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diciplinas)) return false;
        Diciplinas that = (Diciplinas) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getSemestre(), that.getSemestre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSemestre());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Diciplinas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                ", professor=" + professor +
                '}';
    }
}
