package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//quem eh a entidade que trabalhara e qual eh o tipo da PK
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByTitulo(String nomeCurso);
    //Eh aqui que poe o underline para diferenciar a ambiguidade.
    List<Topico> findByCursoNome(String nomeCurso);

    //Caso nao queira seguir o padrao de nomenclatura do Spring
    //Tera que montar a query manualmente.
//    @Query("SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso")
//    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
