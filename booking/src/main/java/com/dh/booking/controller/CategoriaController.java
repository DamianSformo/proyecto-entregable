package com.dh.booking.controller;

import com.dh.booking.dto.CategoriaDto;
import com.dh.booking.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@CrossOrigin

public class CategoriaController {

    //* ///////// ATRIBUTOS ///////// *//

    @Autowired
    private ICategoriaService service;

    //* ///////// GET ///////// *//

    @GetMapping("h")
    public void c(){
        System.out.println("hola");
    }

    @GetMapping("traer")
    public Collection<CategoriaDto> getCategorias(){
        return service.getAll();
    }

    @GetMapping("traer/{id}")
    public CategoriaDto getCategoria(@PathVariable Long id){
        return service.get(id);
    }

    //* ///////// POST ///////// *//

    @PostMapping("guardar")
    public void saveCategoria(@RequestBody CategoriaDto categoriaDto){
        service.save(categoriaDto);
    }

    //* ///////// DELETE ///////// *//

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        service.delete(id);
    }



}
