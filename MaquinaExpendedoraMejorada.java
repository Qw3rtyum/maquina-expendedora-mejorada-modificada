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
    // El número de billetes vendidos
    private int billetesVendidos;
    // El tipo de Máquina expendedora
    private boolean maquinaEspecial;
    // El número de billetes de la máquina
    private int numeroBilletes;
    // EL número de billetes vendidos para el premio
    private int billetesVendidosPremio;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean esEspecial, int billetesTotal) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaEspecial = esEspecial;
        numeroBilletes = billetesTotal;
        billetesVendidosPremio = 0;
    }

    /**
     * Crea una maquina expendedora con el precio,
     * origen y destino ya especificados.
     */
    public MaquinaExpendedoraMejorada(boolean esEspecial, int billetesTotal) {
        precioBillete = 50;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "León";
        estacionDestino = "Madrid";
        billetesVendidos = 0;
        maquinaEspecial = esEspecial;
        numeroBilletes = billetesTotal;
        billetesVendidosPremio = 0;
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
        if (numeroBilletes > 0) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else {
            System.out.println("Error: No es posible introducir");
            System.out.println("dinero debido a que la máquina");
            System.out.println("se ha quedado sin billetes");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if (numeroBilletes > 0) {
            numeroBilletes = numeroBilletes - 1;
            int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                if (maquinaEspecial == true) {
                    if (billetesVendidosPremio == 3) {
                        int descuento = precioBillete / 4;
                        System.out.println("# !!!ENHORABUENA!!!");
                        System.out.println("# Usted ha ganado un decuento");
                        System.out.println("# de " + (descuento) + " euros para");
                        System.out.println("# compras en McNollos");
                        billetesVendidosPremio = -1;
                    }
                }
                System.out.println("##################");
                System.out.println();
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos = billetesVendidos + 1;
                billetesVendidosPremio = billetesVendidosPremio + 1;
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                        
            }            
        }
        else {
            System.out.println("Error: No es posible imprimir");
            System.out.println("billetes debido a que la máquina");
            System.out.println("se ha quedado sin billetes");
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
     * Se vacía todo el dinero que hay en la máquina expendedora
     * (Incluyendo los dos depósitos)
     */
    public int vaciarDineroDeLaMaquina() {
        int totalAVaciar = totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0;
        }
        else {
            totalAVaciar = -1;
            System.out.println("Error: Imposible vaciar la");
            System.out.println("máquina mientras hay una");
            System.out.println("operación en curso");
        }
        return totalAVaciar;
    }
    
    /**
     * Muestra el número de billetes vendidos desde que se ha creado
     * la máquina expendedora
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    
    /**
     * Imprime el número de billetes vendidos desde que se ha creado
     * la máquina expendedora
     */
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Se han vendido " + (billetesVendidos) + " billetes");
        System.out.println("desde que se ha creado");
        System.out.println("la máquina");
    }
}
