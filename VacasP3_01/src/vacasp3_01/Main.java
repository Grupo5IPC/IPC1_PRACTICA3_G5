package vacasp3_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import vacasp3_01.Alumnos.*;

public class Main {

    public static Gestor_alumno gestor_alumno;
    public static Handler verificaciones;
    public static int alum;

    public static void main(String[] args) {
        gestor_alumno = new Gestor_alumno();
        VentanaArchivos v1 = new VentanaArchivos();
    }

    public static void C_alumnos(String rutaTextField) {
        int cont = 0;
        if (gestor_alumno.verificar_cant() == 100) {
            System.out.println("Ya se han ingresado la cantidad maxima de alumnos");
        } else {
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
                    //ERROR AL USAR METODO COMPROBARFILA_ALUMNO
                    try {

                        if (!verificaciones.ComprobarFila_Alumno(col, cont, i)) {
                            if (cont == 0) {
                                cont++;
                            }

                            System.out.println("pasa");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    //TERMINA ERROR

                    if ((gestor_alumno.verificar_alum_carnet(Integer.parseInt(col[1]))) && (gestor_alumno.verificar_alum_id(Integer.parseInt(col[0])))) {
                        if (gestor_alumno.verificar_cant() == 100) {
                            System.out.println("Limite de carga Alcanzado");
                            break;
                        } else {
                            char genero = col[4].charAt(0);
                            gestor_alumno.Ins_alum(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2], col[3], genero);
                            alum++;
                        }
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
