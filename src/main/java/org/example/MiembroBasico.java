package org.example;

public class MiembroBasico extends Miembro{
    public MiembroBasico(String cedula, String nombre, String apellido, double cuotaBase) {
        super(cedula, nombre, apellido, cuotaBase);
    }

    @Override
    public double calcularCuota() {
        return getCuotaBase();
    }

    @Override
    public String toString() {
        return "[Basico] " + super.toString();
    }


}
