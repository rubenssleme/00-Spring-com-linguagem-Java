package br.com.petz.parceirosapi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.petz.parceirosapi.entity.Categoria;
import br.com.petz.parceirosapi.entity.Cliente;
import br.com.petz.parceirosapi.entity.Parceiro;
import br.com.petz.parceirosapi.entity.Pedido;
import br.com.petz.parceirosapi.entity.Produto;
import br.com.petz.parceirosapi.entity.enums.PedidoStatus;
import br.com.petz.parceirosapi.repository.CategoriaRepository;
import br.com.petz.parceirosapi.repository.ClienteRepository;
import br.com.petz.parceirosapi.repository.ParceiroRepository;
import br.com.petz.parceirosapi.repository.PedidoRepository;
import br.com.petz.parceirosapi.repository.ProdutoRepository;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepositorio;
	@Autowired
	private ParceiroRepository parceiroRepositorio;
	@Autowired
	private PedidoRepository pedidoRepositorio;
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	@Autowired
	private ProdutoRepository produtoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Farmacia");
		Categoria cat3 = new Categoria(null, "Higiene E Beleza");
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto p1 = new Produto(null, "Ração Golden: Especificações", "Farinha de vísceras de frango, farinha de carne, milho integral moído, quirera de arroz gordura de frango, farelo de arroz", 90.5, "https://staticpetz.stoom.com.br/fotos/1512153979370.jpg");
		Produto p2 = new Produto(null, "Shampoo Cloresten Agener União", "Cada 100 ml contem Nitrato de miconazol 2,53 g, Gluconato de clorexidine (solução a 20%) 10 ml, Essência herbal 0,20 g, Veículo q.s.p 100 ml.", 86.0, "https://staticpetz.stoom.com.br/fotos/1512153979370.jpg");
		Produto p3 = new Produto(null, "Luva Removedora de Pelos Chalesco Clean Glove para Cães", "A luva ajuda a reduzir a queda de pelos para manter a casa mais limpa. Perfeito para cães e gatos de pelo longo ou curto, os pelos ficarão na luva, tornando a limpeza mais fácil.", 50.99, "https://staticpetz.stoom.com.br/fotos/1512153979370.jpg");
		Produto p4 = new Produto(null, "Cetoconazol Spray Ibasa 2% Para Cães", "Cada 100ml contém: 2,0g de cetoconazol e 100ml de veículo q.s.p..", 47.0, "https://staticpetz.stoom.com.br/fotos/1512153979370.jpg");
		Produto p5 = new Produto(null, "Lenços Umedecidos Chalesco para Cães 80un", "Aqua qb para 100%, PEG-7 Cocoato de Glicerilo 0,50%,.", 24.99, "https://staticpetz.stoom.com.br/fotos/1512153979370.jpg");
		produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		Cliente u1 = new Cliente("nome","14286444492", "email","senha","rua","cidade","bairro","cep","estado");
		Cliente u2 = new Cliente("nome2","14386444592","email","senha2","rua2","cidade2","bairro2","cep2","estado2");
		clienteRepositorio.saveAll(Arrays.asList(u1, u2));
		
		Parceiro par1 = new Parceiro("PetZonaSul","14286444492", "email","senha","rua","cidade","bairro","cep","estado");
		Parceiro par2 = new Parceiro("PetZonaSul2","14286444492", "email2","senha","rua2","cidade","bairro","cep2","estado");
		Parceiro par3 = new Parceiro("PetZonaNorte","14386444592","email","senha2","rua2","cidade2","bairro2","cep2","estado");
		Parceiro par4 = new Parceiro("PetZonaOeste","14486444492", "email","senha","rua","cidade","bairro","cep","estado");
		Parceiro par5 = new Parceiro("PetZonaLeste","14286444492", "email2","senha","rua2","cidade","bairro","cep2","estado");
		Parceiro par6 = new Parceiro("PetZonaNorte2","14386444592","emailnorte2","senha2","ruanorte2","cidade2","bairronorte2","cep2","estado");
		parceiroRepositorio.saveAll(Arrays.asList(par1,par2,par3,par4,par5,par6));

		Pedido pe1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido pe2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ENTREGUE, u2);
		Pedido pe3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENVIADO, u1);
		pedidoRepositorio.saveAll(Arrays.asList(pe1, pe2, pe3));

	}
}
