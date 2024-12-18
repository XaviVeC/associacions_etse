package prac3.Main_Grafico;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import prac3.Estructuras.ListaAcciones;

public class Main_Grafico  extends JFrame implements ActionListener{

    private static String[] acciones = {"Charla", "Demostracion"};
   private JPanel panelBotones;
   private JButton[] botonesAcciones;
   

   public Main_Grafico(String titulo, ListaAcciones listaTodasLasAcciones){
        super (titulo);
    
        this.setSize(400, 300);
        this.setLocation(570, 220);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        botonesAcciones = new JButton[acciones.length];

        for (int i = 0; i< acciones.length; i++){
            botonesAcciones[i] = new JButton(acciones[i]);
            botonesAcciones[i].setBackground(Color.white);
            botonesAcciones[i].addActionListener(this);
            panelBotones.add(botonesAcciones[i]);    
        }
        contenedor.add(panelBotones, BorderLayout.NORTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,400);
        this.setVisible(true);


       


    }


@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}

private void mostrarLaInformacionDemostraciones(ListaAcciones listaAcciones){
    if(){
        
    }
}

}



   

