/*
 */
package administradorderecursoshumanos;

public class Ventas extends Persona{
    
    private double ComisionPorVentas;
    private String ZonaAsignada;
 
    public Ventas() {}

    /**
     * @param ComisionPorVentas: comision acumulada de las ventas que haya realizado el vendedor
     * @param ZonaAsignada: territorio al que se dedica el vendedor
     */
    public Ventas(String Nombre, String Cedula, double Salario, double ComisionPorVentas, String ZonaAsignada) {
        super(Nombre, Cedula, Salario);
        this.ComisionPorVentas = ComisionPorVentas;
        this.ZonaAsignada = ZonaAsignada;
    }

    /**
     *@return ComisionPorVentas
     */
    public double getComisionPorVentas() {
        return ComisionPorVentas;
    }

    /**
     * @param ComisionPorVentas
     */
    public void setComisionPorVentas(double ComisionPorVentas) {
        this.ComisionPorVentas = ComisionPorVentas;
    }

    /**
     * @return ZonaAsignada
     */
    public String getZonaAsignada() {
        return ZonaAsignada;
    }

    /**
     * @param ZonaAsignada
     */
    public void setZonaAsignada(String ZonaAsignada) {
        this.ZonaAsignada = ZonaAsignada;
    }
    
    @Override
    public double CalcularSalario() {
        return super.getSalario()+ComisionPorVentas;
    }
    
}
