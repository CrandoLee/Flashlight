package com.example.togglebutton;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	private ToggleButton tgbButton;
	private ImageView img;
	private LinearLayout linearLayout;
	private Camera camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tgbButton = (ToggleButton) findViewById(R.id.toggleButton1);
		img = (ImageView) findViewById(R.id.imageView1);
		tgbButton.setOnCheckedChangeListener(this);
		linearLayout = (LinearLayout) findViewById(R.id.layout1);
		camera = Camera.open();
		camera.startPreview();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		tgbButton.setChecked(isChecked);
		if (isChecked) {
			Camera.Parameters parameters = camera.getParameters();
			parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(parameters);
			img.setBackgroundColor(Color.WHITE);
			linearLayout.setBackgroundColor(Color.WHITE);
		}

		else {
			Camera.Parameters parameters = camera.getParameters();
			parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
			camera.setParameters(parameters);
			img.setBackgroundColor(Color.BLACK);
			linearLayout.setBackgroundColor(Color.BLACK);
		}

	}

}
