package br.com.loja.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.loja.DAO.ClienteDao;
import br.com.loja.DAO.MysqlDAO;
import br.com.loja.modelo.Cliente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClienteApp extends Application {
	private Label nome;
	private Label telefone;
	private Label cpf;
	private Label endereco;
	private Label dataNascimento;
	private AnchorPane pane;
	private TextField txNome;
	private TextField txTelefone;
	private TextField txCpf;
	private TextField txEndereco;
	private TextField txDataNascimento;
	private GregorianCalendar data=new GregorianCalendar();	
	private Button btSalvar;
	private Button btCancelar;
	private static Stage stage;	
	
	public AnchorPane getPane() {
		return pane;
	}

	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}

	public TextField getTxNome() {
		return txNome;
	}

	public void setTxNome(TextField txNome) {
		this.txNome = txNome;
	}

	public TextField getTxTelefone() {
		return txTelefone;
	}

	public void setTxTelefone(TextField txTelefone) {
		this.txTelefone = txTelefone;
	}

	public TextField getTxCpf() {
		return txCpf;
	}

	public void setTxCpf(TextField txCpf) {
		this.txCpf = txCpf;
	}

	public TextField getTxEndereco() {
		return txEndereco;
	}

	public void setTxEndereco(TextField txEndereco) {
		this.txEndereco = txEndereco;
	}
	
	public TextField getTxDataNascimento() {
		return txDataNascimento;
	}

	public void setTxDataNascimento(TextField txDataNascimento) {
		this.txDataNascimento = txDataNascimento;
	}

	public void setBtSalvar(Button btSalvar) {
		this.btSalvar = btSalvar;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public Button getBtSalvar() {
		return btSalvar;
	}

	public void setBtEntrar(Button btSalvar) {
		this.btSalvar = btSalvar;
	}

	public Button getBtCancelar() {
		return btCancelar;
	}

	public void setBtCancelar(Button btCancelar) {
		this.btCancelar = btCancelar;
	}

	public static Stage getStage() {
		return stage;
	}	

	public static void setStage(Stage stage) {
		ClienteApp.stage = stage;
	}

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
		pane.setPrefSize(350, 250);	
		
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
		
		btSalvar = new Button("Salvar");
		btCancelar = new Button("Cancelar");
		
		pane.getChildren().addAll(nome,txNome,telefone,txTelefone,cpf,txCpf,endereco,txEndereco,dataNascimento,txDataNascimento,btSalvar,btCancelar);	
	}
	
	private void initLayout(){	
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
		btSalvar.setLayoutX(10);
		btSalvar.setLayoutY(210);
		btCancelar.setLayoutX(80);
		btCancelar.setLayoutY(210);	
	}
	
	//Ações dos componentes
	private void initListerners(){
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
		
		//validação
		if((txNome.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
			JOptionPane.showMessageDialog(null, "Adicionado Com Sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Preencha o campo");	
			return;
		}	
		
		if((txTelefone.getText().length() > 0 ) || (txEndereco.getText().length() > 0 )){
			JOptionPane.showMessageDialog(null, "Adicionado Com Sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Preencha o campo");	
			return;
		}	
		
		//gravando a conexão
		MysqlDAO<Cliente> dao = new ClienteDao();				
		dao.insert(cliente);			
	}
		

	public static void main(String[] args) {
		launch(args);
	}


}
