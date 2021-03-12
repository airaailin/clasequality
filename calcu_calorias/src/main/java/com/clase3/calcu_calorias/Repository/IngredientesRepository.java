package com.clase3.calcu_calorias.Repository;

import com.clase3.calcu_calorias.DTOS.CaloriasDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.ResourcesUtil;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;


@Repository
public class IngredientesRepository implements IIngredientesRepository {

    public IngredientesRepository() {
        this.calorias = leerBaseDatos();
    }

    List<CaloriasDTO> calorias;

    @Override
    public CaloriasDTO encontrarCaloriasPorIngrediente(String ingrediente){
        return this.calorias.stream()
                .filter(caloria -> caloria.getNombre().equals(ingrediente))
                .findFirst().orElseThrow(NoSuchElementException::new);

    }

    private List<CaloriasDTO> leerBaseDatos(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:food.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriasDTO>> typeReference = new TypeReference<List<CaloriasDTO>>() {};
        List<CaloriasDTO> caloriasDTOS = null;
        try {
            caloriasDTOS = objectMapper.readValue(archivo, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return caloriasDTOS;
    }

}
