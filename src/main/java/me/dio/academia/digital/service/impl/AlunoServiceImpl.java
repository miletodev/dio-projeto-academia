package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementação do serviço de gestão de Alunos.
 *
 * Esta classe fornece as operações de criação, busca, atualização, deleção de
 * alunos e listagem de suas avaliações físicas. Utiliza o Spring Service para
 * disponibilizar as instâncias gerenciadas e o Spring Data JPA para operações
 * de persistência.
 */
@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    /**
     * Cria um novo aluno no sistema.
     *
     * @param form Objeto contendo os dados do aluno (nome, CPF, bairro, data de nascimento).
     * @return O aluno criado e persistido no banco de dados.
     */
    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    /**
     * Recupera um aluno com base no ID.
     *
     * @param id O identificador do aluno.
     * @return O aluno identificado pelo ID.
     * @throws RuntimeException Caso o aluno não seja encontrado.
     */
    @Override
    public Aluno get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));
    }

    /**
     * Retorna todos os alunos cadastrados.
     * Os alunos são retornados ordenados pelo atributo "nome" em ordem crescente.
     *
     * @return Uma lista de alunos cadastrados.
     */
    @Override
    public List<Aluno> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    /**
     * Atualiza os dados de um aluno existente.
     *
     * @param id O identificador único do aluno.
     * @param formUpdate Objeto contendo os dados a serem atualizados (nome, bairro e/ou data de nascimento).
     * @return O objeto do aluno atualizado.
     * @throws AlunoNotFoundException Se o aluno com o ID fornecido não for encontrado.
     */
    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException
                        ("Aluno com ID " + id + " não encontrado"));
        return repository.save(aluno);
    }

    /**
     * Remove um aluno com base no ID.
     *
     * @param id O identificador único do aluno.
     * @throws RuntimeException Se o aluno com o ID fornecido não for encontrado.
     */
    @Override
    public void delete(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));
        repository.delete(aluno);
    }

    /**
     * Lista todas as avaliações físicas associadas a um aluno.
     *
     * @param id O identificador do aluno.
     * @return Uma lista de avaliações físicas do aluno identificado.
     * @throws RuntimeException Caso o aluno não seja encontrado.
     */
    @Transactional(readOnly = true)
    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("Aluno com ID " + id + " não encontrado"));
        return aluno.getAvaliacoes();
    }

}
