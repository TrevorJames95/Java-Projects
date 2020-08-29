package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private static JPanel gridPannel = new JPanel();
    private static JLabel lbl1 = new JLabel();
    private static JLabel lbl2 = new JLabel();
    private static JButton reset = new JButton();
    public static JSlider speedSlider = new JSlider(1, 10, 5);
    public static JLabel speedLabel;
    public static JButton pauseButton;

    public GameOfLife() {
        setTitle("Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();

        lbl1.setName("GenerationLabel");
        lbl2.setName("AliveLabel");
        lbl1.setText("Generation #0");
        lbl2.setText("Alive: 0");

        pauseButton = new JButton();
        pauseButton.setName("PlayToggleButton");
        reset.setName("ResetButton");

        pauseButton.setText("PAUSE");
        reset.setText("Reset");

        speedLabel = new JLabel();


        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setName("SpeedSlider");
        speedLabel.setText("5 Seconds per evolution.");
        speedLabel.setName("SpeedLabel");

        header.add(pauseButton);
        header.add(reset);
        header.add(lbl1);
        header.add(lbl2);
        header.add(speedLabel);
        header.add(speedSlider);

        add(header, BorderLayout.WEST);
        gridPannel.setLayout(new GridLayout(20, 20, 1,1));
        gridPannel.setVisible(true);

        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        add(gridPannel);
        setVisible(true);

        try{
            Thread s = new State();
            s.start();
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            System.out.println("Thread was Interrupted.");
        }
    }


    public static void paintGrid(char[][] universe, int gen){
        Component[] componentList = gridPannel.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof JPanel){

                //Remove it
                gridPannel.remove(c);
            }
        }

        int alive = 0;
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                if(universe[i][j] == 'O'){
                    panel.setBackground(Color.BLACK);
                    alive++;
                }
                gridPannel.add(panel);
            }
        }

        lbl1.setText("Generation #" + gen);
        lbl2.setText("Alive: " + alive);
    }
}


