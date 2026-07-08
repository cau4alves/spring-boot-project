package br.com.caua.spring_boot_project.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
}
