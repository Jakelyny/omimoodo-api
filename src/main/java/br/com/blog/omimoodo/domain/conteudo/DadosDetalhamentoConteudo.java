package br.com.blog.omimoodo.domain.conteudo;

public record DadosDetalhamentoConteudo(Long id, String titulo, String texto, String autor, String imagem) {

    public DadosDetalhamentoConteudo(Conteudo conteudo) {
        this(conteudo.getId(), conteudo.getTitulo(), conteudo.getTexto(), conteudo.getAutor(), conteudo.getImagem());
    }
}
