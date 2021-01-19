import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAPACITY_HD extends JFrame{
    private JTextField RAMCAP;
    private JTextField RAMPERCENT;
    private JComboBox RAMCAPCHOICE;
    private JTextField OSPSCAP;
    private JComboBox OSPSCAPCHOICE;
    private JButton CALCULATEButton;
    private JPanel RAM;
    long TBTOB = 1099511627776L;
    long GBTOB = 1073741824;
    long MBTOB = 1048576;
    int KBTOB = 1024;
    int Byte =8;
    double Bit = 0.125;
    int LOGHDR;
    int LOGOSR;

    public static void main(String[] args) {

        JFrame frame = new JFrame("HD CAPACITY");
        frame.setSize(850,150);
    }


    public CAPACITY_HD()
    {
        this.setContentPane(RAM);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();

        CALCULATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CAPACITYFUNC2();
            }
        });
    }

    public void CAPACITYFUNC2(){
        try {
            int RAAMCAP = Integer.parseInt(RAMCAP.getText());
            int OPSPSCAP = Integer.parseInt(OSPSCAP.getText());
            int RAMPERCEN = Integer.parseInt(RAMPERCENT.getText());
            RAMCAPCHOICE.getSelectedIndex();
            OSPSCAPCHOICE.getSelectedIndex();
            try {
                if ("TB".equals(RAMCAPCHOICE.getSelectedItem())) {
                    long TB = TBTOB * RAAMCAP;
                    LOGHDR = (int) (Math.log(TB) / Math.log(2));
                } else if ("GB".equals(RAMCAPCHOICE.getSelectedItem())) {
                    long GB = GBTOB * RAAMCAP;
                    LOGHDR = (int) (Math.log(GB) / Math.log(2));
                } else if ("MB".equals(RAMCAPCHOICE.getSelectedItem())) {
                    long MB = MBTOB * RAAMCAP;
                    LOGHDR =(int) (Math.log(MB) / Math.log(2));
                } else if ("KB".equals(RAMCAPCHOICE.getSelectedItem())) {
                    long KB = KBTOB * RAAMCAP;
                    LOGHDR = (int) (Math.log(KB) / Math.log(2));
                } else {
                    LOGHDR = (int) (Math.log(RAAMCAP) / Math.log(2));
                }
            } catch (ArithmeticException b) {
                System.out.println(b);
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG AT HD!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

            try {
                if ("TB".equals(OSPSCAPCHOICE.getSelectedItem())) {
                    long TB = TBTOB * OPSPSCAP;
                    LOGOSR = (int) (Math.log(TB) / Math.log(2));
                } else if ("GB".equals(OSPSCAPCHOICE.getSelectedItem())) {
                    long GB = GBTOB * OPSPSCAP;
                    LOGOSR = (int) (Math.log(GB) / Math.log(2));
                } else if ("MB".equals(OSPSCAPCHOICE.getSelectedItem())) {
                    long MB = MBTOB * OPSPSCAP;
                    LOGOSR = (int) (Math.log(MB) / Math.log(2));
                } else if ("KB".equals(OSPSCAPCHOICE.getSelectedItem())) {
                    long KB = KBTOB * OPSPSCAP;
                    LOGOSR = (int) (Math.log(KB) / Math.log(2));
                } else {
                    LOGOSR = (int) (Math.log(OPSPSCAP)/ Math.log(2));
                }

            } catch (ArithmeticException b) {
                System.out.println(b);
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG AT P/S!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

            int PLAISIO = (LOGHDR-LOGOSR);
            int hd = 128;
            int i;
            String[] LIMIT = new String[6];
            for(i=0; i <=LIMIT.length-1; i++)
            {
                int PAGE = (int) Math.pow(2,(Math.log(hd*GBTOB)/ Math.log(2))-LOGOSR);
                int PlaisioSelida = (int) ((PAGE*((PLAISIO+1)*Bit))/MBTOB);
                double MBa=((double)PlaisioSelida/(RAAMCAP*KBTOB))*100;
                if(MBa < RAMPERCEN)
                {String MBaS = String.valueOf(MBa); LIMIT[i] = MBaS.substring(0,4)+"   IS OK!!";}
                else {String MBaS = String.valueOf(MBa); LIMIT[i] = MBaS+"   IS NOT OK!!";}

                hd = hd*2;
            }

            JFrame f = new JFrame("RAM TOTAL");
            f.setLocationRelativeTo(null);
            f.getContentPane().setBackground(Color.DARK_GRAY);
            JLabel l1, l2, l3, l4, l5, l6, l7, l8;
            l1 = new JLabel("                THE AVAILABLE RAM PERCENTAGE IS        : " + RAMPERCEN + "%");
            l1.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l1.setForeground(Color.white);
            l1.setBounds(100, 30, 700, 30);
            l8 = new JLabel("--------------------------------------------------------------------------------------------------\n");
            l8.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l8.setForeground(Color.white);
            l8.setBounds(100, 50, 700, 30);
            l2 = new JLabel("FOR : 128 MB THE TOTAL PER CENTAGE IS     : " + LIMIT[0]);
            l2.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l2.setForeground(Color.white);
            l2.setBounds(100, 70, 700, 30);
            l3 = new JLabel("FOR : 256 MB THE TOTAL PER CENTAGE IS     : " + LIMIT[1]);
            l3.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l3.setForeground(Color.white);
            l3.setBounds(100, 100, 700, 30);
            l4 = new JLabel("FOR : 512 MB THE TOTAL PER CENTAGE IS     : " + LIMIT[2]);
            l4.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l4.setForeground(Color.white);
            l4.setBounds(100, 130, 700, 30);
            l5 = new JLabel("FOR : 1024 GB THE TOTAL PER CENTAGE IS   : " + LIMIT[3]);
            l5.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l5.setForeground(Color.white);
            l5.setBounds(100, 160, 700, 30);
            l6 = new JLabel("FOR : 2048 GB THE TOTAL PER CENTAGE IS   : " + LIMIT[4]);
            l6.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l6.setForeground(Color.white);
            l6.setBounds(100, 190, 700, 30);
            l7 = new JLabel("FOR : 4056 GB THE TOTAL PER CENTAGE IS   : " + LIMIT[5]);
            l7.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l7.setForeground(Color.white);
            l7.setBounds(100, 220, 700, 30);
            f.add(l1);
            f.add(l8);
            f.add(l2);
            f.add(l3);
            f.add(l4);
            f.add(l5);
            f.add(l6);
            f.add(l7);
            f.setSize(820, 330);
            f.setPreferredSize(new Dimension(820, 330));
            f.setLayout(null);
            f.setVisible(true);



        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!\n"+ a, "ERROR!!!", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
