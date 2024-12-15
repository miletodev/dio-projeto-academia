package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade Avaliação Física.
 *
 * Este controlador implementa funcionalidades como:
 * - Criação de uma avaliação física
 * - Recuperação de avaliações físicas individuais ou em listas
 * - Atualização e remoção de registros de avaliação física
 *
 * @author Mirtilo Mileto Silva de Almeida
 */
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    /**
     * Cria uma nova avaliação física para um aluno.
     *
     * @param form Objeto contendo os dados necessários para criar a avaliação física.
     * @return A avaliação física criada.
     */
    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);

    }

    /**
     * Recupera uma avaliação física específica pelo ID informado.
     *
     * @param id ID da avaliação física a ser recuperada.
     * @return A avaliação física correspondente ao ID.
     */
    @GetMapping("/{id}")
    public AvaliacaoFisica get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Lista todas as avaliações físicas registradas no sistema.
     *
     * @return Lista contendo todas as avaliações físicas.
     */
    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    /**
     * Atualiza uma avaliação física existente.
     *
     * @param id ID da avaliação física a ser atualizada.
     * @param formUpdate Objeto contendo os novos dados para atualização.
     * @return A avaliação física atualizada.
     */
    @PutMapping("/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm formUpdate) {
        return service.update(id, formUpdate);
    }

    /**
     * Exclui uma avaliação física com base no ID fornecido.
     *
     * @param id ID da avaliação física a ser excluída.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
