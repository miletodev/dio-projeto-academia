package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe que representa uma Avaliação Física no sistema de academia digital.
 *
 * <p>Uma Avaliação Física registra os dados físicos de um aluno em um momento
 * específico, incluindo peso, altura e a data da avaliação.</p>
 *
 * <p>Regras:
 * - Cada Avaliação Física está associada a um Aluno.
 * - As avaliações podem ser excluídas automaticamente ao excluir o aluno,
 * devido ao uso de <code>CascadeType.ALL</code>.</p>
 *
 * <p>Esta classe utiliza o framework JPA para persistência e Lombok para
 * geração de código boilerplate como getters, setters e construtores.</p>
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  /**
   * Identificador único da avaliação física.
   * É gerado automaticamente pelo banco de dados através da estratégia
   * <code>GenerationType.IDENTITY</code>.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Relacionamento N-para-1 entre Avaliação Física e Aluno.
   *
   * <p>Regras:
   * - Várias avaliações físicas podem estar associadas ao mesmo aluno.
   * - A anotação <code>@JoinColumn</code> define o nome da coluna no banco
   * de dados como <code>aluno_id</code>.</p>
   *
   * <p>O uso de <code>cascade = CascadeType.ALL</code> garante que, ao excluir
   * um aluno, todas as avaliações físicas associadas sejam excluídas.</p>
   */
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  /**
   * Data em que a avaliação física foi realizada.
   *
   * <p>Por padrão, o valor é inicializado com a data e hora corrente
   * ao criar a instância através de <code>LocalDateTime.now()</code>.</p>
   */
  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  /**
   * Peso atual do aluno durante a avaliação.
   *
   * <p>Este campo é obrigatório e não pode ser nulo, sendo mapeado na coluna
   * <code>peso_atual</code> no banco de dados.</p>
   */
  @Column(nullable = false, name = "peso_atual")
  private double peso;

  /**
   * Altura atual do aluno durante a avaliação.
   *
   * <p>Este campo é obrigatório e não pode ser nulo, sendo mapeado na coluna
   * <code>altura_atual</code> no banco de dados.</p>
   */
  @Column(nullable = false, name = "altura_atual")
  private double altura;

}
