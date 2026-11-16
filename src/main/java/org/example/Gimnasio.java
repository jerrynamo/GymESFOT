package org.example;

import java.util.HashMap;

public class Gimnasio {
    private HashMap<String, Miembro> miembros;

    public Gimnasio() {
        miembros = new HashMap<>();
    }

    public boolean reistrarMiembros(Miembro miembro){
        if(miembros.containsKey(miembro.getCedula())){
            return false;
        }
        miembros.put(miembro.getCedula(),miembro);
        return true;
    }

    public Miembro buscar(String cedula){
        return miembros.get(cedula);
    }

    public Miembro buscar(String nombre, String apellido){
        for (Miembro m : miembros.values()){
            if(m.getNombre().equalsIgnoreCase(nombre) && m.getApellido().equalsIgnoreCase(apellido)){
                return m;
            }
        }
        return null;
    }

    public boolean reistrarAsistemancia(String cedula){
        Miembro miembro = buscar(cedula);

        if(miembro == null){
            return false;
        }

        miembro.registrarAsistencias();
        return true;
    }

    public void mostrarMiembros(){
        if(miembros.isEmpty()){
            System.out.println("No hay miembros");
            return;
        }
        for (Miembro m : miembros.values()){
            System.out.println(m);
        }

    }

    public void mostrarEstadisticas(){
        if(miembros.isEmpty()){
            System.out.println("No hay Miembros");
            return;
        }

        double ingresoTotal = 0;
        int totalAsistencias = 0;
        Miembro miembroMayor = null;

        for (Miembro m : miembros.values()){
            ingresoTotal += m.calcularCuota();
            totalAsistencias += m.getAsistencias();

            if(miembroMayor == null || m.calcularCuota() > miembroMayor.calcularCuota()){
                miembroMayor = m;
            }
        }

        double promedio = (double) totalAsistencias / miembros.size();

        System.out.println("Miembro que paga mas: "+ miembroMayor.getNombre() + " " + miembroMayor.getApellido() + " " + String.format("%.2f",miembroMayor.getCuotaBase()));
        System.out.println("Inreso mensual total: "+ ingresoTotal);
        System.out.println("Promedio de asistencias por miembro: "+ String.format("%.2f",promedio));
    }

}
