package com.ada.aniversario.service;
import com.ada.aniversario.dto.AnivRequestDTO;
import com.ada.aniversario.dto.AnivResponseDTO;
import com.ada.aniversario.entity.Aniversario;
import com.ada.aniversario.repository.AniversarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AniversarioService {

    @Autowired
    private AniversarioRepository aniversarioRepository;

    @Autowired
    public AniversarioService(AniversarioRepository aniversarioRepository) {
        this.aniversarioRepository = aniversarioRepository;
    }

    public AnivResponseDTO salvar(AnivRequestDTO anivRequestDTO) {
        Aniversario aniversario = new Aniversario();
        Aniversario anivSalvo = this.aniversarioRepository.save(aniversario);
        return new AnivResponseDTO(anivSalvo.getId(), anivSalvo.getNome());
    }

    public AnivResponseDTO atualizar(AnivRequestDTO anivRequestDTO, Long id) {
        Aniversario aniversario = this.aniversarioRepository.findById(id).get();
        String[] arr = anivRequestDTO.getCodigo().split("\\$");
        aniversario.setNome(arr[1]);
        Aniversario anivSalvo = this.aniversarioRepository.save(aniversario);
        return new AnivResponseDTO(anivSalvo.getId(), anivSalvo.getNome());
    }


    public List<Aniversario> buscarTodos() {
        return this.aniversarioRepository.findAll();
    }

    public Aniversario buscarPorId(Long id) {
        return this.aniversarioRepository.findById(id).get();
    }

    public Aniversario buscar(Long id, String nome) {
        if (nome != null) {
            return this.aniversarioRepository.findAniversarioByNome(nome).get();
        }

        return this.aniversarioRepository.findById(id).get();
    }

    public void deletar(Long id) {
        this.aniversarioRepository.deleteById(id);
    }

}
