package br.com.loja.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuApp extends Application{
	private AnchorPane pane;
	private ImageView imgUsuario;
	private ImageView imgCarro;
	private ImageView imgServico;
	private ImageView imgRelatorio;
	private Button btUsuario;
	private Button btVeiculo;
	private Button btServico;
	private Button btRelatorio;	

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListerners();		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Menu");
		stage.setResizable(false);
		stage.show();
		initLayout();
	}
	
	public void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(500,500);

		imgUsuario = new ImageView(new Image("http://3.bp.blogspot.com/-9xy8lO8uqc8/VN_LdHA03ZI/AAAAAAAABZM/utxy8OgcS1c/s1600/"+
												"usuario.png"));
		imgUsuario.fitHeightProperty().set(200);
		imgUsuario.fitWidthProperty().set(200);
		
		btUsuario = new Button("",imgUsuario);
		
		imgCarro = new ImageView(new Image("http://www.realconsorcios.com/images/segurocarro.png"));
		imgCarro.fitHeightProperty().set(200);
		imgCarro.fitWidthProperty().set(200);
		
		btVeiculo = new Button("",imgCarro);			

		imgServico = new ImageView(new Image("http://www.engenharsc.com.br/wp-content/uploads/2015/01/icone-infraestrutura-01.png"));
		imgServico.fitHeightProperty().set(200);
		imgServico.fitWidthProperty().set(200);
		
		btServico = new Button("",imgServico);	
		
		imgRelatorio= new ImageView(new Image("http://cdn5.seomaster.com.br/wp-content/uploads/2015/01/icon-relatorio.png"));
		imgRelatorio.fitHeightProperty().set(200);
		imgRelatorio.fitWidthProperty().set(200);
		
		btRelatorio = new Button("",imgRelatorio);	
						
        pane.getChildren().addAll(btUsuario,btVeiculo,btServico,btRelatorio);		
	}
	
	private void initLayout(){	
		btUsuario.setLayoutX(10);
		btUsuario.setLayoutY(20);
		btVeiculo.setLayoutX(285);
		btVeiculo.setLayoutY(20);
		btServico.setLayoutX(10);
		btServico.setLayoutY(285);
		btRelatorio.setLayoutX(285);
		btRelatorio.setLayoutY(285);
	}
	
	private void initListerners(){		
		
		btUsuario.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				logaUsuario();				
			}			
		});	
		
		btVeiculo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				logaVeiculo();				
			}			
		});	
	}
	
	public void logaUsuario(){
		try{
			new ClienteApp().start(new Stage());
			LoginApp.getStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void logaVeiculo(){
		try{
			new VeiculoApp().start(new Stage());
			LoginApp.getStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
