/*
 */
package administradorderecursoshumanos;

import javax.swing.JOptionPane;

public class Agencia {
    private Persona empleados[] = new Persona[10];
    private int CantidadDeEmpleados = 0;
    private String Nombre = "";/*nombre de la agencia*/
    
    public void ContratacionDePersonal(){
        if(CantidadDeEmpleados == 10){
            JOptionPane.showMessageDialog(null, "No pueden haber mas de 10 empleados");
            return;
        }
        int puesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puesto a crear\n1)Ventas\n2)Agente de ventas\n3)Proveeduria"
                + "\n4)Almacenamiento\n5)Administracion \n6)Cancelar proceso"));
        
        Persona nueva = null;
        String nombre = "", cedula = "";
        double salario = 0;
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo trabajador");
        cedula = JOptionPane.showInputDialog("Ingrese la cedula");
        salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario"));
        switch(puesto){
            case 1:{
                double ComisionPorVentas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la comision por ventas"));
                String ZonaAsignada = JOptionPane.showInputDialog("Ingrese la zona asignada al vendedor");
                
                nueva = new Ventas(nombre, cedula, salario, ComisionPorVentas, ZonaAsignada);
                
            break;}
            
            case 2:{
                double comisionPorVentas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la comision por ventas"));
                String zonaAsignada = JOptionPane.showInputDialog("Ingrese la zona asignada al vendedor");
                String vehiculoAsignado = JOptionPane.showInputDialog("Ingrese la placa del vehiculo asignado");
                double viaticos = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de viaticos asignados"));
                
                nueva = new AgenteDeVentas(nombre, cedula, salario, comisionPorVentas, zonaAsignada, vehiculoAsignado, viaticos);
            break;}
            
            case 3:{
                String area = JOptionPane.showInputDialog("Ingrese el area asignada");
                String bodegaAsignada = JOptionPane.showInputDialog("Ingrese la bodega asignada");
                
                nueva = new Proveeduria(nombre, cedula, salario, area, bodegaAsignada);
            break;}
            
            case 4:{
                String area = JOptionPane.showInputDialog("Ingrese el area asignada");
                
                nueva = new Almacenamiento(nombre, cedula, salario, cedula, area);
            break;}
            
            case 5:{
                double exclusividad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de exclusividad"));
                
                nueva = new Administracion(nombre, cedula, salario, exclusividad);
            break;}
            
            case 6:{
                JOptionPane.showMessageDialog(null, "Regresando al menu principal");
                return;}
            default:{
                JOptionPane.showMessageDialog(null, "Regresando al menu principal", "Se ha cancelado el proceso", JOptionPane.INFORMATION_MESSAGE);
            return;}
        }
        empleados[CantidadDeEmpleados] = nueva;/*asignacion a la lista*/
        CantidadDeEmpleados++;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void AdministracionDePersonal(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula a administrar");
        
        for(int i = 0; i < CantidadDeEmpleados; i++){
            if (empleados[i] == null){return;}
            if(empleados[i].getCedula().equalsIgnoreCase(cedula)){
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(empleados[i].getNombre()+"\nQue desea administrar:\n1)Cambiar estado\n2)Calcular salario\n3)Volver"));
                switch(opcion){
                    case 1:{
                        empleados[i].setEstado();
                    break;}
                    
                    case 2:{
                        JOptionPane.showMessageDialog(null, "El salario de "+empleados[i].getNombre()+" corresponde a: "+empleados[i].CalcularSalario());
                    break;}
                    default:{JOptionPane.showMessageDialog(null, "Volviendo al menu principal");}
                }
            }
        }
    }
    
    public String CalculoLocalDePlanilla(){
        String planilla = "";
        if(empleados.length == 0){return "No hay empleados en la agencia "+Nombre+"\n\n";}
        for(int i = 0; i < CantidadDeEmpleados; i++){
            planilla += "Trabajador con cedula "+empleados[i].getCedula()+" y nombre "+empleados[i].getNombre()+" recibe un total de "+empleados[i].CalcularSalario()+" colones\n";
        }
        return planilla+"El total de la plantilla de la empresa "+Nombre+" es de "+calculoDePlanilla()+" colones mensuales\n\n";
    }
    
    public double calculoDePlanilla(){
    double total = 0;
    if(empleados.length == 0){return 0;}
        for(int i = 0; i < CantidadDeEmpleados; i++){
            if (empleados[i] == null){continue;}
            total += empleados[i].CalcularSalario();
        }
    return total;
    }
}