package usuarios;

public class BancoDeUsuarios {
    private Usuario[] todosPerfis = new Usuario[1000];
    private int quantPerfis = 0;
    private int posicaoLogin = 0;

    public Usuario[] getTodosPerfis() {
        return todosPerfis;
    }

    public void setTodosPerfis(Usuario todosPerfis) {
        this.todosPerfis[quantPerfis] = todosPerfis;
    }

    public int getQuantPerfis() {
        return quantPerfis;
    }

    public void setQuantPerfis(int quantPerfis) {
        this.quantPerfis = quantPerfis;
    }

    public int getPosicaoLogin() {
        return posicaoLogin;
    }

    public void setPosicaoLogin(int posicaoLogin) {
        this.posicaoLogin = posicaoLogin;
    }
}
