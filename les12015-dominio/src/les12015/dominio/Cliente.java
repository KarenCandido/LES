package les12015.dominio;

import java.sql.Timestamp;

public class Cliente extends Usuario {
    private String nome;
    private Timestamp dataNascimento;
    private String cpf;
    private String genero;
    private int ranking;
    private boolean status;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(Integer id, String email, String nome, String cpf) {
        setId(id);
        this.setEmail(email);
        this.nome = nome;
        this.cpf = cpf;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
