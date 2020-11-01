package model;

public class Maquina {
	
	private int idMaquinas;
	private String hostname;
	private String SO;
	private String descricao;
	
	public Maquina () {
		
	}
	
	public Maquina(int idMaquinas , String hostname , String SO , String descricao) {
		this.idMaquinas = idMaquinas;
		this.hostname = hostname;
		this.SO = SO;
		this.descricao = descricao;
	}
		
	
	public int getIdMaquinas() {
		return idMaquinas;
	}
	public void setIdMaquinas(int idMaquinas) {
		this.idMaquinas = idMaquinas;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SO == null) ? 0 : SO.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
		result = prime * result + idMaquinas;
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
		Maquina other = (Maquina) obj;
		if (SO == null) {
			if (other.SO != null)
				return false;
		} else if (!SO.equals(other.SO))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (hostname == null) {
			if (other.hostname != null)
				return false;
		} else if (!hostname.equals(other.hostname))
			return false;
		if (idMaquinas != other.idMaquinas)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Maquina [idMaquinas=" + idMaquinas + ", hostname=" + hostname + ", SO=" + SO + ", descricao="
				+ descricao + "]";
	}
}
