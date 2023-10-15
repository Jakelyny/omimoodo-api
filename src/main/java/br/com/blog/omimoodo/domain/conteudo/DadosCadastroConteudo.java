package br.com.blog.omimoodo.domain.conteudo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConteudo(

        @NotBlank
        String titulo,
        @NotBlank
        String texto,
        @NotBlank
        String autor,
        Boolean ativo,
        // permite que salve quando for null ou tiver no começo https ou http e no fim formado de imagem
        @Pattern(regexp = "^(http|https)://.*\\.(jpg|jpeg|png|gif|bmp|svg)$|^$")
        String imagem) {

}
