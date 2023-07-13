import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.Socket;

public class ClientsController extends Thread{
    public JFXTextArea clientTxtArea;
    public JFXTextField ClienttxtField;
    public Button sendButton;
    public Label userNamelbl;

    PrintWriter writer;

    BufferedReader reader;
    Socket socket;

    private FileChooser fileChooser;
    private File filePath;

    public void initialize(){
//        emojiLoad();
//        emojiPane.setVisible(false);
//        lblClientName.setText(AddNewUserFormController.username);
        try {
            socket = new Socket("localhost",9000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
