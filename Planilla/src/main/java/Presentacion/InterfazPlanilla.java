/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;
import Logica.*;

public class InterfazPlanilla 
{

    public static void main(String[] args) 
    {   //Colaborador Base
        colaboradorBase objColaboradorbase = new colaboradorBase();
        objColaboradorbase.setCedula(111480781);
        objColaboradorbase.setNombre("Luis");
        objColaboradorbase.setApellido1("Vargas");
        objColaboradorbase.setApellido2("Rojas");
        objColaboradorbase.setPorcentaje(20);
        objColaboradorbase.Mostrar();
        //Colaborador Horas
        colaboradorHoras objColaboradorHoras = new colaboradorHoras();
        objColaboradorHoras.setCedula(111480781);
        objColaboradorHoras.setNombre("Luis");
        objColaboradorHoras.setApellido1("Vargas");
        objColaboradorHoras.setApellido2("Rojas");
        objColaboradorHoras.setCantidaHoras(60);
        objColaboradorHoras.Mostrar();
        
        
        
        
        
        
        
    }
    
}
