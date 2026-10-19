package Livro.API_Livros2.Service.converter;

import Livro.API_Livros2.Repository.Entity.Livro;
import Livro.API_Livros2.Repository.dto.LivroDTO;
import org.springframework.stereotype.Component;

@Component
public class LivroConverter {

    //dto para entidade
    public Livro toEntity (LivroDTO livroDTO){   //parametro é oq vai ser utilizado/get / e nome oq vai set
        Livro livro = new Livro();
        //pegando o valor da dto e set na entity
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setPreco(livroDTO.getPreco());

        return livro;
    }

    //entidade para dto
    public LivroDTO toDto (Livro livro){
        //new ()
        LivroDTO livroDTO = new LivroDTO();
        //pega o valor da entity e set na dto
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setPreco(livro.getPreco());

        return livroDTO;


    }



}
