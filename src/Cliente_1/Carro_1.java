/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_1;

import Cliente_2.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * Personaje principal
 */
public class Carro_1 extends JPanel implements ActionListener, KeyListener{
    private int x;
    private int y;

    public Carro_1(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Carro_1(){
       this.x=20;
       this.y=20;
    }
    public void dibujar(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(12+x, 75+y, 20, 20);
        g.setColor(Color.black);
        g.fillOval(19+x, 81+y, 7, 7);
        g.setColor(Color.ORANGE);
        g.fillOval(50+x,75+y, 20, 20);
        g.setColor(Color.black);
        g.fillOval(57+x, 81+y, 7, 7);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(10+x, 60+y, 60, 20);
        Polygon  poligono = new Polygon();
        poligono.addPoint(10+x,60+y);
        poligono.addPoint(30+x,40+y);
        poligono.addPoint(50+x,40+y);
        poligono.addPoint(70+x,60+y);
        g.drawPolygon(poligono);
        g.setColor(Color.pink);
        g.fillPolygon(poligono);
        g.setColor(Color.BLACK);
        g.drawRect(10+x, 40+y, 60, 60);
   }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN: y += 10; break;
            case KeyEvent.VK_UP: y -= 10; break;
            case KeyEvent.VK_LEFT: x -= 10; break;
            case KeyEvent.VK_RIGHT: x += 10; break;
              
          }
    }
    
    public void mover(){
       this.x+=1;
       //this.y+=1;
    }
    
     public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
