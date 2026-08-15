package br.com.caua.spring_boot_project.database.repository;

import br.com.caua.spring_boot_project.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExercicioRepository extends JpaRepository<ExerciciosEntity, Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    @Query(value = """
          SELECT e FROM ExerciciosEntity e 
          where UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)
    """
    )
    List<ExerciciosEntity> findAllByGrupoMuscularjpql(@Param("grupoMuscular") String grupoMuscular);
}
