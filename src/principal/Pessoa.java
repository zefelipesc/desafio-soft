package principal;

import javax.swing.*;
import java.util.*;

public class Pessoa {


    private String nome;
    private String sobreNome;
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private Integer idade;
    private List<AtividadeFisica> atividadeFisicas;

    public Pessoa() { }

    public Pessoa(String nome, String sobreNome, Integer dia, Integer mes, Integer ano, Integer idade, List<AtividadeFisica> atividadeFisicas){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.atividadeFisicas = atividadeFisicas;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public List<AtividadeFisica> getAtividadeFisicas() {
        return atividadeFisicas;
    }

    public void setAtividadeFisicas(List<AtividadeFisica> atividadeFisicas) {
        this.atividadeFisicas = atividadeFisicas;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    //public void validarData(int dia, int mes, int ano) {
    //    int qtdDias;
    //    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
    //        qtdDias = 31;
    //    } else {
    //        qtdDias = 30;
    //    }
    //    if (dia < 1 || dia > qtdDias) {
    //        throw new IllegalArgumentException("o dia tem que ser de 1 a " + qtdDias);
    //    }
    //    if (mes < 1 || mes > 12) {
    //        throw new IllegalArgumentException("Informe um mês válido.");
    //    }
    //    if (ano > 2021) {
    //        throw new IllegalArgumentException("Ano inválido");
    //    }
   // }


}
