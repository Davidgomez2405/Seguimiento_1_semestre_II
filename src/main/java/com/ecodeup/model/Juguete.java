package com.ecodeup.model;
    import com.ecodeup.model.TipoJuguete;

public class Juguete {
        private String nombre;
        private TipoJuguete tipo;
        private double precio;
        private int cantidad;

        public Juguete(String nombre, TipoJuguete tipo, double precio, int cantidad) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public TipoJuguete getTipo() {
            return tipo;
        }

        public void setTipo(TipoJuguete tipo) {
            this.tipo = tipo;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }


