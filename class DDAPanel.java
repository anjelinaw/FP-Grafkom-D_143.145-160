package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DDAPanel extends JPanel {

    JTextField txtX1 = new JTextField();
    JTextField txtY1 = new JTextField();

    JTextField txtX2 = new JTextField();
    JTextField txtY2 = new JTextField();

    JButton btnGenerate = new JButton("Generate DDA");
    JButton btnReset = new JButton("Reset");

    JTextArea hasil = new JTextArea();

    public DDAPanel() {

        setLayout(null);
        setBackground(new Color(108, 218, 142));

        JLabel title = new JLabel("DDA LINE ALGORITHM");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(260,20,350,35);
        add(title);

        //================ Titik Awal =================

        JLabel lblAwal = new JLabel("Titik Awal");
        lblAwal.setFont(new Font("Arial", Font.BOLD,18));
        lblAwal.setBounds(120,80,150,30);
        add(lblAwal);

        JLabel lblX1 = new JLabel("X1");
        lblX1.setBounds(80,130,30,30);
        add(lblX1);

        txtX1.setBounds(120,130,100,30);
        add(txtX1);

        JLabel lblY1 = new JLabel("Y1");
        lblY1.setBounds(80,180,30,30);
        add(lblY1);

        txtY1.setBounds(120,180,100,30);
        add(txtY1);

        //================ Titik Akhir =================

        JLabel lblAkhir = new JLabel("Titik Akhir");
        lblAkhir.setFont(new Font("Arial", Font.BOLD,18));
        lblAkhir.setBounds(520,80,150,30);
        add(lblAkhir);

        JLabel lblX2 = new JLabel("X2");
        lblX2.setBounds(480,130,30,30);
        add(lblX2);

        txtX2.setBounds(520,130,100,30);
        add(txtX2);

        JLabel lblY2 = new JLabel("Y2");
        lblY2.setBounds(480,180,30,30);
        add(lblY2);

        txtY2.setBounds(520,180,100,30);
        add(txtY2);

        //================ Tombol =================

        btnGenerate.setBounds(250,250,150,40);
        add(btnGenerate);

        btnReset.setBounds(430,250,100,40);
        add(btnReset);

        //================ Output =================

        JLabel lblOutput = new JLabel("Output Titik DDA");
        lblOutput.setFont(new Font("Arial",Font.BOLD,18));
        lblOutput.setBounds(320,320,180,30);
        add(lblOutput);

        hasil.setEditable(false);

        JScrollPane scroll = new JScrollPane(hasil);
        scroll.setBounds(180,360,450,150);

        add(scroll);

        //================ Event Generate =================

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    double x1 = Double.parseDouble(txtX1.getText());
                    double y1 = Double.parseDouble(txtY1.getText());

                    double x2 = Double.parseDouble(txtX2.getText());
                    double y2 = Double.parseDouble(txtY2.getText());

                    double dx = x2 - x1;
                    double dy = y2 - y1;

                    double step = Math.max(Math.abs(dx), Math.abs(dy));

                    double xInc = dx / step;
                    double yInc = dy / step;

                    double x = x1;
                    double y = y1;

                    hasil.setText("");

                    hasil.append("===== HASIL DDA =====\n\n");
                    hasil.append(String.format("dx = %.2f\n",dx));
                    hasil.append(String.format("dy = %.2f\n",dy));
                    hasil.append(String.format("Step = %.0f\n",step));
                    hasil.append(String.format("X Increment = %.2f\n",xInc));
                    hasil.append(String.format("Y Increment = %.2f\n\n",yInc));

                    hasil.append("No\tX\tY\n");
                    hasil.append("---------------------------\n");

                    for(int i=0;i<=step;i++){

                        hasil.append(i+"\t"+
                                Math.round(x)+
                                "\t"+
                                Math.round(y)+
                                "\n");

                        x += xInc;
                        y += yInc;

                    }

                }catch(Exception ex){

                    JOptionPane.showMessageDialog(null,
                            "Input harus berupa angka!");

                }

            }
        });

        //================ Reset =================

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtX1.setText("");
                txtY1.setText("");

                txtX2.setText("");
                txtY2.setText("");

                hasil.setText("");

            }
        });

    }

}
