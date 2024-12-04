package main;

public class Avaliacao {
    private Usuario usuario;
    private int nota;
    private String comentario;

    public Avaliacao(Usuario usuario, int nota, String comentario) {
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
