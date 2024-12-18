package prac3.Main_Grafico;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

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

public class Main_Grafico  extends JFrame implements ActionListener{

    private static String[] acciones = {"Charla", "Demostracion"};
   private JPanel panelBotones;
   private JButton[] botonesAcciones;
   String tipoAccionSelecionada = "ninguna";
   

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

private void mostrarLaInformacionDemostracionesDeUnaAsociacion(ListaAcciones listaAcciones, ListaAsociaciones listaAsociaciones){
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
        
        
    }


}



   

