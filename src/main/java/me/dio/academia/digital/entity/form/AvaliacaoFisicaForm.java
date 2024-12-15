package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;


/**
 * Classe responsável por receber os dados necessários para criar uma nova Avaliação Física.
 *
 * Os dados fornecidos nesta classe serão usados para realizar a criação de uma
 * nova instância da entidade {@link me.dio.academia.digital.entity.AvaliacaoFisica}.
 *
 * Contém:
 * <ul>
 *   <li>O identificador do aluno que será avaliado</li>
 *   <li>O peso do aluno no momento da avaliação</li>
 *   <li>A altura do aluno no momento da avaliação</li>
 * </ul>
 *
 * Utiliza as anotações do Lombok para reduzir o código boilerplate:
 * <ul>
 *   <li>{@code @Data}: Gera os métodos getters, setters, equals, hashCode e toString.</li>
 *   <li>{@code @NoArgsConstructor}: Gera um construtor vazio.</li>
 *   <li>{@code @AllArgsConstructor}: Gera um construtor com todos os campos.</li>
 * </ul>
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  /**
   * Identificador único do aluno que será avaliado.
   * Deve corresponder a uma instância válida de {@link Aluno}.
   */
  private Long alunoId;

  /**
   * Peso do aluno registrado no momento da avaliação.
   */
  private double peso;

  /**
   * Altura do aluno registrada no momento da avaliação.
   */
  private double altura;
}
