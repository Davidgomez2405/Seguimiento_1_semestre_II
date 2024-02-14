package com.ecodeup.mapping.mappers;

import com.ecodeup.mapping.dtos.JugueteDTO;
import com.ecodeup.model.Juguete;

public class JugueteMapper {
    public static JugueteDTO mapFromModel(Juguete juguete){
      return new JugueteDTO(juguete.getNombre(), juguete.getCantidad(), juguete.getPrecio());
    }
}
