package br.com.loja.application;

import br.com.loja.modelo.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VeiculoApp extends Application {
	private Cliente cpf;
	private TextField txCpf;
	private AnchorPane pane;
	private Label tipo;
	private ComboBox boxTipo;
	private Label modelo;
	private TextField txModelo;
	private Label placa;
	private TextField txPlaca;
	private static Stage stage;


	@Override
	public void start(Stage stage) throws Exception {
		initComponent();		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Carro");
		stage.setResizable(false);
		stage.show();	
		initLayout();
		//VeiculoApp stage = stage;
	}
	
	public void initComponent(){
		 pane = new AnchorPane(); 
		 pane.setPrefSize(400,300);
		 
		 tipo = new Label("Tipo de veiculo:");		
		    boxTipo = new ComboBox<String>();
		    boxTipo.setEditable(true);
		    boxTipo.setPrefHeight(30);
		    boxTipo.setPrefWidth(150);
			 ObservableList<String> options = 
					 FXCollections.observableArrayList("Carro","Caminhão","Moto");			 
			 boxTipo.setItems(options);
			 
			 modelo = new Label("Modelo:");
			 txModelo = new TextField();
			 
			 placa = new Label("Placa:");
			 txPlaca = new TextField();
			 
			 
			 pane.getChildren().addAll(tipo,boxTipo,modelo,txModelo,placa,txPlaca);		 
	}
	
	public void initLayout(){
		tipo.setLayoutX((pane.getWidth() - boxTipo.getWidth()) / 2);
		tipo.setLayoutY(10);
		boxTipo.setLayoutX((pane.getWidth() - boxTipo.getWidth()) / 2);
		boxTipo.setLayoutY(30);
		modelo.setLayoutX((pane.getWidth() - txModelo.getWidth()) / 2);
		modelo.setLayoutY(70);
		txModelo.setLayoutX((pane.getWidth() - txModelo.getWidth()) / 2);
		txModelo.setLayoutY(90);
		placa.setLayoutX((pane.getWidth() - txPlaca.getWidth()) / 2);
		placa.setLayoutY(130);
		txPlaca.setLayoutX((pane.getWidth() - txModelo.getWidth()) / 2);
		txPlaca.setLayoutY(150);		
	}
	
	public static void main(String[] args) {			
		
		launch(args);
	}
	

}
