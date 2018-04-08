package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.Pet;

public class PetDAO {
	
	public void insert(Pet pet) throws Exception {
		
		String sqlPet = "insert into Pet (Nome_pet,Especie,Porte,Raca,Alergia,Problema_saude,Observacao,Sexo,Medicamento,"
				+ "Nome_dono,Perfume,Vermifugado,v8,Antirabica,Castrado,id_cliente) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		
		try
		{
			Connection con = new Conexao().abrir(); 	// Abre a conexão com o banxo 		 		
			
			if(true) {// TODO Não estiver repetido 
				//  Insere os dados do formulário no BD.		        
				stmt = con.prepareStatement(sqlPet, Statement.RETURN_GENERATED_KEYS);
		        stmt.setString(1, pet.getNome());
		        stmt.setString(2, pet.getEspecie());
		        stmt.setString(3, pet.getPorte());
		        stmt.setString(4, pet.getRaca());
		        stmt.setString(5, pet.getAlergia());
		        stmt.setString(6, pet.getProblemaSaude());
		        stmt.setString(7, pet.getObservacao());
		        stmt.setString(8, pet.getSexo());
		        stmt.setString(9, pet.getMedicamento());
		        stmt.setString(10, pet.getNomeDono());
		        stmt.setInt(11, pet.getPerfume());
		        stmt.setDate(12, pet.getVermifugado());
		        stmt.setDate(13, pet.getV8());
		        stmt.setDate(14, pet.getAntirabica());
		        stmt.setInt(15, pet.getCastrado()); 
		        stmt.setInt(16, pet.getCliente().getId());
				
		        stmt.executeUpdate();
		        // abaixo você obtém o id gerado para a coluna auto-incremento do MySql
		        // e seta este id no objeto Estado que está sendo adicionado.
		        ResultSet rs = stmt.getGeneratedKeys();
		        rs.next();
		        int idGerado = rs.getInt(1);
		        pet.setId(idGerado);

		        stmt.close();  
			}
			
            System.out.println("Gravado!");
            con.close();
		}catch(SQLException ErroSQL){
			System.out.println(ErroSQL);
			throw new RuntimeException(ErroSQL);		
		}catch(ClassNotFoundException ErroNotFound){
			System.out.println(ErroNotFound);			 
		}
	}
	

}
