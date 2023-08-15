package com.ada.aniversario.dto;

import com.ada.aniversario.entity.Aniversario;
import com.ada.aniversario.repository.AniversarioRepository;
import com.ada.aniversario.service.AniversarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnivRequestDTO {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
