/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeoneditor;

import java.io.Serializable;

/**
 *
 * @author nithrilh
 */
public class Grille implements Serializable{
    private static final long serialVersionUID = 1350092881346723535L;
    private int tailleX,tailleY;
    private String GrilleDonjon[][];
    private String GrilleObjets[][];
    
    public Grille(int tailleX,int tailleY){
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        GrilleDonjon = new String[tailleX][tailleY];
        GrilleObjets = new String[tailleX][tailleY];
        for(int i=0;i<tailleX;i++){
            for(int j=0;j<tailleY;j++){
                GrilleDonjon[i][j]="vide";
                GrilleObjets[i][j]="vide";
            }
        }
    }
    
    public int getSizeX(){
        return tailleX;
    }
    
    public int getSizeY(){
        return tailleY;
    }
    
    public void setTile(int X,int Y, String type){
        GrilleDonjon[X][Y]=type;
    }
    
    public String getTile(int X,int Y){
        return GrilleDonjon[X][Y];
    }
    
    public void setObjet(int X,int Y, String type){
        if(GrilleDonjon[X][Y]=="sol"){
        GrilleObjets[X][Y]=type;
        }
        System.out.println(GrilleDonjon[X][Y]);
    }
    
    public String getObjet(int X,int Y){
        return GrilleObjets[X][Y];
    }
    
    public void reset(){
        for(int i=0;i<tailleX;i++){
            for(int j=0;j<tailleY;j++){
                GrilleDonjon[i][j]="vide";
                GrilleObjets[i][j]="vide";
            }
        }
    }
}
