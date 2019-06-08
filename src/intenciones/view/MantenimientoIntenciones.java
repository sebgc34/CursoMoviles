/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intenciones.view;

import com.csvreader.CsvWriter;
import intenciones.controller.Controller;
import intenciones.model.Acciongracias;
import intenciones.model.Empleados;
import intenciones.model.Misas;
import intenciones.model.Sufragio;
import intenciones.model.Tipointencion;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebgc
 */
public class MantenimientoIntenciones extends javax.swing.JFrame {

    DefaultListModel dlm;
    Controller cont;
    DefaultTableModel dtm;
    Object[] o = new Object[5];
    int filaSeleccionada = -1;
    
    public MantenimientoIntenciones() {
        initComponents();
        cont=new Controller();
         dtm = (DefaultTableModel) jTable1.getModel();
        cargarDatos();
        this.setExtendedState(MAXIMIZED_BOTH);
        llenarCombo();
         llenarCombo2();
        
    }
    
    
    
    public void limpiar(){
    int x=dtm.getRowCount()-1;

    for(int i=0;i<=x;i++){

        dtm.removeRow(0);
    }
    cargarDatos();
    }
    
      public void limpiarTodo(){
    int x=dtm.getRowCount()-1;

    for(int i=0;i<=x;i++){

        dtm.removeRow(0);
    }
 
    }
    
    
    public void cargarDatos(){
     List<Acciongracias> listemp = cont.listAccionGracias();
     for(Acciongracias str: listemp){
        o[0] = str.getAccion();
        o[1] = str.getMotivo();
        o[2] = str.getFecha();
        o[3]=str.getMisa();
        o[4]=String.valueOf(str.getId());
        dtm.addRow(o);
      
       
     
     }
    }
    
       public void cargarDatosConFecha(){
     List<Acciongracias> listemp = cont.listBusquedaAccionConFecha(fechabusq.getDate());
  

      
     if(listemp.isEmpty()){
    JOptionPane.showMessageDialog(null, "No hay registro con esas caracteriticas");
     }
     else{
         limpiarTodo();
                 
        for(Acciongracias str: listemp){
        o[0] = str.getAccion();
        o[1] = str.getMotivo();
        o[2] = str.getFecha();
        o[3]=str.getMisa();
        o[4]=String.valueOf(str.getId());
        dtm.addRow(o);
      
       
     
     }}
   
     
    }
    
       
          public void cargarDatosSinFecha(){
            List<Acciongracias> listemp = cont.listBusquedaAccionSinFecha(busq.getSelectedItem().toString());

      
     if(listemp.isEmpty()){
    JOptionPane.showMessageDialog(null, "No hay registro con esas caracteriticas");
     }
     else{
         limpiarTodo();
                 
        for(Acciongracias str: listemp){
        o[0] = str.getAccion();
        o[1] = str.getMotivo();
        o[2] = str.getFecha();
        o[3]=str.getMisa();
        o[4]=String.valueOf(str.getId());
        dtm.addRow(o);
      
       
     
     }}
   
     
    }
          
          public void Resp(){
    String outputFile = "C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Respaldos/Acciongracias/Accion_Respaldos.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists){
            File ficheroUsuarios = new File(outputFile);
            ficheroUsuarios.delete();
        }        
            
        try {
         
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Accion");
            csvOutput.write("Motivo");
            csvOutput.write("fecha");
              csvOutput.write("Misa");
           
           
            csvOutput.endRecord();
        List<Acciongracias> listemp = cont.listAccionGracias();
     for(Acciongracias str: listemp){
                csvOutput.write(str.getAccion());
                csvOutput.write(str.getMotivo());
                csvOutput.write(String.valueOf(str.getFecha()));
                csvOutput.write(str.getMisa());
                
               
                csvOutput.endRecord();                   
     }
             
            csvOutput.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
    
    
          
             public void cargarDatosBusquedaCompleta(){
     List<Acciongracias> listemp = cont.listBusquedaAccionCompleta(busq.getSelectedItem().toString(),fechabusq.getDate());

      
     if(listemp.isEmpty()){
    JOptionPane.showMessageDialog(null, "No hay registro con esas caracteriticas");
     }
     else{
         limpiarTodo();
                 
        for(Acciongracias str: listemp){
        o[0] = str.getAccion();
        o[1] = str.getMotivo();
        o[2] = str.getFecha();
        o[3]=str.getMisa();
        o[4]=String.valueOf(str.getId());
        dtm.addRow(o);
      
       
     
     }}
   
     
    }
    
    
    
public void mostrar(){
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"Nombre", "Cont"});
    List<Empleados> listemp = cont.listEmpleados();

    try {
        for (Empleados str : listemp) {
            modelo.addRow(new Object[]{str.getNombre(), str.getContrasena()});
        }
        jTable1.setModel(modelo);
    } catch (Exception e) {
        System.out.println(e);
    }
}
public void llenarCombo(){
    
    List<Tipointencion> listtipo=cont.listtipoin();


  try {
        for (Tipointencion str : listtipo) {
         jComboBox1.addItem(str.getDetalle());
         busq.addItem(str.getDetalle());
        }
        
    } catch (Exception e) {
        System.out.println(e);
    }
}


public void llenarCombo2(){
    
    List<Misas> listtipo=cont.listMisas();


  try {
        for (Misas str : listtipo) {
         jComboBox2.addItem(str.getMisa());
        }
        
    } catch (Exception e) {
        System.out.println(e);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        acc = new javax.swing.JTextField();
        motivo = new javax.swing.JTextField();
        fechaa = new com.toedter.calendar.JDateChooser();
        misa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fechabusq = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        busq = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDateChooser1.setToolTipText("");
        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Acción de Gracias:");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Motivo:");

        jLabel6.setText("*Acción de Gracias:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha:");

        jLabel3.setText("Hora:");

        jLabel4.setText("*Hora(Nueva):");

        jLabel12.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel12.setText("Formulario de acción de gracias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setText("Traer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Acción", "Motivo", "Fecha", "Misa", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel7.setText("Mantenimiento Acción de Gracias");
        jLabel7.setToolTipText("");

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Acción de gracias:");

        jLabel9.setText("Motivo:");

        jLabel10.setText("Fecha:");

        jLabel11.setText("Misa:");

        jLabel13.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel13.setText("Acción:");

        fechabusq.setDateFormatString("yyyy-MM-dd");

        jLabel14.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel14.setText("Fecha:");

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fechaa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(motivo, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                            .addComponent(acc))
                                        .addGap(216, 216, 216)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(misa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busq, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechabusq, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(busq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechabusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4)
                                    .addComponent(jLabel9)))
                            .addComponent(motivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jLabel10)))
                    .addComponent(fechaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(misa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator5)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator3)))
            .addGroup(layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator3))
                .addGap(14, 14, 14)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public boolean validarEspacios(){
    boolean bandera=false;
   
  // if("".equals(jTextField1.getText())){
    //   jTextField1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

     
       
  // bandera=true;
   //}
              if(jDateChooser1.getDate()==null){
              
                  jDateChooser1.setBackground(Color.RED); 
              
                   bandera=true;
              }
      

   
   return bandera;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String TEMP="";
String TEMP2="";
        if(!validarEspacios()){
        try{
      Date fecha=jDateChooser1.getDate();


if(   "".equals(jTextField3.getText())){
    TEMP=jComboBox2.getSelectedItem().toString();
}
else{
    TEMP=jTextField3.getText();
    Misas m=new Misas(TEMP);
    cont.agregaMisas(m);
  
}

if(   "".equals(jTextField2.getText())){
    TEMP2=jComboBox1.getSelectedItem().toString();
}
else{
    TEMP2=jTextField2.getText();
      Tipointencion t=new Tipointencion(TEMP2);
    cont.agregaTipointencion(t);
}
     Acciongracias accion=new Acciongracias(TEMP2,jTextField1.getText(),fecha,TEMP);
     
      jTextField1.setText("");
     jTextField2.setText("");
      jTextField3.setText("");
  jComboBox2.setSelectedIndex(0);
 jComboBox1.setSelectedIndex(0);
     cont.agregaAccionGracias(accion);
      jTextField1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
         jDateChooser1.setBackground(Color.WHITE); 
  limpiar();
  Resp();
   
     
            
     
 
 }
 catch(Exception e){
 }
}
else{
  
       JOptionPane.showMessageDialog(null, "Debe llenar los espacios que son obligatorios");

}
        llenarCombo();
         llenarCombo2();
        
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
           
            acc.setText(jTable1.getValueAt(filaSeleccionada, 0).toString());
            motivo.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
           misa.setText(jTable1.getValueAt(filaSeleccionada, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado una fila");
        }
        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Principal v = new Principal();
                    v.setVisible(true);
                    super.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      filaSeleccionada = jTable1.getSelectedRow();
         if(filaSeleccionada!=-1){
  if(fechaa.getDate()==null){
  
      
 
   cont.actulizacionAccionSinfecha(Integer.valueOf(jTable1.getValueAt(filaSeleccionada, 4).toString()),acc.getText(),motivo.getText(),misa.getText());
   JOptionPane.showMessageDialog(null,  "Se actualizo correctamente");
   acc.setText("");
     motivo.setText("");
         misa.setText("");
       limpiar();
   
  }
  
  else{
       cont.actulizacionAccionconfecha(Integer.valueOf(jTable1.getValueAt(filaSeleccionada, 4).toString()),acc.getText(),motivo.getText(),fechaa.getDate(),misa.getText());
    JOptionPane.showMessageDialog(null,  "Se actualizo correctamente");
     acc.setText("");
     motivo.setText("");
         misa.setText("");
       limpiar();
  }
         }
         else{
            JOptionPane.showMessageDialog(null,  "No se han traido datos");
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      filaSeleccionada = jTable1.getSelectedRow();
         if(filaSeleccionada!=-1){
        cont.DeleteAccionc(Integer.valueOf(jTable1.getValueAt(filaSeleccionada, 4).toString()));
        limpiar();
         JOptionPane.showMessageDialog(null,  "Se elimino correctamente ");
         }
         else{
         
          JOptionPane.showMessageDialog(null,  "No has seleccionado una fila");
         
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      limpiar();
        if("".equals(busq.getSelectedItem().toString())&&fechabusq.getDate()==null){
      
          JOptionPane.showMessageDialog(null,  "No hay datos para filtrar");
         
      }
      else{
            
            if(!"".equals(busq.getSelectedItem().toString())&&fechabusq.getDate()!=null){
            
         cargarDatosBusquedaCompleta();
            }
            else{
      if(!"".equals(busq.getSelectedItem().toString())&&fechabusq.getDate()==null){
         
         cargarDatosSinFecha();
          
      }
      else{
       cargarDatosConFecha();
      }
            }
      }        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoIntenciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoIntenciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoIntenciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoIntenciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoIntenciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc;
    private javax.swing.JComboBox<String> busq;
    private com.toedter.calendar.JDateChooser fechaa;
    private com.toedter.calendar.JDateChooser fechabusq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField misa;
    private javax.swing.JTextField motivo;
    // End of variables declaration//GEN-END:variables
}
