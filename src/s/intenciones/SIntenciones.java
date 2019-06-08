/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.intenciones;

import intenciones.view.MantenimientoGenerador;
import intenciones.view.MantenimientoIntenciones;
import intenciones.view.MantenimientoRogacion;
import intenciones.view.MantenimientoSufragio;
import intenciones.view.Principal;
import intenciones.view.login;
import intenciones.view.word;
import javafx.application.Application;
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sebgc
 */
public class SIntenciones extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Principal p=new Principal();
        MantenimientoGenerador d=new MantenimientoGenerador();
        MantenimientoIntenciones d1=new MantenimientoIntenciones();
        MantenimientoRogacion d2=new MantenimientoRogacion();
        MantenimientoSufragio d3=new MantenimientoSufragio();
        word d4=new word();
       
        login v = new login();
        p.setVisible(true);    
    
    }
    
}
