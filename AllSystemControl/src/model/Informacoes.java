package model;

import java.util.Date;

public class Informacoes {
	
	private int idInformacoes;
	private int idMaquina;
	private double CPU;
	private double HDTotal;
	private double HDUtilizado;
	private double HDDisponivel;
	private double RamTotal;
	private double RamUtilizada;
	private double RamDisponivel;
	private Date Data;
	
	public Informacoes() {
		
	}
	
	public Informacoes(int idInformacoes, int idMaquina, double CPU, double HDTotal, double HDUtilizado,
			double HDDisponivel, double RamTotal, double RamUtilizada, double RamDisponivel, Date Data) {
		super();
		this.idInformacoes = idInformacoes;
		this.idMaquina = idMaquina;
		this.CPU = CPU;
		this.HDTotal = HDTotal;
		this.HDUtilizado = HDUtilizado;
		this.HDDisponivel = HDDisponivel;
		this.RamTotal = RamTotal;
		this.RamUtilizada = RamUtilizada;
		this.RamDisponivel = RamDisponivel;
		this.Data = Data;
	}
	public int getIdInformacoes() {
		return idInformacoes;
	}
	public void setIdInformacoes(int idInformacoes) {
		this.idInformacoes = idInformacoes;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public double getCPU() {
		return CPU;
	}
	public void setCPU(double cPU) {
		CPU = cPU;
	}
	public double getHDTotal() {
		return HDTotal;
	}
	public void setHDTotal(double hDTotal) {
		HDTotal = hDTotal;
	}
	public double getHDUtilizado() {
		return HDUtilizado;
	}
	public void setHDUtilizado(double hDUtilizado) {
		HDUtilizado = hDUtilizado;
	}
	public double getHDDisponivel() {
		return HDDisponivel;
	}
	public void setHDDisponivel(double hDDisponivel) {
		HDDisponivel = hDDisponivel;
	}
	public double getRamTotal() {
		return RamTotal;
	}
	public void setRamTotal(double ramTotal) {
		RamTotal = ramTotal;
	}
	public double getRamUtilizada() {
		return RamUtilizada;
	}
	public void setRamUtilizada(double ramUtilizada) {
		RamUtilizada = ramUtilizada;
	}
	public double getRamDisponivel() {
		return RamDisponivel;
	}
	public void setRamDisponivel(double ramDisponivel) {
		RamDisponivel = ramDisponivel;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(CPU);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Data == null) ? 0 : Data.hashCode());
		temp = Double.doubleToLongBits(HDDisponivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(HDTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(HDUtilizado);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(RamDisponivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(RamTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(RamUtilizada);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idInformacoes;
		result = prime * result + idMaquina;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Informacoes other = (Informacoes) obj;
		if (Double.doubleToLongBits(CPU) != Double.doubleToLongBits(other.CPU))
			return false;
		if (Data == null) {
			if (other.Data != null)
				return false;
		} else if (!Data.equals(other.Data))
			return false;
		if (Double.doubleToLongBits(HDDisponivel) != Double.doubleToLongBits(other.HDDisponivel))
			return false;
		if (Double.doubleToLongBits(HDTotal) != Double.doubleToLongBits(other.HDTotal))
			return false;
		if (Double.doubleToLongBits(HDUtilizado) != Double.doubleToLongBits(other.HDUtilizado))
			return false;
		if (Double.doubleToLongBits(RamDisponivel) != Double.doubleToLongBits(other.RamDisponivel))
			return false;
		if (Double.doubleToLongBits(RamTotal) != Double.doubleToLongBits(other.RamTotal))
			return false;
		if (Double.doubleToLongBits(RamUtilizada) != Double.doubleToLongBits(other.RamUtilizada))
			return false;
		if (idInformacoes != other.idInformacoes)
			return false;
		if (idMaquina != other.idMaquina)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Informacoes [idInformacoes=" + idInformacoes + ", idMaquina=" + idMaquina + ", CPU=" + CPU
				+ ", HDTotal=" + HDTotal + ", HDUtilizado=" + HDUtilizado + ", HDDisponivel=" + HDDisponivel
				+ ", RamTotal=" + RamTotal + ", RamUtilizada=" + RamUtilizada + ", RamDisponivel=" + RamDisponivel
				+ ", Data=" + Data + "]";
	}

}
