package Testes;


import negocio.CalculaIrpfFactory;
import negocio.Contribuinte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculaImpostoTeste {






    @BeforeEach
    public void setUp(){
    }

    @Test
    public void teste01(){
        Contribuinte c = new Contribuinte("Matheus","03146513056",25,2,new BigDecimal(6000.0),new BigDecimal(30000.0));
        assertEquals( new BigDecimal(1551.6).setScale(2,BigDecimal.ROUND_UP),CalculaIrpfFactory.getTipo(c).valorAPagar().setScale(2,BigDecimal.ROUND_UP) );
    }
    @Test
    public void teste02(){
        Contribuinte c = new Contribuinte("bianca", "031465210", new BigDecimal(3000.0), new BigDecimal(10000.0));
        assertEquals( new BigDecimal(0.00).setScale(2,BigDecimal.ROUND_UP),CalculaIrpfFactory.getTipo(c).valorAPagar().setScale(2,BigDecimal.ROUND_UP) );
    }
    @Test
    public void teste03simplificado(){
        Contribuinte c = new Contribuinte("vitor","14523658",66,6,new BigDecimal(10000.0),new BigDecimal(60000.0));
        assertEquals(new BigDecimal(7478.75),CalculaIrpfFactory.getTipo(c).valorAPagar().setScale(2,BigDecimal.ROUND_UP));
    }
    @Test
    public void teste04completo(){
        Contribuinte  c = new Contribuinte("maria", "04578258", new BigDecimal(3000.0), new BigDecimal(40000.0));
        assertEquals(new BigDecimal(4866.25),CalculaIrpfFactory.getTipo(c).valorAPagar().setScale(2,BigDecimal.ROUND_UP));

    }

}
