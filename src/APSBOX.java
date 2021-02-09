import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class APSBOX extends JFrame {

    long TBTOB = 1099511627776L;
    long GBTOB = 1073741824;
    int MBTOB = 1048576;
    int KBTOB = 1024;
    int Byte =8;
    double Bit = 0.125;
    int LOGHD;
    int LOGOS;
    int LOGRAM;
    private JTextField discfield;
    private JComboBox discombo;
    private JTextField ramfield;
    private JComboBox ramcombo;
    private JTextField plaisiofield;
    private JComboBox plaisiocombo;
    private JButton CALCULATEFORMEB;
    private JPanel APSpanel;


    public static void main(String[] args) {

        JFrame frame = new JFrame("ΜΕΓΕΘΟΣ ΑΠΣ - ΠΣ");
        frame.setSize(850,300);
    }
    public APSBOX()
    {
        this.setContentPane(APSpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();

        CALCULATEFORMEB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                APSBOX();
            }
        });
    }

    public void APSBOX(){
        try {
            int HADCAP = Integer.parseInt(discfield.getText());
            int LOGRA = Integer.parseInt(ramfield.getText());
            int OPSPSCAP = Integer.parseInt(plaisiofield.getText());
            discombo.getSelectedIndex();
            ramcombo.getSelectedIndex();
            plaisiocombo.getSelectedIndex();
            try {
                if ("TB".equals(discombo.getSelectedItem())) {
                    long TB = TBTOB * HADCAP;
                    LOGHD = (int) (Math.log(TB) / Math.log(2));
                } else if ("GB".equals(discombo.getSelectedItem())) {
                    long GB = GBTOB * HADCAP;
                    LOGHD = (int) (Math.log(GB) / Math.log(2));
                } else if ("MB".equals(discombo.getSelectedItem())) {
                    int MB = MBTOB * HADCAP;
                    LOGHD =(int) (Math.log(MB) / Math.log(2));
                } else if ("KB".equals(discombo.getSelectedItem())) {
                    int KB = KBTOB * HADCAP;
                    LOGHD = (int) (Math.log(KB) / Math.log(2));
                } else {
                    LOGHD = (int) (Math.log(HADCAP) / Math.log(2));
                }
            } catch (ArithmeticException b) {
                System.out.println(b);
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG AT HD!!.", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

            try {
                if ("TB".equals(ramcombo.getSelectedItem())) {
                    long TB = TBTOB * LOGRA;
                    LOGRAM = (int) (Math.log(TB) / Math.log(2));
                } else if ("GB".equals(ramcombo.getSelectedItem())) {
                    long GB = GBTOB * LOGRA;
                    LOGRAM = (int) (Math.log(GB) / Math.log(2));
                } else if ("MB".equals(ramcombo.getSelectedItem())) {
                    int MB = MBTOB * LOGRA;
                    LOGRAM = (int) (Math.log(MB) / Math.log(2));
                } else if ("KB".equals(ramcombo.getSelectedItem())) {
                    int KB = KBTOB * LOGRA;
                    LOGRAM = (int) (Math.log(KB) / Math.log(2));
                } else {
                    LOGRAM = (int) (Math.log(LOGRA)/ Math.log(2));
                }

            } catch (ArithmeticException b) {
                System.out.println(b);
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG AT P/S!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
            try {
                if ("TB".equals(plaisiocombo.getSelectedItem())) {
                    long TB = TBTOB * OPSPSCAP;
                    LOGOS = (int) (Math.log(TB) / Math.log(2));
                } else if ("GB".equals(plaisiocombo.getSelectedItem())) {
                    long GB = GBTOB * OPSPSCAP;
                    LOGOS = (int) (Math.log(GB) / Math.log(2));
                } else if ("MB".equals(plaisiocombo.getSelectedItem())) {
                    int MB = MBTOB * OPSPSCAP;
                    LOGOS =(int) (Math.log(MB) / Math.log(2));
                } else if ("KB".equals(plaisiocombo.getSelectedItem())) {
                    int KB = KBTOB * OPSPSCAP;
                    LOGOS = (int) (Math.log(KB) / Math.log(2));
                } else {
                    LOGOS = (int) (Math.log(OPSPSCAP) / Math.log(2));
                }
            } catch (ArithmeticException b) {
                System.out.println(b);
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG AT HD!!.", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
            int PLAISIO = LOGRAM - LOGOS;
            long PAGE = LOGHD - LOGOS;
            double PAGESQUEAR = Math.pow(2,PAGE);
            double PLAISIOSQUEAR = Math.pow(2,PLAISIO);

            double PLAISIOSELIDA = (PAGESQUEAR*(PLAISIO+1)*Bit)/MBTOB;
            double APSel = (PLAISIOSQUEAR*(PAGE+1)*Bit)/MBTOB;



            JFrame f = new JFrame("RAM TOTAL");
            f.setLocationRelativeTo(null);
            f.getContentPane().setBackground(Color.DARK_GRAY);
            JLabel l1, l2;
            l1 = new JLabel("ΤΟ ΔΙΑΘΕΣΙΜΟ ΠΛΑΙΣΙΟ ΕΙΝΑΙ        : " + PLAISIOSELIDA+" MB");
            l1.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l1.setForeground(Color.white);
            l1.setBounds(100, 30, 700, 30);
            l2 = new JLabel("Ο ΑΝΕΣΤΡΑΜΕΝΟΣ ΠΙΝΑΚΑΣ ΕΙΝΑΙ       : " +APSel+" MB");
            l2.setFont(new Font("Book Antiqua", Font.BOLD, 18));
            l2.setForeground(Color.white);
            l2.setBounds(100, 90, 700, 30);
            f.add(l1);
            f.add(l2);
            f.setSize(800, 200);
            f.setPreferredSize(new Dimension(800, 200));
            f.setLayout(null);
            f.setVisible(true);



        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!\n"+ a, "ERROR!!!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
