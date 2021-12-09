package controle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.Product;

import javax.swing.*;
import java.io.IOException;
import java.nio.DoubleBuffer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ControleProduct {
    @FXML
    private VBox vbox;

    @FXML
    private ListView listview;

    @FXML
    private ListView listview1;

    @FXML
    private ListView busca;

    @FXML
    private TextField buscar1;

    @FXML
    private ListView<String> listview2;

    @FXML
    private ListView<Integer> listPreco;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private ImageView carrinho;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView preco;

    @FXML
    private ImageView camisa;

    @FXML
    private ImageView perfume;

    @FXML
    private ImageView logout;

    @FXML
    private TextField text;

    @FXML
    private TextField buscar;

    @FXML
    private Button botao;

    @FXML
    private Button botao1;

    @FXML
    private Button botaoTotal;

    @FXML
    void addName(MouseEvent event) {
        listview2.getItems().add(text.getText());
    }

    @FXML
    void removeName(MouseEvent event) {
        int selectID = listview2.getSelectionModel().getSelectedIndex();
        listview2.getItems().remove(selectID);
    }

    List<String> busc = new ArrayList<>();


    private List<String> gettarCamisa() {

        List<Product> products = new ArrayList<>();
        List<String> products1 = new ArrayList<>();
        Product product;

        product = new Product();
        product.setProduto("CAMISETA LACOSTE");
        product.setPrice(60.00);
        products.add(product);

        product = new Product();
        product.setProduto("CAMISETA TOMMY");
        product.setPrice(55.00);
        products.add(product);

        product = new Product();
        product.setProduto("CAMISETA GUCCI");
        product.setPrice(80.00);
        products.add(product);

        product = new Product();
        product.setProduto("CAMISETA PRADA");
        product.setPrice(70.00);
        products.add(product);


        product = new Product();
        product.setProduto("CAMISETA NIKE");
        product.setPrice(70.00);
        products.add(product);

        for (int i = 0; i < products.size(); i++) {
            products1.add(products.get(i).getProduto(i));
        }

        return products1;

    }

    private List<String> gettarPerfume() {

        List<Product> products = new ArrayList<>();
        List<String> products1 = new ArrayList<>();
        Product product;

        product = new Product();
        product.setProduto("212 VIP MEN");
        product.setPrice(380.00);
        products.add(product);

        product = new Product();
        product.setProduto("ONE MILLION");
        product.setPrice(370.00);
        products.add(product);

        product = new Product();
        product.setProduto("SILVER SCENT");
        product.setPrice(180.00);
        products.add(product);

        product = new Product();
        product.setProduto("FERRARI BLACK");
        product.setPrice(200.00);
        products.add(product);


        product = new Product();
        product.setProduto("BLEU DE CHANEL");
        product.setPrice(970.00);
        products.add(product);

        for (int i = 0; i < products.size(); i++) {
            products1.add(products.get(i).getProduto(i));
        }

        return products1;
    }


    public void initialize() {
        carrinho.setImage(new Image(Paths.get("src/images/icon.png").toUri().toString()));
        logo.setImage(new Image(Paths.get("src/images/logotipo1.png").toUri().toString()));
        logout.setImage(new Image(Paths.get("src/images/logout.png").toUri().toString()));
        camisa.setImage(new Image(Paths.get("src/images/camisa.png").toUri().toString()));
        perfume.setImage(new Image(Paths.get("src/images/perfume.png").toUri().toString()));


        listview.getItems().addAll(gettarCamisa());
        listview1.getItems().addAll(gettarPerfume());
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String produtosList = (String) listview.getSelectionModel().getSelectedItem();
                label.setText(produtosList);
                text.setText(produtosList);

            }
        }
        );
        listview1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String perfumesList = (String) listview1.getSelectionModel().getSelectedItem();
                label1.setText(perfumesList);
                text.setText(perfumesList);
            }
        });

    }

    public void voltar() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/home.fxml"));

        Main.stage.setScene(new Scene(parent));
    }


    public void buscar() throws IOException {

                if (buscar.getText().equals("CAMISETA LACOSTE") || (buscar.getText().equals("CAMISETA TOMMY")) ||
                        (buscar.getText().equals("CAMISETA GUCCI")) || (buscar.getText().equals("CAMISETA PRADA")) ||
                        (buscar.getText().equals("CAMISETA NIKE"))) {
                    listview1.getItems().clear();
                    listview.getItems().clear();
                    listview2.getItems().clear();
                    listview.getItems().add(buscar.getText());


                }

                else if (buscar.getText().equals("212 VIP MEN") || (buscar.getText().equals("ONE MILLION")) ||
                        (buscar.getText().equals("SILVER SCENT")) || (buscar.getText().equals("FERRARI BLACK")) ||
                        (buscar.getText().equals("BLEU DE CHANEL"))) {
                    listview1.getItems().clear();
                    listview.getItems().clear();
                    listview2.getItems().clear();
                    listview1.getItems().add(buscar.getText());

                }

                else{
                    JOptionPane.showMessageDialog(null,"Produto não encontrado!");
                    buscar.clear();
                }

            }

    public void limpar(){
        buscar.clear();
        listview.getItems().clear();
        listview1.getItems().clear();
        listview.getItems().addAll(gettarCamisa());
        listview1.getItems().addAll(gettarPerfume());
    }
}









