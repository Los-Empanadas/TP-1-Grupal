import java.util.ArrayList;

public class Escuela {
    private int numero;
    private String denominacion;
    private ArrayList<DivisionCurso> divisionCursos;

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.divisionCursos = new ArrayList();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setDivisionCursos(ArrayList<DivisionCurso> divisionCursos) {
        this.divisionCursos = divisionCursos;
    }

    public ArrayList<DivisionCurso> getDivisionCursos() {
        return divisionCursos;
    }

    public void agregarDivision(DivisionCurso division) {
        divisionCursos.add(division);
    }
    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (DivisionCurso divisionCurso : divisionesCursos) {
            for (Catedra catedra : divisionCurso.getCatedras()) {
                for (Alumno alumno : catedra.getAlumnos()) {
                    if (alumno.getAnioNacimiento() == anioNacimientoAlumno && alumno.cantidadDesaprobados() == 0) {
                        double promedio = alumno.promedioNotas();
                        if (promedio > mejorPromedio) {
                            mejorPromedio = promedio;
                            mejorAlumno = alumno;
                        }
                    }
                }
            }
        }

        return mejorAlumno;
    }
}
