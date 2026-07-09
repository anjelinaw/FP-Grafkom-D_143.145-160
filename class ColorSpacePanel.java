package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSpacePanel extends JPanel {

    JTextField txtR = new JTextField();
    JTextField txtG = new JTextField();
    JTextField txtB = new JTextField();

    JTextField txtC = new JTextField();
    JTextField txtM = new JTextField();
    JTextField txtY = new JTextField();
    JTextField txtK = new JTextField();

    JPanel preview = new JPanel();

    JButton btnConvert = new JButton("RGB → CMYK");
    JButton btnReset = new JButton("Reset");

    public ColorSpacePanel() {

        setLayout(null);
        setBackground(new Color(255, 131, 193));

        JLabel title = new JLabel("COLOR SPACE");
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setBounds(330,20,250,40);
        add(title);

        JLabel rgb = new JLabel("RGB");
        rgb.setFont(new Font("Arial",Font.BOLD,18));
        rgb.setBounds(120,90,100,30);
        add(rgb);

        JLabel cmyk = new JLabel("CMYK");
        cmyk.setFont(new Font("Arial",Font.BOLD,18));
        cmyk.setBounds(520,90,100,30);
        add(cmyk);

        // ================= RGB =================

        JLabel r = new JLabel("R");
        r.setBounds(70,140,30,30);
        add(r);

        txtR.setBounds(100,140,120,30);
        add(txtR);

        JLabel g = new JLabel("G");
        g.setBounds(70,190,30,30);
        add(g);

        txtG.setBounds(100,190,120,30);
        add(txtG);

        JLabel b = new JLabel("B");
        b.setBounds(70,240,30,30);
        add(b);

        txtB.setBounds(100,240,120,30);
        add(txtB);

        // ================= CMYK =================

        JLabel c = new JLabel("C");
        c.setBounds(470,140,30,30);
        add(c);

        txtC.setEditable(false);
        txtC.setBounds(500,140,120,30);
        add(txtC);

        JLabel m = new JLabel("M");
        m.setBounds(470,190,30,30);
        add(m);

        txtM.setEditable(false);
        txtM.setBounds(500,190,120,30);
        add(txtM);

        JLabel y = new JLabel("Y");
        y.setBounds(470,240,30,30);
        add(y);

        txtY.setEditable(false);
        txtY.setBounds(500,240,120,30);
        add(txtY);

        JLabel k = new JLabel("K");
        k.setBounds(470,290,30,30);
        add(k);

        txtK.setEditable(false);
        txtK.setBounds(500,290,120,30);
        add(txtK);

        // ================= Tombol =================

        btnConvert.setBounds(250,360,150,40);
        add(btnConvert);

        btnReset.setBounds(430,360,120,40);
        add(btnReset);

        // ================= Preview =================

        JLabel lblPreview = new JLabel("Preview Warna");
        lblPreview.setBounds(330,430,150,30);
        add(lblPreview);

        preview.setBounds(300,460,180,60);
        preview.setBackground(Color.WHITE);
        preview.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(preview);

        // ================= Event Convert =================

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int R = Integer.parseInt(txtR.getText());
                    int G = Integer.parseInt(txtG.getText());
                    int B = Integer.parseInt(txtB.getText());

                    if(R<0 || R>255 || G<0 || G>255 || B<0 || B>255){

                        JOptionPane.showMessageDialog(null,"RGB harus antara 0 - 255");
                        return;

                    }

                    double r = R/255.0;
                    double g = G/255.0;
                    double b = B/255.0;

                    double K = 1-Math.max(r,Math.max(g,b));

                    double C,M,Y;

                    if(K==1){

                        C=0;
                        M=0;
                        Y=0;

                    }else{

                        C=(1-r-K)/(1-K);
                        M=(1-g-K)/(1-K);
                        Y=(1-b-K)/(1-K);

                    }

                    txtC.setText(String.format("%.2f %%",C*100));
                    txtM.setText(String.format("%.2f %%",M*100));
                    txtY.setText(String.format("%.2f %%",Y*100));
                    txtK.setText(String.format("%.2f %%",K*100));

                    preview.setBackground(new Color(R,G,B));

                }catch(Exception ex){

                    JOptionPane.showMessageDialog(null,"Input harus berupa angka!");

                }

            }
        });

        // ================= Reset =================

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtR.setText("");
                txtG.setText("");
                txtB.setText("");

                txtC.setText("");
                txtM.setText("");
                txtY.setText("");
                txtK.setText("");

                preview.setBackground(Color.WHITE);

            }
        });

    }

}
