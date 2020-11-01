package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Informacoes;
import model.Maquina;

public class InformacoesDAO {
	
	public int criar(Informacoes informacoes) {
		String sqlInsert = "INSERT INTO Endereco(idusuario,tipodeendereco, cep, endereco, estado, cidade, numero, complemento) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, informacoes.getIdInformacoes());
			stm.setInt(2, informacoes.getIdInformacoes());
			stm.setDouble(3, informacoes.getCPU());
			stm.setDouble(4, informacoes.getHDTotal());
			stm.setDouble(5, informacoes.getHDUtilizado());
			stm.setDouble(6, informacoes.getHDDisponivel());
			stm.setDouble(7, informacoes.getRamTotal());
			stm.setDouble(8, informacoes.getRamUtilizada());
			stm.setDouble(9, informacoes.getRamDisponivel());
			stm.setDate(10, (Date) informacoes.getData());
			
			
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					informacoes.setIdInformacoes(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return informacoes.getIdInformacoes();
	}
	
	public void atualizar(Informacoes informacoes) {
		String sqlUpdate = "UPDATE Endereco SET idusuario = ?,tipodeendereco=?, cep=?, endereco=?, estado=?, cidade=?, numero=?, complemento=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, informacoes.getIdInformacoes());
			stm.setInt(2, informacoes.getIdInformacoes());
			stm.setDouble(3, informacoes.getCPU());
			stm.setDouble(4, informacoes.getHDTotal());
			stm.setDouble(5, informacoes.getHDUtilizado());
			stm.setDouble(6, informacoes.getHDDisponivel());
			stm.setDouble(7, informacoes.getRamTotal());
			stm.setDouble(8, informacoes.getRamUtilizada());
			stm.setDouble(9, informacoes.getRamDisponivel());
			stm.setDate(10, (Date) informacoes.getData());
			
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
	
	public Informacoes carregar(int id) {
		Informacoes informacoes = new Informacoes();
		informacoes.setIdInformacoes(id);
		String sqlSelect = "SELECT idusuario,tipodeendereco, cep, endereco, estado, cidade, numero, complemento FROM Endereco WHERE Endereco.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, informacoes.getIdInformacoes());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					informacoes.setIdInformacoes(rs.getInt("idInformacoes"));
					informacoes.setIdMaquina(rs.getInt("idMaquina"));
					informacoes.setCPU(rs.getDouble("CPU"));
					informacoes.setHDTotal(rs.getDouble("HDTotal"));
					informacoes.setHDUtilizado(rs.getDouble("HDUtilizado"));
					informacoes.setHDDisponivel(rs.getDouble("HDDisponivel"));
					informacoes.setRamTotal(rs.getDouble("RamTotal"));
					informacoes.setRamUtilizada(rs.getDouble("RamUtilizada"));
					informacoes.setRamDisponivel(rs.getDouble("RamDisponivel"));
					informacoes.setData(rs.getDate("Data"));
					
				} else {
					informacoes.setIdInformacoes(-1);
					informacoes.setIdMaquina(-1);
					informacoes.setCPU(-1);
					informacoes.setHDTotal(-1);
					informacoes.setHDUtilizado(-1);
					informacoes.setHDDisponivel(-1);
					informacoes.setRamTotal(-1);
					informacoes.setRamUtilizada(-1);
					informacoes.setRamDisponivel(-1);
					informacoes.setData(null);			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return informacoes;
	}

}
