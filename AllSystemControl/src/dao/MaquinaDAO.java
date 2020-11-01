package dao;

import model.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaquinaDAO {
	
	public int criar(Maquina maquina) {
		String sqlInsert = "INSERT INTO Endereco(idusuario,tipodeendereco, cep, endereco, estado, cidade, numero, complemento) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, maquina.getIdMaquinas());
			stm.setString(2, maquina.getHostname());
			stm.setString(3, maquina.getSO());
			stm.setString(4, maquina.getDescricao());
			
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					maquina.setIdMaquinas(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maquina.getIdMaquinas();
	}
	

	public void atualizar(Maquina maquina) {
		String sqlUpdate = "UPDATE Endereco SET idusuario = ?,tipodeendereco=?, cep=?, endereco=?, estado=?, cidade=?, numero=?, complemento=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, maquina.getIdMaquinas());
			stm.setString(2, maquina.getHostname());
			stm.setString(3, maquina.getSO());
			stm.setString(4, maquina.getDescricao());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM Endereco WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Maquina carregar(int id) {
		Maquina maquina = new Maquina();
		maquina.setIdMaquinas(id);
		String sqlSelect = "SELECT idusuario,tipodeendereco, cep, endereco, estado, cidade, numero, complemento FROM Endereco WHERE Endereco.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, maquina.getIdMaquinas());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					maquina.setIdMaquinas(rs.getInt("idMaquina"));
					maquina.setHostname(rs.getString("hostname"));
					maquina.setSO(rs.getString("SO"));
					maquina.setDescricao(rs.getString("descricao"));
					
				} else {
					maquina.setIdMaquinas(-1);
					maquina.setHostname(null);
					maquina.setSO(null);
					maquina.setDescricao(null);					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return maquina;
	}
}
