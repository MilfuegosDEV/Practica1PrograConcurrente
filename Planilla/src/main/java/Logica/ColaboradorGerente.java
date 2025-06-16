/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Luna Cienfuegos
 */
public class ColaboradorGerente extends Colaborador{
    
    private String posicion;
    private double porcentaje;
    private double salarioBase;
    
    public ColaboradorGerente(int cedula, String nombre,String apellido1,String apellido2,String posicion){
        super(nombre,apellido1,apellido2,cedula);
        this.posicion = posicion.toUpperCase();
        
        switch (this.posicion){
            case"A":
                porcentaje = 0.15;
                salarioBase = 1100000;
                break;
            case "B":
                porcentaje = 0.10;
                salarioBase = 1200000;
                break;
            case "C":
                porcentaje = 0.05;
                salarioBase = 1300000;
                break;
                
        }
    }

    @Override
    public void Mostrar() {
        String txt = ""; 

txt += "\nCedula "+getCedula() + "\nNombre"+getNombre()+"\nApellido1"+getApellido1()+"\nApellido2"+getApellido2()+"\nPosición"+ posicion+"\nSalario" +calcularSalario();

JOptionPane.showMessageDialog(null, txt, "Gerente", JOptionPane.INFORMATION_MESSAGE);}


        
        

    @Override
    public double calcularSalario() {
        return salarioBase + (salarioBase * porcentaje);
    
    
}
    public String getPosicion() {
    return posicion;
}

    
}
