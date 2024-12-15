package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por lidar com operações relacionadas aos objetos da entidade Aluno.
 *
 * Define endpoints REST para criar, buscar e listar alunos, bem como acessar as avaliações físicas
 * associadas a um aluno específico. Utiliza o serviço AlunoServiceImpl para processar a lógica
 * de negócios associada.
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    /**
     * Serviço responsável por gerenciar as operações relacionadas à entidade Aluno.
     *
     * Esta instância de AlunoServiceImpl, injetada pelo mecanismo de inversão de controle do Spring,
     * é utilizada para realizar operações como criação, recuperação, atualização, remoção de alunos
     * e listagem de avaliações físicas associadas.
     */
    @Autowired
    private AlunoServiceImpl service;

    /**
     * Retorna uma lista com todos os alunos cadastrados no sistema.
     *
     * @return Uma lista contendo objetos do tipo Aluno.
     */
    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    /**
     * Cria um novo aluno no sistema a partir dos dados fornecidos.
     *
     * @param form Objeto do tipo AlunoForm contendo as informações necessárias para a criação de um novo aluno.
     * @return O objeto Aluno criado, contendo os dados persistidos.
     */
    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);
    }

    /**
     * Método responsável por listar todas as avaliações físicas associadas a um aluno específico.
     *
     * @param id O identificador único do aluno cujas avaliações físicas serão listadas.
     * @return Uma lista contendo todas as avaliações físicas do aluno identificado pelo parâmetro.
     */
    @GetMapping( "/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
        return service.getAllAvaliacaoFisica(id);
    }
}
