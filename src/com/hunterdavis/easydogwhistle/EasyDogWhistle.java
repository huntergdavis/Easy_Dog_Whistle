package com.hunterdavis.easydogwhistle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class EasyDogWhistle extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
		// listener for frequency button
		OnClickListener frequencyListner = new OnClickListener() {
			public void onClick(View v) {
				EditText freqText = (EditText) findViewById(R.id.freqbonus);
				String frequency = freqText.getText().toString();
				if (frequency.length() > 0) {
					float localFreqValue = Float.valueOf(frequency);
					playFrequency(v.getContext(), localFreqValue);
				}

			}
		};
		
		// listener for frequency button
		OnClickListener dogOneListener = new OnClickListener() {
			public void onClick(View v) {
				playFrequency(v.getContext(), 26000);
			}
		};
		
		// listener for frequency button
		OnClickListener dogTwoListener = new OnClickListener() {
			public void onClick(View v) {
				playFrequency(v.getContext(), 23000);
			}
		};
		
		// listener for frequency button
		OnClickListener dogThreeListener = new OnClickListener() {
			public void onClick(View v) {
				playFrequency(v.getContext(), 22000);
			}
		};
		
		// listener for frequency button
		OnClickListener dogFourListener = new OnClickListener() {
			public void onClick(View v) {
				playFrequency(v.getContext(), 21000);
			}
		};
		
		
		
		// frequency button
		Button freqButton = (Button) findViewById(R.id.freqbutton);
		freqButton.setOnClickListener(frequencyListner);
		
		// Whistle Button 1-4
		Button dogOneButton = (Button) findViewById(R.id.dogone);
		dogOneButton.setOnClickListener(dogOneListener);
		Button dogTwoButton = (Button) findViewById(R.id.dogtwo);
		dogTwoButton.setOnClickListener(dogTwoListener);
		Button dogThreeButton = (Button) findViewById(R.id.dogthree);
		dogThreeButton.setOnClickListener(dogThreeListener);
		Button dogFourButton = (Button) findViewById(R.id.dogfour);
		dogFourButton.setOnClickListener(dogFourListener);
		
		
		// Look up the AdView as a resource and load a request.
		AdView adView = (AdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
        
    }
    
	public void playFrequency(Context context, float frequency) {

		// final float frequency2 = 440;
		float increment = (float) (2 * Math.PI) * frequency / 44100; // angular
																		// increment
																		// for
																		// each
																		// sample
		float angle = 0;
		AndroidAudioDevice device = new AndroidAudioDevice();
		float samples[] = new float[1024];

		for (int j = 0; j < 60; j++) {
			for (int i = 0; i < samples.length; i++) {
				samples[i] = (float) Math.sin(angle);
				angle += increment;
			}

			device.writeSamples(samples);

		}
	}
    
    
    
}