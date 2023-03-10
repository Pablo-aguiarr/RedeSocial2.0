import exceptions.InvalidPasswordException;
import exceptions.UserNotFoundException;
import usuarios.BancoDeUsuarios;
import usuarios.Usuario;
import usuarios.Post;
import java.util.Scanner;

public class RedeSocial {

    static BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    RedeSocial novoLogin = new RedeSocial();
    System.out.println("Entrando na Rede Social...");
    novoLogin.telaInicial();
    }

    public static void telaInicial() {

        titulo("BEM VINDO A ESTA BELÍSSIMA REDE SOCIAL!");
        System.out.println("Digite o número da opção desejada:");
        System.out.println("1: Cadastro");
        System.out.println("2: login");
        System.out.println("3: Fechar");
        int primeiraTela = pegaNumInt();

        while(primeiraTela < 1 || primeiraTela > 3) {
            System.out.println("Opção não encontrada!");
            System.out.println("Digite o número da opção desejada:");
            System.out.println("1: Cadastro");
            System.out.println("2: login");
            System.out.println("3: Fechar");
            primeiraTela = pegaNumInt();
        }

        if (primeiraTela == 1) {
            titulo("CADASTRO DE NOVO USUÁRIO");
            cadastrarPerfil();
            telaInicial();

        } else if(primeiraTela == 2) {
            try {
                telaDeLogin();
            } catch(UserNotFoundException e) {
                System.out.println("usuário não encontrado");
                telaInicial();
            }

        } else {
            System.out.println("Até logo!");
        }
    }

    private static void cadastrarPerfil() {
        Usuario usuario = new Usuario();
        System.out.println("Nome completo: ");
        usuario.setNome(scan.nextLine());
        if (usuario.getNome().equals("")) {
            System.out.println("Erro! o nome não pode ficar em branco");
            telaInicial();
        }

        System.out.println("Login: ");
        usuario.setLogin(scan.nextLine().toUpperCase());
        if(bancoDeUsuarios.getQuantPerfis() > 0) {
            for(int i = 0; i < bancoDeUsuarios.getQuantPerfis(); i++) {
                if (usuario.getLogin().equals(bancoDeUsuarios.getTodosPerfis()[i].getLogin())) {
                    System.out.println("login já cadastrado! Faça login ou cadastre com outro nome.");
                    telaInicial();
                }
            }
        }

        if (usuario.getLogin().equals("")) {
            System.out.println("Erro! o login não pode ficar em branco");
            telaInicial();
        }

        System.out.println("Senha: ");
        usuario.setSenha(scan.nextLine());
        if (usuario.getSenha().equals("")) {
            System.out.println("Erro! a senha não pode ficar em branco");
            telaInicial();
        }

        bancoDeUsuarios.setTodosPerfis(usuario);
        bancoDeUsuarios.setQuantPerfis(bancoDeUsuarios.getQuantPerfis()+1);
        System.out.println("USUÁRIO CADASTRADO COM SUCESSO!");
        System.out.println();
    }

    private static void telaDeLogin() throws UserNotFoundException, InvalidPasswordException {
        titulo("LOGIN DE USUÁRIO CADASTRADO");
        try {
            bancoDeUsuarios.setPosicaoLogin(verificaLogin());
        }
        catch (UserNotFoundException e) {
            System.out.println("usuário não encontrado");
            telaInicial();
        }
        try {
            verificaSenha();
        } catch (InvalidPasswordException e) {
            System.out.println("Senha não encontrada!");
            telaInicial();
        }
        telaPosLogin();
    }

    static int verificaLogin() {
        System.out.println("Login: ");
        String login = scan.nextLine().toUpperCase();
        boolean verificador = false;
        int posicao = 0;
        if (bancoDeUsuarios.getQuantPerfis() != 0) {
            for (int i = 0 ; i < bancoDeUsuarios.getQuantPerfis(); i++ ) {
                if (bancoDeUsuarios.getTodosPerfis()[i].getLogin().equals(login)) {
                    verificador = true;
                    posicao = i;
                }
            }
        }
        if(!verificador) {
            throw new UserNotFoundException();
        } else {
            return posicao;
        }
    }

    public static void verificaSenha() {
        System.out.println("Senha: ");
        String senha = scan.nextLine();
        if(bancoDeUsuarios.getTodosPerfis()[bancoDeUsuarios.getPosicaoLogin()].getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            throw new InvalidPasswordException();
        }
    }

    private static void telaPosLogin() {
        Usuario usuarioAtual = bancoDeUsuarios.getTodosPerfis()[bancoDeUsuarios.getPosicaoLogin()];
        titulo("BEM VINDO AO SEU PERFIL, " + usuarioAtual.getNome().toUpperCase() + "!");
        System.out.println();
        System.out.println("Digite o número da opção desejada:");
        System.out.println("1 - NOVA POSTAGEM");
        System.out.println("2 - VER MINHA TIMELINE");
        System.out.println("3 - SAIR");
        int opcao2 = 0;
        while(opcao2 < 1 || opcao2 > 3) {
            opcao2 = pegaNumInt();
        }
        if (opcao2 == 1) {
            Post postagem = usuarioAtual.fazerNovaPostagem();
            usuarioAtual.setPostagens(postagem);
             telaPosLogin();
        } else if (opcao2 == 2) {
            usuarioAtual.verMinhasPostagens();
            telaPosLogin();
        } else {
            System.out.println("Até breve!");
            telaInicial();
        }
    }

    static int pegaNumInt() {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("Valor inválido. Por favor, digite um número inteiro");
            scan.nextLine();
        }
        return scan.nextInt();
    }

    public static void titulo(String mensagem) {
        String str = "~";
        System.out.println(str.repeat(mensagem.length()));
        System.out.println(mensagem);
        System.out.println(str.repeat(mensagem.length()));
        System.out.println();
        System.out.println();
    }
}