package day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener {

    public Client(){
        initComponent();
    }

    private void initComponent() {
        setTitle("MySQL Client");
        setExtendedState(MAXIMIZED_BOTH);
        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        Font font = new Font("consolas",Font.PLAIN,24);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        TextArea sqlTextArea = new TextArea();
        sqlTextArea.setPreferredSize(new Dimension(dimension.width,dimension.height/2));
        sqlTextArea.setFont(font);
        sqlTextArea.setForeground(Color.WHITE);
        sqlTextArea.setForeground(Color.darkGray);

        JPanel north= new JPanel();
        north.setPreferredSize(new Dimension(dimension.width,(int)(dimension.getHeight()/2)));

        north.add(sqlTextArea);

        TextArea outputTextArea =new TextArea();
        outputTextArea.setBackground(Color.WHITE);
        outputTextArea.setPreferredSize(new Dimension(dimension.width/2,dimension.height/2));
        outputTextArea.setEditable(false);

        String[] columnNames={"ID","USERNAME","PASSWORD"};
        Object[][] rowData={
                {1,"Tom","123"},
                {2,"Jerry","abc"}
        };

        JTable resultTable = new JTable(rowData, columnNames);
        resultTable.setBackground(Color.WHITE);
        resultTable.setPreferredSize(new Dimension(dimension.width / 2, dimension.height / 2));


        JPanel south = new JPanel();
        south.setLayout(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setPreferredSize(new Dimension(dimension.width, (int) (dimension.getHeight() / 2)));

        south.add(outputTextArea, BorderLayout.WEST);
        south.add(resultTable, BorderLayout.EAST);

        main.add(north, BorderLayout.NORTH);
        main.add(south, BorderLayout.SOUTH);
        add(main);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Client();
    }
}
