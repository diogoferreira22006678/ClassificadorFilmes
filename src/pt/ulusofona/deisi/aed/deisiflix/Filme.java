package pt.ulusofona.deisi.aed.deisiflix;

import java.util.ArrayList;

public class Filme {

    int id;
    String titulo;
    public ArrayList<Pessoa> actor;
    public ArrayList<Pessoa> realizador;
    public ArrayList<GeneroCinematografico> nomeGenero;
    String data;
    int orcamento;
    double mediaVotos;
    int nrVotos;
    double duracao;

    public Filme(int id, String titulo, double duracao, int orcamento, String data) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.orcamento = orcamento;
        this.data = data;

    }

    public Filme(int id, String titulo,String data, int nrVotos,double mediaVotos) {
        this.id = id;
        this.titulo = titulo;
        this.mediaVotos = mediaVotos;
        this.nrVotos = nrVotos;
        this.data = data;

    }

    public Filme(int id, double mediaVotos, int nrVotos){
        this.id = id;
        this.mediaVotos = mediaVotos;
        this.nrVotos = nrVotos;
    }

    public Filme(int id, String titulo, ArrayList<Pessoa> actor, ArrayList<Pessoa> realizador,
                 ArrayList<GeneroCinematografico> nomeGenero, String data, int orcamento, double mediaVotos,
                 int nrVotos, double duracao) {
        this.id = id;
        this.titulo = titulo;
        this.actor = actor;
        this.realizador = realizador;
        this.nomeGenero = nomeGenero;
        this.data = data;
        this.orcamento = orcamento;
        this.mediaVotos = mediaVotos;
        this.nrVotos = nrVotos;
        this.duracao = duracao;

    }

    @Override

    public String toString(){

        String[] divisao = data.split("-");

        return id + " | " + titulo + " | " + divisao[2]+ "-" +
                divisao[1]+ "-" + divisao[0] + " | " +
                nrVotos + " | " + mediaVotos;
    }
}
