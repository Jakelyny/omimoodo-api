package br.com.blog.omimoodo.controller;
import br.com.blog.omimoodo.domain.conteudo.*;
import br.com.blog.omimoodo.domain.conteudo.Conteudo;
import br.com.blog.omimoodo.domain.conteudo.ConteudoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("conteudo")
public class ConteudoController {

    @Autowired
    private ConteudoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConteudo dados, UriComponentsBuilder uriBuilder) {
        var conteudo = new Conteudo(dados);
        repository.save(conteudo);
        var uri = uriBuilder.path("conteudo/{id}").buildAndExpand(conteudo.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConteudo(conteudo));
    }

    @GetMapping
    public ResponseEntity<Page<Conteudo>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConteudo dados) {
        var conteudo = repository.getReferenceById(dados.id());
        conteudo.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConteudo(conteudo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var conteudo = repository.getReferenceById(id);
        conteudo.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var conteudo = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoConteudo(conteudo));
    }

}