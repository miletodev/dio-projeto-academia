package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositório responsável pelas operações de persistência da entidade {@link AvaliacaoFisica}.
 *
 * Esta interface abstrai a comunicação com o banco de dados e permite realizar
 * operações básicas como salvar, atualizar, deletar e buscar instâncias de
 * {@link AvaliacaoFisica}.
 *
 * Extende a interface {@link JpaRepository}, que fornece uma implementação padrão
 * para operações CRUD (Create, Read, Update, Delete) e paginação.
 *
 * O Spring Data JPA gerenciará automaticamente a implementação dessa interface em
 * tempo de execução.
 *
 * Funcionalidades herdadas de {@link JpaRepository}:
 * <ul>
 *   <li>Save (salvar e atualizar registros)</li>
 *   <li>Find (localizar registros por ID ou outros critérios)</li>
 *   <li>Delete (excluir registros)</li>
 *   <li>Pagination e Sorting (paginação e ordenação de registros)</li>
 * </ul>
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @version 1.0
 */
@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
}
