package br.com.loja.application;	
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*Boas práticas de programação no login, por isso a criação de variáves e methodos pra deixar mais limpo o código*/
public class LoginApp extends Application {
	/*criaremos nossos componentes como variáveis globais, e então, eles
	serão instanciados e configurados em um método chamado initComponents():*/
	private AnchorPane pane;
	private Label login;
	private Label senha;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar;
	private Button btSair;
	private static Stage stage;
	
	public AnchorPane getPane() {
		return pane;
	}

	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}	

	public Label getLogin() {
		return login;
	}

	public void setLogin(Label login) {
		this.login = login;
	}

	public Label getSenha() {
		return senha;
	}

	public void setSenha(Label senha) {
		this.senha = senha;
	}

	public TextField getTxLogin() {
		return txLogin;
	}

	public void setTxLogin(TextField txLogin) {
		this.txLogin = txLogin;
	}

	public PasswordField getTxSenha() {
		return txSenha;
	}

	public void setTxSenha(PasswordField txSenha) {
		this.txSenha = txSenha;
	}

	public Button getBtEntrar() {
		return btEntrar;
	}

	public void setBtEntrar(Button btEntrar) {
		this.btEntrar = btEntrar;
	}

	public Button getBtSair() {
		return btSair;
	}

	public void setBtSair(Button btSair) {
		this.btSair = btSair;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		LoginApp.stage = stage;
	}	

	@Override
	public void start(Stage stage) throws Exception {
//		//criando o painel(tamanho e largura)
//		AnchorPane pane = new  AnchorPane();
//		pane.setPrefSize(400, 300);
//		
//		//criando os campos do painel
//		//criando o campo  login
//		TextField txLogin = new TextField();
//		txLogin.setPromptText("Digite seu login");
//		
//		//criando uma campo de texto oculto pra senha
//		PasswordField txSenha = new PasswordField();
//		txSenha.setPromptText("Digite sua senha");
//		
//		//criando os botões
//		Button btEntrar = new Button("Entrar");
//		Button btSair = new Button("Sair");
//		
//		//passando os componentes para o painel
//		pane.getChildren().addAll(txLogin,txSenha,btEntrar,btSair);
//		
//		//Nosso primeiro toque de requinte
//		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
//		
//		//Exibindo o painel
//		Scene scene =  new Scene(pane);
//		stage.setScene(scene);
//		stage.show();
//		
//		//ordenando os componentes
//		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
//		txLogin.setLayoutY(50);
//		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
//		txSenha.setLayoutY(100);
//		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
//		btEntrar.setLayoutY(150);
//		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
//		btSair.setLayoutY(200);		
		
		initComponents();
		initListerners();
		Scene scene =  new Scene(pane);
		stage.setScene(scene);
		
		//remove a opção de maximizar a tela
		stage.setResizable(false);
		
		//Dá um título para a tela
		stage.setTitle("Login - GolFX");		
		
		stage.show();
		initLayout();
		LoginApp.stage = stage;
	}
		
	private void initComponents(){
		
		pane = new AnchorPane();
		//pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, green 0%, silver 100%);");
		pane.setPrefSize(400, 300);
		login = new Label("Login:");
		txLogin = new TextField();
		txLogin.setPromptText("Digite seu Login...");
		senha = new Label("Senha:");
		txSenha = new PasswordField();
		txSenha.setPromptText("Digite sua senha...");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		pane.getChildren().addAll(login,txLogin,senha,txSenha,btEntrar,btSair);	
	}
	
	private void initLayout(){
		login.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		login.setLayoutY(30);
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		senha.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		senha.setLayoutY(80);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX(150);
		btEntrar.setLayoutY(150);
		btSair.setLayoutX(200);
		btSair.setLayoutY(150);			
	}
	
	//Ações dos componentes
	private void initListerners(){
		btSair.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				fecharAplicacao();	
			}			
		});
		
		btEntrar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				logar();				
			}			
		});		
	}
	
	private void fecharAplicacao(){
		System.exit(0);
	}
	
	private void logar() {
		try{
			if(txLogin.getText().equals("admin") && txSenha.getText().equals("elis")){
				//todo Abrir  a tela vitrineApp
				
					new MenuApp().start(new Stage());
					LoginApp.getStage().close();
				
			}else{
				JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
