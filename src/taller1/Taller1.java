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
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;



public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void fileReader(){
        try {
            // Asignación del nombre de archivo por defecto que usará la aplicación

            String archivo = "C:\\Users\\Andrey\\Desktop\\Taller1\\src\\taller1\\Origen.txt";
            
            // Se trata de leer el archivo y analizarlo en la clase que se ha creado con JFlex
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            //System.out.println(buffer);
            AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);
            
            String Documento = "";
            String Nombre = "";
            String Apellido = "";
            String Nota="";
            String Correo = "";
            int cont=0;

            while (true) {

                // Obtener el token analizado y mostrar su información
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }

                //System.out.println(token.toString());
                //System.out.println(token.getToken());
                
                
                switch(token.getToken())
                {
                    case "Cedula":
                    {
                        Documento=token.getLexema();
                    }break;
                    case "Nombre_Apellido":
                    {
                        if(cont==0)
                        {
                            Nombre=token.getLexema();   
                            cont=1;
                        }else
                        {
                            Apellido=token.getLexema();
                            cont=0;
                        }
                    }break;
                    case "Correo":
                    {
                        Correo=token.getLexema();
                    }break;
                    case "Nota":
                    {
                        Nota=token.getLexema();
                    }break;
                }
                        
                if(token.getToken().equals("Nota"))
                {
                    //JOptionPane.showMessageDialog(null, "Datos Capturados.\n\nDocumento: "+Documento+"\nNombre: "+Nombre+"\nApellido: "+Apellido+"\nCorreo: "+Correo+"\nNota: "+Nota);
                    pdf(Documento,Nombre,Apellido,Correo,Nota); 
                    System.out.println("Documento Generado para "+Nombre+" "+Apellido);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        try {
            sheetReaderflex();
            fileReader();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void crearCarpeta(){
        String ruta = "C:\\tallerNotas";
        File crear_carpeta = new File(ruta);
        if(!crear_carpeta.exists()){
            crear_carpeta.mkdir();
            System.out.println("no existia");
        }else{
            System.out.println("ya existe");
        }
    }
    
    public static void pdf(String id,String nombre, String apellido, String email, String nota){
        String prueba = nombre+"_"+id;
        //crearCarpeta();
        try {
            FileOutputStream arc = new FileOutputStream("Notas/"+prueba+".pdf");//("C:\\tallerNotas/"+prueba+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, arc);
            doc.open();
            
            doc.add(new Paragraph("UNIVERSIDAD NACIONAL DE COLOMBIA"));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Reporte de notas finales - LENGUAJES DE PROGRAMACIÓN 2019"));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Nombre: "+nombre));
            doc.add(new Paragraph("Apellido: "+apellido));
            doc.add(new Paragraph("Cedula: "+id));
            doc.add(new Paragraph("E-mail: "+email));
            doc.add(new Paragraph("Nota: "+nota));
            doc.close();
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
    public static void sheetReaderflex(){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String rutaArchivoExcel = "C:\\Users\\Andrey\\Desktop\\Taller1\\src\\taller1\\ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            
            fichero = new FileWriter("C:\\Users\\Andrey\\Desktop\\Taller1\\src\\taller1\\Origen.txt",false);
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
