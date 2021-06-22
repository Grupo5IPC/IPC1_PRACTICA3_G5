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

public class GrafPie extends JFrame implements ActionListener {
    
    JFrame ventana;
    JLabel titulo = new JLabel("GRAFICA DE PIE POR SEXO");
    JButton boton = new JButton("Ordenar");
    JTextField txtRuta, txtTitulo;
    JButton btnOrdenar;
    
    public GrafPie() {
        configurarVentana();
        repaint();
    }

    private void configurarVentana() {
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
    }
//
//    private void Pie(String[][] array) {
//        File txt = buscar.RutaArchivo(this, txtRuta);
//        array = this.buscar.Archivo(new JFrame(), txt);
//        DefaultPieDataset datos = new DefaultPieDataset();
//        for (int i = 0; i < array[0].length; i++) {
//            int valor = Integer.parseInt(array[1][i]);
////            datos.PieDataset(valor, array[0][i]/*, array[1][i]*/);
//            datos.setValue(array[0][i], valor);
//        }
//        JFreeChart ch = ChartFactory.createPieChart("Grafica de pie", datos, true, true, false);
//        ChartPanel cp = new ChartPanel(ch);
//        add(cp);
//        cp.setBounds(70, 200, 1200, 350);
//        repaint();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnOrdenar) {
            setVisible(false);
//            new VentanaOrden();
            repaint();
        }
    }

}
