package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.boot.SpringApplication;

public class SalaEstudioUI extends JFrame {

    
    private SalaEstudioRepository salaEstudioRepository;
    private JLabel labelAforo;

    public SalaEstudioUI(SalaEstudioRepository salaEstudioRepository) {
        this.salaEstudioRepository = salaEstudioRepository;
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void initComponents() {
        setTitle("Control de accesos sala");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Botones (lectores) para aumentar y disminuir el aforo        
        JButton disminuirButton = new JButton("Lector Entrada");
        JButton aumentarButton = new JButton("Lector Salida");
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(disminuirButton);
        buttonPanel.add(aumentarButton);
        add(buttonPanel, BorderLayout.CENTER);

        aumentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarAforo();
            }
        });

        disminuirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disminuirAforo();
            }
        });
    }

    private void aumentarAforo() {
        // Incrementar el aforo y actualizar la etiqueta
        salaEstudioRepository.findAll().forEach(salaEstudio -> {
            salaEstudio.setAforoActual(salaEstudio.getAforoActual() + 1);
            salaEstudioRepository.save(salaEstudio);
        });

    }

    private void disminuirAforo() {
        // Disminuir el aforo y actualizar la etiqueta
        salaEstudioRepository.findAll().forEach(salaEstudio -> {
            salaEstudio.setAforoActual(salaEstudio.getAforoActual() - 1);
            salaEstudioRepository.save(salaEstudio);
        });

    }

    public static void main(String[] args) {
        // Inicializar la aplicación Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Asegúrate de que SalaEstudioRepository haya sido inyectado en SalasEstudioApplication antes de crear SalaEstudioUI
                SalaEstudioRepository salaEstudioRepository = SpringApplication.run(SalasEstudioApplication.class, args)
                        .getBean(SalaEstudioRepository.class);
                new SalaEstudioUI(salaEstudioRepository).setVisible(true);
            }
        });
    }
}
