package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Conta;
import models.Product;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    public static Stage stage;
    public static void main(String[] args) { launch(args); }

    public static List<Conta> cadastro = new ArrayList<>();
    //Lista de cadastros que está sendo adicionada aqui do controleCadastro

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Parent home = FXMLLoader.load(Main.class.getResource("/telas/home.fxml"));
        stage.setTitle("Dyas Store");
        stage.setScene(new Scene(home));
        stage.show();
        Image icon = (new Image(Paths.get("src/images/iconLogo.png").toUri().toString()));
        stage.getIcons().add(icon);

    }
}
