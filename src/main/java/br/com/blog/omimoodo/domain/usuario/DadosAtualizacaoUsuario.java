package br.com.blog.omimoodo.domain.usuario;
import br.com.blog.omimoodo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
