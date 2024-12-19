package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        matricula.setId(form.getAlunoId());
        return matricula;
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula com ID " + id + " não encontrada"));
    }

    @Override
    public List<Matricula> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void delete(Long id) {
        Matricula matricula = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("A matrícula com o ID " + id + " não foi encontrada"));
        repository.delete(matricula);
    }
}
