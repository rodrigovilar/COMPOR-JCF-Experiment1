package br.ufcg.ppgcc.compor.jcf.experimento1;

public class FontePagadora {

	private String nome;
	private String cpfCnpj;
	private double rendimentoRecebidos;
	private double contribuicaoPrevidenciariaOficial;
	private double impostoRetidoNaFonte;
	private double decimoTerceiroSalario;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDecimoTerceiroSalario() {
		return decimoTerceiroSalario;
	}
	
	public void setDecimoTerceiroSalario(double decimoTerceiroSalario) {
		this.decimoTerceiroSalario = decimoTerceiroSalario;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public double getRendimentoRecebidos() {
		return rendimentoRecebidos;
	}

	public void setRendimentoRecebidos(double rendimentoRecebidos) {
		this.rendimentoRecebidos = rendimentoRecebidos;
	}

	public double getContribuicaoPrevidenciariaOficial() {
		return contribuicaoPrevidenciariaOficial;
	}

	public void setContribuicaoPrevidenciariaOficial(
			double contribuicaoPrevidenciariaOficial) {
		this.contribuicaoPrevidenciariaOficial = contribuicaoPrevidenciariaOficial;
	}

	public double getImpostoRetidoNaFonte() {
		return impostoRetidoNaFonte;
	}

	public void setImpostoRetidoNaFonte(double impostoRetidoNaFonte) {
		this.impostoRetidoNaFonte = impostoRetidoNaFonte;
	}

}
