package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
* Classe que representa uma matrícula no sistema de academia digital.
 *
 * A matricula indica a associação de um aluno ao sistema,
 * contendo informações sobre o aluno e a data em que a matícula foi criada.
 *
 * Regras:
 * - Cada aluno pode possur apenas uma matrícula.
 * - A exclusão de um aluno resulta na exclusão automática da matrícula associada.
 *
 * Esta classe utiliza o framework JPA para persistência e Lombok para geração de código boilerplate
 * como getters, setters e construtores.
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @since 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  /**
   * Identificador único de matrícula.
   * É gerado automaticamente pelo banco de dados através da estratégia <code>GenerationType.IDENTITY</code>
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Relacionamento um-para-um entre Matrícula e ALuno com efeito cascata.
   */
  @OneToOne(cascade = CascadeType.ALL)
  private Aluno aluno;

  /**
   * Data em que a matrícula foi criada.
   *
   * <p>Por padrão, é inicializada com a data e hora corrente no momento da
   * criação da instância através de <code>LocalDateTime.now()</code>.</p>
   */
  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
