/*
 */
package administradorderecursoshumanos;

import javax.swing.JOptionPane;

public class AdministradorDeRecursosHumanos {
    
    Agencia Agencias[] = new Agencia[10];
    int CantidadDeAgencias = 0;
    
    
    public static void main(String[] args) {
        AdministradorDeRecursosHumanos admin = new AdministradorDeRecursosHumanos();
    }
    
    public AdministradorDeRecursosHumanos(){
        JOptionPane.showMessageDialog(null, "Bienvenido al administrador de recursos humanos", "Administrador de Recursos Humanos", JOptionPane.PLAIN_MESSAGE);
        for(;;){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese:\n1)Crear una Agencia\n2)Administrar agencias\n3)Calcular la planilla de forma global\n4)Salir"));
            switch(opcion){
                case 1:{
                    if(CantidadDeAgencias == 10){
                        JOptionPane.showMessageDialog(null, "No pueden haber mas de 10 agencias");
                        break;
                    }
                    CrearAgencia();
                break;}
                
                case 2:{
                    AdministrarAgencia();
                break;}
                
                case 3:{
                    CalculoGlobalDePlanilla();
                break;}
                
                default:{
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    System.exit(0);
                break;}
        }
        
        }
    }
    
    public void CrearAgencia(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la nueva agencia");
        Agencia nueva = new Agencia();
        nueva.setNombre(nombre);
        
        Agencias[CantidadDeAgencias] = nueva;
        CantidadDeAgencias++;
    }
    
    public void AdministrarAgencia(){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese:\n1)Ver Planilla de una agencia\n2)Cerrar agencia \n3)Contratar personas para una agencia\n4)Regresar"
                + "\n3)Contratar personal\n)Salir"));
        switch(opcion){
            case 1:{
                String nombreDeLaAgencia = JOptionPane.showInputDialog("Ingrese el nombre de la agencia para buscar");
                for(Agencia elemento:Agencias){
                    if(elemento.getNombre().equalsIgnoreCase(nombreDeLaAgencia)){
                        JOptionPane.showMessageDialog(null, elemento.CalculoLocalDePlanilla());
                    }
                }
            break;}
            
            case 2:{
                String nombreDeLaAgencia = JOptionPane.showInputDialog("Ingrese el nombre de la agencia para buscar");
                for(int i = 0; i < Agencias.length; i++){
                    if(Agencias[i].getNombre().equalsIgnoreCase(nombreDeLaAgencia)){
                        int respuesta = JOptionPane.showConfirmDialog(null, "Desea cerrar la empresa "+Agencias[i].getNombre());
                        if(respuesta == JOptionPane.YES_OPTION){
                            Agencias[i] = null;
                            Agencia sinVacios[] = new Agencia[10];
                            int elementos = 0;
                            for(int j = 0; j < Agencias.length; j++){
                                if(Agencias[j] != null){
                                    sinVacios[elementos] = Agencias[j];
                                    elementos++;
                                }
                            }
                        Agencias = sinVacios;
                        CantidadDeAgencias--;
                        }
                    }
                }
                
            break;}
            
            case 3:{
                String nombreDeLaAgencia = JOptionPane.showInputDialog("Ingrese el nombre de la agencia para buscar");
                for(Agencia elemento:Agencias){
                    if(elemento.getNombre().equalsIgnoreCase(nombreDeLaAgencia)){
                        elemento.ContratacionDePersonal();
                    }
                }
            break;}
            default:{JOptionPane.showMessageDialog(null, "Regresando al menu principal");}
        }
    }
    
    public void CalculoGlobalDePlanilla(){
        String planillas = "";
        double total = 0;
        for(Agencia elemento:Agencias){
            planillas += elemento.CalculoLocalDePlanilla()+"\n";
            total += elemento.calculoDePlanilla();
        }
        if(Agencias.length == 0){JOptionPane.showMessageDialog(null, "No hay agencias"); return;}
        JOptionPane.showMessageDialog(null, planillas+"\n\nEl total de planillas corresponde a "+total);
    }
}
