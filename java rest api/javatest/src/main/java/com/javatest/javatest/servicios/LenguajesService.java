package com.javatest.javatest.servicios;

import com.javatest.javatest.models.Lenguajes;
import com.javatest.javatest.repository.LenguajesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LenguajesService {

    LenguajesRepository lenguajesRepository;
    public LenguajesService(LenguajesRepository lenguajesRepository){
        this.lenguajesRepository = lenguajesRepository;
    }

    public List<Lenguajes> getAllLenguajes(){
        Iterable<Lenguajes> iterable = lenguajesRepository.findAll();
        List<Lenguajes> lenguajes = new ArrayList<>();
        iterable.forEach(lenguajes::add); // Agrega cada elemento del Iterable a la lista
        return lenguajes;
    }

    public void saveLenguajes( Lenguajes lenguaje){
        lenguajesRepository.save(lenguaje);

    }
}
