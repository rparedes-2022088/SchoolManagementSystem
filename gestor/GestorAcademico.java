package gestor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import servicio.ServiciosAcademicosI;
import model.Curso;
import model.Estudiante;
import model.excepciones.*;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaMatriculadoException {
        if (estudiantes.stream().anyMatch(e -> e.getId() == estudiante.getId())) {
            throw new EstudianteYaMatriculadoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoYaExistenteException {
        if (cursos.stream().anyMatch(c -> c.getId() == curso.getId())) {
            throw new CursoYaExistenteException("El curso ya existe.");
        }
        cursos.add(curso);
        inscripciones.put(curso, new ArrayList<>());
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = obtenerCursoPorId(idCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado.");
        }

        if (inscripciones.get(curso).contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }

        inscripciones.get(curso).add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = obtenerCursoPorId(idCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado.");
        }

        Estudiante estudiante = obtenerEstudiantePorId(idEstudiante);
        if (estudiante == null || !inscripciones.get(curso).contains(estudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }

        inscripciones.get(curso).remove(estudiante);
    }

    private Curso obtenerCursoPorId(int id) {
        return cursos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    private Estudiante obtenerEstudiantePorId(int id) {
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public HashMap<Curso, ArrayList<Estudiante>> getInscripciones() {
        return inscripciones;
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


