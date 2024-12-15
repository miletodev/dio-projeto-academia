package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementação do serviço responsável por gerenciar as Avaliações Físicas.
 *
 * Este serviço fornece os métodos necessários para realizar as operações principais
 * relacionadas à entidade Avaliação Física, como:
 * <ul>
 *  <li>Criação de uma nova avaliação física</li>
 *  <li>Consulta de avaliações específicas ou de toda a lista</li>
 *  <li>Atualização de avaliações físicas existentes</li>
 *  <li>Exclusão de avaliações físicas</li>
 * </ul>
 *
 * Utiliza os repositórios {@link AvaliacaoFisicaRepository} e {@link AlunoRepository}
 * para realizar as operações no banco de dados.
 *
 * @author Mirtilo Mileto Silva de Almeida
 * @version 1.0
 */
@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * Cria uma nova avaliação física com base nos dados fornecidos no formulário.
     *
     * @param form Objeto {@link AvaliacaoFisicaForm} contendo os dados necessários para criação.
     * @return A instância criada de {@link AvaliacaoFisica}.
     * @throws IllegalArgumentException Se o ID do aluno fornecido no formulário não for encontrado.
     */
    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        // Recupera o aluno pelo ID especificado no formulário
        Optional<Aluno> alunoOptional = alunoRepository.findById(form.getAlunoId());
        if (!alunoOptional.isPresent()) {
            throw new IllegalArgumentException("Aluno com o ID " + form.getAlunoId() + " não encontrado!");
        }

        Aluno aluno = alunoOptional.get();

        // Define os dados da avaliação física
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        // Salva a avaliação e retorna a instância criada
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    /**
     * Retorna uma avaliação física com base no ID fornecido.
     *
     * @param id ID da avaliação física a ser recuperada.
     * @return A instância correspondente de {@link AvaliacaoFisica}.
     * @throws IllegalArgumentException Se nenhuma avaliação física for encontrada com o ID fornecido.
     */
    @Override
    public AvaliacaoFisica get(Long id) {
        // Implemente a lógica ou deixe como null, se necessário.
        return null;
    }

    /**
     * Retorna uma lista com todas as avaliações físicas registradas no sistema.
     *
     * @return Uma lista de instâncias {@link AvaliacaoFisica}.
     */
    @Override
    public List<AvaliacaoFisica> getAll() {
        return List.of();
    }

    /**
     * Atualiza os dados de uma avaliação física existente.
     *
     * @param id ID da avaliação física a ser atualizada.
     * @param formUpdate Objeto {@link AvaliacaoFisicaUpdateForm} contendo os novos dados.
     * @return A instância atualizada de {@link AvaliacaoFisica}.
     * @throws IllegalArgumentException Se nenhuma avaliação física for encontrada com o ID fornecido.
     */
    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        // Implemente a lógica ou deixe como null, se necessário.
        return null;
    }

    /**
     * Exclui uma avaliação física com base no ID fornecido.
     *
     * @param id ID da avaliação física a ser excluída.
     * @throws IllegalArgumentException Se nenhuma avaliação física for encontrada com o ID fornecido.
     */
    @Override
    public void delete(Long id) {
        // Lógica de exclusão, se necessário
    }

}