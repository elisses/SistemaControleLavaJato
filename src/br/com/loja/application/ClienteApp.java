package br.com.loja.application;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.loja.DAO.ClienteDao;
import br.com.loja.DAO.MysqlDAO;
import br.com.loja.modelo.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClienteApp extends Application {
	private Label id;
	private Label nome;
	private Label telefone;
	private Label cpf;
	private Label endereco;
	private Label dataNascimento;
	private Label boxModCarro;
	private ComboBox<String> boxCarro;
	private AnchorPane pane;	
	private TextField txId;
	private TextField txNome;
	private TextField txTelefone;
	private TextField txCpf;
	private TextField txEndereco;
	private TextField txDataNascimento;
	private GregorianCalendar data=new GregorianCalendar();	
	private Button btSalvar;
	private Button btAtualiza;
	private Button btCancelar;
	private static Stage stage;	
	
	@Override
	public void start(Stage stage) throws Exception {			
		initComponents();
		initListerners();
		Scene scene = new Scene(pane);
		stage.setScene(scene);			
		stage.setTitle("Cadastro de Cliente");
		stage.setResizable(false);					
		stage.show();
		initLayout();
		ClienteApp.stage = stage;				
	}
		
	private void initComponents(){
		
		pane = new AnchorPane();
		pane.setPrefSize(500, 300);	
		
		id = new Label("Id:");
		txId = new TextField();
		txId.setDisable(true);
		
		nome = new Label("Nome:");
		txNome = new TextField();		
		txNome.setPromptText("Digite o nome");
		
		telefone  = new Label("Telefone:");
		txTelefone = new TextField();
		txTelefone.setPromptText("(00)0000-0000");
		
		cpf  = new Label("CPF:");
		txCpf = new TextField();
		txCpf.setPromptText("000.000.000-00");
		
		endereco  = new Label("Endereço:");
		txEndereco = new TextField();
		txEndereco.setPromptText("Digite o endereço");
		
		dataNascimento  = new Label("Data Nascimento:");
		txDataNascimento= new TextField();
		txDataNascimento.setPromptText("dd/MM/yyyy");
		
		boxModCarro = new Label("Modelo de Carro:");		
	    boxCarro = new ComboBox<String>();
	    boxCarro.setEditable(true);
		boxCarro.setPrefHeight(30);
		boxCarro.setPrefWidth(150);
		 ObservableList<String> options = 
	                FXCollections.observableArrayList("Codigo","Nome","Cidade");
		 
		boxCarro.setItems(options);
		
		btSalvar = new Button("Salvar");
		btCancelar = new Button("Cancelar");
		btAtualiza = new Button("Atualizar");
		
		
		pane.getChildren().addAll(nome,txNome,telefone,txTelefone,cpf,txCpf,endereco,
				txEndereco,dataNascimento,txDataNascimento,btSalvar,btAtualiza,btCancelar,boxCarro,boxModCarro,id,txId);	
	}
	
	public  void initLayout(){	
		nome.setLayoutX(5);
		nome.setLayoutY(10);
		txNome.setLayoutX(5);
		txNome.setLayoutY(15);
		nome.setLayoutX(10);
		nome.setLayoutY(20);
		txNome.setLayoutX(10);
		txNome.setLayoutY(40);
		telefone.setLayoutX(200);
		telefone.setLayoutY(20);
		txTelefone.setLayoutX(200);
		txTelefone.setLayoutY(40);	
		cpf.setLayoutX(10);
		cpf.setLayoutY(80);
		txCpf.setLayoutX(10);
		txCpf.setLayoutY(100);
		endereco.setLayoutX(200);
		endereco.setLayoutY(80);
		txEndereco.setLayoutX(200);
		txEndereco.setLayoutY(100);			
		dataNascimento.setLayoutX(10);
		dataNascimento.setLayoutY(140);
		txDataNascimento.setLayoutX(10);
		txDataNascimento.setLayoutY(160);
		boxModCarro.setLayoutX(200);
		boxModCarro.setLayoutY(140);
		boxCarro.setLayoutX(200);
		boxCarro.setLayoutY(160);
		btSalvar.setLayoutX(10);
		btSalvar.setLayoutY(210);
		btAtualiza.setLayoutX(80);
		btAtualiza.setLayoutY(210);
		btCancelar.setLayoutX(160);
		btCancelar.setLayoutY(210);	
	}	
	//Ações dos componentes
	
		
	public void initListerners(){
		btCancelar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				fecharAplicacao();	
			}			
		});
		
		btSalvar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				adiciona();				
			}			
		});	
		
		btAtualiza.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				atualiza();
				
			}
			
		});
			
		
	}

	private void fecharAplicacao(){
		System.exit(0);
	}
		
	private void adiciona(){
		Cliente cliente = new Cliente();		
		cliente.setNome(txNome.getText());
		cliente.setTelefone(txTelefone.getText());
		cliente.setCpf(txCpf.getText());
		cliente.setEndereco(txEndereco.getText());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(txDataNascimento.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setDataNascimento(cal);	
		try{
			//validação
			if((txNome.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
				JOptionPane.showMessageDialog(null, "Adicionado Com Sucesso");
			}else if((txTelefone.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
				JOptionPane.showMessageDialog(null, "Adicionado Com Sucesso");
			}else{
				JOptionPane.showMessageDialog(null, "Preencha o campo");	
				return;
			}	
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		//gravando a conexão
		MysqlDAO<Cliente> dao = new ClienteDao();				
		Long codigo = null;
		
		try {
			codigo = dao.insert(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cliente.setId(codigo);
		txId.setText(codigo.toString());
	}
	
	private void atualiza(){
		Cliente cliente = new Cliente();		
		cliente.setTelefone(txTelefone.getText());
		cliente.setCpf(txCpf.getText());
		cliente.setEndereco(txEndereco.getText());
		cliente.setId(Long.valueOf(txId.getText()));
		cliente.setNome(txNome.getText());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(txDataNascimento.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setDataNascimento(cal);	
		try{
			//validação
			if((txNome.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
				JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			}else if((txTelefone.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
				JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			}else{
				JOptionPane.showMessageDialog(null, "Preencha o campo");	
				return;
			}	
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	
		//gravando a conexão
		MysqlDAO<Cliente> dao = new ClienteDao();				
		try {
			dao.update(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}


	public static void main(String[] args) {			
		
		launch(args);
	}


}
