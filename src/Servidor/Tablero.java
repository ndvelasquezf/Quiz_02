/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente_1.Carro_1;
import Cliente_2.Carro_2;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario9
 */
public class Tablero  extends JPanel  implements ActionListener, KeyListener, Runnable {

    private Timer timer; 
    private ArrayList<Circulo> circulo;
    private Carro_1 personaje1;
    private Carro_2 personaje2;
    private int puntaje_1 = 0;
    private int puntaje_2 = 0;
    
    
    
    
    
    
    public Tablero(){
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personaje1 = new Carro_1(500,500);
      this.personaje2 = new Carro_2(600,600);
      
      this.circulo = new ArrayList<Circulo>();
      this.circulo.add(new Circulo(20,20));
      this.circulo.add(new Circulo(100,80));
      this.circulo.add(new Circulo(80,120));
      this.circulo.add(new Circulo(50,150));
      this.circulo.add(new Circulo(300,89));
      this.circulo.add(new Circulo(14,300));
      this.circulo.add(new Circulo(300,120));
      this.circulo.add(new Circulo(23,450));
      this.circulo.add(new Circulo(200,189));
      this.circulo.add(new Circulo(140,500));
      this.timer = new Timer(20, this);
      this.timer.start();
    }
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         for(Circulo c: this.circulo)
            c.dibujar(g);
         
         this.personaje1.dibujar(g);
         this.personaje2.dibujar(g);
         g.drawString("Puntaje " + puntaje_1, 40, 40);
         g.drawString("Puntaje " + puntaje_2, 40, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validarColisiones();
        for(Circulo c: this.circulo)
            c.mover();
            repaint();
        
    }
     
    
    public void validarColisiones(){
        Rectangle recPersonaje1= this.personaje1.obtenerRectangulo();
        Rectangle recPersonaje2= this.personaje2.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle RecCir = c.obtenerRectangulo();
           if(recPersonaje1.intersects(RecCir)){
               copia.remove(c);
               this.puntaje_1++;
           }
           if(recPersonaje2.intersects(RecCir)){
               copia.remove(c);
               this.puntaje_2++;
           }
           this.circulo=copia;   
           
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
       this.personaje1.keyPressed(e);
       this.personaje2.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
