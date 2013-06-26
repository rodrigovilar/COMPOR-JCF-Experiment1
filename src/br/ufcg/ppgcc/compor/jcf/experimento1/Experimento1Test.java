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
		FontePagadora fonte1 = criarFontePagadoraPadrao1();
		FontePagadora fonte2 = criarFontePagadoraPadrao2();
		
		fachada.criarNovaDeclaracao(criarDeclaracaoPadrao());
		fachada.criarFontePagadora(fonte1);
		fachada.criarFontePagadora(fonte2);
		List<FontePagadora> fontes = fachada.listarFontesPagadoras();

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
	public void calculoImpostoIsento() {
		//15000
		//pago 100
		
		//assert que o total final  -100,00
		//assert que o total a pagar 0
		//assert que o total pago 100
	}
	
	@Test
	public void calculoImpostoFaixa2() {
		//22500
		//pago 150
		
		//assert que o total final 64,10
		//assert que o total a pagar 214,10
		//assert que o total pago 150
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
		FontePagadora fonte = new FontePagadora();
		fonte.setNome("UFCG");
		fonte.setCpfCnpj("000.000.000/0000-00");
		fonte.setRendimentoRecebidos(50000);
		fonte.setContribuicaoPrevidenciariaOficial(5000);
		fonte.setImpostoRetidoNaFonte(8000);
		fonte.setDecimoTerceiroSalario(5000);
		return fonte;
	}
	
	private FontePagadora criarFontePagadoraPadrao2() {
		FontePagadora fonte = new FontePagadora();
		fonte.setNome("UFPB");
		fonte.setCpfCnpj("000.000.000/0000-00");
		fonte.setRendimentoRecebidos(20000);
		fonte.setContribuicaoPrevidenciariaOficial(2000);
		fonte.setImpostoRetidoNaFonte(900);
		fonte.setDecimoTerceiroSalario(2000);
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
