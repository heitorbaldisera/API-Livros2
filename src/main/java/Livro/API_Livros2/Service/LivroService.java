package Livro.API_Livros2.Service;

import Livro.API_Livros2.Repository.Entity.Livro;
import Livro.API_Livros2.Repository.dao.LivroDAO;
import Livro.API_Livros2.Repository.dto.LivroDTO;
import Livro.API_Livros2.Service.converter.LivroConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO livroDAO;
    private final LivroConverter livroConverter;

    // injeção de dependência pelo construtor
    // o Spring injeta o LivroDAO e o LivroConverter automaticamente
    public LivroService(LivroDAO livroDAO, LivroConverter livroConverter) {
        this.livroDAO = livroDAO;
        this.livroConverter = livroConverter;
    }

    // CREATE
    public LivroDTO salvar(LivroDTO dto) {
        // converte o DTO recebido em Entity usando o converter
        Livro livro = livroConverter.toEntity(dto);

        // manda o DAO salvar a Entity no banco
        Livro livroSalvo = livroDAO.salvar(livro);

        // converte a Entity salva (com id gerado) de volta para DTO e retorna
        return livroConverter.toDto(livroSalvo);
    }

    // LIST
    public List<LivroDTO> listar() {
        // busca todos os livros do banco como lista de Entity
        List<Livro> livros = livroDAO.listar();

        // cria uma lista vazia de DTO para preencher
        List<LivroDTO> resultado = new ArrayList<>();

        // percorre cada Entity, converte para DTO e adiciona na lista
        for (Livro livro : livros) {
            LivroDTO dto = livroConverter.toDto(livro);
            resultado.add(dto);
        }

        // retorna a lista de DTOs para o Controller
        return resultado;
    }

    // UPDATE
    public LivroDTO atualizar(Long id, LivroDTO dto) {
        // busca o livro existente no banco pelo id
        // se não encontrar, lança exceção automaticamente
        Livro livro = livroDAO.buscarPorId(id);

        // atualiza os campos do livro encontrado com os dados do DTO
        // não criamos um Livro novo pois precisamos manter o id existente
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setPreco(dto.getPreco());

        // salva o livro atualizado no banco
        Livro livroSalvo = livroDAO.salvar(livro);

        // converte a Entity atualizada para DTO e retorna
        return livroConverter.toDto(livroSalvo);
    }

    // DELETE
    public void delete(Long id) {
        // repassa o id para o DAO deletar do banco
        // não precisa retornar nada (void)
        livroDAO.delete(id);
    }
}