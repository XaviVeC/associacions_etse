package prac3.Main_Grafico;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import prac3.Accion.Demostracion;
import prac3.Estructuras.ListaAcciones;
import prac3.Estructuras.ListaAsociaciones;

public class Main_Grafico  extends JFrame {

   
   private JPanel panelBotones;
   private JButton[] botonesAsociaciones;
   
   

   public Main_Grafico(String titulo, ListaAsociaciones listaDeTodasLasAsociaciones){
        super (titulo);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        

       


    }


private void inicializarBotonesAsociaciones(ListaAsociaciones listaAsociaciones){

    panelBotones.setLayout((LayoutManager) new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
    
    for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++){
            botonesAsociaciones[i] = new JButton();
            botonesAsociaciones[i].setText(listaAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion());
            botonesAsociaciones[i].setBackground(Color.WHITE);

    }
}




private void mostrarLaInformacionDeDemostraciones(ListaAcciones listaAcciones, ListaAsociaciones listaAsociaciones){
    ListaAcciones demostraciones = new ListaAcciones(listaAcciones.getNumeroAcciones());
        for (int i = 0; i < listaAcciones.getNumeroAcciones(); i++ ){
            if(listaAcciones.getAccionEnXIndice(i) instanceof Demostracion){
                Demostracion demostracion = (Demostracion) listaAcciones.getAccionEnXIndice(i);
                for(int j = 0; j < listaAsociaciones.getIndiceAsociaciones(); j++ ){
                    String asociacion = listaAsociaciones.getElementoListaAsociacion(j);
                    if(demostracion.getNombreAccion().equalsIgnoreCase(asociacion)){
                        demostraciones.addAccion(demostracion);
                    }
                }
            }
        }

        JTextArea textoDemostracion = new JTextArea(10, 30);
        textoDemostracion.setLineWrap(true);
        textoDemostracion.setWrapStyleWord(true);
        textoDemostracion.setText(demostraciones.toString());
        textoDemostracion.setCaretPosition(0);
        JScrollPane scrollPanel = new JScrollPane(textoDemostracion);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JOptionPane.showMessageDialog(this, scrollPanel, "Demostraciones de la Asociacion:", JOptionPane.INFORMATION_MESSAGE);
        
        
    }


}



   

