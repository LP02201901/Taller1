/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author Andrey
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // Asignación del nombre de archivo por defecto que usará la aplicación
            String archivo = "C:\\Users\\Andrey\\Desktop\\Taller1\\src\\taller1\\prueba.txt";

            // Se trata de leer el archivo y analizarlo en la clase que se ha creado con JFlex
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);

            while (true) {

                // Obtener el token analizado y mostrar su información
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }

                System.out.println(token.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
