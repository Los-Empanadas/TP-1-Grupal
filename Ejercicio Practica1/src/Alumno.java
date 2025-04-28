import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Calendar;

public class Alumno {
    private Long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Catedra catedra;
    private ArrayList<Nota> notas;

    public Alumno(Long legajo, String nombre, String apellido, Date fechaNacimiento, Catedra catedra) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.catedra = catedra;
        this.notas = new ArrayList<>();
    }

    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public Nota mejorNota(int codigoCatedra) {
        Nota mejorNota = new Nota(0, 0, null, false, null, null);
        mejorNota.setValor(0);
        if (Objects.equals(catedra.getCodigo(), codigoCatedra)) {

            for (Nota nota : notas) {
                if (codigoCatedra == nota.getCatedra().getCodigo() && nota.isEsRecuperatorio() == false && mejorNota.getValor() < nota.getValor()) {
                    mejorNota = nota;
                }
            }
        } else {
            for (Nota nota : notas) {
                if (this.legajo == nota.getAlumno().getLegajo() && mejorNota.getValor() < nota.getValor()) {
                    mejorNota = nota;
                }
            }

        }
        return mejorNota;
    }

    public double promedioNotas(int codigoCatedra) {
        int cantNotas = 0;
        double totalNotas=0;
        if (Objects.equals(catedra.getCodigo(), codigoCatedra)) {

            for (Nota nota : notas) {
                if (codigoCatedra == nota.getCatedra().getCodigo() && nota.isEsRecuperatorio() == false){
                    totalNotas = totalNotas+nota.getValor();
                    cantNotas++;
                }
            }
        } else {
            for (Nota nota : notas) {
                totalNotas = totalNotas+nota.getValor();
                cantNotas++;
            }
        }
        return totalNotas/cantNotas;
    }
    public int cantidadExamenes() {
        int cantidad = 0;
        for (Nota nota : notas) {
            if (!nota.isEsRecuperatorio()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadRecuperatorios() {
        int cantidad = 0;
        for (Nota nota : notas) {
            if (nota.isEsRecuperatorio()) {
                cantidad++;
            }
        }
        return cantidad;
    }
    public int cantidadDesaprobados() {
        int contador = 0;
        for (Nota nota : notas) {
            if (nota.getValor() < 6) {
                contador++;
            }
        }
        return contador;
    }
    public int getAnioNacimiento() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaNacimiento);
        return calendar.get(Calendar.YEAR);
    }
}