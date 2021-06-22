package com.grupo5;

import com.grupo5.Grafica.GrafPie;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Menu extends JFrame implements ActionListener {

    JFrame ventana;
    JButton botonPie = new JButton("Grafica por sexo (Pie)");
    JButton botonBar1 = new JButton("Grafica por edad (Barras)");
    JButton botonBar2 = new JButton("Grafica por notas (Barras)");
    JButton botonInicio = new JButton("Inicio");
    JTextField txtRuta, txtTitulo;
    JButton btnOrdenar;
    
    public Menu(){
    configurarVentana();
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

        //BOTÓN PIE
        botonPie.setBounds(90, 40, 500, 50);
        botonPie.setVisible(true);
        botonPie.addActionListener(this);
        this.add(botonPie);
        
        //BOTÓN BARRA EDAD
        botonBar1.setBounds(90, 110, 500, 50);
        botonBar1.setVisible(true);
        botonBar1.addActionListener(this);
        this.add(botonBar1);
        
        //BOTÓN BARRA NOTA
        botonBar2.setBounds(90, 180, 500, 50);
        botonBar2.setVisible(true);
        botonBar2.addActionListener(this);
        this.add(botonBar2);
        
        //BOTÓN INICIO
        botonInicio.setBounds(90, 250, 500, 50);
        botonInicio.setVisible(true);
        botonInicio.addActionListener(this);
        this.add(botonInicio);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonPie) {
            setVisible(false);
            new GrafPie();
            repaint();
        }
    }

}
