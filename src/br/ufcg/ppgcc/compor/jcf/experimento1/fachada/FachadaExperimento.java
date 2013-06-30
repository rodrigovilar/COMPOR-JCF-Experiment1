package br.ufcg.ppgcc.compor.jcf.experimento1.fachada;

import java.util.List;

import br.ufcg.ppgcc.compor.jcf.simple.ComporFacade;


public class FachadaExperimento extends ComporFacade {

	
	@Override
	protected void addComponents() {
	}
	
	public void criarNovaDeclaracao(Declaracao declaracao) {
	}

	public List<Declaracao> listarDeclaracoes() {
		return null;
	}

	public void criarFontePagadora(Declaracao declaracao, FontePagadora fonte) {
	}

	public RelatorioCompleto relatorioCompleto(Declaracao declaracao) {
		return null;
	}

	public void criarDependente(Declaracao declaracao, Dependente dependente) {
	}

	public List<FontePagadora> listarFontes(Declaracao declaracao) {
		return null;
	}

	public List<Dependente> listarDependentes(Declaracao declaracao) {
		return null;
	}

}
