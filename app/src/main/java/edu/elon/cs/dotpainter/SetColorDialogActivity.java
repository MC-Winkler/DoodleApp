package edu.elon.cs.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class SetColorDialogActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private SeekBar alphaSeekBar;
    private View colorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color_dialog);

        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        alphaSeekBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        colorDisplay = (View) findViewById(R.id.current_color_view);

        Intent fromMain = getIntent();

        alphaSeekBar.setProgress(fromMain.getIntExtra("rgb_alpha", 0));
        redSeekBar.setProgress(fromMain.getIntExtra("rgb_red", 0));
        greenSeekBar.setProgress(fromMain.getIntExtra("rgb_green", 0));
        blueSeekBar.setProgress(fromMain.getIntExtra("rgb_blue", 0));

        redSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);
        alphaSeekBar.setOnSeekBarChangeListener(this);

        colorDisplay.setBackgroundColor(Color.argb(alphaSeekBar.getProgress(), redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_color_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSetColorClick (View view) {
        Intent colorData = new Intent();
        colorData.putExtra("rgb_red", redSeekBar.getProgress());
        colorData.putExtra("rgb_green", greenSeekBar.getProgress());
        colorData.putExtra("rgb_blue", blueSeekBar.getProgress());
        colorData.putExtra("rgb_alpha", alphaSeekBar.getProgress());
        setResult(RESULT_OK, colorData);
        finish();

    }

    public void onProgressChanged (SeekBar seekbar, int progress, boolean fromUser){
        if (seekbar == alphaSeekBar){
            colorDisplay.setBackgroundColor(Color.argb(progress, redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress()));
        }
        else if (seekbar == redSeekBar){
            colorDisplay.setBackgroundColor(Color.argb(alphaSeekBar.getProgress(), progress, greenSeekBar.getProgress(), blueSeekBar.getProgress()));
        }
        else if (seekbar == greenSeekBar){
            colorDisplay.setBackgroundColor(Color.argb(alphaSeekBar.getProgress(),  redSeekBar.getProgress(), progress, blueSeekBar.getProgress()));
        }
        else if (seekbar == blueSeekBar){
            colorDisplay.setBackgroundColor(Color.argb(alphaSeekBar.getProgress(), redSeekBar.getProgress(), greenSeekBar.getProgress(), progress));
        }

    }

    public void onStopTrackingTouch (SeekBar seekbar){
    }

    public void onStartTrackingTouch (SeekBar seekbar){
    }
}
