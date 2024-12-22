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

public class Main_Grafico extends JFrame {

    private JPanel contenedorPrincipal;
    private JPanel panelBotones;
    private JButton[] botonesAsociaciones;

    public Main_Grafico(String titulo, ListaAsociaciones listaDeTodasLasAsociaciones, ListaAcciones listaDeTodasLasAcciones) {
        super(titulo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 400);
        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BorderLayout());
        contenedorPrincipal.setBackground(new Color(135, 206, 250));
        panelBotones = new JPanel();

        // Mostrar diálogo inicial al arrancar
        mostrarDialogoInicial(listaDeTodasLasAsociaciones, listaDeTodasLasAcciones);

        this.add(contenedorPrincipal);
        this.setVisible(true);
    }

    /**
     * Muestra un cuadro de diálogo inicial para seleccionar entre ver todas las
     * demostraciones o filtrar por asociación.
     */
    private void mostrarDialogoInicial(ListaAsociaciones listaAsociaciones, ListaAcciones listaAcciones) {
        Object[] opciones = { "Mostrar todas las demostraciones", "Filtrar por asociación" };
        int seleccion = JOptionPane.showOptionDialog(
            this,
            "¿Qué desea hacer?",
            "Seleccionar acción",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (seleccion == 0) {
            // Mostrar todas las demostraciones activas
            mostrarLaInformacionDeDemostraciones(listaAcciones, listaAsociaciones, null);
        } else if (seleccion == 1) {
            // Mostrar lista de asociaciones
            inicializarBotonesAsociaciones(listaAsociaciones, listaAcciones);
        }
    }

    /**
     * Inicializa los botones de las asociaciones para mostrar demostraciones por
     * asociación.
     */
    private void inicializarBotonesAsociaciones(ListaAsociaciones listaAsociaciones, ListaAcciones listaAcciones) {

        // Añadimos el panel para filtrar directamente el nombre de la asociación
        JPanel panelDeBusqueda = new JPanel();
        panelDeBusqueda.setBackground(Color.PINK);
        JTextField filtro = new JTextField(30);
        panelDeBusqueda.add(filtro, BorderLayout.CENTER);

        // Inicializamos el panel de los botones
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));

        // Inicializamos la lista de botones
        botonesAsociaciones = new JButton[listaAsociaciones.getIndiceAsociaciones()];

        // Creamos un botón por cada asociación
        for (int i = 0; i < listaAsociaciones.getIndiceAsociaciones(); i++) {
            botonesAsociaciones[i] = new JButton();
            botonesAsociaciones[i].setText(listaAsociaciones.getElementoListaAsociacion(i).getNombreAsociacion());
            botonesAsociaciones[i].setBackground(Color.WHITE);
            botonesAsociaciones[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JButton sourceButton = (JButton) e.getSource();
                    String nombreAsociacion = sourceButton.getText();

                    // Mostrar demostraciones de la asociación seleccionada
                    mostrarLaInformacionDeDemostraciones(listaAcciones, listaAsociaciones, nombreAsociacion);
                }
            });

            panelBotones.add(botonesAsociaciones[i]);
        }

        // Crear un JScrollPane para poder hacer el Scroll
        JScrollPane scrollPanel = new JScrollPane(panelBotones);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Añadimos una búsqueda a tiempo real para el panel de búsqueda
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

            private void filtrarLasAsociaciones() {
                String nombreAsociacionQueBuscamos = filtro.getText().toLowerCase();
                panelBotones.removeAll();

                for (int i = 0; i < botonesAsociaciones.length; i++) {
                    JButton boton = botonesAsociaciones[i];
                    if (boton.getText().toLowerCase().contains(nombreAsociacionQueBuscamos)) {
                        panelBotones.add(boton);
                    }
                }

                panelBotones.revalidate();
                panelBotones.repaint();
            }
        });

        // Configuramos el panel principal y añadimos el Scroll Panel
        contenedorPrincipal.removeAll(); // Limpiar contenido previo
        contenedorPrincipal.add(scrollPanel, BorderLayout.CENTER);
        contenedorPrincipal.add(panelDeBusqueda, BorderLayout.NORTH);
        contenedorPrincipal.revalidate();
        contenedorPrincipal.repaint();
    }

    /**
     * Muestra la información de las demostraciones, filtradas o no.
     */
    private void mostrarLaInformacionDeDemostraciones(ListaAcciones listaAcciones, ListaAsociaciones listaAsociaciones,
            String nombreAsociacion) {

        // Crear el panel principal de demostraciones
        JPanel panelDemostraciones = new JPanel();
        panelDemostraciones.setLayout(new BoxLayout(panelDemostraciones, BoxLayout.Y_AXIS));

        // Filtrar demostraciones
        ListaAcciones demostraciones;
        if (nombreAsociacion == null) {
            demostraciones = listaAcciones.demostracionesActivasConFiltro(false, null); // Todas las activas
        } else {
            demostraciones = listaAcciones.demostracionesActivasConFiltro(true, nombreAsociacion); // Filtrar por asociación
        }

        // Actualizar panel con las demostraciones
        actualizarPanelDemostraciones(panelDemostraciones, demostraciones);

        // Crear un JScrollPane para las demostraciones
        JScrollPane scrollDemostraciones = new JScrollPane(panelDemostraciones);
        scrollDemostraciones.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Mostrar el panel en un JOptionPane
        JOptionPane.showMessageDialog(this, scrollDemostraciones,
                nombreAsociacion == null ? "Todas las Demostraciones" : "Demostraciones - " + nombreAsociacion,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarPanelDemostraciones(JPanel panelDemostraciones, ListaAcciones demostraciones) {
        panelDemostraciones.removeAll();

        for (int i = 0; i < demostraciones.getNumeroAcciones(); i++) {
            Demostracion demostracion = (Demostracion) demostraciones.getAccionEnXIndice(i);
            JButton botonDemostracion = new JButton(demostracion.getNombreAccion());
            botonDemostracion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarDetallesDemostracion(demostracion);
                }
            });

            panelDemostraciones.add(botonDemostracion);
        }

        panelDemostraciones.revalidate();
        panelDemostraciones.repaint();
    }

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