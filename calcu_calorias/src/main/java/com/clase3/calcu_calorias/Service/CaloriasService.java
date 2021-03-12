package com.clase3.calcu_calorias.Service;

import com.clase3.calcu_calorias.DTOS.CaloriasDTO;
import com.clase3.calcu_calorias.DTOS.IngredientesDTO;
import com.clase3.calcu_calorias.DTOS.PlatoDTO;
import com.clase3.calcu_calorias.DTOS.RespuestaDTO;
import com.clase3.calcu_calorias.Repository.IIngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CaloriasService implements ICaloriasService{
    @Autowired
    private IIngredientesRepository repository;

    @Override
    public RespuestaDTO calculadora(PlatoDTO plato) {
        RespuestaDTO respuesta = new RespuestaDTO();

        respuesta.setTotalCaloriasPorPlato(this.totalCaloriasPorPlato(plato));
        respuesta.setTotalCaloriasPorIngrediente(this.totalCaloriasPorIngrediente(plato));
        respuesta.setIngredienteConMasCalorias(this.ingredienteConMasCalorias(plato));

        return respuesta;
    }

    public double totalCaloriasPorPlato(PlatoDTO plato){
        double totalCaloriasPorPlato = 0;
        for (IngredientesDTO i: plato.getIngredientes()){
            totalCaloriasPorPlato+= i.getPeso() * repository.encontrarCaloriasPorIngrediente(i.getNombre()).getCalorias()/100;
        }
        return totalCaloriasPorPlato;
    }

    public HashMap<String, Double> totalCaloriasPorIngrediente(PlatoDTO plato){
        HashMap <String, Double> totalCaloriasPorIngrediente = new HashMap<String, Double>();
        for (IngredientesDTO i: plato.getIngredientes()) {
            totalCaloriasPorIngrediente.put(i.getNombre(), i.getPeso() * repository.encontrarCaloriasPorIngrediente
                    (i.getNombre()).getCalorias() / 100);
        }
        return totalCaloriasPorIngrediente;

    }

    public IngredientesDTO ingredienteConMasCalorias(PlatoDTO plato){
        double caloriasIngredienteMasCalorias = 0;
        IngredientesDTO ingredienteConMasCalorias = null;
        for (IngredientesDTO i: plato.getIngredientes()){
            if(i.getPeso() * repository.encontrarCaloriasPorIngrediente
                    (i.getNombre()).getCalorias() / 100 > caloriasIngredienteMasCalorias){
                caloriasIngredienteMasCalorias = (i.getPeso() * repository.encontrarCaloriasPorIngrediente
                        (i.getNombre()).getCalorias() / 100);
                ingredienteConMasCalorias = i;
            }
        }
        return ingredienteConMasCalorias;
    }

}
