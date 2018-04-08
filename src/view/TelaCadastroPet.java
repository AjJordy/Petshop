package view;

import java.net.URL;
import java.util.ResourceBundle;

import control.PetDAO;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.Pet;


public class TelaCadastroPet extends Application implements Initializable{	

	@FXML private TextField txtNomePet;
	@FXML private TextField txtPorte;
	@FXML private TextField txtRaca;
	@FXML private TextField txtSaude;
	@FXML private TextField txtAlergia;
	@FXML private TextField txtMedicamento;
	@FXML private TextArea txtObservacao;		
	
	@FXML private Button btnCadastrarPet;	
	
	@FXML private CheckBox problema;
	@FXML private CheckBox alergia;
	@FXML private CheckBox medicamento;
	@FXML private CheckBox castrado;
	@FXML private CheckBox perfume;
	@FXML private CheckBox vermifugado;
	@FXML private CheckBox v8;
	@FXML private CheckBox antirabica;
	
	@FXML private DatePicker dateVermifugado;
	@FXML private DatePicker dateV8;
	@FXML private DatePicker dateAntirabica;
	
	
	private Cliente cliente = new Cliente();
	private Pet pet = new Pet();
	private PetDAO pt = new PetDAO();
	
	@FXML
	private void handleCadastrarPet(ActionEvent event) throws Exception {	
				
		pet.setNome(txtNomePet.getText());
		pet.setNomeDono(cliente.getNome());
		pet.setPorte(txtPorte.getText());
		pet.setRaca(txtRaca.getText()); 
		pet.setObservacao(txtObservacao.getText());				
		pet.setNomeDono(cliente.getNome());
		pet.setProblemaSaude(txtSaude.getText());
		pet.setAlergia(txtAlergia.getText());
		pet.setMedicamento(txtMedicamento.getText());
		pet.setVermifugado(dateVermifugado.getValue());
		pet.setAntirabica(dateAntirabica.getValue());
		pet.setV8(dateV8.getValue());
		
		pet.setCliente(cliente);
		pt.insert(pet);
		
	    Stage stage = (Stage) btnCadastrarPet.getScene().getWindow(); // get a handle to the stage
	    stage.close(); // do what you have to do
    }
	
	@FXML
	private void handleProblema(ActionEvent event) throws Exception{
		if(problema.isSelected()) txtSaude.setDisable(false);		 
	}
	@FXML
	private void handleAlergia(ActionEvent event) throws Exception{
		if(alergia.isSelected()) txtAlergia.setDisable(false);
	}
	@FXML
	private void handleMedicamento(ActionEvent event) throws Exception{
		if(medicamento.isSelected()) txtMedicamento.setDisable(false);
	}
	@FXML
	private void handleCastrado(ActionEvent event) throws Exception{
		if(castrado.isSelected()) pet.setCastrado(1);
		else pet.setCastrado(0);
	}
	@FXML
	private void handlePerfume(ActionEvent event) throws Exception{
		if(perfume.isSelected()) pet.setPerfume(1);
		else pet.setPerfume(0);
	}
	@FXML
	private void handleVermifugado(ActionEvent event) throws Exception{
		if(vermifugado.isSelected()) dateVermifugado.setDisable(false);
	}
	@FXML
	private void handleV8(ActionEvent event) throws Exception{
		if(v8.isSelected()) dateV8.setDisable(false);
	}
	@FXML
	private void handleAntirabica(ActionEvent event) throws Exception{
		if(antirabica.isSelected()) dateAntirabica.setDisable(false);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        btnCadastrarPet.setOnAction(eventCadastro -> {
			try {
				handleCadastrarPet(eventCadastro);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        problema.setOnAction(eventProblema -> {
			try {
				handleProblema(eventProblema);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        alergia.setOnAction(eventAlergia -> {
			try {
				handleAlergia(eventAlergia);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        medicamento.setOnAction(eventMedicamento -> {
			try {
				handleMedicamento(eventMedicamento);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        castrado.setOnAction(eventCastrado -> {
			try {
				handleCastrado(eventCastrado);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        perfume.setOnAction(eventPerfume -> {
			try {
				handlePerfume(eventPerfume);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        vermifugado.setOnAction(eventVermifugado -> {
			try {
				handleVermifugado(eventVermifugado);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        v8.setOnAction(eventV8 -> {
			try {
				handleV8(eventV8);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
        
        antirabica.setOnAction(eventAntirabica -> {
			try {
				handleAntirabica(eventAntirabica);
			} catch (Exception erroCadastro) {
				erroCadastro.printStackTrace();
			}
		});
	}
	
	public void setClientePet(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Cadastrar Pet");
		System.out.println(cliente.getNome());		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
