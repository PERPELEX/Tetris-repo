package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread 
{
    private GameSpace gs;

    public GameThread(GameSpace gs)
    {
        this.gs = gs;
    }

    @Override
    public void run()
    {
        while (true)
        {            
                gs.blockFall();
                try 
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) 
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
} 
