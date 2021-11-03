public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero de billetes vendidos
    private int billetesVendidos;
    // Tipo de m�quina
    private boolean maquinaConPremios;
    // N�mero m�ximo billetes
    private int numeroMaximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premios, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaConPremios = premios;
        numeroMaximoBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (billetesVendidos < numeroMaximoBilletes) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
        else {
            System.out.println("Billetes agotados. No se pueden comprar m�s billetes");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (billetesVendidos < numeroMaximoBilletes) {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                 System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println(); 
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //Incrementa en 1 los billetes vendidos
                billetesVendidos = billetesVendidos + 1;
            
                if (maquinaConPremios == true) {
                    System.out.println("Descuento de " + precioBillete * 0.10 + " euros " + "en comercio a elegir");
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
            }
        }
        else {
            System.out.println("Billetes agotados. No se pueden comprar m�s billetes");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Devuelve todo el dinero, acumulado y del cliente
     */
    public int vaciarDineroDeLaMaquina() {
        int cantidadDeDineroVaciado = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0;
        }
    
        else {
            System.out.println("No se puede vaciar el dinero, hay una operaci�n en marcha");
            System.out.println("Cancela la operaci�n y retira el dinero del cliente");
            cantidadDeDineroVaciado = -1;        
        }
        return cantidadDeDineroVaciado;
    }
    /**
     * Devuelve el numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    /**
     * Imprime el numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("N�mero de billetes vendidos: " + billetesVendidos);
    }
}
