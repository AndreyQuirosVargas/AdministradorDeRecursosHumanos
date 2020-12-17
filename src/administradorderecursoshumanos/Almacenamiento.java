/*
 */
package administradorderecursoshumanos;

import javax.swing.JOptionPane;

public class Almacenamiento extends Proveeduria {
    enum funciones{organizacion, descarga}
    
    private funciones Funcion = funciones.organizacion;

    /**
     *@param Funcion: labores que realiza el funcionario de almacenamiento(organizacion u descarga)
     */
    public Almacenamiento(String Nombre, String Cedula, double Salario, String Area, String BodegaAsignada) {
        super(Nombre, Cedula, Salario, Area, BodegaAsignada);
        setFuncion();
    }

    public funciones getFuncion() {
        return Funcion;
    }

    public void setFuncion() {
        int respuestaEstados = JOptionPane.showOptionDialog(null, "Seleccione un estado", "Selector de estados", 0, 
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"organizacion", "descarga"}, "organizacion");
                
                respuestaEstados++;
                switch(respuestaEstados){
                    case 1:{
                        this.Funcion = funciones.organizacion;
                    break;}
                    case 2:{
                        this.Funcion = funciones.descarga;
                    break;}
                    
                    default:{this.Funcion = funciones.organizacion;}
                }
    }
    
    @Override
     public double CalcularSalario() {
        return super.getSalario();
    }
}
