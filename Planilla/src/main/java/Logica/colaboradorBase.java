/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;


public class colaboradorBase extends Colaborador
{   // Atributos
    private double porcentaje;

    
    //Constructores
    public colaboradorBase() {}

    public colaboradorBase(double porcentaje, String nombre, String apellido1, String apellido2, int cedula) {
        super(nombre, apellido1, apellido2, cedula);
        this.porcentaje = porcentaje;
    }
    

    //get/set
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    //metodos
    public double getPorcentaje() {
        return porcentaje;
    }

    
    @Override
    public double calcularSalario() 
    {
        return 250000;
    }
    
    @Override
    public void Mostrar() 
    {
        String txt="";
        
        txt+="\n Cedula:"+getCedula()+"\n Nombre: "+getNombre()+"\n Apellido1:"+getApellido1()+
             "\n Apellido2: "+getApellido2()+"\n Porcentaje:"+getPorcentaje()+
             "\n Salario:"+calcularSalario();
        
        JOptionPane.showMessageDialog(null,txt);
    }

    
}
