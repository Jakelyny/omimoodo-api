package br.com.blog.omimoodo.domain.usuario;
import br.com.blog.omimoodo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(

        @NotBlank
        String nome,
        String senha,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        String telefone,
        Boolean ativo,
        Boolean adm,
        DadosEndereco endereco) {

}
