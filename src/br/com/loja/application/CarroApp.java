package br.com.loja.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarroApp extends Application {
	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Carro");
		stage.setResizable(true);
		stage.show();
		
		
	}
	

}
