package br.com.caua.spring_boot_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ExercicioDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String grupoMuscular;
}
