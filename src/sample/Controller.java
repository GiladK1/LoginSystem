package sample;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static sample.dataBase.getConnection;


public class Controller  {

    @FXML
    private TextField name ;
    @FXML
    private TextField pass;
    @FXML
    private Button butt,regButt;
    @FXML
     Text resTxt;





    public void checkUserFromDb()  {
        String info = pass.getText();
    try {
        Connection conn = getConnection();
        PreparedStatement stm = conn.prepareStatement("SELECT name FROM table1 WHERE id ="+info);
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            System.out.println(res.getString("name"));
            resTxt.setText("Welcome");
        }

        conn.close();
        res.close();
        stm.close();
    }catch (Exception e){e.printStackTrace();}

    }

    public void openRgister()
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Register Window");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){e.printStackTrace();}
    }

}
