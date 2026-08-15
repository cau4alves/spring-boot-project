package br.com.caua.spring_boot_project.service;

import br.com.caua.spring_boot_project.database.model.ExerciciosEntity;
import br.com.caua.spring_boot_project.database.repository.IExercicioRepository;
import br.com.caua.spring_boot_project.dto.ExercicioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExercicioRepository exercicioRepository;

    public List<ExerciciosEntity> listAll() {
        return exercicioRepository.findAll();
    }

    public void save(ExercicioDTO exercicioDTO) {
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exercicioDTO.getNome())
                .grupoMuscular(exercicioDTO.getGrupoMuscular())
                .build();

        exercicioRepository.save(exercicio);
    }

    public List<ExerciciosEntity> getExercicioByGrupoMuscular(String grupoMuscular) {
        return exercicioRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
