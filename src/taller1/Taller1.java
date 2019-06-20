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
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void fileReader(){
        try {
            // Asignación del nombre de archivo por defecto que usará la aplicación

            String archivo = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/prueba.txt";
            
            // Se trata de leer el archivo y analizarlo en la clase que se ha creado con JFlex
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            System.out.println(buffer);

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
    public static void main(String[] args) {
        try {
            sheetReaderflex();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void sheetReaderflex(){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String rutaArchivoExcel = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            
            fichero = new FileWriter("/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/prueba.txt",true);
            pw = new PrintWriter(fichero);
            
            
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    pw.println(contenidoCelda);
                    //System.out.println("celda: " + contenidoCelda);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static void sheetReader(){
        try {
            String rutaArchivoExcel = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    System.out.println("celda: " + contenidoCelda);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
