package com.grupo5;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaArchivos extends JFrame implements ActionListener {

    JLabel titulo = new JLabel("CARGAR ARCHIVOS");
    JLabel info = new JLabel("Ingresa el nombre de la carpeta");
    JTextField textField = new JTextField();
    JButton boton = new JButton("Cargar");
    JButton aceptar = new JButton("Aceptar");
    JFrame infoVen = new JFrame("Información");
    
    public VentanaArchivos() {
        setTitle("Proyecto de IPC");
        //Icono
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Image miIcono = mipantalla.getImage("build/classes/ipc1/proyecto1_201900597/principal.jpg");
        
        setIconImage(miIcono);
        Dimension tamPantalla = mipantalla.getScreenSize();
        
            int alturaPantalla = tamPantalla.height;
            int anchoPantalla = tamPantalla.width;
        
            setSize(anchoPantalla/2,alturaPantalla/2);
            
            setLocation(anchoPantalla/4, alturaPantalla/4);
        this.getContentPane().setBackground(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Componentes();
    }

    public void Componentes() {
        //TITULO
        titulo.setBounds(250, 20, 300, 50);
        titulo.setFont(new Font("Monserrat", Font.BOLD, 18));
        titulo.setVisible(true);
        this.add(titulo);

        //INFO
        info.setBounds(240, 100, 250, 50);
        info.setFont(new Font("Monserrat", Font.ITALIC, 13));
        info.setVisible(true);
        this.add(info);

        //TEXTFIELD
        textField.setBounds(115, 150, 450, 30);
        textField.setVisible(true);
        this.add(textField);

        //BOTÓN
        boton.setBounds(290, 200, 100, 30);
        boton.setVisible(true);
        boton.addActionListener(this);
        this.add(boton);
    }

    public void InfoVentana() {
        //VENTANA
        infoVen.setSize(300, 130);
        infoVen.setLocationRelativeTo(null);
        infoVen.getContentPane().setBackground(null);
        infoVen.setResizable(false);
        infoVen.setLayout(null);
        infoVen.setVisible(true);

        //INFO
        JLabel text = new JLabel("Archivos cargados exitosamente");
        text.setBounds(60, 10, 250, 50);
        text.setFont(new Font("Monserrat", Font.ITALIC, 12));
        text.setVisible(true);
        infoVen.add(text);

        //BOTÓN
        aceptar.setBounds(100, 60, 100, 30);
        aceptar.setVisible(true);
        aceptar.addActionListener(this);
        infoVen.add(aceptar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton) {
            String ruta = textField.getText();
            //Main.getFilas(ruta);
            Main.C_alumnos(ruta + "\\Alumnos.csv");
            Main.C_cursos(ruta + "\\Curso.csv");
            Main.Asignacion(ruta + "\\Asignacion.csv");
            InfoVentana();
        }
        if (ae.getSource() == aceptar) {
            infoVen.dispose();
        }
    }
}
