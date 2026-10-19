package Livro.API_Livros2.Repository.dao;

import Livro.API_Livros2.Repository.Entity.Livro;
import Livro.API_Livros2.Repository.LivroRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroDAO {

    private final LivroRepository livroRepository;

    public LivroDAO(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    //create
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    //list
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    //update
    public Livro update(Livro livro) {
        return livroRepository.save(livro);
    }

    //delete
    public void delete(Long id) {
        livroRepository.deleteById(id);
    }


    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow();
    }

}
