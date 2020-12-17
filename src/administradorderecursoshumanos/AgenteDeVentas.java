/*
 */
package administradorderecursoshumanos;

public class AgenteDeVentas extends Ventas {
    
    private String VehiculoAsignado = "";
    private double Viaticos;

    /**
     * @param VehiculoAsignado: placa o identificador del vehiculo que se le asigna al agente de ventas
     * @param Viaticos: monto economico para gastos de la gira
     */
    public AgenteDeVentas(String Nombre, String Cedula, double Salario, double ComisionPorVentas, String ZonaAsignada, String VehiculoAsignado, double Viaticos) {
        super(Nombre, Cedula, Salario, ComisionPorVentas, ZonaAsignada);
        this.VehiculoAsignado = VehiculoAsignado;
        this.Viaticos = Viaticos;
    }

    public String getVehiculoAsignado() {
        return VehiculoAsignado;
    }

    public void setVehiculoAsignado(String VehiculoAsignado) {
        this.VehiculoAsignado = VehiculoAsignado;
    }

    public double getViaticos() {
        return Viaticos;
    }

    public void setViaticos(double Viaticos) {
        this.Viaticos = Viaticos;
    }
    
    @Override
    public double CalcularSalario(){
    return super.getSalario()+super.getComisionPorVentas()+Viaticos;
    }
}
