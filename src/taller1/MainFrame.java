/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import taller1.Taller1.*;

/**
 *
 * @author User
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        plantillaArea1.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Pestanas = new javax.swing.JTabbedPane();
        plantillaPerzo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        plantillaArea = new javax.swing.JTextArea();
        crearPdfButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        savePlantiButton = new javax.swing.JButton();
        plantillaPrede = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        plantillaArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        buscarButton1 = new javax.swing.JButton();
        crearPdfButton1 = new javax.swing.JButton();
        pathText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        savedirButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pathText1 = new javax.swing.JTextField();
        excelDirButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        ayudaMenu = new javax.swing.JMenu();
        ayudaItem1 = new javax.swing.JMenuItem();
        ayudaItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CorresponFlex");
        setResizable(false);

        Pestanas.setBackground(new java.awt.Color(204, 204, 204));

        plantillaArea.setColumns(20);
        plantillaArea.setRows(5);
        jScrollPane1.setViewportView(plantillaArea);

        crearPdfButton.setText("Crear PDF");
        crearPdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPdfButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Introduzca la Plantilla");

        savePlantiButton.setText("Guardar Plantilla");
        savePlantiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePlantiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plantillaPerzoLayout = new javax.swing.GroupLayout(plantillaPerzo);
        plantillaPerzo.setLayout(plantillaPerzoLayout);
        plantillaPerzoLayout.setHorizontalGroup(
            plantillaPerzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantillaPerzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plantillaPerzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantillaPerzoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plantillaPerzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(savePlantiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crearPdfButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plantillaPerzoLayout.setVerticalGroup(
            plantillaPerzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantillaPerzoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plantillaPerzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantillaPerzoLayout.createSequentialGroup()
                        .addComponent(crearPdfButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savePlantiButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        Pestanas.addTab("Plantilla Personalizada", plantillaPerzo);

        plantillaArea1.setColumns(20);
        plantillaArea1.setRows(5);
        plantillaArea1.setText("No hay plantilla seleccionada.");
        jScrollPane2.setViewportView(plantillaArea1);

        jLabel3.setText("Plantilla seleccionada");

        buscarButton1.setText("Buscar Plantilla");
        buscarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButton1ActionPerformed(evt);
            }
        });

        crearPdfButton1.setText("Crear PDF");
        crearPdfButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPdfButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plantillaPredeLayout = new javax.swing.GroupLayout(plantillaPrede);
        plantillaPrede.setLayout(plantillaPredeLayout);
        plantillaPredeLayout.setHorizontalGroup(
            plantillaPredeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantillaPredeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plantillaPredeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantillaPredeLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plantillaPredeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(crearPdfButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(plantillaPredeLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        plantillaPredeLayout.setVerticalGroup(
            plantillaPredeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantillaPredeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plantillaPredeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantillaPredeLayout.createSequentialGroup()
                        .addComponent(crearPdfButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        Pestanas.addTab("Plantillas Predeterminadas", plantillaPrede);

        pathText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTextActionPerformed(evt);
            }
        });

        savedirButton.setText("Buscar Direccion");
        savedirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savedirButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion de creacion de PDF");

        pathText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathText1ActionPerformed(evt);
            }
        });

        excelDirButton.setText("Buscar Direccion");
        excelDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelDirButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Direccion del Excel");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(Pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(pathText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savedirButton))
                    .addComponent(jSeparator2)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(pathText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excelDirButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(savedirButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excelDirButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pestanas))
        );

        ayudaMenu.setText("Ayuda");

        ayudaItem1.setText("Sintaxis");
        ayudaItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaItem1ActionPerformed(evt);
            }
        });
        ayudaMenu.add(ayudaItem1);

        ayudaItem2.setText("Guardado");
        ayudaItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaItem2ActionPerformed(evt);
            }
        });
        ayudaMenu.add(ayudaItem2);

        jMenuBar.add(ayudaMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ayudaItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Todos los tokens ingresados deben estar separados por UN SALTO DE LINEA."
                + "\n Ejemplo:\n nombre\n apellido\n identificacion\n");
    }//GEN-LAST:event_ayudaItem1ActionPerformed

    private void crearPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPdfButtonActionPerformed
        String path = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/Origen.txt";
        String path1 =pathText1.getText();
        String path2 =pathText.getText();
        String planti =plantillaArea.getText();
        ArrayList<String> aux2 = lectorPlantilla(planti);
        ArrayList<String> aux3 = new ArrayList<>();
        ArrayList<String> aux4 = new ArrayList<>();
        String[][] aux = new String[0][0];
        boolean bol=false;
        try {
            aux = Taller1.excelReaderValidateDistance(path, path1);
            for (int i = 0; i < aux2.size(); i++) {
                for (int j = 0; j < aux.length; j++) {
                    int y =computeLevenshteinDistance(aux2.get(i), aux[j][0]);
                    /*if(aux2.get(i).equals("-")){
                        aux2.set(i," ");
                        bol=true;
                    }else if(aux2.get(i).equals("+")){
                        aux2.set(i,"\n");
                        bol=true;
                    }*/
                    if(y<=3){
                        Taller1.Verificador_token(aux2.get(i),path);//se va a pifear
                        System.out.println(y+" "+aux2.get(i)+"_"+aux[j][0]);
                        for (int k = 1; k < aux[j].length; k++) {
                            System.out.println(aux3.add(aux[j][k])+" tok");
                        }
                    }
                }
            }
//C:\Users\User.LENOVO\Documents\NetBeansProjects\Taller1-master1\src\taller1\ExcelEjemplo.xlsx
//C:\Users\User.LENOVO\Documents\Scanned Documents
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        int d = aux[0].length;
        for (int i = 0; i < d; i++){
            for (int j = i; j < aux3.size(); j=j+aux[0].length-1) {
                aux4.add(aux3.get(j));
                System.out.println(j);
            }
            String nombre = aux4.get(0)+"_"+aux4.get(1);
            Taller1.pdf(aux4, path2, nombre);
            aux4.clear();
        }
    }//GEN-LAST:event_crearPdfButtonActionPerformed

    private void pathTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathTextActionPerformed

    private void savedirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savedirButtonActionPerformed
        JFileChooser path = new JFileChooser();
        int option = path.showDialog(this, "Aceptar");
        if(option == JFileChooser.APPROVE_OPTION){
            File f = path.getCurrentDirectory();//getSelectedFile();
            pathText.setText(f.toString());
        }
    }//GEN-LAST:event_savedirButtonActionPerformed

    private void ayudaItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Se debe seleccionar un archivo de la carpeta en la que se desea guardar"
                + "\n o escribir la ruta manualmente.");
    }//GEN-LAST:event_ayudaItem2ActionPerformed

    private void savePlantiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePlantiButtonActionPerformed
        String planti =plantillaArea.getText();
        JFileChooser path = new JFileChooser();
        int option = path.showSaveDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = path.getSelectedFile();
            try {
                escribirTxt(f.toString(), lectorPlantilla(planti));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Plantilla guardada.");
        }
    }//GEN-LAST:event_savePlantiButtonActionPerformed

    private void buscarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButton1ActionPerformed
        JFileChooser path = new JFileChooser();
        int option = path.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = path.getSelectedFile();
            try {
                plantillaArea1.setText(leerTxt(f.toString()));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buscarButton1ActionPerformed

    private void crearPdfButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPdfButton1ActionPerformed
        String path = "/Users/Sunny/Documents/Unal/201901/Lenguajes de Programacion/Taller1/Taller1/src/taller1/Origen.txt";
        String path1 =pathText1.getText();
        String path2 =pathText.getText();
        String planti =plantillaArea1.getText();
        ArrayList<String> aux2 = lectorPlantilla(planti);
        ArrayList<String> aux3 = new ArrayList<>();
        ArrayList<String> aux4 = new ArrayList<>();
        String[][] aux = new String[0][0];
        boolean bol=false;
        try {
            aux = Taller1.excelReaderValidateDistance(path, path1);
            for (int i = 0; i < aux2.size(); i++) {
                for (int j = 0; j < aux.length; j++) {
                    int y =computeLevenshteinDistance(aux2.get(i), aux[j][0]);
                    /*if(aux2.get(i).equals("-")){
                        aux2.set(i," ");
                        bol=true;
                    }else if(aux2.get(i).equals("+")){
                        aux2.set(i,"\n");
                        bol=true;
                    }*/
                    if(y<=3){
                        Taller1.Verificador_token(aux2.get(i),path);//se va a pifear
                        System.out.println(y+" "+aux2.get(i)+"_"+aux[j][0]);
                        for (int k = 1; k < aux[j].length; k++) {
                            System.out.println(aux3.add(aux[j][k])+" tok");
                        }
                    }
                }
            }
//C:\Users\User.LENOVO\Documents\NetBeansProjects\Taller1-master1\src\taller1\ExcelEjemplo.xlsx
//C:\Users\User.LENOVO\Documents\Scanned Documents
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        int d = aux[0].length;
        for (int i = 0; i < d; i++){
            for (int j = i; j < aux3.size(); j=j+aux[0].length-1) {
                aux4.add(aux3.get(j));
                System.out.println(j);
            }
            String nombre = aux4.get(0)+"_"+aux4.get(1);
            Taller1.pdf(aux4, path2, nombre);
            aux4.clear();
        }
    }//GEN-LAST:event_crearPdfButton1ActionPerformed

    private void pathText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathText1ActionPerformed

    private void excelDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelDirButtonActionPerformed
        JFileChooser path = new JFileChooser();
        int option = path.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = path.getSelectedFile();
            pathText1.setText(f.toString());
        }
    }//GEN-LAST:event_excelDirButtonActionPerformed

    private ArrayList<String> lectorPlantilla(String p){
        ArrayList<String> lc1 = new ArrayList<>();
        String[] parts= p.split(" ");
        lc1.addAll(Arrays.asList(parts));
        for (int i = 0; i < lc1.size(); i++) {
            System.out.println(lc1.get(i));
        }
        return lc1;
    }
    
    public static String leerTxt(String arch) throws FileNotFoundException, IOException{
        String aux="";
        String cadena;
        FileReader f = new FileReader(arch);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            aux=aux+cadena+"\n";
            System.out.println(cadena);
        }
        b.close();
        return aux;
    }  
    
    public static void escribirTxt(String arch, ArrayList<String> arr) throws IOException{
        FileWriter fichero = new FileWriter(arch);
        PrintWriter pw = new PrintWriter(fichero);
        for (int i = 0; i < arr.size(); i++){
            pw.println(arr.get(i));
        }
        fichero.close();        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
        

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Pestanas;
    private javax.swing.JMenuItem ayudaItem1;
    private javax.swing.JMenuItem ayudaItem2;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JButton buscarButton1;
    private javax.swing.JButton crearPdfButton;
    private javax.swing.JButton crearPdfButton1;
    private javax.swing.JButton excelDirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField pathText;
    private javax.swing.JTextField pathText1;
    private javax.swing.JTextArea plantillaArea;
    private javax.swing.JTextArea plantillaArea1;
    private javax.swing.JPanel plantillaPerzo;
    private javax.swing.JPanel plantillaPrede;
    private javax.swing.JButton savePlantiButton;
    private javax.swing.JButton savedirButton;
    // End of variables declaration//GEN-END:variables

    private static int minimum(int a, int b, int c) {
        if(a<=b && a<=c)
        {
            return a;
        } 
        if(b<=a && b<=c)
        {
            return b;
        }
        return c;
    }
 
    public static int computeLevenshteinDistance(String str1, String str2) {
        return computeLevenshteinDistance(str1.toCharArray(), str2.toCharArray());
    }
 
    private static int computeLevenshteinDistance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];
 
        for(int i=0;i<=str1.length;i++)
        {
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++)
        {
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++)
        {
            for(int j=1;j<=str2.length;j++)
            { 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
 
    }
}


