package com.martinsaman.login.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USUARIORS")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USUARIORS_GEN",sequenceName = "USUARIORS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "USUARIORS_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String nombres;

    public Usuario(){

    }

    public Usuario(String email, String nombres) {
        this.email = email;
        this.nombres = nombres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
