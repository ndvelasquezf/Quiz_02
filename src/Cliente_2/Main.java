/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_2;

import Servidor.Tablero;
import java.awt.Dimension;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author Usuario9
 */
public class Main {
  
    public static void main(String[] args) throws IOException {
        Socket cliente = 
                new Socket ("localhost",9000);
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500,500));
        frame.add(new Tablero());//adicionando el panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
