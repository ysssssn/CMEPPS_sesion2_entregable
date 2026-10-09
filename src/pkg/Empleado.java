package pkg;

public class Empleado {

	public enum TipoEmpleado {
	    VENDEDOR,
	    ENCARGADO
	}
	
    public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
    	
    	float salarioBase;

    	if (tipo == TipoEmpleado.ENCARGADO) {
    	    salarioBase = 2500;
    	} else {
    	    salarioBase = 2000;
    	}
    	
        float prima;
        if (ventasMes >= 1500) {
            prima = 200;
        } else if (ventasMes >= 1000) {
            prima = 100;
        } else {
            prima = 0;
        }

        float pagoHorasExtra = horasExtra * 30;

        return salarioBase + prima + pagoHorasExtra;
    }

    public float calculoNominaNeta(float nominaBruta) {
        float retencion;
        if (nominaBruta <= 2100) {
            retencion = 0f;
        } else if (nominaBruta < 2500) {
            retencion = 0.15f;
        } else {
            retencion = 0.18f;
        }
        return nominaBruta * (1 - retencion);
    }
}