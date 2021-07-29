package Estoque.groupacp.repository;

import Estoque.groupacp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "select p from Produto p where upper(trim(p.nome)) like %?1%")
    List<Produto> buscarPorNome(String name);

}
