package model.excepciones;

public class EstudianteNoInscritoEnCursoException extends Exception {
    public EstudianteNoInscritoEnCursoException(String message) {
        super(message);
    }
}