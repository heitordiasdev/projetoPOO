package controle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Conta;
import org.w3c.dom.Text;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ControleCadastro {
    @FXML
    public ImageView voltar;

    @FXML
    public TextField passwordTent;

    @FXML
    public ImageView logo;

    @FXML
    public TextField user;

    @FXML
    public TextField password;


    public void initialize(){

        logo.setImage(new Image(Paths.get("src/images/logotipo.png").toUri().toString()));
        voltar.setImage(new Image(Paths.get("src/images/seta.png").toUri().toString()));
    }


    public void cadastro() throws IOException {

        if (passwordTent.getText().equals(password.getText()) && (!passwordTent.getText().isBlank())){
            Conta conta;

            conta = new Conta();
            conta.setUser(user.getText());
            conta.setPassword(password.getText());
            Main.cadastro.add(conta);
            JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!");

            Parent parent = FXMLLoader.load(Main.class.getResource("/telas/home.fxml"));

            Main.stage.setScene(new Scene(parent));
        }

        else{
            JOptionPane.showMessageDialog(null,"As senhas não coincidem ou Está em Branco!");
        }


    }
    public void voltar() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/home.fxml"));

        Main.stage.setScene(new Scene(parent));
    }

}