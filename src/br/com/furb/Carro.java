package br.com.furb;
public class Carro {

	private int qtdMotor;
	private int qtdAno;
	private int qtdKm;
	private int qtdValor;
	private int qtdCombustivel;

	/**
	 * Construtor padrão
	 */
	public Carro(){}
	
	/**
	 * Construtor com todos os atributos
	 * @param qtdMotor
	 * @param qtdAno
	 * @param qtdKm
	 * @param qtdValor
	 * @param qtdCombustivel
	 */
	public Carro(int qtdMotor, int qtdAno, int qtdKm, int qtdValor, int qtdCombustivel) {
		this.qtdMotor = qtdMotor;
		this.qtdAno = qtdAno;
		this.qtdKm = qtdKm;
		this.qtdValor = qtdValor;
		this.qtdCombustivel = qtdCombustivel;
	}

	@Override
	public String toString() {
		return "dados analisados \n"
				+ "Motor:       " + this.getQtdMotor() + "\n"
				+ "Ano:         " + this.getQtdAno() + "\n"
				+ "Valor:       " + this.getQtdValor() + "\n"
				+ "KM:          " + this.getQtdKm() + "\n"
				+ "Combustível: " + this.getQtdCombustivel();
	}

	public int getQtdMotor() {
		return qtdMotor;
	}
	
	public int getQtdCombustivel() {
		return qtdCombustivel;
	}

	public int getQtdAno() {
		return qtdAno;
	}
	
	public int getQtdKm() {
		return qtdKm;
	}
	
	public int getQtdValor() {
		return qtdValor;
	}

	public void addQtdAno() {
		this.qtdAno++;
	}
	
	public void addQtdValor() {
		this.qtdValor++;
	}
	
	public void addQtdKm() {
		this.qtdKm++;
	}
	
	public void addQtdMotor() {
		this.qtdMotor++;
	}
	
	public void addQtdCombustivel() {
		this.qtdCombustivel++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qtdAno;
		result = prime * result + qtdCombustivel;
		result = prime * result + qtdKm;
		result = prime * result + qtdMotor;
		result = prime * result + qtdValor;
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
		Carro other = (Carro) obj;
		if (qtdAno != other.qtdAno)
			return false;
		if (qtdCombustivel != other.qtdCombustivel)
			return false;
		if (qtdKm != other.qtdKm)
			return false;
		if (qtdMotor != other.qtdMotor)
			return false;
		if (qtdValor != other.qtdValor)
			return false;
		return true;
	}
	
}