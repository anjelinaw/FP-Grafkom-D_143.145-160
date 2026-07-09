package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslasiPanel extends JPanel {

    JTextField txtX = new JTextField();
    JTextField txtY = new JTextField();

    JTextField txtTx = new JTextField();
    JTextField txtTy = new JTextField();

    JTextField hasilX = new JTextField();
    JTextField hasilY = new JTextField();

    JButton btnHitung = new JButton("Translasi");
    JButton btnReset = new JButton("Reset");

    public TranslasiPanel() {

        setLayout(null);
        setBackground(new Color(135, 199, 255));

        JLabel title = new JLabel("TRANSFORMASI - TRANSLASI");
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setBounds(240,20,400,40);
        add(title);

        //================ INPUT TITIK =================

        JLabel lblInput = new JLabel("Titik Awal");
        lblInput.setFont(new Font("Arial",Font.BOLD,18));
        lblInput.setBounds(120,80,150,30);
        add(lblInput);

        JLabel lblX = new JLabel("X");
        lblX.setBounds(70,140,30,30);
        add(lblX);

        txtX.setBounds(100,140,120,30);
        add(txtX);

        JLabel lblY = new JLabel("Y");
        lblY.setBounds(70,190,30,30);
        add(lblY);

        txtY.setBounds(100,190,120,30);
        add(txtY);

        //================ TRANSLASI =================

        JLabel lblTrans = new JLabel("Nilai Translasi");
        lblTrans.setFont(new Font("Arial",Font.BOLD,18));
        lblTrans.setBounds(500,80,180,30);
        add(lblTrans);

        JLabel lblTx = new JLabel("Tx");
        lblTx.setBounds(470,140,30,30);
        add(lblTx);

        txtTx.setBounds(510,140,120,30);
        add(txtTx);

        JLabel lblTy = new JLabel("Ty");
        lblTy.setBounds(470,190,30,30);
        add(lblTy);

        txtTy.setBounds(510,190,120,30);
        add(txtTy);

        //================ OUTPUT =================

        JLabel lblOutput = new JLabel("Hasil Translasi");
        lblOutput.setFont(new Font("Arial",Font.BOLD,18));
        lblOutput.setBounds(300,280,200,30);
        add(lblOutput);

        JLabel lblHX = new JLabel("X'");
        lblHX.setBounds(260,340,30,30);
        add(lblHX);

        hasilX.setBounds(300,340,120,30);
        hasilX.setEditable(false);
        add(hasilX);

        JLabel lblHY = new JLabel("Y'");
        lblHY.setBounds(260,390,30,30);
        add(lblHY);

        hasilY.setBounds(300,390,120,30);
        hasilY.setEditable(false);
        add(hasilY);

        //================ BUTTON =================

        btnHitung.setBounds(250,470,130,40);
        add(btnHitung);

        btnReset.setBounds(420,470,100,40);
        add(btnReset);

        //================ EVENT TRANSLASI =================

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int x = Integer.parseInt(txtX.getText());
                    int y = Integer.parseInt(txtY.getText());

                    int tx = Integer.parseInt(txtTx.getText());
                    int ty = Integer.parseInt(txtTy.getText());

                    int xBaru = x + tx;
                    int yBaru = y + ty;

                    hasilX.setText(String.valueOf(xBaru));
                    hasilY.setText(String.valueOf(yBaru));

                    JOptionPane.showMessageDialog(null,
                            "Titik Awal : ("+x+","+y+")\n"+
                                    "Translasi : ("+tx+","+ty+")\n\n"+
                                    "Hasil : ("+xBaru+","+yBaru+")");

                }catch(Exception ex){

                    JOptionPane.showMessageDialog(null,"Input harus berupa angka!");

                }

            }
        });

        //================ RESET =================

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtX.setText("");
                txtY.setText("");

                txtTx.setText("");
                txtTy.setText("");

                hasilX.setText("");
                hasilY.setText("");

            }
        });

    }

}
