package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.Cliente;
import model.Pet;

public class ClienteDAO {
	
	public void insert(Cliente cliente) throws Exception {
		
		String sqlCliente = "insert into Cliente (Nome, Telefone, Celular,Email,whatsapp,CPF ,Endereco) values (?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		
		try
		{
			Connection con = new Conexao().abrir(); 	// Abre a conexão com o banxo 

				
			
			if(true) {// TODO Não estiver repetido 
				//  Insere os dados do formulário no BD.				
				stmt = con.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS); 
		        stmt.setString(1, cliente.getNome());
		        stmt.setString(2, cliente.getTelefone());
		        stmt.setString(3, cliente.getCelular());
		        stmt.setString(4, cliente.getEmail());
		        stmt.setInt(5, cliente.getWhatsapp());
		        stmt.setString(6, cliente.getCpf());
		        stmt.setString(7, cliente.getEndereco()); 
				
		        stmt.executeUpdate();
		        // abaixo você obtém o id gerado para a coluna auto-incremento do MySql
		        // e seta este id no objeto Estado que está sendo adicionado.
		        ResultSet rs = stmt.getGeneratedKeys();
		        rs.next();
		        int idGerado = rs.getInt(1);
		        cliente.setId(idGerado);

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