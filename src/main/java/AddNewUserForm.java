import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddNewUserForm extends Application implements Initializable {

    public JFXTextField logintxtField;
    public Button loginSendBtn;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/addnewuser_form.fxml"))));
        stage.show();

        new Thread(()->{
            Server server = new Server();
            try {
                server.Server();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loadUserNames();
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String userName = logintxtField.getText();


        //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/clientsController_form.fxml"))));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/clientsController_form.fxml"));
        AnchorPane anchorPane = loader.load();
        ClientsController clientsController = loader.getController();
        clientsController.setLabel(userName);
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle(userName+" Form");
        logintxtField.setText("");
    }
}
