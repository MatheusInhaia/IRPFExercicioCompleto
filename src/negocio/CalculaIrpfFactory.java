package negocio;

public class CalculaIrpfFactory {


    public static CalculaIrpf getTipo(Contribuinte c) {
        if (c.getNumeroDependentes() > 0){
            return new CalculoIrpfCompleto(c);
        }else{
        return new CalculoIrpfSimplificado(c);
        }
    }

}

