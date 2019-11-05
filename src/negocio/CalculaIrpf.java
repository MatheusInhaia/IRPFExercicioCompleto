package negocio;

import java.math.BigDecimal;

public interface CalculaIrpf {
    BigDecimal baseCalculo();
    BigDecimal verificarDesconto();
    BigDecimal valorAPagar();
}
