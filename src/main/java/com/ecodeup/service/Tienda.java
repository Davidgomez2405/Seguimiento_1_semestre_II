package com.ecodeup.service;

import com.ecodeup.model.Juguete;
import com.ecodeup.model.TipoJuguete;

import java.util.*;

public class Tienda implements JugueteService {
    private String nombre;
    private Map<String, Juguete> inventario;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
    }

    public void agregarJuguete(Juguete juguete) {
        inventario.put(juguete.getNombre(), juguete);
    }

    public int contarJuguetesPorTipo(TipoJuguete tipo) {
        int count = 0;
        for (Juguete juguete : inventario.values()) {
            if (juguete.getTipo() == tipo) {
                count++;
            }
        }
        return count;
    }

    public int cantidadTotalJuguetes() {
        return inventario.size();
    }

    public double valorTotalJuguetes() {
        double total = 0;
        for (Juguete juguete : inventario.values()) {
            total += juguete.getPrecio() * juguete.getCantidad();
        }
        return total;
    }

    public void disminuirExistencias(String nombreJuguete, int cantidad) {
        Juguete juguete = inventario.get(nombreJuguete);
        if (juguete != null) {
            juguete.setCantidad(juguete.getCantidad() - cantidad);
        }
    }

    public void aumentarExistencias(String nombreJuguete, int cantidad) {
        Juguete juguete = inventario.get(nombreJuguete);
        if (juguete != null) {
            juguete.setCantidad(juguete.getCantidad() + cantidad);
        }
    }

    public TipoJuguete tipoConMasJuguetes() {
        Map<TipoJuguete, Integer> counts = new HashMap<>();
        for (Juguete juguete : inventario.values()) {
            counts.put(juguete.getTipo(), counts.getOrDefault(juguete.getTipo(), 0) + 1);
        }
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public TipoJuguete tipoConMenosJuguetes() {
        Map<TipoJuguete, Integer> counts = new HashMap<>();
        for (Juguete juguete : inventario.values()) {
            counts.put(juguete.getTipo(), counts.getOrDefault(juguete.getTipo(), 0) + 1);
        }
        return Collections.min(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public List<Juguete> obtenerJuguetesConValorMayorA(double valor) {
        List<Juguete> juguetes = new ArrayList<>();
        for (Juguete juguete : inventario.values()) {
            if (juguete.getPrecio() > valor) {
                juguetes.add(juguete);
            }
        }
        return juguetes;
    }

    public List<Juguete> ordenarPorCantidadExistencias() {
        List<Juguete> juguetes = new ArrayList<>(inventario.values());
        juguetes.sort(Comparator.comparingInt(Juguete::getCantidad));
        return juguetes;
    }
}
