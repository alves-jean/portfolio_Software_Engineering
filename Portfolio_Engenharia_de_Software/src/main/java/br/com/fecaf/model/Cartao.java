package br.com.fecaf.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo_cartao;
    private String descricao;
    private String prioridade;
    private String situacao;
    private Date data_inicio;
    private Date data_final;
    private int id_mural;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo_cartao() {
        return titulo_cartao;
    }

    public void setTitulo_cartao(String titulo_cartao) {
        this.titulo_cartao = titulo_cartao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public int getId_mural() {
        return id_mural;
    }

    public void setId_mural(int id_mural) {
        this.id_mural = id_mural;
    }
}
