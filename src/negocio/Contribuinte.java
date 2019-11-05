package negocio;

import java.math.BigDecimal;

public class Contribuinte {
    private String nome;
    private String CPF;
    private int idade;
    private int numeroDependentes;
    private BigDecimal contribuicaoPrevidenciariaOficial;
    private BigDecimal totalRendimentos;
    private BigDecimal valorAPagar;

    public Contribuinte (String nome, String CPF, int idade, int numeroDependentes,BigDecimal contribuicaoPrevidenciariaOficial, BigDecimal totalRendimentos){
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.numeroDependentes = numeroDependentes;
        this.contribuicaoPrevidenciariaOficial = contribuicaoPrevidenciariaOficial;
        this.totalRendimentos = totalRendimentos;

    }

    public Contribuinte(String nome, String CPF, BigDecimal contribuicaoPrevidenciariaOficial, BigDecimal totalRendimentos) {
        this.nome = nome;
        this.CPF = CPF;
        this.contribuicaoPrevidenciariaOficial = contribuicaoPrevidenciariaOficial;
        this.totalRendimentos = totalRendimentos;

    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public int getIdade() {
        return idade;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }


    public BigDecimal getContribuicaoPrevidenciariaOficial() {
        return this.contribuicaoPrevidenciariaOficial;
    }

    public BigDecimal getTotalRendimentos() {
        return this.totalRendimentos;
    }

    public void setValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public BigDecimal getValorAPagar() {
        return valorAPagar;
    }

    @Override
    public String toString() {
        return "Contribuinte" + " nome:'" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", idade=" + idade +
                ", numeroDependentes=" + numeroDependentes +
                ", totalRendimentos=" + totalRendimentos +
                '}';
    }
}
