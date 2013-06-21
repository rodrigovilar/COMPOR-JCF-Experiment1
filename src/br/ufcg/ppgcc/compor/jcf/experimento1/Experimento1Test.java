package br.ufcg.ppgcc.compor.jcf.experimento1;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Experimento1Test {

	private FachadaExperimento fachada;

	@Before
	public void iniciar() {
		fachada = new FachadaExperimento();
	}
	
	@Test
	public void novaDeclaracao() {
		Declaracao declaracao = criarDeclaracaoMinima();
		verificaCriacaoDeclaracao(declaracao); 
	}


	@Test
	public void declaracaoCompleta() {
		Declaracao declaracao = criarDeclaracaoPadrao();		
		verificaCriacaoDeclaracao(declaracao); 
	}

	@Test
	public void novaFontePagadora() {
		FontePagadora fonte = criarFontePagadoraPadrao1();
		
		fachada.criarNovaDeclaracao(criarDeclaracaoPadrao());
		fachada.criarFontePagadora(fonte);
		List<FontePagadora> fontes = fachada.listarFontesPagadoras();

		assertEquals(1, fontes.size());
		assertEquals(fonte, fontes.get(0));		
	}

	@Test
	public void duasFontesPagadorasEmUmaDeclaracao() {
		
	}

	@Test
	public void duasDeclaracoes() {
		
	}

	@Test
	public void duasFontesPagadorasUmaEmCadaDeclaracao() {
		
	}

	@Test
	public void calculoImpostoIsento() {
		//9000

		//assert que o a pagar é 0
		//assert que o total é 0
		//assert que o total pago é 0
	}

	@Test
	public void calculoImpostoFaixa1() {
		//22500
		//pago 100
		
		//assert que o a pagar é 114,10
		//assert que o total é 214,10
		//assert que o total pago é 100
	}

	
	private FontePagadora criarFontePagadoraPadrao1() {
		FontePagadora fonte = new FontePagadora();
		fonte.setNome("UFCG");
		fonte.setCpfCnpj("000.000.000/0000-00");
		fonte.setRendimentoRecebidos(50000);
		fonte.setContribuicaoPrevidenciariaOficial(5000);
		fonte.setImpostoRetidoNaFonte(8000);
		fonte.setDecimoTerceiroSalario(5000);
		return fonte;
	}

	private Declaracao criarDeclaracaoMinima() {
		Declaracao declaracao = new Declaracao();
		declaracao.setNome("Jose");
		declaracao.setCpf("000.000.000-00");
		return declaracao;
	}
	
	private Declaracao criarDeclaracaoPadrao() {
		Declaracao declaracao = criarDeclaracaoMinima();
		declaracao.setDataNascimento(Calendar.getInstance());
		declaracao.setTituloEleitoral("000");
		declaracao.setEndereco(criarEnderecoPadrao());
		declaracao.setNaturezaOcupacao(10);
		declaracao.setOcupacaoPrincipal(100);
		return declaracao;
	}

	private void verificaCriacaoDeclaracao(Declaracao declaracao) {
		fachada.criarNovaDeclaracao(declaracao);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		
		assertEquals(1, declaracoes.size());
		assertEquals(declaracao, declaracoes.get(0));
	}

	private Endereco criarEnderecoPadrao() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Log");
		endereco.setNumero(0);
		endereco.setComplemento("A");
		endereco.setBairro("Bai");
		endereco.setMunicipio("Mun");
		endereco.setEstado("Est");
		endereco.setCEP("00000-000");
		return endereco;
	}

}
