import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        inscripciones.put(curso, new ArrayList<>());
    }

    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        if (inscripciones.containsKey(curso)) {
            inscripciones.get(curso).add(estudiante);
        }
    }

    public void desinscribirEstudianteDeCurso(Estudiante estudiante, Curso curso) {
        if (inscripciones.containsKey(curso)) {
            inscripciones.get(curso).remove(estudiante);
        }
    }

    public ArrayList<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Curso> obtenerCursos() {
        return cursos;
    }

    public ArrayList<Estudiante> obtenerEstudiantesEnCurso(Curso curso) {
        return inscripciones.getOrDefault(curso, new ArrayList<>());
    }

    @Override
    public String toString() {
        return "GestorAcademico{" +
                "estudiantes=" + estudiantes +
                ", cursos=" + cursos +
                ", inscripciones=" + inscripciones +
                '}';
    }
}

