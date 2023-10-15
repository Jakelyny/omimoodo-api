package br.com.blog.omimoodo.domain.conteudo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConteudo(
        @NotNull
        Long id,
        String titulo,
        String texto,
        String autor,
        String imagem,
        Boolean ativo
) {
}
