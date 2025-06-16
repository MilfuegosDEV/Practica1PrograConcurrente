/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniel
 */



package Util;

import Logica.*;
import java.io.*;
import java.util.ArrayList;

public class ArchivoHelper {

    public static void guardar(ArrayList<Colaborador> colaboradores, String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (Colaborador c : colaboradores) {
                if (c instanceof ColaboradorGerente) {
                    ColaboradorGerente g = (ColaboradorGerente) c;
                    writer.write("GERENTE," + g.getCedula() + "," + g.getNombre() + "," + g.getApellido1() + "," + g.getApellido2() + "," + g.getPosicion());
                } else if (c instanceof colaboradorHoras) {
                    colaboradorHoras h = (colaboradorHoras) c;
                    writer.write("HORAS," + h.getCedula() + "," + h.getNombre() + "," + h.getApellido1() + "," + h.getApellido2() + "," + h.getCantidaHoras());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

public static ArrayList<Colaborador> cargar(String ruta) {
    ArrayList<Colaborador> lista = new ArrayList<>();
    File archivo = new File(ruta);

    // Si no existe el archivo, lo crea vacío
    if (!archivo.exists()) {
        try {
            archivo.createNewFile();
            System.out.println("Archivo creado: " + ruta);
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo: " + e.getMessage());
            return lista;
        }
    }

    // Lectura normal
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length < 6) continue; // evitar errores

            String tipo = datos[0];
            int cedula = Integer.parseInt(datos[1]);
            String nombre = datos[2];
            String ap1 = datos[3];
            String ap2 = datos[4];

            if (tipo.equals("GERENTE")) {
                String posicion = datos[5];
                lista.add(new ColaboradorGerente(cedula, nombre, ap1, ap2, posicion));
            } else if (tipo.equals("HORAS")) {
                int horas = Integer.parseInt(datos[5]);
                lista.add(new colaboradorHoras(horas, nombre, ap1, ap2, cedula));
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer: " + e.getMessage());
    }

    return lista;
}

}
