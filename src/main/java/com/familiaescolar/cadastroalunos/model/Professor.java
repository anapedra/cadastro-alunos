package com.familiaescolar.cadastroalunos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
    private static final long serialVersionUID=1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String prontuario;
    @OneToMany(mappedBy = "professor")
    private List<Diciplinas>diciplinas=new ArrayList<>();

    public Professor(String name, String prontuario) {

        this.name = name;
        this.prontuario = prontuario;
    }

    @Deprecated
    public Professor() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
    public List<Diciplinas> getDiciplinas() {
        return diciplinas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prontuario='" + prontuario + '\'' +
                ", diciplinas=" + diciplinas +
                '}';
    }
}
