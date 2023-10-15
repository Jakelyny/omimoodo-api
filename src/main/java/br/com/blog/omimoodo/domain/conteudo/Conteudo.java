package br.com.blog.omimoodo.domain.conteudo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Table(name = "conteudo")
@Entity(name = "Conteudo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String texto;
    private String autor;

    private Boolean ativo;
    private String imagem;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @PrePersist
    protected void onCreate() {
        dataCriacao = new Date();
    }

    public Conteudo(DadosCadastroConteudo dados) {
        this.titulo = dados.titulo();
        this.texto = dados.texto();
        this.autor = dados.autor();
        this.ativo = true;
        this.imagem = dados.imagem();
    }

    public void atualizarInformacoes(DadosAtualizacaoConteudo dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.texto() != null) {
            this.texto = dados.texto();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.imagem() != null) {
            this.imagem = dados.imagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
