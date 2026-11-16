package org.example;

public class MiembroPremium extends Miembro{
    private int sesionesEntrenador;

    public MiembroPremium(String cedula, String nombre, String apellido, double cuotaBase, int sesionesEntrenador) {
        super(cedula, nombre, apellido, cuotaBase);
        this.sesionesEntrenador = sesionesEntrenador;
    }

    @Override
    public double calcularCuota() {
        return getCuotaBase() * 1.20 + sesionesEntrenador * 12;
    }

    @Override
    public String toString() {
        return "[PREMIUM] " + super.toString() + ", Sesiones: "+sesionesEntrenador;
    }
}
