package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import com.grupo5.Cursos.*;
import com.grupo5.Alumnos.*;

public class Main {

    public static Curso[] cursos;
    public static Alumno[] alumnos;
    static int alum, curs;
    public static Gestor_alumno gestor_alumno;
    public static Gestor_curso gestor_curso;
    public static Handler verificaciones;
    public static Log log;

    public static void main(String[] args) {
        gestor_alumno = new Gestor_alumno();
        gestor_curso = new Gestor_curso();
        log = new Log();
        verificaciones = new Handler(log);

        VentanaArchivos v1 = new VentanaArchivos();

    }

    public static void C_alumnos(String rutaTextField) {
        int cont = 0;
        try {
            String filas[];

            String prueba = getContentOfFile(rutaTextField);
            prueba.trim(); //QUITAMOS LOS ESPACIOS
            String s = prueba.trim();

            filas = s.split("\n");

            String[] aux = new String[filas.length];

            for (int i = 0; i < aux.length; i++) {
                aux[i] = "";
            }

            for (int i = 0; i < filas.length; i++) {
                String[] columnas = filas[i].split(",");
                String cola = columnas[0].trim() + ",";

                for (int j = 0; j < columnas.length; j++) {
                    String col = columnas[j].trim() + ",";

                    if (j != 2) {
                        aux[i] += col;

                    } else {
                        aux[i] += col;
                    }

                }

            }
            String filas2[] = aux;

            for (int i = 0; i < filas2.length; i++) {
                String[] col = filas2[i].split(",");
                try {

                    if (!verificaciones.ComprobarFila_Alumno(col, cont, i)) {
                        if (cont == 0) {
                            cont++;
                        }
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                if ((gestor_alumno.verificar_alum_carnet(Integer.parseInt(col[1]))) && (gestor_alumno.verificar_alum_id(Integer.parseInt(col[0])))) {
                    char genero = col[4].charAt(0);
                    gestor_alumno.Ins_alum(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2], col[3], genero);
                    alum++;
                } else {
                    //log.addCuerpo("El Carnet o ID ingresado: " + col[1] + ", " + col[0] + " ya se encuentra registrado");
                }
            }
            /*if (cont > 0) {
                    printErrores();
                }*/
            gestor_alumno.print_alumnos();

        } catch (Exception e) {
            System.out.println("Hubo un error: " + e);

        }
    }

    public static void C_cursos(String rutaTextField) {
        int cont = 0;
        try {
            String filas[];

            String prueba = getContentOfFile(rutaTextField);
            prueba.trim(); //QUITAMOS LOS ESPACIOS
            String s = prueba.trim();

            filas = s.split("\n");

            String[] aux = new String[filas.length];

            for (int i = 0; i < aux.length; i++) {
                aux[i] = "";
            }

            for (int i = 0; i < filas.length; i++) {
                String[] columnas = filas[i].split(",");
                String cola = columnas[0].trim() + ",";

                for (int j = 0; j < columnas.length; j++) {
                    String col = columnas[j].trim() + ",";

                    if (j != 2) {
                        aux[i] += col;

                    } else {
                        aux[i] += col;
                    }

                }

            }
            String filas2[] = aux;

            for (int i = 1; i < filas2.length; i++) {
                String[] col = filas2[i].split(",");
                if (!verificaciones.ComprobarFila_curso(filas2[i].split(","), cont, i)) {
                    //System.out.println("pasa");
                    if (cont == 0) {
                        cont++;
                    }
                    continue;
                }

                gestor_curso.Ins_curso(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2]);
                curs++;

            }
            /*if (cont > 0) {
                printErrores();
            }*/
            gestor_curso.print_cursos();

        } catch (Exception e) {
            System.out.println("Hubo un error" + e);

        }

    }

    public static void Asignacion(String rutaTextField) {
        int cont = 0;
        String ids = "", cadena = "";

        try {
            String filas[];

            String prueba = getContentOfFile(rutaTextField);
            prueba.trim(); //QUITAMOS LOS ESPACIOS
            String s = prueba.trim();

            filas = s.split("\n");

            String[] aux = new String[filas.length];

            for (int i = 0; i < aux.length; i++) {
                aux[i] = "";
            }

            for (int i = 0; i < filas.length; i++) {
                String[] columnas = filas[i].split(",");
                String cola = columnas[0].trim() + ",";

                for (int j = 0; j < columnas.length; j++) {
                    String col = columnas[j].trim() + ",";

                    if (j != 2) {
                        aux[i] += col;

                    } else {
                        aux[i] += col;
                    }

                }

            }
            String filas2[] = aux;

            for (int i = 1; i < filas2.length; i++) {
                String[] col = filas2[i].split(",");
                if (!verificaciones.ComprobarFila_notas(filas2[i].split(","), cont, i)) {
                    //System.out.println("pasa");
                    if (cont == 0) {
                        cont++;
                    }
                    continue;
                }
                /*if (gestor_alumno.verificar_asign(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == false) {
*/
                    if (gestor_alumno.verificarIngreso(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == true) {
                        double nota = Double.parseDouble(col[2]);
                        gestor_alumno.asginarNota(Integer.parseInt(col[0]), Integer.parseInt(col[1]), nota);

                    } else {
                        cadena += col[0] + ", " + col[1] + ", " + col[2] + "\n";
                    }
                /*} else {
                    ids += col[0] + ", " + col[1] + ", " + col[2] + "\n";
                    log.addCuerpo("EL alumno con ID " + col[0] + ", no esta asignado a " + col[1]);

                }*/

            }
            if (!ids.equals("")) {
                System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque los alumnos no estan asignados: ");
                System.out.println(ids);

            }
            if (!cadena.equals("")) {
                System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque los alumnos ya tienen nota ingresada: ");
                System.out.println(ids);
            }
            /*if (cont > 0) {
                        printErrores();
                    }*/
            gestor_alumno.printNota();

        } catch (Exception e) {

        }
    }

    public static String getContentOfFile(String pathname) {
        File archive = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archive = new File(pathname);
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            //System.out.println(content);
            return content;
        } catch (Exception e) {
            System.out.println();
            System.out.println("No se ha podido encontrar el archivo");
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (NullPointerException e) {
                System.out.println("No ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println();
            }
        }
        return "";
    }
}
