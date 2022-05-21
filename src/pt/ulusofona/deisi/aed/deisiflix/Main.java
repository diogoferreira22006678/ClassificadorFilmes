package pt.ulusofona.deisi.aed.deisiflix;


import java.util.ArrayList;
import java.io.*;
import java.util.Locale;

public class Main {

    private static ArrayList<Filme> filmes = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<GeneroCinematografico> generoCinematograficos = new ArrayList<>();
    static ArrayList<String> liFilmes = new ArrayList<>();
    static ArrayList<String> liVotosFilmes = new ArrayList<>();
    static ArrayList<String> liPessoas = new ArrayList<>();
    static ArrayList<String> liGeneroCinematografico = new ArrayList<>();

    static ArrayList<String> getLinhasIgnoradas(String fileName) {
        switch (fileName) {
            case "deisi_movies.txt":
                return liFilmes;
            case "deisi_movie_votes.txt":
                return liVotosFilmes;
            case "deisi_people.txt":
                return liPessoas;
            case "deisi_genres.txt":
                return liGeneroCinematografico;
            default:
                return null;
        }
    }

    static void lerFicheiros() throws IOException {
        filmes.clear();
        ArrayList<String> txtFilmes = Reader.read("deisi_movies.txt");
        ArrayList<String> txtVotosFilmes = Reader.read("deisi_movie_votes.txt");
        ArrayList<String> txtPessoas = Reader.read("deisi_people.txt");
        ArrayList<String> txtGeneroCinematografico = Reader.read("deisi_genres.txt");


        if (txtFilmes == null || txtVotosFilmes == null || txtPessoas == null || txtGeneroCinematografico == null) {
            //throw new IOException();
        }

        parseMovies(txtFilmes);
        parseMoviesVotes(txtVotosFilmes);
        parseMoviesPeople(txtPessoas);
        parseGenres(txtGeneroCinematografico);

    }

    static void parseMovies (ArrayList<String> linhas){
        liFilmes.clear();

        for (int n = 0; n < linhas.size(); n++) {

            String atualLinha = linhas.get(n);
            String[] divisao = atualLinha.split(",");

            if (divisao.length == 5) {
               int idFilme = Integer.parseInt(divisao[0].trim());
               String titulo= divisao[1].trim();
               double duracao =  Double.parseDouble(divisao[2].trim());
               int orcamento = Integer.parseInt(divisao[3].trim());
               String data= divisao[4].trim();

               filmes.add(new Filme(idFilme,titulo,
                       duracao,orcamento,data));
            } else {
                liFilmes.add(atualLinha);
            }
        }
    }

    static void parseMoviesVotes(ArrayList<String> linhas){
        liVotosFilmes.clear();

        for (int n = 0; n < linhas.size(); n++) {

            String atualLinha = linhas.get(n);
            String[] divisao = atualLinha.split(",");

            if (divisao.length == 3) {
                for (Filme f : filmes) {
                    int id = Integer.parseInt(divisao[0].trim());
                    if (f.id == id){

                         f.mediaVotos = Double.parseDouble(divisao[1].trim());
                        f.nrVotos = Integer.parseInt(divisao[2].trim());

                    }
                }
            } else {
                liVotosFilmes.add(atualLinha);
            }

        }

    }

    static void parseMoviesPeople(ArrayList<String> linhas){
        liPessoas.clear();

        for (int n = 0; n < linhas.size(); n++) {

            String atualLinha = linhas.get(n);

            if (atualLinha != null) {
                String[] divisao = atualLinha.split(",");

                if (divisao.length == 5) {


                            int idFilme = Integer.parseInt(divisao[4].trim());
                            int idPessoa = Integer.parseInt(divisao[1].trim());
                            String tipoPessoa = divisao[0].trim();
                            String nome = divisao[2].trim();
                            char genero = divisao[3].trim().charAt(0);

                            Pessoa p = new Pessoa(tipoPessoa, idPessoa, nome, genero, idFilme);
                } else {
                    liPessoas.add(atualLinha);
                }
            }
        }
    }

    static void parseGenres (ArrayList<String> linhas) {
        liGeneroCinematografico.clear();

        for (int n = 0; n < linhas.size(); n++) {

            String atualLinha = linhas.get(n);
            String[] divisao = atualLinha.split(",");

            if (divisao.length == 2) {

                    int idFilme = Integer.parseInt(divisao[1].trim());


                        String nomeGenero = divisao[0].trim();

                        GeneroCinematografico p = new GeneroCinematografico(nomeGenero, idFilme);

            } else {
                liGeneroCinematografico.add(atualLinha);
            }

        }
    }

    static ArrayList<Filme> getFilmes() {
        return filmes;
    }





    public static void main(String[] args) {
        try {
            lerFicheiros();
            System.out.println(getLinhasIgnoradas("deisi_movies.txt"));
            System.out.println(getFilmes().size());
            System.out.println(getLinhasIgnoradas("deisi_movie_votes.txt"));
            System.out.println(getLinhasIgnoradas("deisi_people.txt"));
            System.out.println(getLinhasIgnoradas("deisi_genres.txt"));

        } catch (IOException e) {
            System.out.println("Deu");
        }
    }
}