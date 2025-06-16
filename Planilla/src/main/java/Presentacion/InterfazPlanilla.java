package Presentacion;

import Logica.*;
import Util.ArchivoHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InterfazPlanilla extends JFrame {

    private JTextField txtNombre, txtApellido1, txtApellido2, txtCedula, txtDatoExtra;
    private JComboBox<String> comboTipo;
    private JTable tabla;
    private DefaultTableModel modelo;
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public InterfazPlanilla() {
        setTitle("Gestión de Colaboradores");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        crearFormulario();
        crearTabla();
        crearBotones();

        cargarDesdeArchivo(); // al iniciar
        setVisible(true);
    }

    private void crearFormulario() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido1 = new JTextField();
        txtApellido2 = new JTextField();
        txtDatoExtra = new JTextField();

        comboTipo = new JComboBox<>(new String[]{"Gerente", "Horas", "Comision"});
        comboTipo.addActionListener(e -> actualizarEtiquetaDato());

        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido 1:"));
        panel.add(txtApellido1);
        panel.add(new JLabel("Apellido 2:"));
        panel.add(txtApellido2);
        panel.add(new JLabel("Dato extra (Posición, Horas o ventas):"));
        panel.add(txtDatoExtra);
        panel.add(new JLabel("Tipo de colaborador:"));
        panel.add(comboTipo);

        add(panel, BorderLayout.NORTH);
    }

    private void actualizarEtiquetaDato() {
        String tipo = (String) comboTipo.getSelectedItem();
        if (tipo.equals("Gerente")) {
            txtDatoExtra.setToolTipText("Posición: A, B o C");
        } else if (tipo.equals("Horas")) {
            txtDatoExtra.setToolTipText("Cantidad de horas trabajadas");
        } else {
            txtDatoExtra.setToolTipText("Cantidad de ventas");
        }
        
    }

    private void crearTabla() {
        modelo = new DefaultTableModel(new Object[]{"Cédula", "Nombre", "Tipo", "Salario"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void crearBotones() {
        JPanel panel = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarColaborador());
        panel.add(btnAgregar);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(e -> mostrarSeleccionado());
        panel.add(btnMostrar);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarEnArchivo());
        panel.add(btnGuardar);

        JButton btnCargar = new JButton("Cargar");
        btnCargar.addActionListener(e -> {
            colaboradores.clear();
            modelo.setRowCount(0);
            cargarDesdeArchivo();
        });
        panel.add(btnCargar);

        add(panel, BorderLayout.SOUTH);
    }

    private void agregarColaborador() {
        try {
            int cedula = Integer.parseInt(txtCedula.getText());
            String nombre = txtNombre.getText();
            String ap1 = txtApellido1.getText();
            String ap2 = txtApellido2.getText();
            String extra = txtDatoExtra.getText();
            String tipo = (String) comboTipo.getSelectedItem();

            Colaborador col = null;
            if (tipo.equals("Gerente")) {
                col = new ColaboradorGerente(cedula, nombre, ap1, ap2, extra);
            } else if (tipo.equals("Horas")) {
                int horas = Integer.parseInt(extra);
                col = new colaboradorHoras(horas, nombre, ap1, ap2, cedula);
            }
            else if (tipo.equals("Comision")) {
                int ventas = Integer.parseInt(extra);
                col = new ColaboradorBaseComision(cedula, nombre, ap1, ap2, ventas);
            }

            if (col != null) {
                colaboradores.add(col);
                modelo.addRow(new Object[]{
                    cedula,
                    nombre + " " + ap1 + " " + ap2,
                    tipo,
                    col.calcularSalario()
                });
                limpiarCampos();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void mostrarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0 && fila < colaboradores.size()) {
            colaboradores.get(fila).Mostrar();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccioná una fila válida.");
        }
    }

    private void guardarEnArchivo() {
        ArchivoHelper.guardar(colaboradores, "colaboradores.txt");
        JOptionPane.showMessageDialog(this, "Colaboradores guardados exitosamente.");
    }

    private void cargarDesdeArchivo() {
        colaboradores = ArchivoHelper.cargar("colaboradores.txt");
        for (Colaborador c : colaboradores) {
            String tipo = (c instanceof ColaboradorGerente) ? "Gerente" : "Horas";
            modelo.addRow(new Object[]{
                c.getCedula(),
                c.getNombre() + " " + c.getApellido1() + " " + c.getApellido2(),
                tipo,
                c.calcularSalario()
            });
        }
    }

    private void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtDatoExtra.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazPlanilla::new);
    }
}
