package usuarios;

public class Post {
    private String data;
    private String hora;
    private String texto;

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
