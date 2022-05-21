package pt.ulusofona.deisi.aed.deisiflix;

public class Pessoa {

    int idPessoa;
    String nome;
    char genero;
    String tipoPessoa;
    int filme;


    public Pessoa() {

    }

    public Pessoa(String tipoPessoa, int idPessoa, String nome, char genero, int filme) {

        this.idPessoa = idPessoa;
        this.nome = nome;
        this.genero = genero;
        this.tipoPessoa = tipoPessoa;
        this.filme = filme;

    }
}
