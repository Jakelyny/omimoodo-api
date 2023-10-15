package br.com.blog.omimoodo.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String complemento,
        @NotBlank
        String numero,
        @NotBlank
        String uf,
        @NotBlank
        String cidade) {
}
