package me.dio.academia.digital.exception;

/**
 * Exceção que indica que um determinado aluno não foi encontrado.
 *
 * Esta classe é destinada a ser lançada quando uma operação de busca de aluno
 * não localiza um registro correspondente no banco de dados. Pode ser utilizada
 * em serviços ou repositórios que dependem de alunos existentes para realizar
 * operações.
 *
 * @throws AlunoNotFoundException quando o aluno solicitado não for encontrado
 */
public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
