/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoneditor;

import com.sun.webkit.plugin.Plugin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.MouseInfo;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author nithrilh
 */
public class gridDisplay extends javax.swing.JPanel {
    BufferedImage [][]tiles = new BufferedImage[4][7];
    BufferedImage [][]creatures = new BufferedImage[3][2];
    Grille Grid = new Grille(20,20);
    int mouseLocationX,mouseLocationY =0;
    String outil="vide";
    
    
    public gridDisplay() {
        
        File fichier = new File("tilesheet.jpg");
           BufferedImage image;
           try {
               image = ImageIO.read(fichier);
               for (int i=0;i<4;i++){
                             for (int j=0;j<7;j++)
                             {
                            tiles[i][j]=image.getSubimage(32*i, 32*j, 32, 32);
                            }
               }
           }
               catch (IOException e) { }
        
        File fichier2 = new File("bat.png");
            BufferedImage image2;
            try {
               image2 = ImageIO.read(fichier2);
               for (int i=0;i<3;i++){
                             for (int j=0;j<2;j++)
                             {
                            creatures[i][j]=image2.getSubimage(32*i, 32*j, 32, 32);
                            }
               }
           }
                catch (IOException e) { }
            
        initComponents();
        repaint();
    }
    
    public void setOutil(String outil){
        this.outil = outil;
    }
    
    public void gomme(){
        
    }
    
    public void paintComponent(Graphics g){
        
        System.out.println((int)(mouseLocationX/32)+" "+(int)(mouseLocationY/32));
        for(int i=0;i<Grid.getSizeX();i++){
            for(int j=0;j<Grid.getSizeY();j++){
                if(Grid.getTile(i, j)=="vide"){
                g.drawImage(tiles[0][6], i*32, j*32, this);
                }
                if(Grid.getTile(i, j)=="mur"){
                g.drawImage(tiles[2][2], i*32, j*32, this);
                }
                if(Grid.getTile(i, j)=="sol"){
                g.drawImage(tiles[0][0], i*32, j*32, this);
                }
                if(Grid.getTile(i, j)=="porte"){
                g.drawImage(tiles[2][4], i*32, j*32, this);
                }
                //System.out.println(outil);
            }
            //System.out.println("");
        }
        for(int i=0;i<Grid.getSizeX();i++){
            for(int j=0;j<Grid.getSizeY();j++){
                if(Grid.getObjet(i, j)=="chauve-souris"){
                g.drawImage(creatures[0][1], i*32, j*32, this);
                }
                if(Grid.getObjet(i, j)=="slime"){
                g.drawImage(creatures[1][1], i*32, j*32, this);
                }
                if(Grid.getObjet(i, j)=="scorpion"){
                g.drawImage(creatures[2][1], i*32, j*32, this);
                }
                //System.out.println(outil);
            }
            //System.out.println("");
        }
        
        
        
    }
    
    public void nouveau(int X, int Y){
        Grid = new Grille(X,Y);
        repaint();
    }
    
    public void sauvegarder() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileOutputStream ostream = new FileOutputStream("sav1.ser");
        ObjectOutputStream oos = new ObjectOutputStream(ostream);
        oos.writeObject(Grid);
        oos.flush();
        ostream.close();
        repaint();
        
    }
    
    public void charger() throws FileNotFoundException, IOException, ClassNotFoundException{
        File fichier = new File("sav1.ser");
        FileInputStream istream = new FileInputStream(fichier);
        ObjectInputStream ois = new ObjectInputStream(istream);
        Grid = (Grille) ois.readObject();
        ois.close();
        istream.close();
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //sert a rien
    }//GEN-LAST:event_formMouseClicked
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        mouseLocationX = (int) evt.getX();
        mouseLocationY = (int) evt.getY();
        if(outil=="sol"||outil=="mur"||outil=="porte"||outil=="vide"){
        Grid.setTile((int)(mouseLocationX/32), (int)(mouseLocationY/32), outil);
        }else if(outil=="gomme"){
        if(Grid.getObjet((int)(mouseLocationX/32), (int)(mouseLocationY/32))=="vide"){
            Grid.setTile((int)(mouseLocationX/32), (int)(mouseLocationY/32), "vide");
        }else{
            Grid.setObjet((int)(mouseLocationX/32), (int)(mouseLocationY/32), "vide");
        }
        }else{
        Grid.setObjet((int)(mouseLocationX/32), (int)(mouseLocationY/32), outil);
        }
        repaint();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
