package com.elvilla.computadores;

/**
 * Created by android on 28/05/2018.
 */

public class Computadores {

    private int marca;
    private int ram;
    private int color;
    private int tipo;
    private int so;
    private int foto;

    public Computadores(int marca, int ram, int color, int tipo, int so, int foto) {
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.so = so;
        this.foto = foto;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputadores(this);
    }
}
