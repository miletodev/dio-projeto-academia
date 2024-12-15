package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Classe responsável por representar os dados necessários para criar um novo Aluno.
 *
 * Esta classe contém informações básicas do aluno que serão utilizadas no processo
 * de cadastro na aplicação. Os atributos são validados por meio de anotações para garantir
 * consistência e integridade dos dados fornecidos.
 *
 * Contém os seguintes campos:
 * - Nome do aluno.
 * - CPF do aluno, validado como um formato válido de CPF.
 * - Bairro de residência do aluno.
 * - Data de nascimento do aluno.
 *
 * Utiliza as anotações do Lombok para reduzir o código boilerplate:
 * - @Data: Gera automaticamente métodos como getters, setters, equals, hashCode e toString.
 * - @NoArgsConstructor: Gera um construtor padrão sem argumentos.
 * - @AllArgsConstructor: Gera um construtor com todos os atributos como argumentos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 250, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente.")
  @CPF(message = "'${validatedValue} é inválido!")
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente.")
  @Past(message = "Data '${validatedValue} é inválida.")
  private LocalDate dataDeNascimento;
}
