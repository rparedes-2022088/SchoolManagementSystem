import java.time.LocalDate;

import model.Estudiante;
import model.Curso;
import gestor.GestorAcademico;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 1, 15), Estudiante.Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "Ana", "Gómez", LocalDate.of(1999, 5, 22), Estudiante.Estado.INACTIVO);

        Curso curso1 = new Curso(101, "Matemáticas", "Curso de matemáticas básicas", 5, "v1.0");
        Curso curso2 = new Curso(102, "Literatura", "Curso de literatura universal", 4, "v1.1");

        GestorAcademico gestor = new GestorAcademico();

        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            gestor.inscribirEstudianteCurso(estudiante1, 101);
            gestor.inscribirEstudianteCurso(estudiante2, 102);

            gestor.desinscribirEstudianteCurso(2, 102);

            System.out.println("Estudiantes:");
            System.out.println(gestor.getEstudiantes());

            System.out.println("Cursos:");
            System.out.println(gestor.getCursos());

            System.out.println("Inscripciones:");
            System.out.println(gestor.getInscripciones());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
