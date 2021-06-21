package vacasp3_01.Alumnos;

/**
 *
 * @author Alexis
 */
public class Asignacion_alumno {

    private int Id_alumno;
    private int Id_curso;
    private String nota;

    public Asignacion_alumno(int Id_alumno, int Id_curso, String nota) {
        this.Id_alumno = Id_alumno;
        this.Id_curso = Id_curso;
        this.nota = nota;
    }

    public int getId_alumno() {
        return Id_alumno;
    }

    public void setId_alumno(int Id_alumno) {
        this.Id_alumno = Id_alumno;
    }

    public int getId_curso() {
        return Id_curso;
    }

    public void setId_curso(int Id_curso) {
        this.Id_curso = Id_curso;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    
}