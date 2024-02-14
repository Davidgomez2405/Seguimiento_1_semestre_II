package com.ecodeup.service;

import com.ecodeup.mapping.dtos.JugueteDTO;
import com.ecodeup.model.Juguete;
import com.ecodeup.model.TipoJuguete;

import java.util.List;
import java.util.Map;

public interface JugueteService{
    void agregarJuguete(Juguete juguete);
    int contarJuguetesPorTipo(TipoJuguete tipo);
    int cantidadTotalJuguetes();
    double valorTotalJuguetes();
    void disminuirExistencias(String nombreJuguete, int cantidad);
    void aumentarExistencias(String nombreJuguete, int cantidad);
    TipoJuguete tipoConMasJuguetes();
    TipoJuguete tipoConMenosJuguetes();
    List<Juguete> obtenerJuguetesConValorMayorA(double valor);
    List<Juguete> ordenarPorCantidadExistencias();
}


