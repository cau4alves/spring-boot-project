package br.com.caua.spring_boot_project.controller;

import br.com.caua.spring_boot_project.database.model.ProdutoEntity;
import br.com.caua.spring_boot_project.dto.ProdutoDto;
import br.com.caua.spring_boot_project.exception.NotFoundException;
import br.com.caua.spring_boot_project.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> listAll() {
        return this.produtoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity findOne(@PathVariable Integer id) throws NotFoundException {
        return this.produtoService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity create(@RequestBody ProdutoDto produtoDto) {
        return this.produtoService.createProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity update(@RequestBody ProdutoDto produtoDto, @PathVariable Integer id) throws NotFoundException {
        return this.produtoService.updateProduct(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.produtoService.deleteProduct(id);
    }
}
