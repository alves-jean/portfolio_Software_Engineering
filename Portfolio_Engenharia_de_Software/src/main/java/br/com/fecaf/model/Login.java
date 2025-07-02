package br.com.fecaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private String tipo_permissao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo_permissao() {
        return tipo_permissao;
    }

    public void setTipo_permissao(String tipo_permissao) {
        this.tipo_permissao = tipo_permissao;
    }
}
