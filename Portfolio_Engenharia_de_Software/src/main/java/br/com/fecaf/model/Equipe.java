package br.com.fecaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_login;
    private int id_mural;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public int getId_mural() {
        return id_mural;
    }

    public void setId_mural(int id_mural) {
        this.id_mural = id_mural;
    }
}
