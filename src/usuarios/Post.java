package usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void setData() {
        Date dataHoraAtual = new Date();
        this.data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    }

    public void setHora() {
        Date dataHoraAtual = new Date();
        this.hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
