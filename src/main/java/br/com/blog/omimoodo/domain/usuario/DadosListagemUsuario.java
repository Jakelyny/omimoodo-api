package br.com.blog.omimoodo.domain.usuario;


import br.com.blog.omimoodo.domain.endereco.Endereco;

public record DadosListagemUsuario(Long id, String nome, String email, String cpf, String telefone, Boolean ativo, Boolean adm, Endereco endereco) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(), usuario.getTelefone(), usuario.getAtivo(),usuario.getAdm(), usuario.getEndereco());
    }
}
