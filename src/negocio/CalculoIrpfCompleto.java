package negocio;

import java.math.BigDecimal;

public class CalculoIrpfCompleto implements CalculaIrpf {

    private Contribuinte contribuinte;

    public CalculoIrpfCompleto(Contribuinte c){
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
        BigDecimal porcentagemDesconto;
        if(contribuinte.getIdade()<65){
            if(contribuinte.getNumeroDependentes()<= 2){
                porcentagemDesconto = new BigDecimal(0.98);
            }else if(contribuinte.getNumeroDependentes()>2 && contribuinte.getNumeroDependentes()<6){
                porcentagemDesconto = new BigDecimal(0.965);
            }else{
                porcentagemDesconto = new BigDecimal(0.95);
            }
        }else{
            if(contribuinte.getNumeroDependentes()<= 2){
                porcentagemDesconto = new BigDecimal(0.97);
            }else if(contribuinte.getNumeroDependentes()>2 && contribuinte.getNumeroDependentes()<6){
                porcentagemDesconto = new BigDecimal(0.955);
            }else{
                porcentagemDesconto = new BigDecimal(0.94);
            }

        }
        return porcentagemDesconto;
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
