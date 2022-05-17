package com.dh.booking.service;

import com.dh.booking.dto.CategoriaDto;
import com.dh.booking.model.Categoria;
import com.dh.booking.repository.ICategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoriaService implements ICategoriaService {

    //* ///////// ATTRIBUTES ///////// *//

    @Autowired
    private ICategoriaRepository repository;

    @Autowired
    private ObjectMapper mapper;

    //* ///////// METHODS ///////// *//

    @Override
    public Set<CategoriaDto> getAll() {
        List<Categoria> listaCategoria = repository.findAll();
        Set<CategoriaDto> listaCategoriaDto = new HashSet<>();
        for (Categoria categoria : listaCategoria){
            listaCategoriaDto.add(mapper.convertValue(categoria, CategoriaDto.class));
        }
        return listaCategoriaDto;
    }

    @Override
    public CategoriaDto get(Long id) {
        CategoriaDto categoriaDto = mapper.convertValue(repository.getById(id), CategoriaDto.class);
        return categoriaDto;
    }

    @Override
    public void save(CategoriaDto categoriaDto) {
        Categoria categoria = mapper.convertValue(categoriaDto, Categoria.class);
        repository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }



}
