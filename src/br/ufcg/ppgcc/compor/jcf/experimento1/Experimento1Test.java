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
		Declaracao declaracaoSalva = salvarDeclaracaoComUmaFonte(fonte);
		List<FontePagadora> fontes = declaracaoSalva.getFontes();

		assertEquals(1, fontes.size());
		assertEquals(fonte, fontes.get(0));		
	}

	private Declaracao salvarDeclaracaoComUmaFonte(FontePagadora fonte) {
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);
		fachada.criarFontePagadora(declaracao, fonte);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		Declaracao declaracaoSalva = declaracoes.get(0);
		return declaracaoSalva;
	}

	@Test
	public void duasFontesPagadorasEmUmaDeclaracao() {
		FontePagadora fonte1 = criarFontePagadoraPadrao1();
		FontePagadora fonte2 = criarFontePagadoraPadrao2();
		
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);
		fachada.criarFontePagadora(declaracao, fonte1);
		fachada.criarFontePagadora(declaracao, fonte2);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		List<FontePagadora> fontes = declaracoes.get(0).getFontes();

		assertEquals(2, fontes.size());
		assertEquals(fonte1, fontes.get(0));
		assertEquals(fonte2, fontes.get(0));
	}

	@Test
	public void duasDeclaracoes() {
		Declaracao declaracao1 = criarDeclaracaoPadrao();
		Declaracao declaracao2 = criarDeclaracaoMinima();
		
		fachada.criarNovaDeclaracao(declaracao1);
		fachada.criarNovaDeclaracao(declaracao2);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		
		assertEquals(2, declaracoes.size());
		assertEquals(declaracao1, declaracoes.get(0));
		assertEquals(declaracao2, declaracoes.get(1));
	}

	@Test
	public void duasFontesPagadorasUmaEmCadaDeclaracao() {
		Declaracao declaracao1 = criarDeclaracaoPadrao();
		Declaracao declaracao2 = criarDeclaracaoMinima();
		
		fachada.criarNovaDeclaracao(declaracao1);
		fachada.criarNovaDeclaracao(declaracao2);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		
		assertEquals(2, declaracoes.size());
		assertEquals(declaracao1, declaracoes.get(0));
		assertEquals(declaracao2, declaracoes.get(1));

	}

	@Test
	public void calculoImpostoIsento1() {
		FontePagadora fonte = criarFontePagadoraPadrao(15000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		
		assertEquals(declaracao.getImpostoDevido(), 0, 0.01);
	}

	@Test
	public void calculoImpostoIsento2() {
		FontePagadora fonte = criarFontePagadoraPadrao(15000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		
		assertEquals(declaracao.getImpostoDevido(), 0, 0.01);
	}

	@Test
	public void calculoImpostoFaixa2_1() {
		FontePagadora fonte = criarFontePagadoraPadrao(24000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		
		assertEquals(declaracao.getImpostoDevido(), 326.60, 0.01);
	}

	@Test
	public void calculoImpostoFaixa2_2() {
		FontePagadora fonte = criarFontePagadoraPadrao(24000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		
		assertEquals(declaracao.getImpostoDevido(), 326.60, 0.01);
	}

	@Test
	public void calculoImpostoFaixa2_3() {
		FontePagadora fonte = criarFontePagadoraPadrao(24000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		
		assertEquals(declaracao.getImpostoDevido(), 326.60, 0.01);
	}

	@Test
	public void calculoImpostoFaixa3() {
		//35000
		//pago 200
		
		//assert que o total final  1368,45
		//assert que o total a pagar 1568,45
		//assert que o total pago 200
	}
	
	@Test
	public void calculoImpostoFaixa4() {
		//45000
		//pago 250
		
		//assert que o total final  3249,21
		//assert que o total a pagar 3499,21
		//assert que o total pago 250
	}
	
	@Test
	public void calculoImpostoFaixa5() {
		//55000
		//pago 300
		
		//assert que o total final  5746,62
		//assert que o total a pagar 6046,62
		//assert que o total pago 300
	}

	
	private FontePagadora criarFontePagadoraPadrao1() {
		return criarFontePagadoraPadrao(50000);
	}

	private FontePagadora criarFontePagadoraPadrao(int rendimentoRecebidos) {
		FontePagadora fonte = new FontePagadora();
		fonte.setNome("UFCG");
		fonte.setCpfCnpj("000.000.000/0000-00");
		fonte.setRendimentoRecebidos(rendimentoRecebidos);
		return fonte;
	}
	
	private FontePagadora criarFontePagadoraPadrao2() {
		FontePagadora fonte = new FontePagadora();
		fonte.setNome("UFPB");
		fonte.setCpfCnpj("000.000.000/0000-00");
		fonte.setRendimentoRecebidos(20000);
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
