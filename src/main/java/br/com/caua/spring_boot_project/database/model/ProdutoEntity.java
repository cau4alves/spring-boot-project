package br.com.caua.spring_boot_project.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoEntity {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer qtd;
}
