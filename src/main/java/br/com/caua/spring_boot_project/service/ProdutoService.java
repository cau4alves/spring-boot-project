package br.com.caua.spring_boot_project.service;

import br.com.caua.spring_boot_project.database.model.ProdutoEntity;
import br.com.caua.spring_boot_project.dto.ProdutoDto;
import br.com.caua.spring_boot_project.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .name("Caua")
                .price(new BigDecimal(200))
                .qtd(4)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .name("Caua")
                .price(new BigDecimal(200))
                .qtd(4)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .name("Caua")
                .price(new BigDecimal(200))
                .qtd(4)
                .build());
    }

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity findOne(Integer id) throws NotFoundException {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        return produto;
    }

    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        Integer integer = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(integer)
                .name(produtoDto.getName())
                .price(produtoDto.getPrice())
                .qtd(produtoDto.getQtd())
                .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produto.setName(produtoDto.getName());
        produto.setPrice(produtoDto.getPrice());
        produto.setQtd(produtoDto.getQtd());

        return produto;
    }

    public void deleteProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}
