package com.clase3.calcu_calorias.Service;

import com.clase3.calcu_calorias.DTOS.PlatoDTO;
import com.clase3.calcu_calorias.DTOS.RespuestaDTO;

public interface ICaloriasService {
    RespuestaDTO calculadora(PlatoDTO plato);
}
