package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Aluno no sistema de academia digital.
 *
 * <p>Um aluno possui informações básicas, como nome, CPF, bairro e data de nascimento.
 * Além disso, está relacionado com uma ou mais avaliações físicas realizadas durante o cadastro.</p>
 *
 * <p>Esta classe utiliza JPA para persistência, Lombok para emissão de código boilerplate
 * (getters, setters e construtores) e Jackson para serialização/deserialização JSON.</p>
 *
 * Regras:
 * - O CPF deve ser único para cada aluno.
 * - Um aluno pode estar associado a várias avaliações físicas.
 *
 * <p>Anotações:
 * - <code>@JsonIgnore</code>: evita a serialização do relacionamento de retornos desnecessários.
 * - <code>@JsonIgnoreProperties</code>: utilizado para ignorar problemas do Hibernate durante
 * operações de serialização.</p>
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @since 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  /**
   * Identificador único do aluno.
   *
   * <p>Este campo é gerado automaticamente pelo banco de dados utilizando a estratégia
   * <code>GenerationType.IDENTITY</code>.</p>
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Nome completo do aluno.
   *
   * <p>Este campo é obrigatório, indicado pela anotação
   * <code>@Column(nullable = false)</code>.</p>
   */
  @Column(nullable = false)
  private String nome;

  /**
   * CPF do aluno.
   *
   * <p>O CPF deve ser único para cada aluno, garantido pela anotação
   * <code>@Column(unique = true)</code>.</p>
   */
  @Column(unique = true)
  private String cpf;

  /**
   * Bairro onde o aluno reside.
   * Este campo é opcional e não possui restrições na base de dados.
   */
  private String bairro;

  /**
   * Data de nascimento do aluno.
   *
   * <p>Representa a data em que o aluno nasceu. Utiliza o tipo <code>LocalDate</code>
   * para facilitar operações e formatações com datas.</p>
   */
  private LocalDate dataDeNascimento;

  /**
   * Lista de Avaliações Físicas associadas ao aluno.
   *
   * <p>Relacionamento do tipo "Um para Muitos" (<code>@OneToMany</code>),
   * onde um aluno pode ter várias avaliações físicas.
   * O atributo <code>mappedBy</code> indica que o campo `aluno` na entidade
   * `AvaliacaoFisica` gerencia este relacionamento.</p>
   *
   * <p>O <code>FetchType.LAZY</code> é usado para buscar as avaliações apenas
   * quando forem explicitamente acessadas, melhorando a eficiência.</p>
   *
   * <p>A anotação <code>@JsonIgnore</code> evita a serialização do campo para JSON
   * na saída de uma API REST, prevenindo problemas de referência cíclica.</p>
   */
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //Um aluno tem várias avaliações
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
