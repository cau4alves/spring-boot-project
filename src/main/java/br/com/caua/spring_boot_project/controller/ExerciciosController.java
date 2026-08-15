package br.com.caua.spring_boot_project.controller;

import br.com.caua.spring_boot_project.database.model.ExerciciosEntity;
import br.com.caua.spring_boot_project.dto.ExercicioDTO;
import br.com.caua.spring_boot_project.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll() {
        return exerciciosService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExercicioDTO exercicioDTO) {
        exerciciosService.save(exercicioDTO);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExercicioByGrupoMuscular(@PathVariable String grupoMuscular) {
        return exerciciosService.getExercicioByGrupoMuscular(grupoMuscular);
    }
}
