package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import model.Cliente;

import control.ClienteDAO;


public class TelaCadastro extends Application implements Initializable{	
	
	@FXML private Button btnFinalizar;
	@FXML private Button btnAddPet;
	@FXML private Button btnCadastraCliente;
	@FXML private Label txtSucesso;
	@FXML private TextField txtNome;
	@FXML private TextField txtTelefone;
	@FXML private TextField txtCelular;
	@FXML private TextField txtEmail;
	@FXML private TextField txtEndereco;
	@FXML private TextField txtCPF;
	@FXML private CheckBox whatsapp;
	@FXML private BorderPane pet_border;	
	
	private Cliente cliente = new Cliente();
	private ClienteDAO cl = new ClienteDAO();	
	
	@FXML 
	private void handleFinalizar(ActionEvent event) throws Exception {		
   
	}
	
	@FXML
	private void handleCadastraCliente(ActionEvent event) throws Exception {		
	
		cliente.setNome(txtNome.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setCelular(txtCelular.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setEndereco(txtEndereco.getText());		
		cliente.setCpf(txtCPF.getText());
		
		cl.insert(cliente);
		
		txtSucesso.setOpacity(1);
		txtNome.setDisable(true);
		txtTelefone.setDisable(true);
		txtCelular.setDisable(true);
		txtEmail.setDisable(true);
		txtEndereco.setDisable(true);
		txtCPF.setDisable(true);
		whatsapp.setDisable(true);
		
		btnCadastraCliente.setDisable(true);
	}
	
	@FXML
	protected void handlePetButtonAction(ActionEvent event) throws Exception{	
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroPet.fxml"));
		try{
			loader.load();
		}catch(IOException ex){
			System.out.println("Erro ao load");
		}
		TelaCadastroPet tcp = loader.getController();
		tcp.setClientePet(cliente);
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.showAndWait();
		
//	     Stage stage = new Stage();//(Stage) btnAddPet.getScene().getWindow();
//	     Parent root = FXMLLoader.load(getClass().getResource("CadastroPet.fxml")); 
//	     Scene scene = new Scene(root);
//	     stage.setScene(scene);
//	     stage.show();
		
	}
	@FXML
	protected void handleWhatsapp(ActionEvent event) throws Exception{
//		whatsapp.selectedProperty().addListener(new ChangeListener<Boolean>() {
//	 	       @Override
//	 	       public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//	 	    	   if(whatsapp.isSelected()) cliente.setWhatsapp(1);
//	 	    	   else cliente.setWhatsapp(0);
//	 	       }
//	 	    });		
		 if(whatsapp.isSelected()) cliente.setWhatsapp(1);
         else cliente.setWhatsapp(0);
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        btnCadastraCliente.setOnAction(eventCadastro -> {
			try {
				handleCadastraCliente(eventCadastro);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        btnAddPet.setOnAction(eventPet -> {
			try {
				handlePetButtonAction(eventPet);
			} catch (Exception erroPet) {
				erroPet.printStackTrace();
			}
		});
        
        btnFinalizar.setOnAction(eventFinalizar -> {
        	try {
        		handleFinalizar(eventFinalizar);
        	}catch(Exception erroFinalizar){
        		erroFinalizar.printStackTrace();
        	}
        });
        
        whatsapp.setOnAction(eventWhatsapp -> {
        	try {
        		handleWhatsapp(eventWhatsapp);
        	}catch(Exception erroFinalizar){
        		erroFinalizar.printStackTrace();
        	}
        });
	}
	

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub		
		stage.setTitle("Cadastro");        
	}
	
	public static void main(String[] args) {
        launch();
    }

}