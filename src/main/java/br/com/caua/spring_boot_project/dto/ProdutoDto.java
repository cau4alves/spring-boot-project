package br.com.caua.spring_boot_project.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDto {

    private String name;

    private BigDecimal price;

    private Integer qtd;
}
