package dao;

import model.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaquinaDAO {
	
	public int criar(Maquina maquina) {
		String sqlInsert = "INSERT INTO maquinas(idMaquinas,hostname, SO, descricao) VALUES (?, ?, ?, ?)";
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
		String sqlUpdate = "UPDATE maquinas SET idMaquinas = ?, hostname=?, SO=?, descricao=? WHERE idMaquinas=?";
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
		String sqlDelete = "DELETE FROM maquinas WHERE idMaquina = ?";
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
		String sqlSelect = "SELECT idMaquinas , hostname , SO , descricao FROM maquinas WHERE maquinas.idMaquinas = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, maquina.getIdMaquinas());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					maquina.setIdMaquinas(rs.getInt("idMaquinas"));
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
