package com.ada.aniversario.dto;

import com.ada.aniversario.repository.AniversarioRepository;

public class AnivResponseDTO {

    private String codigo;

    public AnivResponseDTO(Long id, String nome) {
        this.codigo = nome + "#" + id.toString();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}