package model;
import java.time.LocalDate;

public class Estudiante extends Persona {
    private LocalDate fechaDeNacimiento;
    private Estado estado;

    public enum Estado {
        MATRICULADO, INACTIVO, GRADUADO
    }

    public Estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, Estado estado) {
        super(id, nombre, apellido);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public LocalDate getFechaDeNacimiento() { return fechaDeNacimiento; }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) { this.fechaDeNacimiento = fechaDeNacimiento; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + "'"+
                ", apellido='" + getApellido() + "'"+
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", estado=" + estado +
                '}';
    }
}


