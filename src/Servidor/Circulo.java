/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Usuario9
 */
public class Circulo {
    private int x;
    private int y;

    public Circulo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    private int x_x=this.x;
    private int y_y=this.y;
    
    public Circulo(){
       this.x=20;
       this.y=20;
    }
    public void dibujar(Graphics g){
       g.fillOval(x, y, 20, 20);
       g.setColor(Color.red);
       g.drawRect(x, y, 20, 20);
   }
    
    public void mover(){
        if(x<1000){
           this.x+=1; 
        }else{
           x=x_x;
        }
        
       
       
    }
    
    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 20, 20);
    }
    
}
