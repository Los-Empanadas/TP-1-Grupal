import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Crear escuela
        Escuela escuela = new Escuela(123, "UTN");

        // Crear división
        DivisionCurso division = new DivisionCurso(101, 1, 1, escuela);
        escuela.agregarDivision(division);

        // Crear cátedras
        Catedra catedraMatematica = new Catedra(1, "Matematica", division);
        Catedra catedraHistoria = new Catedra(2, "Historia", division);
        division.agregarCatedra(catedraMatematica);
        division.agregarCatedra(catedraHistoria);

        // Crear alumnos
        Alumno alumno1 = new Alumno(1000L, "Juan", "Bert", new Date(2005, 3, 15), catedraMatematica);
        Alumno alumno2 = new Alumno(1001L, "Maria", "Lorc", new Date(2005, 7, 20), catedraMatematica);
        Alumno alumno3 = new Alumno(1002L, "Pedro", "Zuni", new Date(2005, 11, 5), catedraHistoria);
        Alumno alumno4 = new Alumno(1003L, "Ana", "Seve", new Date(2006, 1, 10), catedraHistoria);

        // Crear notas para cada alumno
        alumno1.agregarNota(new Nota(1, 8, new Date(2025, 4, 28), false));
        alumno1.agregarNota(new Nota(2, 7, new Date(2025, 4, 28), false));
        alumno1.agregarNota(new Nota(3, 9, new Date(2025, 4, 28), false));
        alumno1.agregarNota(new Nota(4, 6, new Date(2025, 4, 28), false));
        alumno1.agregarNota(new Nota(5, 7, new Date(2025, 4, 28), false));

        alumno2.agregarNota(new Nota(6, 10, new Date(2025, 4, 28), false));
        alumno2.agregarNota(new Nota(7, 9, new Date(2025, 4, 28), false));
        alumno2.agregarNota(new Nota(8, 8, new Date(2025, 4, 28), false));
        alumno2.agregarNota(new Nota(9, 10, new Date(2025, 4, 28), false));
        alumno2.agregarNota(new Nota(10, 7, new Date(2025, 4, 28), false));

        alumno3.agregarNota(new Nota(11, 6, new Date(2025, 4, 28), true)); // Recuperatorio
        alumno3.agregarNota(new Nota(12, 8, new Date(2025, 4, 28), false));
        alumno3.agregarNota(new Nota(13, 5, new Date(2025, 4, 28), false));
        alumno3.agregarNota(new Nota(14, 9, new Date(2025, 4, 28), false));

        alumno4.agregarNota(new Nota(15, 7, new Date(2025, 4, 28), false));
        alumno4.agregarNota(new Nota(16, 6, new Date(2025, 4, 28), false));
        alumno4.agregarNota(new Nota(17, 8, new Date(2025, 4, 28), false));
        alumno4.agregarNota(new Nota(18, 9, new Date(2025, 4, 28), false));
        alumno4.agregarNota(new Nota(19, 10, new Date(2025, 4, 28), false));

        // Agregar alumnos a cátedras
        catedraMatematica.agregarAlumno(alumno1);
        catedraMatematica.agregarAlumno(alumno2);
        catedraHistoria.agregarAlumno(alumno3);
        catedraHistoria.agregarAlumno(alumno4);

        // PROBAR FUNCIONES

        System.out.println("Mejor alumno de la catedra Matematica:");
        System.out.println(catedraMatematica.mejorAlumnoCatedra().getNombre());

        System.out.println("Mejor alumno de la division:");
        System.out.println(division.mejorAlumnoDivisionCurso().getNombre());

        System.out.println("Mejor alumno de la escuela nacido en 2005:");
        Alumno mejor2005 = escuela.getMejorAlumnoEscuela(2005);
        if (mejor2005 != null) {
            System.out.println(mejor2005.getNombre());
        } else {
            System.out.println("No hay alumnos para ese año.");
        }

        System.out.println("Top 3 mejores alumnos de la escuela nacidos en 2005:");
        List<Alumno> new ArrayList(topAlumnos = escuela.getMejorAlumnoEscuela(2005));
        for (Alumno a : topAlumnos) {
            System.out.println(a.getNombre() + " con promedio: " + a.promedioNotas());
        }
    }
}