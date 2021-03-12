package com.clase3.calcu_calorias.Repository;

import com.clase3.calcu_calorias.DTOS.CaloriesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

//autor: ailinaira
@Repository
public class IngredientsRepository implements IIngredientsRepository {

    public IngredientsRepository() {
        this.calories = readDataBase();
    }

    List<CaloriesDTO> calories;

    @Override
    public CaloriesDTO getIngredientCalories(String ingredient){
        return this.calories.stream()
                .filter(calorie -> calorie.getName().equals(ingredient))
                .findFirst().orElseThrow(NoSuchElementException::new);

    }

    //metodo que lee la base de datos (json)
    private List<CaloriesDTO> readDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriesDTO>> typeReference = new TypeReference<List<CaloriesDTO>>() {};
        List<CaloriesDTO> caloriesDTOS = null;
        try {
            caloriesDTOS = objectMapper.readValue(file, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return caloriesDTOS;
    }

}
