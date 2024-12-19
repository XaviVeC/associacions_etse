package prac3.Main_Grafico;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import prac3.Accion.Demostracion;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;

public class Main_Grafico  extends JFrame {

   private JPanel contenedorPrincipal;
   private JPanel panelBotones;
   private JButton[] botonesAsociaciones;
   

   public Main_Grafico(String titulo, ListaAsociaciones listaDeTodasLasAsociaciones){
        super (titulo);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(600,400);
        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BorderLayout());

        panelBotones = new JPanel();


        inicializarBotonesAsociaciones(listaDeTodasLasAsociaciones);

        this.add(contenedorPrincipal);
        this.setVisible(true);
        

    }


/*
 * Método que crea tantos botones como asociaciones hay y los añade a un panel de tipo Scroll y lo añade al contenedor principal
 */

private void inicializarBotonesAsociaciones(ListaAsociaciones listaAsociaciones){
    //Inicializamos el panel de los botones 
    panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
    //Inicializamos la lista de botones 
    botonesAsociaciones = new JButton[listaAsociaciones.getIndiceAsociaciones()];

    //Vamos creando tantos botones como Asociaciones hayan 
    for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++){
            botonesAsociaciones[i] = new JButton();
            botonesAsociaciones[i].setText(listaAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion());
            botonesAsociaciones[i].setBackground(Color.WHITE);
            botonesAsociaciones[i].addActionListener(new ActionListener() {
            
                public void actionPerformed(ActionEvent e) {
                   
                    JButton sourceButton = (JButton) e.getSource();
                    String nombreAsociacion = sourceButton.getText();

                    JOptionPane.showMessageDialog(Main_Grafico.this,"Has seleccionado la asociación: " + nombreAsociacion, "Información de la Asociación",JOptionPane.INFORMATION_MESSAGE);
                    
                }
            });

            panelBotones.add(botonesAsociaciones[i]);
    }



    // Crear un JScrollPane para poder hacer el Scroll
    JScrollPane scrollPanel = new JScrollPane(panelBotones);
    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    //Configuramos el panel principal y añadimos el Scroll Panel
    contenedorPrincipal.setLayout(new BorderLayout());
    contenedorPrincipal.add(scrollPanel, BorderLayout.CENTER);

}




private void mostrarLaInformacionDeDemostraciones(ListaAcciones listaAcciones, ListaAsociaciones listaAsociaciones){
    ListaAcciones demostraciones = new ListaAcciones(listaAcciones.getNumeroAcciones());
        for (int i = 0; i < listaAcciones.getNumeroAcciones(); i++ ){
            if(listaAcciones.getAccionEnXIndice(i) instanceof Demostracion){
                Demostracion demostracion = (Demostracion) listaAcciones.getAccionEnXIndice(i);
                for(int j = 0; j < listaAsociaciones.getIndiceAsociaciones(); j++ ){
                    String asociacion = listaAsociaciones.getElementoListaAsociacion(j).getNombreAsociacion();
                    if(demostracion.getNombreAccion().equalsIgnoreCase(asociacion)){
                        demostraciones.addAccion(demostracion);
                    }
                }
            }
        }

        //Mostraremos las demostraciones activas en un nuevo panel
        JPanel panelDemostraciones = new JPanel();
        panelDemostraciones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < demostraciones.getNumeroAcciones(); i++){
            Demostracion demostracion = (Demostracion) listaAcciones.getAccionEnXIndice(i);
            JButton botonDemostracion = new JButton(demostracion.getNombreAccion());

            botonDemostracion.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mostrarDetallesDemostracion(demostracion);
                }
            });
            panelDemostraciones.add(botonDemostracion);
        }
        JScrollPane scrollDemostraciones = new JScrollPane(panelDemostraciones);
        scrollDemostraciones.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JOptionPane.showMessageDialog(this, scrollDemostraciones, "Demostraciones de //FALTA LLAMAR NOMBRE ASOCIACION" , JOptionPane.INFORMATION_MESSAGE);
    }

    //metodo para que para cada demostracion activa se pueda ver toda su informacion 
    private void mostrarDetallesDemostracion(Demostracion demostracion) {
        JTextArea demostracionDetalles = new JTextArea(10, 30);
        demostracionDetalles.setLineWrap(true);
        demostracionDetalles.setWrapStyleWord(true);
        demostracionDetalles.setText(demostracion.toString());
        demostracionDetalles.setCaretPosition(0);
    
        JScrollPane scrollDetalles = new JScrollPane(demostracionDetalles);
        scrollDetalles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
        JOptionPane.showMessageDialog(this, scrollDetalles, "Detalles de Demostración", JOptionPane.INFORMATION_MESSAGE);
    }




}



   

