package com.grupo5.Grafica;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import com.grupo5.Alumnos.*;
import com.grupo5.Cursos.Gestor_curso;
import com.grupo5.Menu;
import static com.grupo5.Menu.gestor_curso;
import java.awt.BorderLayout;

public class GraficaEdades extends JFrame implements ActionListener {

    JFrame ventana;
    JButton ordenarGenero = new JButton("Ordenar");
    JButton regresarGenero = new JButton("Regresar");
    JTextField txtRuta, txtTitulo;
    public static Gestor_alumno gestor_alumno;
    //public static Gestor_curso gestor_curso;

    public GraficaEdades(Gestor_alumno alumno, Gestor_curso curso) {
        gestor_alumno = alumno;
        gestor_curso = curso;
        //gestor_curso = curso;
        setTitle("Proyecto de IPC");
        //Icono
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Image miIcono = mipantalla.getImage("principal.jpg");

        setIconImage(miIcono);
        Dimension tamPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamPantalla.height;
        int anchoPantalla = tamPantalla.width;

        setSize(anchoPantalla / 2, alturaPantalla / 2);

        setLocation(anchoPantalla / 5, alturaPantalla / 7);
        this.getContentPane().setBackground(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Componentes();
        Grafica();
    }

    public void Componentes() {

        //BOTÓN ORDENAR
        ordenarGenero.setBounds(620, 330, 120, 40);
        ordenarGenero.setVisible(true);
        ordenarGenero.addActionListener(this);
        this.add(ordenarGenero);

        //BOTÓN REGRESAR
        regresarGenero.setBounds(620, 380, 120, 40);
        regresarGenero.setVisible(true);
        regresarGenero.addActionListener(this);
        this.add(regresarGenero);

        //PANEL
        /*panel1.setSize(this);
        panel1.setVisible(true);
        this.add(panel1);*/
    }

    public void Grafica() {
        int[] Aux = gestor_alumno.Cont_Edades();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(Aux[0], "Edades", "0-9");
        datos.setValue(Aux[1], "Edades", "10-19");
        datos.setValue(Aux[2], "Edades", "20-29");
        datos.setValue(Aux[3], "Edades", "30-39");
        datos.setValue(Aux[4], "Edades", "40-49");
        datos.setValue(Aux[5], "Edades", "50-59");
        datos.setValue(Aux[6], "Edades", "60-69");
        datos.setValue(Aux[7], "Edades", "70-79");
        datos.setValue(Aux[8], "Edades", "80-89");
        datos.setValue(Aux[9], "Edades", "90-100");

        //System.out.println("Hombres:" + Aux[0]);
        //System.out.println("Mujeres:" + Aux[1]);
        JFreeChart grafica = ChartFactory.createBarChart("Edades", "Edades de los alumnos", "Cantidad de alumnos", datos, PlotOrientation.VERTICAL,true,true, false);
        ChartPanel panel = new ChartPanel(grafica);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(800, 500));

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        pack();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ordenarGenero) {
            try {
                //your code here
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        if (e.getSource() == this.regresarGenero) {
            try {
                this.dispose();
                Menu menu = new Menu(gestor_alumno, gestor_curso);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }
}
