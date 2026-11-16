package org.example;

import java.security.Guard;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Gimnasio gimnasio = new Gimnasio();

    public static void main(String[] args) {
        int opcion = 0;
        do{
            System.out.print("--- MENÚ GYMESFOT ---\n" +
                    "1. Registrar miembro básico\n" +
                    "2. Registrar miembro premium\n" +
                    "3. Registrar asistencia\n" +
                    "4. Buscar miembro\n" +
                    "5. Mostrar miembros\n" +
                    "6. Mostrar estadísticas\n" +
                    "7. Salir\n" +
                    "Ingrese opción: ");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    registrarBasico();
                    break;
                case 2:
                    registrarPremiun();
                    break;
                case 3:
                    registrarAsistencia();
                    break;
                case 4:
                    buscarMiembro();
                    break;
                case 5:
                    gimnasio.mostrarMiembros();
                    break;
                case 6:
                    gimnasio.mostrarEstadisticas();
                    break;
                case 7:
                    System.out.println("Saliedo.....");
                    break;
                default:
                    System.out.println("Error: Opcion invlida");
            }


        }while(opcion != 7);
    }

    public static void registrarBasico(){
        System.out.println(" - Registrar miembro básico - ");
        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        if(gimnasio.buscar(cedula) !=null){
            System.out.println("La cedula ya esta registrada.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Cuota base: ");
        double cuota = sc.nextDouble();
        sc.nextLine();

        if(cuota < 0 ){
            System.out.println("La cuota no puede ser negativa");
            return;
        }

        MiembroBasico miembro = new MiembroBasico(cedula,nombre,apellido,cuota);

        if(gimnasio.reistrarMiembros(miembro)){
            System.out.println("Miembro reistrado");
        }else {
            System.out.println("La cedula ya esta registrada");
        }
    }
    public static void registrarPremiun(){
        System.out.println(" - Registrar miembro premium - ");
        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        if(gimnasio.buscar(cedula) != null){
            System.out.println("La cedula esta registrada");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Cuota base: ");
        double cuota = sc.nextDouble();

        System.out.print("Sesiones con entrenador: ");
        int sesiones = sc.nextInt();
        sc.nextLine();

        if(cuota < 0 || sesiones < 0){
            System.out.println("LA CUOTA O SESIONES NO PUEDE SER NEATIVAS");
            return;
        }

        MiembroPremium miembro = new MiembroPremium(cedula,nombre,apellido,cuota,sesiones);

        if(gimnasio.reistrarMiembros(miembro)){
            System.out.println("Miembro premium registrado");
        }else{
            System.out.println("La cedula ya esta registrada");
        }
    }
    public static void registrarAsistencia(){
        System.out.println("Cedula: ");
        String cedula = sc.nextLine();

        if(gimnasio.reistrarAsistemancia(cedula)){
            Miembro miembro = gimnasio.buscar(cedula);
            System.out.println("Asistencia registrada. "+ miembro.getNombre()+ " " + miembro.getApellido() + " lleva " + miembro.getAsistencias() + " asistencias");
        }else {
            System.out.println("Miembro no encontrado");
        }
    }
    public static void buscarMiembro(){
        System.out.println("1.- Por cedula \n 2.- Por nombre y apellido");
        System.out.print("Opcion: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        Miembro encontrado = null;

        switch (opcion) {

            case 1:
                System.out.print("Cedula: ");
                String cedula = sc.nextLine();

                encontrado = gimnasio.buscar(cedula);
                break;

            case 2:
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Apellido: ");
                String apellido = sc.nextLine();

                encontrado = gimnasio.buscar(nombre, apellido);
                break;

            default:
                System.out.println("Opcion no valida");
                return;
        }

        if (encontrado == null) {
            System.out.println("Miembro no encontrad");
        } else {
            System.out.println(encontrado);
        }

    }
}