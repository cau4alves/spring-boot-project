package br.com.caua.spring_boot_project.database.repository;

import br.com.caua.spring_boot_project.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
