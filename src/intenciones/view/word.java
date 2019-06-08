/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intenciones.view;

import intenciones.model.Acciongracias;
import intenciones.model.Rogacion;
import intenciones.model.Sufragio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


/**
 *
 * @author sebgc
 */
public class word {
    
    public XWPFDocument document =new XWPFDocument();
       public XWPFDocument document2 =new XWPFDocument();


    
 
    public boolean par(int a){
        if(a==0){return true;}
    if(a%2==0){
            return true;
        }else{
          return false;
        } 
    }
    
    public void crearDoc(List<Acciongracias> list,List<Rogacion>listR,List<Sufragio> listS,String misa,Date d){
    try{
      

    FileOutputStream output=new FileOutputStream(direccionDoc(d,misa));
    
    XWPFParagraph paragraphTitulo=document.createParagraph(); 
    
    XWPFRun runTitulo=paragraphTitulo.createRun();
    
    paragraphTitulo.setAlignment(ParagraphAlignment.CENTER);
    runTitulo.setBold(true);
    runTitulo.setFontSize(20);
    runTitulo.setUnderline(UnderlinePatterns.WORDS);
    int m=d.getMonth()+1;
     int y=1900+d.getYear();
                
    runTitulo.setText("Intenciones del "+"Dia:"+d.getDate()+" Mes:"+m+" Año:"+y+" Misa:"+misa);
    runTitulo.setColor("2d2e30");  
    runTitulo.addBreak();
 
       //Accion de gracias
         XWPFParagraph par1=document.createParagraph();
    
    XWPFRun run1=par1.createRun();
    par1.setAlignment(ParagraphAlignment.LEFT);
      run1.setBold(true);
    run1.setFontSize(20);
    run1.setUnderline(UnderlinePatterns.WORDS);
    run1.setText("Acción de Gracias");
    run1.setColor("2d2e30");
    if(list.size()>0){
       XWPFParagraph paragraph=document.createParagraph();
     
    XWPFRun runpara=paragraph.createRun();
      runpara.setFontSize(18);
          runpara.setColor("2f66f2");
        
     paragraph.setAlignment(ParagraphAlignment.LEFT); 
      String temp=" ";
    for(int i=0;i<list.size();i++){
    
     
    if(" ".equals(temp)){
           temp=list.get(i).getAccion()+" "+list.get(i).getMotivo();
    }
    else{temp=temp+"  /   "+list.get(i).getAccion()+" "+list.get(i).getMotivo();}
   
  
  
    }
        runpara.setText(temp);
    }
    else{
      XWPFParagraph p1=document.createParagraph();
    XWPFRun r1=p1.createRun();
    r1.setText("No hay Registros");
    
    }
    //Rogacion
    
     XWPFParagraph par2=document.createParagraph();
    
    XWPFRun run2=par2.createRun();
    par2.setAlignment(ParagraphAlignment.LEFT);
      run2.setBold(true);
    run2.setFontSize(20);
    run2.setUnderline(UnderlinePatterns.WORDS);
    run2.setText("Rogación");
    run2.setColor("2d2e30");
    
    if(listR.size()>0){
           XWPFParagraph paragraphR=document.createParagraph();
    XWPFRun runparaR=paragraphR.createRun();
      runparaR.setFontSize(18);
          runparaR.setColor("2f66f2");
          
    paragraphR.setAlignment(ParagraphAlignment.LEFT);
    String temp2=" ";
      for(int i=0;i<listR.size();i++){
    
  

  
    if(" ".equals(temp2)){
           temp2=listR.get(i).getIntencion()+" "+listR.get(i).getMotivo();
    }
    else{temp2=temp2+"  /   " +listR.get(i).getIntencion()+" "+listR.get(i).getMotivo();}
 
  
  
    }
        runparaR.setText(temp2);
    }
    else
    {
    XWPFParagraph p2=document.createParagraph();
    XWPFRun r2=p2.createRun();
    r2.setText("No hay Registros");
    }
    
    //Sufragio
     XWPFParagraph par3=document.createParagraph();
    
    XWPFRun run3=par3.createRun();
    par3.setAlignment(ParagraphAlignment.LEFT);
      run3.setBold(true);
    run3.setFontSize(20);
    run3.setUnderline(UnderlinePatterns.WORDS);
    run3.setText("Sufragio");
    run3.setColor("2d2e30");
    if(listS.size()>0){
         XWPFParagraph paragraphS=document.createParagraph();
    XWPFRun runparaS=paragraphS.createRun();
    runparaS.setFontSize(18);
    runparaS.setColor("2f66f2");
   
    paragraphS.setAlignment(ParagraphAlignment.LEFT);
    String temp3=" ";
      for(int i=0;i<listS.size();i++){
     
  

  
    if(" ".equals(temp3)){
           temp3=listS.get(i).getNombre()+" "+listS.get(i).getFecharecuerdo();
    }
    else{temp3=temp3+"  /   " +listS.get(i).getNombre()+" "+listS.get(i).getFecharecuerdo();}
 
  
   
    }
        runparaS.setText(temp3);
    }
    else{ 
    XWPFParagraph p3=document.createParagraph();
    XWPFRun r3=p3.createRun();
    r3.setText("No hay Registros");
    }
    
    
    


    document.write(output);
    output.close();
    
 
    }
  
    catch (Exception e){
    JOptionPane.showMessageDialog(null,"Ocurrio un error a genera el documento");
    }
 
    }
    
    
 
    public void crearDocNube(List<Acciongracias> list,List<Rogacion>listR,List<Sufragio> listS,String misa,Date d){

 
   
    try{
      
   FileOutputStream output=new FileOutputStream(DirecciondocNube(d,misa));
    
    XWPFParagraph paragraphTitulo=document2.createParagraph(); 
    
    XWPFRun runTitulo=paragraphTitulo.createRun();
    
    paragraphTitulo.setAlignment(ParagraphAlignment.CENTER);
    runTitulo.setBold(true);
    runTitulo.setFontSize(20);
    runTitulo.setUnderline(UnderlinePatterns.WORDS);
    int m=d.getMonth()+1;
     int y=1900+d.getYear();
                
    runTitulo.setText("Intenciones del "+"Dia:"+d.getDate()+" Mes:"+m+" Año:"+y+" Misa:"+misa);
    runTitulo.setColor("2d2e30");  
    runTitulo.addBreak();
 
       //Accion de gracias
         XWPFParagraph par1=document2.createParagraph();
    
    XWPFRun run1=par1.createRun();
    par1.setAlignment(ParagraphAlignment.LEFT);
      run1.setBold(true);
    run1.setFontSize(20);
    run1.setUnderline(UnderlinePatterns.WORDS);
    run1.setText("Acción de Gracias");
    run1.setColor("2d2e30");
    if(list.size()>0){
       XWPFParagraph paragraph=document2.createParagraph();
     
    XWPFRun runpara=paragraph.createRun();
      runpara.setFontSize(18);
          runpara.setColor("2f66f2");
        
     paragraph.setAlignment(ParagraphAlignment.LEFT); 
      String temp=" ";
    for(int i=0;i<list.size();i++){
    
     
    if(" ".equals(temp)){
           temp=list.get(i).getAccion()+" "+list.get(i).getMotivo();
    }
    else{temp=temp+"  /   "+list.get(i).getAccion()+" "+list.get(i).getMotivo();}
   
  
  
    }
        runpara.setText(temp);
    }
    else{
      XWPFParagraph p1=document2.createParagraph();
    XWPFRun r1=p1.createRun();
    r1.setText("No hay Registros");
    
    }
    //Rogacion
    
     XWPFParagraph par2=document2.createParagraph();
    
    XWPFRun run2=par2.createRun();
    par2.setAlignment(ParagraphAlignment.LEFT);
      run2.setBold(true);
    run2.setFontSize(20);
    run2.setUnderline(UnderlinePatterns.WORDS);
    run2.setText("Rogación");
    run2.setColor("2d2e30");
    
    if(listR.size()>0){
           XWPFParagraph paragraphR=document2.createParagraph();
    XWPFRun runparaR=paragraphR.createRun();
      runparaR.setFontSize(18);
          runparaR.setColor("2f66f2");
          
    paragraphR.setAlignment(ParagraphAlignment.LEFT);
    String temp2=" ";
      for(int i=0;i<listR.size();i++){
    
  

  
    if(" ".equals(temp2)){
           temp2=listR.get(i).getIntencion()+" "+listR.get(i).getMotivo();
    }
    else{temp2=temp2+"  /   " +listR.get(i).getIntencion()+" "+listR.get(i).getMotivo();}
 
  
  
    }
        runparaR.setText(temp2);
    }
    else
    {
    XWPFParagraph p2=document2.createParagraph();
    XWPFRun r2=p2.createRun();
    r2.setText("No hay Registros");
    }
    
    //Sufragio
     XWPFParagraph par3=document2.createParagraph();
    
    XWPFRun run3=par3.createRun();
    par3.setAlignment(ParagraphAlignment.LEFT);
      run3.setBold(true);
    run3.setFontSize(20);
    run3.setUnderline(UnderlinePatterns.WORDS);
    run3.setText("Sufragio");
    run3.setColor("2d2e30");
    if(listS.size()>0){
         XWPFParagraph paragraphS=document2.createParagraph();
    XWPFRun runparaS=paragraphS.createRun();
    runparaS.setFontSize(18);
    runparaS.setColor("2f66f2");
   
    paragraphS.setAlignment(ParagraphAlignment.LEFT);
    String temp3=" ";
      for(int i=0;i<listS.size();i++){
     
  

  
    if(" ".equals(temp3)){
           temp3=listS.get(i).getNombre()+" "+listS.get(i).getFecharecuerdo();
    }
    else{temp3=temp3+"  /   " +listS.get(i).getNombre()+" "+listS.get(i).getFecharecuerdo();}
 
  
   
    }
        runparaS.setText(temp3);
    }
    else{ 
    XWPFParagraph p3=document2.createParagraph();
    XWPFRun r3=p3.createRun();
    r3.setText("No hay Registros");
    }
    
    
    


    document2.write(output);
    output.close();
    
 
    }
  
    catch (Exception e){
    JOptionPane.showMessageDialog(null,"Ocurrio un error a genera el document2o");
    }
  

    }
    
    public String dia(int x){
        String t="";
        if(x==1){ t="Lunes";}
        if(x==2){t="Martes";}
        if(x==3){t="Miercoles";}
        if(x==4){t="Jueves";}
        if(x==5){t="Viernes";}
        if(x==6){t="Sabado";}
        if(x==0){t="Domingo";}
    return t;
    }
    
       public String mes(int x){
        String t="";
        if(x==1){t="Enero";}
        if(x==2){t="Febrero";}
        if(x==3){t="Marzo";}
        if(x==4){t="Abril";}
        if(x==5){t="Mayo";}
        if(x==5){t="Junio";}
        if(x==6){t="Julio";}
        if(x==8){t="Agosto";}
        if(x==9){t="Septiembre";}
        if(x==10){t="Octubre";}
        if(x==11){t="Noviembre";}
         if(x==12){t="Diciembre";}
        
    return t;
    }
       
       
       public String direccionDoc(Date d,String m){
             String dia="";
           String temp="";
           String mes="";
           
           if (d.getMonth() == 0) {
             mes="Enero";
           }
           if (d.getMonth() == 1) {
             mes="Febreo";
           }
           if (d.getMonth() == 2) {
             mes="Marzo";
           }
           if (d.getMonth() == 3) {
mes="Abril";
           }
           if (d.getMonth() == 4) {
mes="Mayo";
           }
           if (d.getMonth() == 5) {
mes="Junio";
           }
           if (d.getMonth() == 6) {
               mes="Julio";
           }
           if (d.getMonth() == 7) {
               mes="Agosto";

           }
           if (d.getMonth() == 8) {
mes="Setiembre";
           }
           if (d.getMonth() == 9) {
mes="Octubre";
           }
           if (d.getMonth() == 10) {
mes="Noviembre";
           }
           if (d.getMonth() == 11) {
mes="Diciembre";
           }
           
           //dias
           if(d.getDate()==1){
               dia="1";
               
           }
           
           
            if(d.getDate()==2){
               dia="1";
               
           }
            
            
             if(d.getDate()==3){
               dia="3";
               
           }
             
             
             if(d.getDate()==4){
               dia="4";
               
           }
             
             if(d.getDate()==5){
               dia="5";
               
           }
             
             if(d.getDate()==6){
               dia="6";
               
           }
             
             if(d.getDate()==7){
               dia="7";
               
           }
             
             if(d.getDate()==8){
               dia="8";
               
           }
             
             
             
             if(d.getDate()==9){
               dia="9";
               
           }
             
             if(d.getDate()==10){
               dia="10";
               
           }

              if(d.getDate()==11){
               dia="11";
               
           }
           
           
            if(d.getDate()==12){
               dia="12";
               
           }
            
            
             if(d.getDate()==3){
               dia="13";
               
           }
             
             
             if(d.getDate()==14){
               dia="14";
               
           }
             
             if(d.getDate()==15){
               dia="15";
               
           }
             
             if(d.getDate()==16){
               dia="16";
               
           }
             
             if(d.getDate()==17){
               dia="17";
               
           }
             
             if(d.getDate()==18){
               dia="18";
               
           }
             
             
             
             if(d.getDate()==19){
               dia="19";
               
           }
             
             if(d.getDate()==20){
               dia="20";
               
           }
             
             
             
             
             
             
             
              if(d.getDate()==21){
               dia="21";
               
           }
           
           
            if(d.getDate()==22){
               dia="22";
               
           }
            
            
             if(d.getDate()==23){
               dia="23";
               
           }
             
             
             if(d.getDate()==24){
               dia="24";
               
           }
             
             if(d.getDate()==25){
               dia="25";
               
           }
             
             if(d.getDate()==26){
               dia="26";
               
           }
             
             if(d.getDate()==27){
               dia="27";
               
           }
             
             if(d.getDate()==28){
               dia="28";
               
           }
             
             
             
             if(d.getDate()==29){
               dia="29";
               
           }
             
             if(d.getDate()==30){
               dia="30";
               
           }
             
             if(d.getDate()==31){
               dia="31";
               
           }
              
           if (d.getDay()==0) {
               if("6:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Domingo/6am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("10:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Domingo/10am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";}
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Domingo/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if(!"6:am".equals(m)&&!"10:am".equals(m)&&!"6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Domingo/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
           if (d.getDay()==1) {
               if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Lunes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Lunes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Lunes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==2) {
               
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Martes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){ 
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Martes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Martes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
               
           }
           if (d.getDay()==3) {
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Miercoles/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Miercoles/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Miercoles/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==4) {
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Jueves/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Jueves/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Jueves/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==5) {
               
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Viernes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Viernes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Viernes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
           if (d.getDay()==6) {
               
                 if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Sabado/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if( !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Sabado/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
return temp;
       
       
       }
       
       public String DirecciondocNube(Date d,String m){
           String dia = "";
           String temp = "";
           String mes = "";

           if (d.getMonth() == 0) {
               mes = "Enero";
           }
           if (d.getMonth() == 1) {
               mes = "Febreo";
           }
           if (d.getMonth() == 2) {
               mes = "Marzo";
           }
           if (d.getMonth() == 3) {
               mes = "Abril";
           }
           if (d.getMonth() == 4) {
               mes = "Mayo";
           }
           if (d.getMonth() == 5) {
               mes = "Junio";
           }
           if (d.getMonth() == 6) {
               mes = "Julio";
           }
           if (d.getMonth() == 7) {
               mes = "Agosto";

           }
           if (d.getMonth() == 8) {
               mes = "Setiembre";
           }
           if (d.getMonth() == 9) {
               mes = "Octubre";
           }
           if (d.getMonth() == 10) {
               mes = "Noviembre";
           }
           if (d.getMonth() == 11) {
               mes = "Diciembre";
           }

           //dias
           if (d.getDate() == 1) {
               dia = "1";

           }

           if (d.getDate() == 2) {
               dia = "1";

           }

           if (d.getDate() == 3) {
               dia = "3";

           }

           if (d.getDate() == 4) {
               dia = "4";

           }

           if (d.getDate() == 5) {
               dia = "5";

           }

           if (d.getDate() == 6) {
               dia = "6";

           }

           if (d.getDate() == 7) {
               dia = "7";

           }

           if (d.getDate() == 8) {
               dia = "8";

           }

           if (d.getDate() == 9) {
               dia = "9";

           }

           if (d.getDate() == 10) {
               dia = "10";

           }

           if (d.getDate() == 11) {
               dia = "11";

           }

           if (d.getDate() == 12) {
               dia = "12";

           }

           if (d.getDate() == 3) {
               dia = "13";

           }

           if (d.getDate() == 14) {
               dia = "14";

           }

           if (d.getDate() == 15) {
               dia = "15";

           }

           if (d.getDate() == 16) {
               dia = "16";

           }

           if (d.getDate() == 17) {
               dia = "17";

           }

           if (d.getDate() == 18) {
               dia = "18";

           }

           if (d.getDate() == 19) {
               dia = "19";

           }

           if (d.getDate() == 20) {
               dia = "20";

           }

           if (d.getDate() == 21) {
               dia = "21";

           }

           if (d.getDate() == 22) {
               dia = "22";

           }

           if (d.getDate() == 23) {
               dia = "23";

           }

           if (d.getDate() == 24) {
               dia = "24";

           }

           if (d.getDate() == 25) {
               dia = "25";

           }

           if (d.getDate() == 26) {
               dia = "26";

           }

           if (d.getDate() == 27) {
               dia = "27";

           }

           if (d.getDate() == 28) {
               dia = "28";

           }

           if (d.getDate() == 29) {
               dia = "29";

           }

           if (d.getDate() == 30) {
               dia = "30";

           }

           if (d.getDate() == 31) {
               dia = "31";

           }
             
              if (d.getDay()==0) {
               if("6:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Domingo/6am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("10:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Domingo/10am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";}
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Domingo/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if(!"6:am".equals(m)&&!"10:am".equals(m)&&!"6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Domingo/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
           if (d.getDay()==1) {
               if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/Desktop/Documentos-Intenciones/Lunes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Lunes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Lunes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==2) {
               
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Martes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Martes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Martes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
               
           }
           if (d.getDay()==3) {
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Miercoles/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Miercoles/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Miercoles/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==4) {
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Jueves/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Jueves/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Jueves/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               
           }
           if (d.getDay()==5) {
               
                if("8:am".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Viernes/8am/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
               if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Viernes/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if(!"8:am".equals(m)&& !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Viernes/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
           if (d.getDay()==6) {
               
                 if("6:pm".equals(m)){
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Sabado/6pm/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
                   
               }
               
               if( !"6:pm".equals(m)){
               
               temp="C:/Users/Parroquia San Isidro/OneDrive/Documentos-Intenciones/Sabado/otra/IntencionesDia"+dia+"Mes"+mes+"doc.docx";
               }
           }
           return temp;
                   
       }
    
}
