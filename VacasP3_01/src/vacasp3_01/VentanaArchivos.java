package vacasp3_01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaArchivos extends JFrame implements ActionListener {

    JLabel titulo = new JLabel("CARGAR ARCHIVOS");
    JLabel info = new JLabel("Ingresa la ruta de la carpeta");
    JTextField textField = new JTextField();
    JButton boton = new JButton("Cargar");

    public VentanaArchivos() {
        setTitle("Cargar archivos");
        this.setSize(430, 230);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Componentes();
    }

    public void Componentes() {
        //TITULO
        titulo.setBounds(145, 20, 150, 50);
        titulo.setFont(new Font("Monserrat", Font.BOLD, 14));
        titulo.setVisible(true);
        this.add(titulo);

        //INFO
        info.setBounds(20, 70, 250, 50);
        info.setFont(new Font("Monserrat", Font.ITALIC, 12));
        info.setVisible(true);
        this.add(info);

        //TEXTFIELD
        textField.setBounds(20, 120, 250, 30);
        textField.setVisible(true);
        this.add(textField);

        //BOTÓN
        boton.setBounds(290, 120, 100, 30);
        boton.setVisible(true);
        boton.addActionListener(this);
        this.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton) {
            String ruta = textField.getText();
            //Main.getFilas(ruta);
            Main.C_alumnos(ruta);
        }
    }
}
