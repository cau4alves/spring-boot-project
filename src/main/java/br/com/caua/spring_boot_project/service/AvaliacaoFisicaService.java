package br.com.caua.spring_boot_project.service;

import br.com.caua.spring_boot_project.database.model.AlunosEntity;
import br.com.caua.spring_boot_project.database.model.AvaliacoesFisicasEntity;
import br.com.caua.spring_boot_project.database.repository.IAlunosRepository;
import br.com.caua.spring_boot_project.database.repository.IAvaliacoesFisicasRepository;
import br.com.caua.spring_boot_project.dto.AvaliacaoFisicaDTO;
import br.com.caua.spring_boot_project.exception.BadRequestException;
import br.com.caua.spring_boot_project.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;
    private final IAlunosRepository alunosRepository;

    public void create(AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisicas = aluno.getAvaliacaoFisica();

        if(avaliacoesFisicas != null) {
            throw new BadRequestException("Avaliação já cadastrada para esse aluno");
        }

        avaliacoesFisicas = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDTO.getPeso())
                .altura(avaliacaoFisicaDTO.getAltura())
                .porcentagemCorporal(avaliacaoFisicaDTO.getPorcentagemCorporal())
                .build();

        avaliacoesFisicas = avaliacoesFisicasRepository.save(avaliacoesFisicas);

        aluno.setAvaliacaoFisica(avaliacoesFisicas);
        alunosRepository.save(aluno);

    }
}
