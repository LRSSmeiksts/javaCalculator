import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Thread.sleep;
// coment
class Calculator implements ActionListener, MouseListener {
    double number, result;
    int calcType;
    Color grey = new Color(77, 75, 75);
    Color darkGrey = new Color(61, 60, 60);
    Color lightGrey = new Color(219, 217, 217);
    JFrame frame;
    JPanel outsideUpper;
    JPanel innerUpper;
    JTextField display;
    JPanel keyPadPanel;
    JPanel innerPadPanel;
    JButton bttDEC = new JButton(".");
    JButton bttC = new JButton("C");
    JButton bttAC = new JButton("AC");
    JButton bttEQ = new JButton("=");
    JButton bttPLUS = new JButton("+");
    JButton bttMINUS = new JButton("-");
    JButton bttDIV = new JButton("/");
    JButton bttMUL = new JButton("*");
    JButton btt0 = new JButton("0");
    JButton btt1 = new JButton("1");
    JButton btt2 = new JButton("2");
    JButton btt3 = new JButton("3");
    JButton btt4 = new JButton("4");
    JButton btt5 = new JButton("5");
    JButton btt6 = new JButton("6");
    JButton btt7 = new JButton("7");
    JButton btt8 = new JButton("8");
    JButton btt9 = new JButton("9");

    public void formatButton (JButton btt){
        btt.setBackground(darkGrey);
        btt.setBorder(null);
        btt.setFont(new Font("Arial", Font.BOLD, 20));
        btt.setForeground(new Color(219, 217, 217));
    }
    public void GUISetUp(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(420,640);
        ImageIcon icon = new ImageIcon("calcLogo.png");
        frame.setIconImage(icon.getImage());

        outsideUpper = new JPanel();
        JPanel outsideUpper = new JPanel();
        outsideUpper.setBackground(grey);
        outsideUpper.setBounds(0,0,420,180);
        outsideUpper.setLayout(null);

        innerUpper = new JPanel();
        innerUpper.setBackground(lightGrey);
        innerUpper.setBounds(14,20,380,140);
        innerUpper.setLayout(new GridLayout(1,1,20,15));
        outsideUpper.add(innerUpper);

        display = new JTextField();
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 65));
        display.setForeground(new Color(46, 45, 45));
        display.setBackground(lightGrey);
        display.setEditable(false);
        display.setText("");
        innerUpper.add(display);

        keyPadPanel = new JPanel();
        keyPadPanel.setBackground(grey);
        keyPadPanel.setBounds(0,180,420,460);
        keyPadPanel.setLayout(null);

        innerPadPanel = new JPanel();
        innerPadPanel.setBackground(new Color(77, 75, 75));
        innerPadPanel.setBounds(14,30,380,360);
        innerPadPanel.setLayout(new GridLayout(5,4,12,10));
        keyPadPanel.add(innerPadPanel);

        formatButton(bttDEC);
        formatButton(bttC);
        formatButton(bttAC);
        formatButton(bttEQ);
        formatButton(bttPLUS);
        formatButton(bttMINUS);
        formatButton(bttMUL);
        formatButton(bttDIV);
        formatButton(btt0);
        formatButton(btt1);
        formatButton(btt2);
        formatButton(btt3);
        formatButton(btt4);
        formatButton(btt5);
        formatButton(btt6);
        formatButton(btt7);
        formatButton(btt8);
        formatButton(btt9);

        bttDEC.addActionListener(this);
        bttC.addActionListener(this);
        bttAC.addActionListener(this);
        bttEQ.addActionListener(this);
        bttPLUS.addActionListener(this);
        bttMINUS.addActionListener(this);
        bttMUL.addActionListener(this);
        bttDIV.addActionListener(this);
        btt0.addActionListener(this);
        btt1.addActionListener(this);
        btt2.addActionListener(this);
        btt3.addActionListener(this);
        btt4.addActionListener(this);
        btt5.addActionListener(this);
        btt6.addActionListener(this);
        btt7.addActionListener(this);
        btt8.addActionListener(this);
        btt9.addActionListener(this);

        bttDEC.addMouseListener(this);
        bttC.addMouseListener(this);
        bttAC.addMouseListener(this);
        bttEQ.addMouseListener(this);
        bttPLUS.addMouseListener(this);
        bttMINUS.addMouseListener(this);
        bttMUL.addMouseListener(this);
        bttDIV.addMouseListener(this);
        btt0.addMouseListener(this);
        btt1.addMouseListener(this);
        btt2.addMouseListener(this);
        btt3.addMouseListener(this);
        btt4.addMouseListener(this);
        btt5.addMouseListener(this);
        btt6.addMouseListener(this);
        btt7.addMouseListener(this);
        btt8.addMouseListener(this);
        btt9.addMouseListener(this);




        //row 1
        innerPadPanel.add(new JLabel());
        innerPadPanel.add(new JLabel());
        innerPadPanel.add(bttAC);
        innerPadPanel.add(bttC);
        //row 2
        innerPadPanel.add(btt1);
        innerPadPanel.add(btt2);
        innerPadPanel.add(btt3);
        innerPadPanel.add(bttPLUS);
        //row 3
        innerPadPanel.add(btt4);
        innerPadPanel.add(btt5);
        innerPadPanel.add(btt6);
        innerPadPanel.add(bttMINUS);
        //row 4
        innerPadPanel.add(btt7);
        innerPadPanel.add(btt8);
        innerPadPanel.add(btt9);
        innerPadPanel.add(bttMUL);
        //row 5
        innerPadPanel.add(btt0);
        innerPadPanel.add(bttDEC);
        innerPadPanel.add(bttEQ);
        innerPadPanel.add(bttDIV);

        frame.add(outsideUpper);
        frame.add(keyPadPanel);
        frame.setVisible(true);
    }
    Calculator(){
        GUISetUp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source == bttAC) {
                display.setText("");
            } else if (source == bttC) {
                int length = display.getText().length();
                int number = length - 1;
                if (length >= 1) {
                    StringBuilder back = new StringBuilder(display.getText());
                    back.deleteCharAt(number);
                    display.setText(back.toString());
                }
            } else if (source == btt0) {
                if (display.getText().equals("0")) {
                    return;
                } else {
                    display.setText(display.getText() + "0");
                }

            } else if (source == btt1) {
                display.setText(display.getText() + "1");
            } else if (source == btt2) {
                display.setText(display.getText() + "2");
            } else if (source == btt3) {
                display.setText(display.getText() + "3");
            } else if (source == btt4) {
                display.setText(display.getText() + "4");
            } else if (source == btt5) {
                display.setText(display.getText() + "5");
            } else if (source == btt6) {
                display.setText(display.getText() + "6");
            } else if (source == btt7) {
                display.setText(display.getText() + "7");
            } else if (source == btt8) {
                display.setText(display.getText() + "8");
            } else if (source == btt9) {
                display.setText(display.getText() + "9");
            } else if (source == bttDEC) {
                if (display.getText().contains(".")) {
                    return;
                } else {
                    display.setText(display.getText() + ".");
                }
            } else if (source == bttPLUS) {
                String str = display.getText();
                number = Double.parseDouble(display.getText());
                display.setText("");
                calcType = 1;
            } else if (source == bttMINUS) {
                String str = display.getText();
                number = Double.parseDouble(display.getText());
                display.setText("");
                calcType = 2;
            } else if (source == bttMUL) {
                String str = display.getText();
                number = Double.parseDouble(display.getText());
                display.setText("");
                calcType = 3;
            } else if (source == bttDIV) {
                String str = display.getText();
                number = Double.parseDouble(display.getText());
                display.setText("");
                calcType = 4;
            } else if (source == bttEQ) {
                switch (calcType) {
                    case 1:
                        System.out.println(number);
                        System.out.println(Double.parseDouble(display.getText()));
                        result = number + Double.parseDouble(display.getText());
                        System.out.println(result);
                        if (Double.toString(result).endsWith(".0")) {
                            display.setText(Double.toString(result).replace(".0", ""));
                            break;
                        } else {
                            display.setText(Double.toString(result));
                            break;
                        }
                    case 2:
                        result = number - Double.parseDouble(display.getText());
                        if (Double.toString(result).endsWith(".0")) {
                            display.setText(Double.toString(result).replace(".0", ""));
                        } else {
                            display.setText(Double.toString(result));
                            break;
                        }
                    case 3:
                        result = number * Double.parseDouble(display.getText());
                        if (Double.toString(result).endsWith(".0")) {
                            display.setText(Double.toString(result).replace(".0", ""));
                        } else {
                            display.setText(Double.toString(result));
                            break;
                        }
                    case 4:
                        if (display.getText().equals("0")) {
                            display.setText("0");
                            break;
                        }
                        result = number / Double.parseDouble(display.getText());
                        String resultStr = Double.toString(result);
                        if(resultStr.length()>8){
                            String temp="";
                            char[] tempArray = resultStr.toCharArray();
                            for(int i =0; i<8; i++){
                                temp += tempArray[i];
                                if(i==8){
                                    break;
                                }
                            }
                            System.out.println(temp);
                            result= Double.parseDouble(temp);
                        }
                        if (Double.toString(result).endsWith(".0")) {
                            display.setText(Double.toString(result).replace(".0", ""));
                        } else {
                            display.setText(Double.toString(result));
                            break;
                        }

                }
            }
            if(display.getText().length()>8){
                display.setText("ERR");
            }
        }
        catch(Exception exception){
            display.setText("ERR");
            try {
                sleep(500);
                display.setText("");
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    @Override
    public void mouseClicked(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(lightGrey);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        JButton btn = (JButton) e.getSource();
        btn.setBackground(darkGrey);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(46, 45, 45));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(darkGrey);
    }

    public static void main(String[] args){
        new Calculator();
    }
}