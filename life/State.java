package life;

import java.io.IOException;

public class State extends Thread {
    char[][] currentGeneration;

    public char[][] getCurrentGeneration() {
        return currentGeneration;
    }
    private long speed;
    private boolean isPaused = false;

    @Override
    public void run() {

        try{
            int n = 20; //scanner.nextInt(); //world size
            //long seed = scanner.nextLong(); //seed size
            int m = 100; //generation number
            int gen = 1;

            GenerateUniverse g = new GenerateUniverse(n);
            life.State s = new life.State();

            s.newLife(g.getUniverse());

            while(m>1){
                speedListener();
                pauseListener();
                if (isPaused) {
                    continue;
                }

                s.newLife(s.getCurrentGeneration());
                s.printUniverse(gen);

                Thread.sleep(GameOfLife.speedSlider.getValue()*1000);

                m--;
                gen++;
            }
        }
        catch(InterruptedException e){
            System.out.println("Oh noes something went wrong.");
        }
    }


    int countNeighbours(char[][] universe, int x, int y){
        int sum = 0;
        int n = universe.length;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + n) % n;
                int row = (y + j + n) % n;

                if(universe[col][row] == 'O'){
                    sum++;
                }
            }
        }
        if(universe[x][y] == 'O'){
            sum--;
        }
        return sum;
    }

    void newLife(char[][] universe){
        int n = universe.length;
        currentGeneration = new char[n][n];
        int x; int y;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //The count for the neighbours that are alive.
                int sum = countNeighbours(universe,i,j);

                //The condition for a cell staying alive.
                if (universe[i][j] == 'O') {
                    if(sum < 2 || sum > 3){
                        currentGeneration[i][j] = ' ';
                    }
                    else{
                        currentGeneration[i][j] = 'O';
                    }
                }
                //The condition for a cell coming back to life.
                else if(universe[i][j]== ' '){
                    if(sum == 3){
                        currentGeneration[i][j] = 'O';
                    }
                    else{
                        currentGeneration[i][j] = ' ';
                    }
                }
            }
        }
    }

    public void printUniverse(int gen){
        GameOfLife.paintGrid(currentGeneration, gen);
    }

    public void speedListener() {
        // Speed slider listener
        GameOfLife.speedSlider.addChangeListener(changeEvent -> {
            this.speed = GameOfLife.speedSlider.getValue();
            if(speed == 1){
                GameOfLife.speedLabel.setText(speed + " Second per evolution.");
            }
            else {
                GameOfLife.speedLabel.setText(speed + " Seconds per evolution.");
            }
        });
    }

    public void pauseListener() {
        // Pause button listener
        GameOfLife.pauseButton.addActionListener(event -> {
            if (GameOfLife.pauseButton.isSelected()) {
                GameOfLife.pauseButton.doClick();
                isPaused = !isPaused;
                GameOfLife.pauseButton.setText(isPaused ? "RESUME" : "PAUSE");
            }
        });
    }
}
