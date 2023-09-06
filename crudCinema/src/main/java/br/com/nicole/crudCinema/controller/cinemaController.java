
package br.com.nicole.crudCinema.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.nicole.crudCinema.model.Filmes;
import br.com.nicole.crudCinema.repository.FilmeRepository;

@Controller
public class cinemaController {

	@Autowired
	private FilmeRepository filmeRepository;

	@GetMapping("/admin")
	public String paginaAdm(Model model) {
		List<Filmes> filmes = filmeRepository.findAll();
		model.addAttribute("filmes", filmes);
		model.addAttribute("Nome_Site", "C I N E - A D M ");
		return "admin";
	}

	@GetMapping("/") // já joga pra pagina inicial somente com "/"
	public String paginaInicial(Model model) {
		model.addAttribute("Nome_Site", "C I N E - F R E E ");
		return "index";
	}

	@GetMapping("/cadastrarFilme")
	public String paginaAdicionarFilme(Filmes filmes) {
		return "adicionarFilme";
	}

	@PostMapping("/adicionarFilme")
	public String adicionaFilme(@Valid Filmes filmes, Errors erros, BindingResult result, Model model) {
		if (result.hasErrors() || (null != erros && erros.getErrorCount() > 0)) {
			return "adicionarFilme";
		}
		filmeRepository.save(filmes);
		return "redirect:/admin";
	}

	@GetMapping("/editar/{id}")
	public String paginaAtualizarFilme(@PathVariable("id") long id, Model model) {

		model.addAttribute("Nome_Site", "C I N E - F R E E ");
		Filmes filmes = filmeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador do filme é inválido" + id));

		model.addAttribute("filmes", filmes);
		return "editarFilme";
	}

	@PostMapping("/atualizar/{id}")
	public String atualizarFilme(@PathVariable("id") long id, @Valid Filmes filme, BindingResult result, Model model) {
		if (result.hasErrors()) {
			filme.setId(id);
			return "editarFilme";
		}
		filmeRepository.save(filme);
		return "redirect:/admin";
	}

	@GetMapping("/delete/{id}")
	public String deletarFilme(@PathVariable("id") long id, Model model) {
		Filmes filme = filmeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador do filme inválido" + id));
		filmeRepository.delete(filme);
		return "redirect:/admin";
	}

	@GetMapping("/filmes_cartas") // GetMapping
	public String listarFilmes(Model model) {
		List<Filmes> filmes = filmeRepository.findAll();
		model.addAttribute("Nome_Site", "C I N E - F R E E ");
		model.addAttribute("filmes", filmes);
		
		return "filmes_cartas";
	}

	@GetMapping("/sugestoes")
	public String susgetoesFilmes(Model model) {
		model.addAttribute("Nome_Site", "C I N E - F R E E ");
		return "sugestoes";
	}

}
