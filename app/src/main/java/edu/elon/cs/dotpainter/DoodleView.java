package edu.elon.cs.dotpainter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Draw lines to the screen on touches.
 *
 * @author J. Hollingsworth and CSC 303 - Fall 2015
 * Modified by Michael Winkler and Rachel McGovern
 * 9/11/15
 */

public class DoodleView extends View {

    public final static int DEFAULT_WIDTH = 25;
    public final static int DEFAULT_RED = 255;
    public final static int DEFAULT_GREEN = 255;
    public final static int DEFAULT_BLUE = 255;
    public final static int DEFAULT_ALPHA = 255;

    private ArrayList<Line> theLines;
    private int penWidth = DEFAULT_WIDTH;
    private int red = DEFAULT_RED;
    private int green = DEFAULT_GREEN;
    private int blue = DEFAULT_BLUE;
    private int alpha = DEFAULT_ALPHA;
    private float x0;
    private float y0;
    private float x1;
    private float y1;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //When the user touches the screen, check if the action was a touch down action or move action.
        //If it was a touch down action, store the location of the touch as the first (x,y) coordinate
        //of a future line. If it was a move action, get the coordinates of that move action and use
        //them together with the previous pair of (x,y) coordinates to create a new line
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();
        }
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x0 = x1;
            y0 = y1;
            x1 = event.getX();
            y1 = event.getY();
            theLines.add(new Line(x0, y0, x1, y1, penWidth, alpha, red, green, blue));
        }

        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        for (Line line : theLines) {
            line.draw(canvas);
        }
        invalidate();
    }

    public void clearLines (){
        //Clears the screen by removing all lines from the theLines arrayList.
        theLines.clear();
    }


    //getters and setters
    public void setRGBRed (int red) {
        this.red = red;
    }

    public int getRGBRed() {
        return red;
    }

    public void setRGBGreen (int green) {
        this.green=green;
    }

    public int getRGBGreen () {
        return green;
    }

    public void setRGBBlue (int blue) {
        this.blue = blue;
    }

    public int getRGBBlue () {
        return blue;
    }

    public void setRGBAlpha (int alpha) {
        this.alpha = alpha;
    }

    public int getRGBAlpha () {
        return alpha;
    }

    public void setPenWidth(int penWidth) {
        this.penWidth = penWidth;
    }

    public int getPenWidth() {
        return penWidth;
    }
}