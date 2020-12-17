/*
 */
package administradorderecursoshumanos;

public class Administracion extends Persona{
    private double Exclusividad = 0;
    
    /**
     *@param Exclusividad: pago extra que obliga al administrador a trabajar exclusivamente para la empresa
     */
    public Administracion(String Nombre, String Cedula, double Salario, double Exclusividad) {
        super(Nombre, Cedula, Salario);
        this.Exclusividad = Exclusividad;
    }

    public double getExclusividad() {
        return Exclusividad;
    }

    public void setExclusividad(double Exclusividad) {
        this.Exclusividad = Exclusividad;
    }
    
    @Override
    public double CalcularSalario() {
        return super.getSalario()+Exclusividad;
    }
}
