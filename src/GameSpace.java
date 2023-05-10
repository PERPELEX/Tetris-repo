package tetris;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class GameSpace extends JPanel 
{
    private int nRows;
    private int nColumns;
    private int cellSize;
    
    private TetrisBlock block;

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        designBlock(g);
    }

    public GameSpace(JPanel gameSpacePlaceholder, int column)
    {
        gameSpacePlaceholder.setVisible(false);
        this.setBounds(gameSpacePlaceholder.getBounds());
        this.setBackground(gameSpacePlaceholder.getBackground());
        this.setBorder(gameSpacePlaceholder.getBorder());

        nColumns = column;
        cellSize = this.getBounds().width / nColumns;
        nRows = this.getBounds().height / cellSize;

        blockSpawner();
    }

    public void blockSpawner()
    {
        block = new TetrisBlock(new int[][] { {1,0}, {1,0}, {1,1}}, Color.blue);
        block.spawn(nColumns);
    }

    public void blockFall()
    {
        if (botttomCheck() == false)
            return;
        
        block.moveDown();
        repaint();
        
    }
    private boolean botttomCheck()
    {
        if (block.bottomEdge() == nRows)
            return false;

        return true;
    }

    private void designBlock (Graphics g)
    { 
    int hg = block.getHeight();
    int wdt = block.getWidth();
    Color clr = block.getColor();
    int[][] shp = block.getShape();
    
        for (int row = 0; row < hg; row++)
        {
            for (int col = 0; col < wdt; col++)
            {
                if (shp[row][col] == 1)
                {
                    int x = (block.getX() + col) * cellSize;
                    int y = (block.getY() + row) * cellSize;;

                    g.setColor(clr);
                    g.fillRect(x, y, cellSize, cellSize);
                    g.setColor(Color.black);
                    g.drawRect(x, y, cellSize, cellSize);
                }
            }
        }
    }
}
