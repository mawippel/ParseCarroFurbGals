package br.com.furb.gui;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import br.com.furb.Carro;
import br.com.furb.CarroParser;
import br.com.furb.exception.ParseCarroException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mhraymundo
 */
public class ComercioGUI extends javax.swing.JFrame {

    public ComercioGUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneEntrada = new javax.swing.JScrollPane();
        txtAreaEntrada = new javax.swing.JTextArea();
        scrollPaneSaida = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();
        btAnalisar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btEquipe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comércio de veículos");
        setMaximumSize(new java.awt.Dimension(870, 670));
        setMinimumSize(new java.awt.Dimension(870, 670));
        setResizable(false);

        scrollPaneEntrada.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneEntrada.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneEntrada.setAutoscrolls(true);

        txtAreaEntrada.setColumns(20);
        txtAreaEntrada.setRows(5);
        txtAreaEntrada.setBorder(new NumberedBorder());
        txtAreaEntrada.setMaximumSize(new java.awt.Dimension(9999, 400));
        txtAreaEntrada.setMinimumSize(new java.awt.Dimension(4, 400));
        txtAreaEntrada.setPreferredSize(null);
        scrollPaneEntrada.setViewportView(txtAreaEntrada);
        txtAreaEntrada.getAccessibleContext().setAccessibleParent(this);

        txtSaida.setEditable(false);
        txtSaida.setColumns(20);
        txtSaida.setRows(5);
        txtSaida.setMaximumSize(new java.awt.Dimension(2147483647, 198));
        txtSaida.setMinimumSize(new java.awt.Dimension(4, 198));
        txtSaida.setPreferredSize(null);
        scrollPaneSaida.setViewportView(txtSaida);

        btAnalisar.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("ic_pesquisar.png"))); // NOI18N
        btAnalisar.setText("analisar");
        btAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalisarActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("ic_limpar.png"))); // NOI18N
        btLimpar.setText("limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btEquipe.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("ic_equipe.png"))); // NOI18N
        btEquipe.setText("equipe");
        btEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEquipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneEntrada)
            .addComponent(scrollPaneSaida)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPaneEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEquipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAnalisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnalisarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	if (txtAreaEntrada.getText().trim().isEmpty()) {
    		txtSaida.setText("");
    		return;
		}

    	try {
    		Carro carro = CarroParser.processar(this.txtAreaEntrada.getText());
    		txtSaida.setText(carro.toString());
		} catch (Exception e) {
			txtSaida.setText(e.getMessage());
		}
    }

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.txtSaida.setText(null);
        this.txtAreaEntrada.setText(null);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEquipeActionPerformed
    	this.txtSaida.setText("Desenvolvedores: Marcelo Wippel, Matheus Henrique e Wallace Reetz.");
    }//GEN-LAST:event_btEquipeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ComercioGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComercioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalisar;
    private javax.swing.JButton btEquipe;
    private javax.swing.JButton btLimpar;
    private javax.swing.JScrollPane scrollPaneEntrada;
    private javax.swing.JScrollPane scrollPaneSaida;
    private javax.swing.JTextArea txtAreaEntrada;
    private javax.swing.JTextArea txtSaida;
    // End of variables declaration//GEN-END:variables
}
