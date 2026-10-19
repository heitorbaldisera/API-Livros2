package Livro.API_Livros2.Repository.dto;

public class LivroDTO {

    private String titulo;
    private String autor;
    private float preco;

    public LivroDTO(String titulo, String autor, float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public LivroDTO() {

    }


    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }


    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
