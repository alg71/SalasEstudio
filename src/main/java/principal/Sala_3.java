
package principal;

import principal.data.SalaEstudioRepository;
import principal.data.ModeloSalaEstudio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.boot.SpringApplication;

public class Sala_3 extends JFrame {

    private ModeloSalaEstudio modeloSalaEstudio;    
    private JLabel labelAforo;

    public Sala_3(SalaEstudioRepository salaEstudioRepository) {
        this.modeloSalaEstudio = new ModeloSalaEstudio(salaEstudioRepository);              
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void initComponents() {
        setTitle("Control de accesos SALA 3");
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
                modeloSalaEstudio.aumentarAforo(3);
            }
        });

        disminuirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloSalaEstudio.disminuirAforo(3);
            }
        });
    }

    public static void main(String[] args) {
        // Inicializar la aplicación Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                SalaEstudioRepository salaEstudioRepository = SpringApplication.run(SalasEstudioApplication.class, args)
                        .getBean(SalaEstudioRepository.class);
                new Sala_3(salaEstudioRepository).setVisible(true);
            }
        });
    }
}
