package Livro.API_Livros2.Repository;

import Livro.API_Livros2.Repository.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {
}
