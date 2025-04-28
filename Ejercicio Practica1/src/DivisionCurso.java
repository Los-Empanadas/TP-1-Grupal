import java.util.ArrayList;

public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private ArrayList<Catedra> catedras;

    public DivisionCurso(int codigo, int anio, int division, Escuela escuela) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
        this.escuela = escuela;
        this.catedras = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public ArrayList<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(ArrayList<Catedra> catedras) {
        this.catedras = catedras;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
    public void agregarCatedra(Catedra catedra) {
        catedras.add(catedra);
    }
    public Alumno mejorAlumnoDivisionCurso() {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (Catedra catedra : catedras) {
            for (Alumno alumno : catedra.getAlumnos()) {
                if (alumno.cantidadExamenes() >= 5 && alumno.cantidadRecuperatorios() == 0) {
                    double promedio = alumno.promedioNotas(this.codigo);
                    if (promedio > mejorPromedio) {
                        mejorPromedio = promedio;
                        mejorAlumno = alumno;
                    }
                }
            }
        }

        return mejorAlumno;
    }
}
