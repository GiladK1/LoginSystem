package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class regController {

    @FXML
    TextField userTxt;
    @FXML
     TextField passTxt;
    @FXML
    Text feedBack;

    public void registerUser()
    {
        try {
            Connection conn = dataBase.getConnection();
            PreparedStatement stm =  conn.prepareStatement("INSERT INTO table1 VALUES ('"+userTxt.getText()+"','"+passTxt.getText()+"')");
            stm.executeUpdate();
            feedBack.setText("DONE, Thank you !");
            conn.close();
            stm.close();


        }catch (Exception e){e.printStackTrace();}


    }
}
