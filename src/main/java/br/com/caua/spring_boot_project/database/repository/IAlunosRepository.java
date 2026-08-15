package br.com.caua.spring_boot_project.database.repository;

import br.com.caua.spring_boot_project.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
}
