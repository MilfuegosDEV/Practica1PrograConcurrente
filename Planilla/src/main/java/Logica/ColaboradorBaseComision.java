/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;

/**
 *
 * @author toon_
 */
public class ColaboradorBaseComision  extends colaboradorBase{
        
    private int ventas;
    private double porcentaje;
    private double salarioBase;

public ColaboradorBaseComision() {
        super(); 
    }

    public ColaboradorBaseComision(int cedula,String nombre, String apellido1, String apellido2, int ventas) {
        super();            
        setCedula(cedula);    
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);

        this.ventas = ventas;
        
        if (ventas < 10){
            porcentaje = 0.5;
            salarioBase = 250000;
        }else if (ventas == 10){
            porcentaje = 0.7;
            salarioBase = 300000;
        }else{
            porcentaje = 0.10;
            salarioBase = 350000;
                    
        }
    
   
    }
    @Override
    public double calcularSalario() {
        return super.calcularSalario(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

  @Override
  
public void Mostrar() {
String txt = ""; 

txt += "\nCedula "+getCedula() + "\nNombre"+getNombre()+"\nApellido1"+getApellido1()+"\nApellido2"+getApellido2()+"\nVentas"+ ventas +"\nSalario" +calcularSalario();

JOptionPane.showMessageDialog(null, txt, "Base+Comisión", JOptionPane.INFORMATION_MESSAGE);}

}




