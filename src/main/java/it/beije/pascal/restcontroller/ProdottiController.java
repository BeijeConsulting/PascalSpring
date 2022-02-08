package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Product;
import it.beije.pascal.repository.ProdottiRepository;
import it.beije.pascal.service.ProdottiService;

@RestController
@RequestMapping("api")
public class ProdottiController {

	@Autowired
	private ProdottiService prodottiService;

	@Autowired
	private ProdottiRepository prodottiRepository;
	
	
	@GetMapping(value = "/prodotti")
	public List<Product> getList(@RequestParam(value = "name", required = false) String nome) {
		System.out.println("GET prodotti");
		
		List<Product> prodotti = prodottiService.getList(nome);

		System.out.println("prodotti : " + prodotti.size());
		
		return prodotti;
	}
	
	@GetMapping(value = "/prodotto/{id}")
	public Product getDetail(@PathVariable Integer id) {
		System.out.println("GET contatto");
		
		Optional<Product> o = prodottiRepository.findById(id);
		
		return o.isPresent() ? o.get() : null;
	}
	
	@PostMapping(value = "/prodotto")
	public Product insert(@RequestBody Product prodotto) {
		System.out.println("POST contatto : " + prodotto);
		
		prodottiRepository.save(prodotto);
		
		return prodotto;
	}
	
	
//	@PutMapping(value = "/prodotto/{id}")
//	public Product insert(@RequestBody Product prodotto, @PathVariable Integer id) {
//		System.out.println("PUT contatto : " + prodotto);
//		
//		Product c = null;
//		if (prodotto.getId() != null && prodotto.getId() == id) {
//			Optional<Product> o = prodottiRepository.findById(id);
//			
//			if (o.isPresent()) {
//				c = o.get();
////				c.setCognome(contatto.getCognome());
////				c.setNome(contatto.getNome());
//				//....
//				BeanUtils.copyProperties(prodotto, c);
//				prodottiRepository.save(c);
//			} else throw new RuntimeException("id errato");
//		}		
//		
//		return c;
//	}
	
//	@DeleteMapping(value = "/prodotto/{id}")
//	public Boolean insert(@PathVariable Integer id) {
//		System.out.println("DELETE prodotto : " + id);
//		
//		Optional<Product> o = prodottiRepository.findById(id);
//			
//		if (o.isPresent()) {
//				prodottiRepository.delete(o.get());
//		} else throw new RuntimeException("id errato");
//				
//		return Boolean.TRUE;
//	}
}