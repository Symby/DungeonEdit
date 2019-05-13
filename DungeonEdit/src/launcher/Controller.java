/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import dungeoneditor.*;


/**
 *
 * @author dylan
 */
public class Controller{
  
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      IHM ihm = new IHM();
      ihm.setVisible(true);}
}
