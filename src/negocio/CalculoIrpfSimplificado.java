package negocio;

import java.math.BigDecimal;

public class CalculoIrpfSimplificado implements CalculaIrpf {


    private Contribuinte contribuinte;

    public CalculoIrpfSimplificado(Contribuinte c){
        this.contribuinte = c;
    }

    @Override
    public BigDecimal baseCalculo() {
        BigDecimal auxiliarBaseImposto;
        auxiliarBaseImposto = (contribuinte.getTotalRendimentos()).subtract(contribuinte.getContribuicaoPrevidenciariaOficial());
        auxiliarBaseImposto = auxiliarBaseImposto.multiply(new BigDecimal(0.95));
        return auxiliarBaseImposto;
    }

    @Override
    public BigDecimal verificarDesconto() {
        return new BigDecimal(1.0);
    }

    @Override
    public BigDecimal valorAPagar() {
        BigDecimal valor;
        BigDecimal aux = new BigDecimal(1800.0);
        BigDecimal valorDaBase = baseCalculo().multiply(verificarDesconto());
        if(valorDaBase.compareTo(new BigDecimal(12000.0))==-1){

            valor = new BigDecimal( 0.0);
            return valor;
        }else if(valorDaBase.compareTo(new BigDecimal(12000.0))==1 && valorDaBase.compareTo(new BigDecimal(24000.0))==-1){

            valor = (valorDaBase.subtract(new BigDecimal(12000.0))).multiply(new BigDecimal(0.15));
            return valor;
        }else{

            valor = ((valorDaBase.subtract(new BigDecimal(24000.0))).multiply(new BigDecimal(0.275))).add(aux);
            return valor;
        }

    }
}
