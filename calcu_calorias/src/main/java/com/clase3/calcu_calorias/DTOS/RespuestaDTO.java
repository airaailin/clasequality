package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter @Getter
public class RespuestaDTO {
    private Double totalCaloriasPorPlato;
    private HashMap totalCaloriasPorIngrediente;
    private IngredientesDTO ingredienteConMasCalorias;
}
