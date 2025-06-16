/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;


public class colaboradorHoras extends Colaborador{

    private int cantidaHoras;
   
    public colaboradorHoras() {}

    public colaboradorHoras(int cantidadHoras, String nombre, String apellido1, String apellido2, int cedula) {
        super(nombre, apellido1, apellido2, cedula);
        this.cantidaHoras = cantidadHoras;
    }
    

    //get/set 
    public void setCantidaHoras(int cantidaHoras) 
    {
        this.cantidaHoras = cantidaHoras;
    }

    public int getCantidaHoras() {
        return cantidaHoras;
    }

    //Metodos
    @Override
    public double calcularSalario() {
        return 3500*getCantidaHoras();
    }
    
    @Override
    public void Mostrar() 
    {
        String txt="";
        
        txt+="\n Cedula:"+getCedula()+"\n Nombre: "+getNombre()+"\n Apellido1:"+getApellido1()+
             "\n Apellido2: "+getApellido2()+"\n Cantidad de Horas:"+getCantidaHoras()+
             "\n Salario:"+calcularSalario();
        
        JOptionPane.showMessageDialog(null,txt);
    }

    
}

