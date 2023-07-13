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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddNewUserForm extends Application implements Initializable {
    public JFXTextField lodingTxt;
    public Button logingBtn;

    public JFXTextField txtUsername;
    static String username;
    public AnchorPane root;
    public JFXPasswordField txtPassword;
    public JFXComboBox comUsername;
    public ArrayList<String> arrayList = new ArrayList<>();

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/client_form.fxml"))));
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
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
}
