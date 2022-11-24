public class Centralita {

    private int contador;
    private double acumulado1;
    private double acumulado2;
    private double acumuladoTotal;

    public int getTotalLlamadas(){
        return contador;
    }

    public double getTotalFacturado(){
        acumuladoTotal = acumulado1 + acumulado2;
        return acumuladoTotal;
    }

    public double registrarLlamadaLocal(LlamadaLocal param){
        contador += 1;
        acumulado1 += param.costeLlamadaLocal();
        return acumulado1;
    }

    public double registrarLlamadaProvincial(LlamadaProvincial param){
        contador += 1;
        acumulado2 = param.costeLlamadaP1() + param.costeLlamadaP2() + param.costeLlamadaP3();
        return acumulado2;
    }

    public void imprimirTotalFacturado(){
        System.out.println("\n==============================");
        System.out.println("El total facturado en llamadas es: " + getTotalFacturado());
        System.out.println("El total de llamadas facturadas es: " + getTotalLlamadas());
    }
}
class Llamada {

    private int numQueLlama;
    private int numDestino;
    private int segundosLlamada = 0;

    public Llamada(){
    }

    public Llamada(int numQueLlama, int numDestino, int segundosLlamada){
        this.numQueLlama = numQueLlama;
        this.numDestino = numDestino;
        this.segundosLlamada = segundosLlamada;
    }

    public void setNumQueLlama(int numQueLlama){
        this.numQueLlama = numQueLlama;
    }

    public void setNumDestino(int numDestino){
        this.numDestino = numDestino;
    }

    public void setSegundosLlamada(int segundosLlamada){
        this.segundosLlamada = segundosLlamada;
    }

    public int getNumQueLlama(){
        return numQueLlama;
    }

    public int getNumDestino(){
        return numDestino;
    }

    public int getSegundosLlamada(){
        return segundosLlamada;
    }

    public void imprimirNumOrigen(){
        System.out.println("\nEl numero que llama es: " + getNumQueLlama());
    }

    public void imprimirNumDestino(){
        System.out.println("El numero al que se llama es: " + getNumDestino());
    }

    public void imprimirDuracionSegundos(){

        System.out.println("La duracion en segundos de la llamada ha sido de: " + getSegundosLlamada()+" segundos");
    }

}
class LlamadaLocal extends Llamada{

    private double costeLocal = 0.15;

    public LlamadaLocal(){
    }

    public LlamadaLocal(int numQueLlama, int numDestino, int segundosLlamada){
        super(numQueLlama, numDestino, segundosLlamada);
    }

    public double costeLlamadaLocal(){
        return (costeLocal * super.getSegundosLlamada());
    }

    public void imprimirCosteLlamadaLx(){
        System.out.println("El coste total de la llamda local es: " + costeLlamadaLocal());
    }

}
class LlamadaProvincial extends Llamada{

    private double costeProvincial1 = 0.20; // banda 1
    private double costeProvincial2 = 0.25;// banda 2
    private double costeProvincial3 = 0.30;// banda 3
    private int franja = 0;

    public LlamadaProvincial(int numQueLlama, int numDestino, int segundosLlamada, int franja){
        super(numQueLlama, numDestino, segundosLlamada);
        this.franja = franja;
    }
    public double costeLlamadaP1(){
        return(costeProvincial1 * super.getSegundosLlamada());
    }

    public double costeLlamadaP2(){
        return(costeProvincial2 * super.getSegundosLlamada());
    }

    public double costeLlamadaP3(){
        return(costeProvincial3 * super.getSegundosLlamada());
    }

    public void imprimirCosteLlamadaPx(){
        switch (franja){
            case 1: System.out.println("El coste total de la llamada provincial franja 1 es: " + costeLlamadaP1());
                break;
            case 2: System.out.println("El coste total de la llamada provincial franja 2 es: " + costeLlamadaP2());
                break;
            case 3: System.out.println("El coste total de la llamada provincial franja 3 es: " + costeLlamadaP3());
                break;
            default: System.out.println("No se introdujeron llamadas provinciales");
                break;
        }
    }
}
class Actividad4 {

    public static void main(String[] args) {

        Centralita c = new Centralita();
        LlamadaLocal l1 = new LlamadaLocal (976776917, 976481651, 43);
        LlamadaLocal l2 = new LlamadaLocal (976501641, 976125464, 93);
        LlamadaProvincial p1 = new LlamadaProvincial (688124321, 976838781, 32, 1);
        LlamadaProvincial p2 = new LlamadaProvincial (622233434, 976830865, 54, 3);




        c.registrarLlamadaLocal(l1);
        c.registrarLlamadaLocal(l2);
        c.registrarLlamadaProvincial(p1);
        c.registrarLlamadaProvincial(p2);
        l1.imprimirNumOrigen();
        l1.imprimirNumDestino();
        l1.imprimirDuracionSegundos();
        l1.imprimirCosteLlamadaLx();
        l2.imprimirNumOrigen();
        l2.imprimirNumDestino();
        l2.imprimirDuracionSegundos();
        l2.imprimirCosteLlamadaLx();
        p1.imprimirNumOrigen();
        p1.imprimirNumDestino();
        p1.imprimirDuracionSegundos();
        p1.imprimirCosteLlamadaPx();
        p2.imprimirNumOrigen();
        p2.imprimirNumDestino();
        p2.imprimirDuracionSegundos();
        p2.imprimirCosteLlamadaPx();
        c.imprimirTotalFacturado();


    }

}
