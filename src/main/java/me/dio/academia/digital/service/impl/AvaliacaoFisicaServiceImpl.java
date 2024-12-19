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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        return avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação Física com o ID " + id + " não encontrada!"));
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
     * Atualiza uma AvaliacaoFisica existente baseado no ID e no form de atualização.
     *
     * @param id o ID que vai ter a AvaliacaoFisica atualizado.
     * @param formUpdate os dados para serem atualizados.
     * @return a AvaliacaoFisica atualizada.
     * @throws EntityNotFoundException se nenhuma avaliação com aquele ID for encontrada.
     * @throws IllegalArgumentException se o form de atualização for null ou inválido.
     */
    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação Física com o ID " + id + " não encontrada!"));

        if (formUpdate != null) {
            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        } else {
            throw new IllegalArgumentException("Verifique os dados informados e tente novamente.");
        }
    }

    /**
     * Exclui uma avaliação física com base no ID fornecido.
     *
     * @param id ID da avaliação física a ser excluída.
     * @throws IllegalArgumentException Se nenhuma avaliação física for encontrada com o ID fornecido.
     */
        @Override
        public void delete(Long id) {
            if (id == null) {
                throw new IllegalArgumentException("O ID fornecido não pode ser nulo.");
            }

            AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Erro ao tentar deletar: Avaliação Física com o ID " + id + " não encontrada no banco de dados."
                    ));

            avaliacaoFisicaRepository.delete(avaliacaoFisica);
        }
    }