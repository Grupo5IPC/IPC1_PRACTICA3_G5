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
import java.awt.BorderLayout;

public class GrafPie extends JFrame implements ActionListener {

    JFrame ventana;
    JLabel titulo = new JLabel("GRAFICA DE PIE POR SEXO");
    JButton boton = new JButton("Ordenar");
    JTextField txtRuta, txtTitulo;
    JButton btnOrdenar;
    public static Gestor_alumno gestor_alumno;
    public static Gestor_curso gestor_curso;

    public GrafPie(Gestor_alumno alumno, Gestor_curso curso) {
        gestor_alumno = alumno;
        gestor_curso = curso;
        setTitle("Proyecto de IPC");
        //Icono
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Image miIcono = mipantalla.getImage("principal.jpg");

        setIconImage(miIcono);
        Dimension tamPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamPantalla.height;
        int anchoPantalla = tamPantalla.width;

        setSize(anchoPantalla / 2, alturaPantalla / 2);

        setLocation(anchoPantalla / 4, alturaPantalla / 4);
        this.getContentPane().setBackground(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Componentes();
        Grafica();
    }

    public void Componentes() {
        //TITULO
        titulo.setBounds(220, 10, 300, 50);
        titulo.setFont(new Font("Monserrat", Font.BOLD, 18));
        titulo.setVisible(true);
        this.add(titulo);

        //BOTÓN
        boton.setBounds(530, 300, 120, 40);
        boton.setVisible(true);
        boton.addActionListener(this);
        this.add(boton);

        //PANEL
        /*panel1.setSize(this);
        panel1.setVisible(true);
        this.add(panel1);*/
    }

    public void Grafica() {
        int[] Aux = gestor_alumno.Cont_Genero();
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Hombres", Aux[0]);
        datos.setValue("Mujeres", Aux[1]);
        //System.out.println("Hombres:" + Aux[0]);
        //System.out.println("Mujeres:" + Aux[1]);

        JFreeChart grafica = ChartFactory.createPieChart("Generos", datos, true, true, false);
        ChartPanel panel = new ChartPanel(grafica);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 500));

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        pack();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnOrdenar) {
            setVisible(false);
        }
    }
}
