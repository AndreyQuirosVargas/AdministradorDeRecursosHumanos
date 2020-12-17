/*
 */
package administradorderecursoshumanos;

import javax.swing.JOptionPane;

public abstract  class Persona {
    enum estados{activo, vacaciones, incapacidad, despedido}
    
    private String Nombre ="";
    private String Cedula = "";
    private estados Estado = estados.activo;
    private double Salario = 0;

    public Persona() {}/*metodo vacio*/
    
    /**
     * @param Nombre
     * @param Cedula: identificacion de la persona
     * @param Estado: relacion que mantiene la persona con la empresa(activo, vacaciones, incapacidad despedido)
     */
    public Persona(String Nombre, String Cedula, double Salario) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        setEstado();
        this.Salario = Salario;
    }
    
    /**
     *@return Nombre
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     *@param Nombre de la persona
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Cedula
     */
    public String getCedula() {
        return Cedula;
    }
    
    /**
     *@param Cedula
     */
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    
    /**
     *@return Estado
     */
    public estados getEstado() {
        return Estado;
    }

    /**
     * @param Estado
     */
    public void setEstado() {
        int respuestaEstados = JOptionPane.showOptionDialog(null, "Seleccione un estado", "Selector de estados", 0, 
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"activo", "vacaciones", "incapacidad", "despedido"}, "Activo");
                
                respuestaEstados++;
                switch(respuestaEstados){
                    case 1:{
                        this.Estado = Persona.estados.activo;
                    break;}
                    case 2:{
                        this.Estado = Persona.estados.vacaciones;
                    break;}
                    case 3:{
                        this.Estado = Persona.estados.incapacidad;
                    break;}
                    case 4:{
                        this.Estado = Persona.estados.despedido;
                    break;}
                    default:{this.Estado = Persona.estados.activo;}
                }
    }

    /**
     * @return Salario
     */
    public double getSalario() {
        return Salario;
    }

    /**
     * @param Salario
     */
    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
    public abstract double CalcularSalario();
    
}
