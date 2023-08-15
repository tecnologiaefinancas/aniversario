package com.ada.aniversario.controller;

import com.ada.aniversario.dto.AnivDTO;
import com.ada.aniversario.dto.AnivRequestDTO;
import com.ada.aniversario.dto.AnivResponseDTO;
import com.ada.aniversario.entity.Aniversario;
import com.ada.aniversario.service.AniversarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aniversario")
public class AniversarioController {

    @Autowired
    private AniversarioService aniversarioService;


    private AnivRequestDTO anivRequestDTO;

/*
    private Aniversario converteParaEntidade(AnivDTO anivDTO) {
        Aniversario aniversario = modelMapper.map(anivDTO, Aniversario.class);
        return aniversario;
    }

    private AnivDTO converteParaDTO(Aniversario aniversario) {
        AnivDTO anivDTO = modelMapper.map(aniversario, AnivDTO.class);
        return anivDTO;
    }

    @PostMapping
    public ResponseEntity<Aniversario> salvar(@RequestBody AnivDTO anivDTO) {
        Aniversario aniversario = aniversarioService.salvar(converteParaEntidade(anivDTO));
        return new ResponseEntity<>(converteParaDTO(aniversario), HttpStatus.CREATED);
    }

    */

    @GetMapping("/{id}")
    public ResponseEntity<Aniversario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.aniversarioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Aniversario> buscarPorIdParam(@RequestParam(required = false) Long id, @RequestParam(required = false) String nome) {
        return ResponseEntity.ok(this.aniversarioService.buscar(id, nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.aniversarioService.deletar(id);
        return ResponseEntity.ok().build();
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<AnivResponseDTO> atualizar(@RequestBody AnivRequestDTO anivRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(this.aniversarioService.atualizar(anivRequestDTO, id));
    }

     */


}

