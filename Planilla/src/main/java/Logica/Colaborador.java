/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Marlon
 */
public abstract class Colaborador 
{  //-------------declaración de atributos----------------//
   private String  nombre,apellido1,apellido2;
   private int cedula;
   //-------------constructores-------------------------//

    public Colaborador() { }
    
    public Colaborador(String nombre, String apellido1, String apellido2, int cedula) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
    }
   //-------------get/set-------------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    //------ metodos---//
    public abstract void Mostrar();
    public abstract double calcularSalario();
}
