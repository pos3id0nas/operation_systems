import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationS extends JFrame {
    private JPanel First;
    private JCheckBox HARDISK;
    private JCheckBox RAM;
    private JButton NEXTButton;
    private JCheckBox aps;
    private JLabel APS;

    public OperationS(String Title)
    {
        super(Title);
        this.setContentPane(First);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(HARDISK.isSelected())
                {new CAPACITY_HD();}
                else if(RAM.isSelected())
                {new CAPCITY();}
                else if(aps.isSelected()){new APSBOX();}

            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new OperationS("O.S.");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
