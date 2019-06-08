/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intenciones.controller;

import intenciones.model.Acciongracias;
import intenciones.model.Empleados;
import intenciones.model.Misas;
import intenciones.model.Rogacion;
import intenciones.model.Sufragio;
import intenciones.model.Tipointencion;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sebgc
 */
public class Controller {
  
    //Inserciones a BD.
    public void agregaAccionGracias(Acciongracias ac){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    session.save(ac);
    tx.commit();
    session.close();
     JOptionPane.showMessageDialog(null, "Se agrego correctamente la Accion de gracias");
    
    }
    
    
    
    public void agregaSufragio(Sufragio su){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    session.save(su);
    tx.commit();
    session.close();
   
    }
    
    
    
    public void agregaRogacion(Rogacion ro){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    session.save(ro);
    tx.commit();
    session.close();
         JOptionPane.showMessageDialog(null, "Se agrego correctamente la rogacion");
    
    }
    
    public void agregaTipointencion(Tipointencion ro){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    session.save(ro);
    tx.commit();
    session.close();
    
    }
    
    
     public void agregaMisas(Misas m){
  SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    session.save(m);
    tx.commit();
    session.close();
    
    }
    
    
    
    
    //trae listas de accion, rogacion, sufragio.
    
    
    public List<Empleados> listEmpleados(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Empleados");
    List<Empleados> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
     
    public List<Acciongracias> listAccionGracias(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Acciongracias");
    List<Acciongracias> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
      
    public List<Rogacion> listRogacion(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Rogacion");
    List<Rogacion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
      
      
    public List<Sufragio> listSufragio(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Sufragio");
    List<Sufragio> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
    
    
      
    public List<Tipointencion> listtipoin(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Tipointencion");
    List<Tipointencion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
   
    }
    
         
    public List<Misas> listMisas(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Misas");
    List<Misas> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
   
    }
    
    
    
    
    //Listas con especificacion de fecha y misa
    
    
     public List<Acciongracias> listAccionFechaesp(String misa2,Date date){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Acciongracias d where d.misa=:misa2 and d.fecha=:date");
    q.setParameter("misa2", misa2);
     q.setParameter("date", date);
    List<Acciongracias> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
     
     
     
     
     
     
     
     
     
    public List<Rogacion> listRogacionesp(String misa2,Date date){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Rogacion d where d.misa=:misa2 and d.fecha=:date");
    q.setParameter("misa2", misa2);
     q.setParameter("date", date);
    List<Rogacion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
    
       
    public List<Sufragio> listSufragioesp(String misa2,Date date){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Sufragio d where d.misa=:misa2 and d.fecha=:date");
    q.setParameter("misa2", misa2);
     q.setParameter("date", date);
    List<Sufragio> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
    //Busquedas especificas
         
    public List<Acciongracias> listBusquedaAccionConFecha( Date da){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Acciongracias d where d.fecha=:da");
    q.setParameter("da", da);
    List<Acciongracias> lista = q.list();
    tx.commit();
    session.close();
    
    return lista; 
    
    }
     
     public List<Acciongracias> listBusquedaAccionSinFecha(String temp){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Acciongracias d where d.accion=:temp");
    q.setParameter("temp", temp);
    List<Acciongracias> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
     
     public List<Acciongracias> listBusquedaAccionCompleta(String temp, Date da){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Acciongracias d where d.accion=:temp and d.fecha=:da");
    q.setParameter("temp", temp);
    q.setParameter("da", da);
    List<Acciongracias> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
     
     
     
      public List<Rogacion> listBusquedaRogacionSinFecha(String temp){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Rogacion d where d.intencion=:temp");
    q.setParameter("temp", temp);
    List<Rogacion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
      
      
         
     
      public List<Rogacion> listBusquedaRogacionConFecha(Date d){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Rogacion d where d.intencion=:temp");

     q.setParameter("d", d);
    List<Rogacion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
      
          
      public List<Rogacion> listBusquedaRogacionCompleta(String temp,Date da){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Rogacion d where d.intencion=:temp and d.fecha=:da");
    q.setParameter("temp", temp);
     q.setParameter("da", da);
    List<Rogacion> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
      
  
    
      
      
            public List<Sufragio> listBusquedaSufragioConFecha(Date da){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Sufragio d where d.fecha=:da");
     q.setParameter("da", da);
    List<Sufragio> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
            
                  public List<Sufragio> listBusquedaSufragioSinFecha(String temp){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Sufragio d where d.nombre=:temp");
    q.setParameter("temp", temp);
    
    List<Sufragio> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
                    
      
            public List<Sufragio> listBusquedaSufragioCompleto(String temp,Date da){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
    Query q=session.createQuery("from Sufragio d where d.nombre=:temp and d.fecha=da");
    q.setParameter("temp", temp);
     q.setParameter("da", da);
    List<Sufragio> lista = q.list();
    tx.commit();
    session.close();
    
    return lista;
    
    }
    
    //
    
    
    
    //updates 
    //sufragio
    public void actulizacionSufragioSinfecha(int id,String nom,String fecr,String misa){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Sufragio objeto = (Sufragio) session.get(Sufragio.class, id);

        objeto.setNombre(nom);
        objeto.setFecharecuerdo(fecr);
        objeto.setMisa(misa);

        session.update(objeto);

        tx.commit();
        session.close();

       
    
    }
    
    
    
    public void actulizacionSufragioConfecha(int id,String nom,String fecr,String misa,Date fe){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Sufragio objeto = (Sufragio) session.get(Sufragio.class, id);

        objeto.setNombre(nom);
        objeto.setFecharecuerdo(fecr);
        objeto.setMisa(misa);
        objeto.setFecha(fe);

        session.update(objeto);

        tx.commit();
        session.close();

     
    
    }
    
    //Accion de gracias
    
    
     public void actulizacionAccionSinfecha(int id,String accion ,String mot,String misa){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Acciongracias objeto = (Acciongracias) session.get(Acciongracias.class, id);

        objeto.setAccion(accion);
        objeto.setMotivo(mot);
        objeto.setMisa(misa);

        session.update(objeto);

        tx.commit();
        session.close();

    
    }
     
     
       public void actulizacionAccionconfecha(int id,String accion ,String mot,Date f,String misa){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Acciongracias objeto = (Acciongracias) session.get(Acciongracias.class, id);

        objeto.setAccion(accion);
        objeto.setMotivo(mot);
        objeto.setMisa(misa);
        objeto.setFecha(f);
        session.update(objeto);

        tx.commit();
        session.close();

    
    }
       
       //Rogacion
       
          public void actulizacionRogacionSinfecha(int id, String intencion, String mot, String misa) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Rogacion objeto = (Rogacion) session.get(Rogacion.class, id);

        objeto.setIntencion(intencion);
        objeto.setMotivo(mot);
        objeto.setMisa(misa);

        session.update(objeto);

        tx.commit();
        session.close();

    }
          
          
             
          public void actulizacionRogacionConfecha(int id, String intencion, String mot,Date d ,String misa) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Rogacion objeto = (Rogacion) session.get(Rogacion.class, id);

        objeto.setIntencion(intencion);
        objeto.setMotivo(mot);
        objeto.setMisa(misa);
        objeto.setFecha(d);

        session.update(objeto);

        tx.commit();
        session.close();

    }
 
          
          
          
       //Delete 
          
          
          
          //Rogacion
             
          public void DeletenRogacion(int id) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Rogacion objeto = (Rogacion) session.get(Rogacion.class, id);

        session.delete(objeto);

        tx.commit();
        session.close();

    }
    
          
          //Accion  
    
     public void DeleteAccionc(int id){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Acciongracias objeto = (Acciongracias) session.get(Acciongracias.class, id);

       
        session.delete(objeto);

        tx.commit();
        session.close();

    
    }
     
     //Sufragio
     
      
     public void DeleteSufragio(int id){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Sufragio objeto = ( Sufragio ) session.get(Sufragio .class, id);

       
        session.delete(objeto);

        tx.commit();
        session.close();

    
    }
     
     
     
     //Cantidad 
      public int CantidadRogaciones(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
   int a=((Long)session.createQuery("select count(*) from Rogacion").uniqueResult()).intValue(); 
    tx.commit();
    session.close();
    
    return a;
    
    }
      
      
      public int CantidadAcciones(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction(); 
   int a=((Long)session.createQuery("select count(*) from Acciongracias").uniqueResult()).intValue(); 
    tx.commit();
    session.close();
    
    return a;
    
    }
      
        public int CantidadSufragio(){
    SessionFactory sesion= NewHibernateUtil.getSessionFactory();
    Session session;
    session=sesion.openSession();
    Transaction tx=session.beginTransaction();
   int a=((Long)session.createQuery("select count(*) from Sufragio").uniqueResult()).intValue(); 
    tx.commit();
    session.close();
    
    return a;
    
    }
     
     
     
    
    
    
    
}
