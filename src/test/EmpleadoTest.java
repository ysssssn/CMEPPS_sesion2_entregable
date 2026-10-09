package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

    private Empleado empleado = new Empleado();

    @Test
    void ventasJustoPorDebajoDe1000NoDaPrima() {
    	System.out.println("Ventas justo por debajo de 1000 no dan prima");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 999, 0);
        assertEquals(2000, resultado);
    }

    @Test
    void ventasExactamente1000DaPrimaDe100() {
        System.out.println("Ventas exactamente 1000 dan prima de 100");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000, 0);
        assertEquals(2100, resultado);
    }

    @Test
    void ventasJustoPorEncimaDe1000DaPrimaDe100() {
    	System.out.println("Ventas justo por encima de 1000 mantienen prima de 100");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1001, 0);
        assertEquals(2100, resultado);
    }

    @Test
    void ventasJustoPorDebajoDe1500MantienePrimaDe100() {
        System.out.println("Ventas justo por debajo de 1500 mantienen prima de 100");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1499, 0);
        assertEquals(2100, resultado);
    }

    @Test
    void ventasExactamente1500DaPrimaDe200() {
        System.out.println("Ventas exactamente 1500 dan prima de 200");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500, 0);
        assertEquals(2200, resultado);
    }

    @Test
    void ventasJustoPorEncimaDe1500MantienePrimaDe200() {
        System.out.println("Ventas justo por encima de 1500 mantienen prima de 200");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1501, 0);
        assertEquals(2200, resultado);
    }

    @Test
    void encargadoTieneSalarioBaseSuperior() {
        System.out.println("Encargado tiene salario base superior a vendedor");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 0, 0);
        assertEquals(2500, resultado);
    }

    @Test
    void horasExtraSePaganA30Euros() {
        System.out.println("Cada hora extra se paga a 30 euros");
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 5);
        assertEquals(2150, resultado); // 2000 + 5*30
    }

    @Test
    void nominaJustoPorDebajoDe2100SinRetencion() {
        System.out.println("Nómina justo por debajo de 2100 sin retención");
        float resultado = empleado.calculoNominaNeta(2099);
        assertEquals(2099, resultado);
    }

    @Test
    void nominaExactamente2100SinRetencion() {
        System.out.println("Nómina exactamente 2100 sin retención");
        float resultado = empleado.calculoNominaNeta(2100);
        assertEquals(2100, resultado);
    }

    @Test
    void nominaJustoPorEncimaDe2100AplicaRetencion15() {
        System.out.println("Nómina justo por encima de 2100 aplica retención del 15%");
        float resultado = empleado.calculoNominaNeta(2101);
        assertEquals(1785.85f, resultado, 0.01f);
    }

    @Test
    void nominaJustoPorDebajoDe2500MantieneRetencion15() {
        System.out.println("Nómina justo por debajo de 2500 mantiene retención del 15%");
        float resultado = empleado.calculoNominaNeta(2499);
        assertEquals(2124.15f, resultado, 0.01f);
    }

    @Test
    void nominaExactamente2500AplicaRetencion18() {
        System.out.println("Nómina exactamente 2500 aplica retención del 18%");
        float resultado = empleado.calculoNominaNeta(2500);
        assertEquals(2050, resultado);
    }

    @Test
    void nominaJustoPorEncimaDe2500MantieneRetencion18() {
        System.out.println("Nómina justo por encima de 2500 mantiene retención del 18%");
        float resultado = empleado.calculoNominaNeta(2501);
        assertEquals(2050.82f, resultado, 0.01f);
    }
}