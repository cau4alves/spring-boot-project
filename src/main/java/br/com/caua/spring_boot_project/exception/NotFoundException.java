package br.com.caua.spring_boot_project.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
