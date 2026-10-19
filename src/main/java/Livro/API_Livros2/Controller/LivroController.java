package Livro.API_Livros2.Controller;

import Livro.API_Livros2.Repository.dto.LivroDTO;
import Livro.API_Livros2.Service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    //nao precisa colocar @requestMapping, pode passar a rota dentro do postMapp
    @PostMapping("/criar-livro")
    public LivroDTO create(@RequestBody LivroDTO livroDTO) {
        return livroService.salvar(livroDTO);
    }

    @GetMapping("/listar-livros")
    public List<LivroDTO> listar() {
        return livroService.listar();
    }

    @PutMapping("/atualizar/{id}")
    public LivroDTO atualizar (@RequestBody LivroDTO livroDTO, @PathVariable Long id) {
        return livroService.atualizar(id, livroDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Long id){
        livroService.delete(id);
    }




}


