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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

public class Taller1 {

    /**
     * @param args the command line arguments
     */
    
//static String RutaOrigen="C:\\Users\\Andrey\\Desktop\\Taller1\\src\\taller1\\Origen.txt";
    public static void fileReader(String RutaOrigen){
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(RutaOrigen));
            // Asignación del nombre de archivo por defecto que usará la aplicación

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
                    //pdf(Documento,Nombre,Apellido,Correo,Nota); 
                    //System.out.println("Documento Generado para "+Nombre+" "+Apellido);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void Escribir_Archivo(String palabra,String RutaOrigen) //Sobre escribe
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(RutaOrigen);
            pw = new PrintWriter(fichero);
            pw.println(palabra);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public static void Agregar_A_Archivo(String palabra,String RutaOrigen) //Agrega al archivo
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(RutaOrigen);
            pw = new PrintWriter(fichero);
            pw.println(palabra);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    
    public static String Verificador_token(String palabra,String RutaOrigen)
    {
        String token1="";
        int cont=0;
        Escribir_Archivo(palabra, RutaOrigen);
        
        BufferedReader buffer = null;
    try {
        buffer = new BufferedReader(new FileReader(RutaOrigen));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Taller1.class.getName()).log(Level.SEVERE, null, ex);
    }
        AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);
        
            while (true) {
            try {
                // Obtener el token analizado y mostrar su información
                TokenPersonalizado token = analizadorJFlex.yylex();
                token1=token.getToken();
                //System.out.println(token.getToken());
                cont++;
            } catch (IOException ex) {
                Logger.getLogger(Taller1.class.getName()).log(Level.SEVERE, null, ex);
            }
                if (!analizadorJFlex.existenTokens()) {
                    break;
                }
                break;
            }
            
        return token1+" - "+cont;
    }
    
    public static List<String> ObtenerTokens(String RutaOrigen)
    {
        List<String> listatokens = new ArrayList<String>();
        String texto="";
        int cont=0;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(RutaOrigen));
            AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);

            while (true) {
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }
                if(token.getToken().equals("Token"))
                {
                    cont++;
                    //System.out.println("Token encontrado: "+token.getLexema());
                    listatokens.add(""+token.getLexema());
                }
                texto+=token.getLexema();
                //System.out.println(token.toString());
            }
        } catch (Exception e) {
            //System.out.println(e.toString());
        }
        //System.out.println(cont+" encontrados");
        //listatokens.add(texto);
        return listatokens;
        
    }
    /*public static void main(String[] args) {
        Verificador_token("Kevin Andrey","dbfdbfdjn");
        try {
            excelReaderValidateDistance("se va a pifear");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }*/
    
    public static void crearCarpeta(){
        String ruta = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/tallerNotas";
        File crear_carpeta = new File(ruta);
        if(!crear_carpeta.exists()){
            crear_carpeta.mkdir();
            //System.out.println("no existia");
        }else{
            //System.out.println("ya existe");
        }
    }
    
    //public static void pdf(ArrayList<String> arr, String path, String name){
    public static void pdf(String a, String path, String name){
        //crearCarpeta();
        //ArrayList<String> arr = a.split("\n");
        a=a.replace("\n", "\n ");
        List<String> arr = Arrays.asList(a.split("\n"));
        try {
            FileOutputStream arc = new FileOutputStream(path+"/"+name+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, arc);
            doc.open();
            for (int i = 0; i < arr.size(); i++) {
                doc.add(new Paragraph(arr.get(i)));
            }
            doc.close();
        } catch (Exception e) {
            System.out.println("error en pdf: "+e);
        }
    }
    
    public static void sheetReaderflex(String RutaOrigen){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String rutaArchivoExcel = RutaOrigen;//"/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            
            fichero = new FileWriter(RutaOrigen,false);//("/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/Origen.txt",false);
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
    
    /**
     * 
     * 
     * 
     * New
     * 
     * 
     * 
     * @return 
     */
    
    
    public static String[][] excelReaderColumn(String RutaOrigen){
        /** Cambio se guardan los datos en una matriz de Strings donde la posición
         * matriz[indice][0] muestra el identificador de cada columna
         * e indice la cantidad de columnas que existen
         * 
         * 
         */
        try {
            String rutaArchivoExcel = RutaOrigen;//"/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Integer control = 0;
            Integer controli = 0;
            Sheet sheet  = workbook.getSheetAt(0); // Get Your Sheet.        
            Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
            for (Row row : sheet) { //For each Row.
                /**
                 * Se toma la primera columna y según la misma hace el calculo de la cantidad
                 * de filas de la matriz
                 */
                Cell cell = row.getCell(0); //Get the Cell at the Index /Column you want.
                if (cell != null){
                    control++;
                }
            }
            String[][] line = new String[sheet.getRow(0).getPhysicalNumberOfCells()][control];
                while (rowIterator.hasNext()) {                
                    Row row = rowIterator.next(); // For each row, iterate through each columns
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if(controli < control){
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:
                                    line[cell.getColumnIndex()][controli] = cell.getRichStringCellValue().getString();                
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    line[cell.getColumnIndex()][controli] = String.valueOf(cell.getNumericCellValue());
                                    break;
                                default:                                
                            }                       
                        }
                    }
                    controli++;
                }
            return line;
                
            } catch (Exception e) {
                e.printStackTrace();              
                String[][] line = new String[0][0];
                return line;
        }
    }
       
    public static String[][] excelReaderValidateDistance(String RutaOrigen1,String RutaOrigen){
        /** Funcion que valida la distancia, dependiendo que se requiera 
          * guarda en un archivo de texto o se toma directamente de la matriz 
          * el valor evaluado
          * 
        */
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
            fichero = new FileWriter(RutaOrigen1,false);//("/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/Origen.txt",false);
            pw = new PrintWriter(fichero);
        
            String[][] data = excelReaderColumn(RutaOrigen);
            for(int i = 0;i < data.length; i++){                
                for(int j = 0;j < data[i].length; j++){
                    //System.out.println(data[i][j]);         
                    pw.println(data[i][j]);
                }   
                //System.out.println(); 
            }
            return data;
            } catch (Exception e) {
              
            //System.out.println(e.toString());
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
        return null;       
    }
    
}
