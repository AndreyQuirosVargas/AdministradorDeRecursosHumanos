/*
 */
package administradorderecursoshumanos;

public class Proveeduria extends Persona{
    
    private String Area = "";
    private String BodegaAsignada = "";

    public Proveeduria() {
    }
    
    /**
     * @param Area: area de productos que corresponden encontrar al funcionario de proveeduria
     * @param BodegaAsignada: bodega en la que deben ser entregados los suministros que solocita a los proveedores
     */
    public Proveeduria(String Nombre, String Cedula, double Salario, String Area, String BodegaAsignada) {
        super(Nombre, Cedula, Salario);
        this.Area = Area;
        this.BodegaAsignada = BodegaAsignada;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getBodegaAsignada() {
        return BodegaAsignada;
    }

    public void setBodegaAsignada(String BodegaAsignada) {
        this.BodegaAsignada = BodegaAsignada;
    }
    
    @Override
    public double CalcularSalario() {
        return super.getSalario();
    }
}
