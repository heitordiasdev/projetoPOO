package controle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.Main;
import models.Conta;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Paths;


import java.io.IOException;
import java.nio.file.Paths;

public class ControleHome {
    @FXML
    private TextField usuario;

    @FXML
    private TextField senha;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView insta;


    public void initialize(){
        imageView.setImage(new Image(Paths.get("src/images/logotipo.png").toUri().toString()));
        insta.setImage(new Image(Paths.get("src/images/insta.png").toUri().toString()));

//        imageView1.setImage(new Image(Paths.get("src/images/degrade.jpg").toUri().toString()));
    }


    public void abrirCadastro() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/cadastro.fxml"));

        Main.stage.setScene(new Scene(parent));

    }

    public void abrirProdutos() throws IOException {

        if (Main.cadastro.isEmpty() && (usuario.getText().isBlank())){

            JOptionPane.showMessageDialog(null,"Usuário e/ou Senha estão incorretos!");
            usuario.setText("");
            senha.setText("");
        }
        for (Conta conta : Main.cadastro) {


            if (conta.getUser().equals(usuario.getText()) && conta.getPassword().equals(senha.getText())) {
                Parent parent = FXMLLoader.load(Main.class.getResource("/telas/produtos.fxml"));

                Main.stage.setScene(new Scene(parent));


            } else {
                JOptionPane.showMessageDialog(null,"Usuário e/ou Senha estão incorretos!");
                usuario.setText("");
                senha.setText("");

            }

        }
    }
}
