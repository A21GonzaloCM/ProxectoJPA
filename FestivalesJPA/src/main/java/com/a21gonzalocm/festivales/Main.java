package com.a21gonzalocm.festivales;

import com.a21gonzalocm.festivales.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //crear una interfaz grafica sencillo para que el usuario pueda interactuar con la base de datos
        EntityManager em = JPAUtil.get().createEntityManager();

        DAOMusico daoMusico = new DAOMusico(em);
        DAOBanda daoBanda = new DAOBanda(em);
        DAOFestival daoFestival = new DAOFestival(em);
        createAndShowGUI(daoMusico, daoBanda, daoFestival);
        //crear un menu por consola para ver los datos

        //Crear una ventana con un text area para la salida de la base de datos

//
//        int opcion = 0;
//        do {
//            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Insertar Musico\n2. Insertar Banda\n3. Insertar Festival\n4. Ver Musicos\n5. Ver Bandas\n6. Ver Festivales\n7. Salir"));
//            switch (opcion) {
//                case 1: {
//                    String nombre = JOptionPane.showInputDialog("Nombre del musico");
//                    String instrumento = JOptionPane.showInputDialog("Instrumento del musico");
//                    Musico musico = new Musico(nombre, instrumento);
//                    daoMusico.insertMusico(musico);
//                }break;
//
//                case 2: {
//                    String nombreBanda = JOptionPane.showInputDialog("Nombre de la banda");
//                    byte[] logo = JOptionPane.showInputDialog("Logo de la banda").getBytes();
//                    String descripcion = JOptionPane.showInputDialog("Descripcion de la banda");
//                    LocalDate fechaCreacion = LocalDate.now();
//                    Banda banda = new Banda(nombreBanda, new HashSet<>(), null, logo, descripcion, fechaCreacion);
//                    daoBanda.insertBanda(banda);
//                } break;
//
//                case 4: {
//                    String[] columnas = {"ID", "Nombre", "Banda", "Es independiente", "Tipo de musica", "Foto", "Descripcion", "Edad", "Nacionalidad", "Instrumento", "Sexo"};
//                    Object[][] datos = new Object[daoMusico.getAllMusicos().size()][11];
//                    int i = 0;
//                    for (Musico m : daoMusico.getAllMusicos()) {
//                        datos[i][0] = m.getId();
//                        datos[i][1] = m.getNombre();
//                        datos[i][2] = m.getBanda();
//                        datos[i][3] = m.isEsIndependiente();
//                        datos[i][4] = m.getTipoMusica();
//                        datos[i][5] = m.getFoto();
//                        datos[i][6] = m.getDescripcion();
//                        datos[i][7] = m.getEdad();
//                        datos[i][8] = m.getNacionalidad();
//                        datos[i][9] = m.getInstrumento();
//                        datos[i][10] = m.getSexo();
//                        i++;
//                    }
//                    JTable tabla = new JTable(datos, columnas);
//
//                    //change table model to make cells not editable
//                    tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
//                        public boolean isCellEditable(int row, int column) {
//                            return false;
//                        }
//                    });
//
//
//                    //Abrir los datos de la fila seleccionada al haceer doble click
//
//                    tabla.addMouseListener(new java.awt.event.MouseAdapter() {
//                        public void mouseClicked(java.awt.event.MouseEvent e) {
//                            if (e.getClickCount() == 2) {
//                                JTable target = (JTable) e.getSource();
//                                int row = target.getSelectedRow();
//                                int column = target.getSelectedColumn();
//                                JOptionPane.showMessageDialog(null, "ID: " + target.getValueAt(row, 0) + "\nNombre: " + target.getValueAt(row, 1) + "\nBanda: " + target.getValueAt(row, 2) + "\nEs independiente: " + target.getValueAt(row, 3) + "\nTipo de musica: " + target.getValueAt(row, 4) + "\nFoto: " + target.getValueAt(row, 5) + "\nDescripcion: " + target.getValueAt(row, 6) + "\nEdad: " + target.getValueAt(row, 7) + "\nNacionalidad: " + target.getValueAt(row, 8) + "\nInstrumento: " + target.getValueAt(row, 9) + "\nSexo: " + target.getValueAt(row, 10));
//                                Musico musico = daoMusico.getMusico((int) target.getValueAt(row, 0));
//
//                            }
//                        }
//                    });
//
//
//                    JFrame ventana = new JFrame();
//                    ventana.setSize(1000, 500);
//                    ventana.setTitle("Musicos");
//                    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    ventana.add(new JScrollPane(tabla));
//                    ventana.setLocationRelativeTo(null);
//                    ventana.setVisible(true);
//
//                }break;
//
//                case 5:{
//                    for (Banda b : daoBanda.getAllBandas()) {
//                        System.out.println(b);
//                    }break;
//                    }
//
//                case 6:{
//                    for (Festival f : daoFestival.getAllFestivales()) {
//                        System.out.println(f);
//                    }break;
//                    }
//
//            }
//        } while (opcion != 7);


    }

    private static void createAndShowGUI(DAOMusico daoMusico, DAOBanda daoBanda, DAOFestival daoFestival) {

        JFrame frame = new JFrame("FESTIVALES JPA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        // Crear un split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(300); // Establecer la posición inicial del divisor

        // Panel izquierdo con 5 botones
        JPanel leftPanel = new JPanel(new GridLayout(5, 1));
        JButton button1 = new JButton("Insertar Musico");
        JButton button2 = new JButton("Insertar Banda");
        JButton button3 = new JButton("Insertar Festival");
        JButton button4 = new JButton("Ver Musicos");
        JButton button5 = new JButton("Ver Bandas");
        JButton button6 = new JButton("Ver Festivales");
        JButton button7 = new JButton("Editar Musico");
        JButton button8 = new JButton("Ver Musico por Instrumento");
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);
        leftPanel.add(button5);
        leftPanel.add(button6);
        leftPanel.add(button7);
        leftPanel.add(button8);


        // Panel derecho (puedes agregar más componentes aquí)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(Color.LIGHT_GRAY);

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                System.out.println("Button clicked: " + clickedButton.getText());
                if (clickedButton.getText().equals("Insertar Musico")) {
                    rightPanel.removeAll();
                    rightPanel.add(createMusicoFormulario(daoMusico, daoBanda), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Insertar Banda")) {
                    rightPanel.removeAll();
                    rightPanel.add(createBandaFormulario(daoBanda), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Insertar Festival")) {
                    rightPanel.removeAll();
                    rightPanel.add(createFestivalFormulario(daoFestival), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Ver Musicos")) {
                    rightPanel.removeAll();
                    rightPanel.add(showAllMusicosPanel(daoMusico), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Ver Bandas")) {
                    rightPanel.removeAll();
                    rightPanel.add(showAllBandasPanel(daoBanda), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Ver Festivales")) {
                    rightPanel.removeAll();
                    rightPanel.add(showAllFestivalsPanel(daoFestival), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (clickedButton.getText().equals("Editar Musico")){
                    rightPanel.removeAll();
                    rightPanel.add(editarMusicoFormulario(daoMusico, daoBanda), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                }else if (clickedButton.getText().equals("Ver Musico por Instrumento")){
                    rightPanel.removeAll();
                    rightPanel.add(showMusicosByInstrumentoPanel(daoMusico), BorderLayout.CENTER);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                }

            }
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        button4.addActionListener(buttonListener);
        button5.addActionListener(buttonListener);
        button6.addActionListener(buttonListener);
        button7.addActionListener(buttonListener);
        button8.addActionListener(buttonListener);


        // Agregar los paneles al split pane
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        frame.add(splitPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JPanel createMusicoFormulario(DAOMusico daoMusico, DAOBanda daoBanda) {
        DAOMusico dmus = daoMusico;
        DAOBanda dban = daoBanda;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        // Agrega los componentes al formulario
        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Banda Id:"));
        JTextField bandaField = new JTextField();
        panel.add(bandaField);

        panel.add(new JLabel("¿Es independiente?"));
        JCheckBox independienteCheckBox = new JCheckBox();
        panel.add(independienteCheckBox);


        panel.add(new JLabel("Descripción:"));
        JTextArea descripcionArea = new JTextArea();
        panel.add(new JScrollPane(descripcionArea));

        panel.add(new JLabel("Edad:"));
        JSpinner edadSpinner = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));
        panel.add(edadSpinner);

        panel.add(new JLabel("Nacionalidad:"));
        JTextField nacionalidadField = new JTextField();
        panel.add(nacionalidadField);

        panel.add(new JLabel("Instrumento:"));
        JTextField instrumentoField = new JTextField();
        panel.add(instrumentoField);

        panel.add(new JLabel("Sexo:"));
        ButtonGroup sexoGroup = new ButtonGroup();
        JRadioButton masculinoRadioButton = new JRadioButton("Masculino");
        JRadioButton femeninoRadioButton = new JRadioButton("Femenino");
        sexoGroup.add(masculinoRadioButton);
        sexoGroup.add(femeninoRadioButton);
        JPanel sexoPanel = new JPanel();
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femeninoRadioButton);
        panel.add(sexoPanel);

        JButton guardarButton = new JButton("Guardar");
        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Musico musico = new Musico();
                musico.setNombre(nombreField.getText());
                Banda b = daoBanda.getBanda(Integer.parseInt(bandaField.getText()));
                musico.setBanda(b);
                musico.setEsIndependiente(independienteCheckBox.isSelected());
                musico.setTipoMusica(b.getTipoMusica());
                musico.setDescripcion(descripcionArea.getText());
                musico.setEdad((int) edadSpinner.getValue());
                musico.setNacionalidad(nacionalidadField.getText());
                musico.setInstrumento(instrumentoField.getText());
                musico.setSexo(masculinoRadioButton.isSelected() ? "M" : "F");
                dmus.insertMusico(musico);
                System.out.println(musico);
            }
        });


        return panel;
    }

    public static JPanel createBandaFormulario(DAOBanda daoBanda) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        // Agrega los componentes al formulario
        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Tipo de música:"));
        JTextField tipoMusicaField = new JTextField();
        panel.add(tipoMusicaField);

        panel.add(new JLabel("Logo:"));
        JButton openButton = new JButton("Open File Chooser");
        JFileChooser fileChooser = new JFileChooser();
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Handle the selected file here
                    String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Selected file: " + selectedFilePath);
                }
            }
        });
        panel.add(openButton);

        panel.add(new JLabel("Descripción:"));
        JTextArea descripcionArea = new JTextArea();
        panel.add(new JScrollPane(descripcionArea));


        JButton guardarButton = new JButton("Guardar");
        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Banda banda = new Banda();
                banda.setNombre(nombreField.getText());
                banda.setTipoMusica(new TipoMusica(tipoMusicaField.getText(), null));
                banda.setLogo(fileChooser.getSelectedFile().getAbsolutePath().getBytes());
                banda.setDescripcion(descripcionArea.getText());
                banda.setFechaCreacion(LocalDate.now());
                daoBanda.insertBanda(banda);
                System.out.println(banda);
            }
        });

        return panel;
    }

    public static JPanel createFestivalFormulario(DAOFestival daoFestival) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        // Agrega los componentes al formulario
        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Web:"));
        JTextField webField = new JTextField();
        panel.add(webField);

        panel.add(new JLabel("Logo:"));
        JButton openButton = new JButton("Open File Chooser");
        JFileChooser fileChooser = new JFileChooser();
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Handle the selected file here
                    String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Selected file: " + selectedFilePath);
                }
            }
        });
        panel.add(openButton);

        panel.add(new JLabel("Descripción:"));
        JTextArea descripcionArea = new JTextArea();
        panel.add(new JScrollPane(descripcionArea));

        panel.add(new JLabel("Lugar:"));
        JTextField lugarField = new JTextField();
        panel.add(lugarField);


        JButton guardarButton = new JButton("Guardar");
        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Festival festival = new Festival();
                festival.setNombre(nombreField.getText());
                festival.setWeb(webField.getText());
                festival.setLogo(fileChooser.getSelectedFile().getAbsolutePath().getBytes());
                festival.setDescripcion(descripcionArea.getText());
                festival.setLugar(lugarField.getText());
                festival.setFechaInicio(LocalDate.now());
                daoFestival.insertFestival(festival);
                System.out.println(festival);
            }
        });

        return panel;
    }

    public static JPanel showAllMusicosPanel(DAOMusico daoMusico) {
        String[] columnas = {"ID", "Nombre", "Banda", "Es independiente", "Tipo de musica", "Foto", "Descripcion", "Edad", "Nacionalidad", "Instrumento", "Sexo"};
        Object[][] datos = new Object[daoMusico.getAllMusicos().size()][11];
        int i = 0;
        for (Musico m : daoMusico.getAllMusicos()) {
            datos[i][0] = m.getId();
            datos[i][1] = m.getNombre();
            datos[i][2] = m.getBanda();
            datos[i][3] = m.isEsIndependiente();
            datos[i][4] = m.getTipoMusica();
            datos[i][5] = m.getFoto();
            datos[i][6] = m.getDescripcion();
            datos[i][7] = m.getEdad();
            datos[i][8] = m.getNacionalidad();
            datos[i][9] = m.getInstrumento();
            datos[i][10] = m.getSexo();
            i++;
        }
        JTable tabla = new JTable(datos, columnas);

        //change table model to make cells not editable
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });


        //Abrir los datos de la fila seleccionada al haceer doble click

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "ID: " + target.getValueAt(row, 0) + "\nNombre: " + target.getValueAt(row, 1) + "\nBanda: " + target.getValueAt(row, 2) + "\nEs independiente: " + target.getValueAt(row, 3) + "\nTipo de musica: " + target.getValueAt(row, 4) + "\nFoto: " + target.getValueAt(row, 5) + "\nDescripcion: " + target.getValueAt(row, 6) + "\nEdad: " + target.getValueAt(row, 7) + "\nNacionalidad: " + target.getValueAt(row, 8) + "\nInstrumento: " + target.getValueAt(row, 9) + "\nSexo: " + target.getValueAt(row, 10));
                    Musico musico = daoMusico.getMusico((int) target.getValueAt(row, 0));

                }
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;

    }

    public static JPanel showAllBandasPanel(DAOBanda daoBanda) {
        String[] columnas = {"ID", "Nombre", "Musicos", "Tipo de musica", "Logo", "Descripcion", "Fecha de creacion"};
        Object[][] datos = new Object[daoBanda.getAllBandas().size()][7];
        int i = 0;
        for (Banda b : daoBanda.getAllBandas()) {
            datos[i][0] = b.getId();
            datos[i][1] = b.getNombre();
            datos[i][2] = b.getMusicos();
            datos[i][3] = b.getTipoMusica();
            datos[i][4] = b.getLogo();
            datos[i][5] = b.getDescripcion();
            datos[i][6] = b.getFechaCreacion();
            i++;
        }
        JTable tabla = new JTable(datos, columnas);

        //change table model to make cells not editable
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "ID: " + target.getValueAt(row, 0) + "\nNombre: " + target.getValueAt(row, 1) + "\nMusicos: " + target.getValueAt(row, 2) + "\nTipo de musica: " + target.getValueAt(row, 3) + "\nLogo: " + target.getValueAt(row, 4) + "\nDescripcion: " + target.getValueAt(row, 5) + "\nFecha de creacion: " + target.getValueAt(row, 6));
                    Banda banda = daoBanda.getBanda((int) target.getValueAt(row, 0));

                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    public static JPanel showAllFestivalsPanel(DAOFestival daoFestival) {
        String[] columnas = {"ID", "Nombre", "Patrocinador", "Web", "Bandas"};
        Object[][] datos = new Object[daoFestival.getAllFestivales().size()][5];
        int i = 0;
        for (Festival f : daoFestival.getAllFestivales()) {
            datos[i][0] = f.getId();
            datos[i][1] = f.getNombre();
            datos[i][2] = f.getPatrocinador();
            datos[i][3] = f.getWeb();
            datos[i][4] = f.getBandas();
            i++;
        }
        JTable tabla = new JTable(datos, columnas);

        //change table model to make cells not editable
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "ID: " + target.getValueAt(row, 0) + "\nNombre: " + target.getValueAt(row, 1) + "\nPatrocinador: " + target.getValueAt(row, 2) + "\nWeb: " + target.getValueAt(row, 3) + "\nBandas: " + target.getValueAt(row, 4));
                    Festival festival = daoFestival.getFestival((int) target.getValueAt(row, 0));

                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    public static JPanel editarMusicoFormulario(DAOMusico daoMusico, DAOBanda daoBanda) {
        DAOMusico dmus = daoMusico;
        DAOBanda dban = daoBanda;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));



        // Agrega los componentes al formulario
        panel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Banda Id:"));
        JTextField bandaField = new JTextField();
        panel.add(bandaField);

        panel.add(new JLabel("¿Es independiente?"));
        JCheckBox independienteCheckBox = new JCheckBox();
        panel.add(independienteCheckBox);

        panel.add(new JLabel("Descripción:"));
        JTextArea descripcionArea = new JTextArea();
        panel.add(new JScrollPane(descripcionArea));

        panel.add(new JLabel("Edad:"));
        JSpinner edadSpinner = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));

        panel.add(edadSpinner);

        panel.add(new JLabel("Nacionalidad:"));
        JTextField nacionalidadField = new JTextField();
        panel.add(nacionalidadField);

        panel.add(new JLabel("Instrumento:"));
        JTextField instrumentoField = new JTextField();
        panel.add(instrumentoField);

        panel.add(new JLabel("Sexo:"));
        ButtonGroup sexoGroup = new ButtonGroup();
        JRadioButton masculinoRadioButton = new JRadioButton("Masculino");
        JRadioButton femeninoRadioButton = new JRadioButton("Femenino");
        sexoGroup.add(masculinoRadioButton);
        sexoGroup.add(femeninoRadioButton);
        JPanel sexoPanel = new JPanel();
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femeninoRadioButton);
        panel.add(sexoPanel);

        JButton guardarButton = new JButton("Guardar");

        panel.add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Musico musico = new Musico();
                musico.setId(Long.parseLong(idField.getText()));
                musico.setNombre(nombreField.getText());
                Banda b = daoBanda.getBanda(Integer.parseInt(bandaField.getText()));
                musico.setBanda(b);
                musico.setEsIndependiente(independienteCheckBox.isSelected());
                musico.setTipoMusica(b.getTipoMusica());
                musico.setDescripcion(descripcionArea.getText());
                musico.setEdad((int) edadSpinner.getValue());
                musico.setNacionalidad(nacionalidadField.getText());
                musico.setInstrumento(instrumentoField.getText());
                musico.setSexo(masculinoRadioButton.isSelected() ? "M" : "F");
                dmus.updateMusico(musico);
                System.out.println(musico);
            }
        });

        return panel;


    }

    public static JPanel showMusicosByInstrumentoPanel(DAOMusico daoMusico) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        // Agrega los componentes al formulario
        panel.add(new JLabel("Instrumento:"));
        JTextField instrumentoField = new JTextField();
        panel.add(instrumentoField);

        JButton buscarButton = new JButton("Buscar");
        panel.add(buscarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instrumento = instrumentoField.getText();
                List<MusicoDTO> musicos = daoMusico.getMusicosByInstrumento(instrumento);
                JTable tabla = new JTable();
                String[] columnas = {"Nombre", "Nacionalidad", "Instrumento", "Sexo"};
                Object[][] datos = new Object[musicos.size()][4];
                int i = 0;
                for (MusicoDTO m : musicos) {
                    datos[i][0] = m.getNombre();
                    datos[i][1] = m.getNacionalidad();
                    datos[i][2] = m.getInstrumento();
                    datos[i][3] = m.getSexo();
                    i++;
                }
                tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });

                JOptionPane.showMessageDialog(null, new JScrollPane(tabla));


            }
        });

        return panel;
    }
}