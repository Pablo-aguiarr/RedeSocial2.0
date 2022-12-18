package usuarios;

import java.time.LocalDate;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private Post[] postagens = new Post[100];
    private int quantidadeDePostagens = 0;

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Post[] getPostagens() {
        return postagens;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPostagens(Post postagem) {
         this.postagens[quantidadeDePostagens] = postagem;
         this.quantidadeDePostagens++;
    }

    public int getQuantidadeDePostagens() {
        return quantidadeDePostagens;
    }

    public Post fazerNovaPostagem() {

        Scanner scan = new Scanner(System.in);
        Post postagem = new Post();
        postagem.setData();
        postagem.setHora();
        System.out.println("Escreva abaixo sua postagem: ");
        postagem.setTexto(scan.nextLine());
        System.out.println("Postagem realizada com sucesso!");
        return postagem;
    }

    public void verMinhasPostagens() {
        for (int i = 0; i < this.quantidadeDePostagens; i++) {
            System.out.println("Data: " + this.postagens[i].getData() + "   Hora: " + this.postagens[i].getHora());
            System.out.println("Postagem: " + this.postagens[i].getTexto());
            System.out.println();
        }
    }
}