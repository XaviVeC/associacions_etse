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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import prac3.Accion.Demostracion;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;

public class Main_Grafico  extends JFrame {

   private JPanel contenedorPrincipal;
   private JPanel panelBotones;
   private JButton[] botonesAsociaciones;
   

   public Main_Grafico(String titulo, ListaAsociaciones listaDeTodasLasAsociaciones, ListaAcciones listaDeTodasLasAcciones){
        super (titulo);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(600,400);
        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BorderLayout());
        contenedorPrincipal.setBackground(new Color(135, 206, 250)); //POR QUE NO SE CAMBIA EL COLOR DE LA VENTANA ??
        panelBotones = new JPanel();


        inicializarBotonesAsociaciones(listaDeTodasLasAsociaciones, listaDeTodasLasAcciones);

    

        this.add(contenedorPrincipal);
        this.setVisible(true);
        

    }


/*
 * Método que crea tantos botones como asociaciones hay y los añade a un panel de tipo Scroll y este al contenedor principal
 */

private void inicializarBotonesAsociaciones(ListaAsociaciones listaAsociaciones, ListaAcciones listaAcciones){
  
    //Añadimos el panel para filtrar directamente el nombre de la asociación 

    JPanel panelDeBusqueda = new JPanel();
    panelDeBusqueda.setBackground(Color.PINK);
    JTextField filtro = new JTextField(30);
    panelDeBusqueda.add(filtro, BorderLayout.CENTER);

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

                    mostrarLaInformacionDeDemostraciones(listaAcciones, listaAsociaciones, nombreAsociacion);

                }
            });

            panelBotones.add(botonesAsociaciones[i]);

    }


    // Crear un JScrollPane para poder hacer el Scroll
    JScrollPane scrollPanel = new JScrollPane(panelBotones);
    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    //Añadimos una búsqueda a tiempo real para el panel de búqueda
    filtro.getDocument().addDocumentListener(new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarLasAsociaciones();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarLasAsociaciones();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarLasAsociaciones();
        }
        
        private void filtrarLasAsociaciones(){
            String nombreAsociacionQueBuscamos = filtro.getText().toLowerCase();
            panelBotones.removeAll();

            for (int i = 0; i < botonesAsociaciones.length; i++){
                JButton boton = botonesAsociaciones[i];
                if (boton.getText().toLowerCase().contains(nombreAsociacionQueBuscamos)){
                    panelBotones.add(boton);
                }
            }

            panelBotones.revalidate();
            panelBotones.repaint();
        }
    });


    //Configuramos el panel principal y añadimos el Scroll Panel
    contenedorPrincipal.setLayout(new BorderLayout());
    contenedorPrincipal.setBackground(new Color(135, 206, 250));
    contenedorPrincipal.add(scrollPanel, BorderLayout.CENTER);
    contenedorPrincipal.add(panelDeBusqueda, BorderLayout.NORTH); 
}




private void mostrarLaInformacionDeDemostraciones(ListaAcciones listaAcciones, ListaAsociaciones listaAsociaciones, String nombreAsociacion){
    ListaAcciones demostraciones = new ListaAcciones(listaAcciones.getNumeroAcciones());

    
    for (int i = 0; i < listaAcciones.getNumeroAcciones(); i++) {
        if (listaAcciones.getAccionEnXIndice(i) instanceof Demostracion) {
            Demostracion demostracion = (Demostracion) listaAcciones.getAccionEnXIndice(i);
            if (demostracion.getNombreAsociacion().equalsIgnoreCase(nombreAsociacion)) {
                demostraciones.addAccion(demostracion);
            }
        }
    }
    
        //Mostraremos las demostraciones activas en un nuevo panel
        JPanel panelDemostraciones = new JPanel();
        panelDemostraciones.setLayout(new BoxLayout(panelDemostraciones, BoxLayout.Y_AXIS));
        
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



   

