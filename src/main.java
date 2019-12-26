import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main {



    public static int b=0;
    public static void main(String[] args) {
        int Width=900;
        int Height=650;
        JFrame frame=Frame();
        frame.add(Pan());

    }

    static JPanel Pan(){
        JPanel main = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JRadioButton f1=new JRadioButton("F(x, y, z)1", false);
        JRadioButton f2=new JRadioButton("F(x, y, z)2", false);
        f1.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        f2.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        ButtonGroup func=new ButtonGroup();
        func.add(f1);
        func.add(f2);
        JButton mc=new JButton("MC");

        JLabel im=new JLabel("Choose function");
        JButton m=new JButton("M+");
        mc.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        m.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        im.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        Box box= Box.createHorizontalBox();
        box.add(mc);
        box.add(Box.createHorizontalStrut(100));
        box.add(im);
        box.add(Box.createHorizontalStrut(100));
        box.add(m);
        p2.add(box);




        JLabel title=new JLabel("Choose function  ");
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        ButtonGroup var=new ButtonGroup();
        JRadioButton varX=new JRadioButton("X", true);
        varX.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        JRadioButton varY=new JRadioButton("Y",false);
        varY.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        JRadioButton varZ=new JRadioButton("Z",false);
        varZ.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        var.add(varX);
        var.add(varY);
        var.add(varZ);


        JTextField inputX=new JTextField();
        inputX.setEditable(true);
        inputX.setVisible(true);
        JTextField inputY=new JTextField();
        inputY.setEditable(true);
        inputY.setVisible(true);
        JTextField inputZ=new JTextField();
        inputZ.setEditable(true);
        inputZ.setVisible(true);



       // main.setLayout(new BorderLayout());

        //p3.setLayout(new BorderLayout());
        p1.add(title);
        p1.add(f1);
        p1.add(f2);
        p3.add(varX);
        p3.add(varY);
        p3.add(varZ);
        Box ultBox=Box.createVerticalBox();
        ultBox.add(p1);
        ultBox.add(Box.createVerticalStrut(50));
        ultBox.add(p2);
        ultBox.add(Box.createVerticalStrut(50));
        ultBox.add(p3);
        ultBox.add(Box.createVerticalStrut(10));
        ultBox.add(new JLabel("Var value: "));
        ultBox.add(Box.createVerticalStrut(5));
        ultBox.add(inputX);
        ultBox.add(Box.createVerticalStrut(5));
        ultBox.add(inputY);
        ultBox.add(Box.createVerticalStrut(5));
        ultBox.add(inputZ);
        ultBox.add(Box.createVerticalStrut(20));

        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                b=1;
                im.setIcon(new ImageIcon("./res/img.png"));
                im.setText(" ");

            }
        });
        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                b=2;
                im.setIcon(new ImageIcon("./res/pic2.png"));
                im.setText(" ");
            }
        });
        inputX.setVisible(false);
        inputY.setVisible(false);
        inputZ.setVisible(false);

        /*main.add(p2, BorderLayout.CENTER);
        main.add(p3, BorderLayout.SOUTH);*/
        varX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputX.setVisible(true);
                main.revalidate();
                main.repaint();

                inputY.setVisible(false);
                main.revalidate();
                main.repaint();

                inputZ.setVisible(false);
                main.revalidate();
                main.repaint();
            }
        });
        varZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputX.setVisible(false);
                main.revalidate();
                main.repaint();

                inputY.setVisible(false);
                main.revalidate();
                main.repaint();

                inputZ.setVisible(true);
                main.revalidate();
                main.repaint();
            }
        });
        varY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputX.setVisible(false);
                main.revalidate();
                main.repaint();

                inputY.setVisible(true);
                main.revalidate();
                main.repaint();

                inputZ.setVisible(false);
                main.revalidate();
                main.repaint();
            }
        });

        double x,y,z;

        JLabel res=new JLabel();
        JLabel curX=new JLabel();
        JLabel curY=new JLabel();
        JLabel curZ=new JLabel();



        JButton calc=new JButton("Calculate");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x=Double.parseDouble(inputX.getText());
                double y=Double.parseDouble(inputY.getText());
                double z=Double.parseDouble(inputZ.getText());
                curX.setText(inputX.getText());
                curY.setText(inputY.getText());
                curZ.setText(inputZ.getText());
                if(b==1){
                   res.setText(Double.toString(fn1(x,y,z)));

                }
                if(b==2){
                    res.setText(Double.toString(fn2(x,y,z)));
                }

            }
        });
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x=Double.parseDouble(curX.getText());
                double y=Double.parseDouble(curY.getText());
                double z=Double.parseDouble(curZ.getText());
                double temp=Double.parseDouble(res.getText());
                if(inputX.isVisible()){
                    x+=temp;
                }
                if(inputY.isVisible()){
                    y+=temp;
                }
                if(inputZ.isVisible()){
                    z+=temp;
                }


                curX.setText( Double.toString(x));
                curY.setText( Double.toString(y));
                curZ.setText( Double.toString(z));
                inputX.setText(Double.toString(x));
                inputY.setText(Double.toString(y));
                inputZ.setText(Double.toString(z));
            }
        });
        mc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputX.setText("");
                inputY.setText("");
                inputZ.setText("");
                curX.setText("");
                curY.setText("");
                curZ.setText("");

            }
        });

        JPanel p4=new JPanel();
        JLabel x1=new JLabel(" x =");
        JLabel x2=new JLabel(" y =");
        JLabel x3=new JLabel(" z =");
        p4.add(x1);
        p4.add(curX);
        p4.add(x2);
        p4.add(curY);
        p4.add(x3);
        p4.add(curZ);
        p4.add(calc);
        p4.add(new JLabel("Result:"));
        p4.add(res);
        ultBox.add(p4);
        main.add(ultBox);

        return main;

    }

    static JFrame Frame(){
        JFrame fr=new JFrame();
        fr.setSize(700,700);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(true);
        return fr;
    }

     static double fn2(double x, double y, double z){
         if (x==-1) return 0 ;
         else {
        double func=(Math.pow(Math.sin(Math.pow(z,y)), 2))/Math.sqrt(1+x*x*x);
        return func;
         }}


     static double fn1(double x, double y, double z){
         if (x==0) return 0;
         else {
         double func=Math.pow((Math.log((1+z)*(1+z))+Math.cos(3.14*Math.pow(y,3))), (1/4))/Math.pow((Math.cos(Math.exp(x))+Math.sqrt(1.0/x)+Math.exp(x*x)), Math.sin(x));
        return func;
    }}
}

