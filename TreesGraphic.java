import java.awt.*;

public class TreesGraphic
{
    public static void main(String[] args)
    {
        final double START_X = 0.5;
        final double START_Y = 0.0;

        for(double i = 0.0; i <= 1.0; i += 0.1)
        {
            StdDraw.setPenRadius(0.00001);
            StdDraw.line(i, 0.0, i, 1.0);
            StdDraw.line(0.0, i, 1.0, i);
        }

        StdDraw.setPenRadius();
        drawTreesRand(START_X, START_Y, 13);
        //drawTrees(START_X, START_Y,13);
    }

    public static void drawTrees(double x, double y, int n)
    {
        drawTrees(x,y, 0, 0, 0.1, n);
    }

    public static void drawTreesRand(double x, double y, int n)
    {
        final double LENGTH = 0.2;
        final double THICKNESS = 0.01;
        drawTreesRand(x,y, 0, 0, LENGTH, THICKNESS, n);
    }

    public static void drawTrees(double x, double y, double lAngle, double rAngle, double length, int n)
    {

        if(n >= 0)
        {
            if(n > 2)
                StdDraw.setPenColor(StdDraw.LIGHT_BROWN);
            else
                StdDraw.setPenColor(Color.green);

            double leftX = x + (length) * Math.sin(Math.toRadians(lAngle));
            double leftY = y + (length) * Math.cos(Math.toRadians(lAngle));

            double rightX = x + (length) * Math.sin(Math.toRadians(rAngle));
            double rightY = y + (length) * Math.cos(Math.toRadians(rAngle));

            StdDraw.line(x, y, leftX, leftY); //draw left branch
            StdDraw.line(x, y, rightX, rightY); //draw right branch

            drawTrees(leftX, leftY, lAngle+20, lAngle-20, length-(length/4), n-1);
            drawTrees(rightX, rightY, rAngle-20, rAngle+20, length-(length/4), n-1);
        }
    }

    public static void drawTreesRand(double x, double y, double lAngle, double rAngle, double length, double size, int n)
    {
        final int BRANCH_COLOR_THRESHOLD = 3;
        final double BRANCH_SIZE_THRESHOLD = 3.5;

        if(n >= 0)
        {
            StdDraw.setPenRadius(size);
            final double ANGLE = 15;

            if(n > BRANCH_COLOR_THRESHOLD)
                StdDraw.setPenColor(StdDraw.DARK_BROWN);
            else
                StdDraw.setPenColor(StdDraw.DARK_GREEN);
                StdDraw.setPenRadius(size+size/BRANCH_COLOR_THRESHOLD);

            //LENGTH RANDOMIZER
            double min = 2.0; double max = 5.0;

            double leftX = x + (length) * Math.sin(Math.toRadians(lAngle));
            double leftY = y + (length) * Math.cos(Math.toRadians(lAngle));

            double rightX = x + (length) * Math.sin(Math.toRadians(rAngle));
            double rightY = y + (length) * Math.cos(Math.toRadians(rAngle));

            StdDraw.line(x, y, leftX, leftY); //draw left branch
            StdDraw.line(x, y, rightX, rightY); //draw right branch


            //BRANCHES' SIZE
            if(size - size/BRANCH_SIZE_THRESHOLD > 0)
                size = size - size/BRANCH_SIZE_THRESHOLD;


            drawTreesRand(leftX, leftY,
                    lAngle+((ANGLE)*Math.random() + ANGLE), lAngle-((ANGLE)*Math.random() + ANGLE)
                    , length-(length/((max-min)*Math.random() + min)), size, n-1);

            drawTreesRand(rightX, rightY,
                    rAngle-((ANGLE)*Math.random() + ANGLE), rAngle+((ANGLE)*Math.random() + ANGLE)
                    , length-(length/((max-min)*Math.random() + min)), size, n-1);
        }
    }


}
