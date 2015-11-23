package com.zhangqi.jingdongrefreshlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity {
	private SeekBar sb;
	private FirstSetpView mFirstStepView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.seekbar);
        mFirstStepView = (FirstSetpView) findViewById(R.id.firstview);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				float currentProgress = (float)seekBar.getProgress()/(float)seekBar.getMax();
				mFirstStepView.setCurrentProgress(currentProgress);
				mFirstStepView.invalidate();
			}
		});
    }

  
}
