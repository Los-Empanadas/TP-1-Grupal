import java.util.ArrayList;

public class Catedra {
    private int codigo;
    private String denominacion;
    private DivisionCurso divisionCurso;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Nota> notas;

    public Catedra(int codigo, String denominacion, DivisionCurso divisionCurso) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.divisionCurso = divisionCurso;
        this.alumnos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public DivisionCurso getDivisionCurso() {
        return divisionCurso;
    }

    public void setDivisionCurso(DivisionCurso divisionCurso) {
        this.divisionCurso = divisionCurso;
    }
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }
    public Alumno mejorAlumnoCatedra() {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (Alumno alumno : alumnos) {
            double promedio = alumno.promedioNotas(this.getCodigo());
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorAlumno = alumno;
            }
        }

        return mejorAlumno;
    }
}
