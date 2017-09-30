package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		int onCreateCount=0;
		int onStartCount=0;
		int onDestroyCount=0;
		int onPauseCount=0;
		int onResumeCount=0;
		int onRestartCount=0;
		int onStopCount=0;

		TextView createTxt, startTxt, resumeTxt, pauseTxt;
		TextView destroyTxt, restartTxt, stopTxt;

		SharedPreferences prefs;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			prefs = getPreferences(MODE_PRIVATE);
			if(prefs != null) {
				onCreateCount = prefs.getInt("OnCreateCount",0);
				onStartCount = prefs.getInt("OnStartCount",0);
				onResumeCount = prefs.getInt("OnResumeCount",0);
				onPauseCount = prefs.getInt("OnPauseCount",0);
				onStopCount = prefs.getInt("OnStopCount",0);
				onRestartCount = prefs.getInt("OnRestartCount",0);
				onDestroyCount = prefs.getInt("OnDestroyCount",0);

				getTextViews(this.findViewById(android.R.id.content));

				createTxt.setText(updateStr(createTxt)+" "+onCreateCount);
				startTxt.setText(updateStr(startTxt)+" "+onStartCount);
				resumeTxt.setText(updateStr(resumeTxt)+" "+onResumeCount);
				pauseTxt.setText(updateStr(pauseTxt)+" "+onPauseCount);
				stopTxt.setText(updateStr(stopTxt)+" "+onStopCount);
				restartTxt.setText(updateStr(restartTxt)+" "+onRestartCount);
				destroyTxt.setText(updateStr(destroyTxt)+" "+onDestroyCount);
			}

            if(savedInstanceState != null) {
                onCreateCount = savedInstanceState.getInt("onCreate counter");
                onStartCount = savedInstanceState.getInt("onStart counter");
                onResumeCount = savedInstanceState.getInt("onResume counter");
                onPauseCount = savedInstanceState.getInt("onPause counter");
                onStopCount = savedInstanceState.getInt("onStop counter");
                onRestartCount = savedInstanceState.getInt("onRestart counter");
				onDestroyCount = savedInstanceState.getInt("onDestroy counter");
                    //probably reset the values for textview here as well
				getTextViews(this.findViewById(android.R.id.content));
				createTxt.setText(updateStr(createTxt)+" "+onCreateCount);
				startTxt.setText(updateStr(startTxt)+" "+onStartCount);
				resumeTxt.setText(updateStr(resumeTxt)+" "+onResumeCount);
				pauseTxt.setText(updateStr(pauseTxt)+" "+onPauseCount);
				stopTxt.setText(updateStr(stopTxt)+" "+onStopCount);
				restartTxt.setText(updateStr(restartTxt)+" "+onRestartCount);
				destroyTxt.setText(updateStr(destroyTxt)+" "+onDestroyCount);
            }



			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO: update the appropriate count variable & update the view
			//createTxt = (TextView) findViewById(R.id.create);
			++onCreateCount;
			createTxt.setText(updateStr(createTxt)+" "+String.valueOf(onCreateCount));
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:  update the appropriate count variable & update the view
			//startTxt = (TextView) findViewById(R.id.start);
			onStartCount++;
			//Log.i(TAG,"tHIS IS THE TEXT: "+txt);
			startTxt.setText(updateStr(startTxt)+" "+String.valueOf(onStartCount));
		}

	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onResume(){
			super.onResume();

			Log.i(TAG, "onResume called");

			//resumeTxt = (TextView) findViewById(R.id.resume);
			++onResumeCount;
			resumeTxt.setText(updateStr(resumeTxt)+" "+String.valueOf(onResumeCount));
		}

		@Override
		public void onPause() {
			super.onPause();

			Log.i(TAG, "onPause called");
			saveCount(this.findViewById(android.R.id.content));

			//pauseTxt = (TextView) findViewById(R.id.pause);
			++onPauseCount;
			pauseTxt.setText(updateStr(pauseTxt)+" "+String.valueOf(onPauseCount));
		}

		@Override
		public void onStop(){
			super.onStop();

			Log.i(TAG, "onStop called");

			//stopTxt = (TextView) findViewById(R.id.stop);
			++onStopCount;
			stopTxt.setText(updateStr(stopTxt)+" "+String.valueOf(onStopCount));
		}

		@Override
		public void onRestart(){
			super.onRestart();

			Log.i(TAG, "onRestart called");

			//restartTxt = (TextView) findViewById(R.id.restart);
			++onRestartCount;
			restartTxt.setText(updateStr(restartTxt)+" "+String.valueOf(onRestartCount));
		}

		@Override
		public void onDestroy(){
			super.onDestroy();

			Log.i(TAG, "onDestroy called");

			//destroyTxt = (TextView) findViewById(R.id.destroy);
			++onDestroyCount;
			destroyTxt.setText(updateStr(destroyTxt)+" "+String.valueOf(onDestroyCount));
		}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:  save state information with a collection of key-value pairs & save all  count variables
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt("onCreate counter",onCreateCount);
            savedInstanceState.putInt("onStart counter",onStartCount);
            savedInstanceState.putInt("onResume counter",onResumeCount);
            savedInstanceState.putInt("onPause counter",onPauseCount);
            savedInstanceState.putInt("onStop counter",onStopCount);
            savedInstanceState.putInt("onRestart counter",onRestartCount);
            savedInstanceState.putInt("onDestroy counter",onDestroyCount);

		}

		@Override
        public void onRestoreInstanceState(Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);

            onCreateCount = savedInstanceState.getInt("onCreate counter");
            onStartCount = savedInstanceState.getInt("onStart counter");
            onResumeCount = savedInstanceState.getInt("onResume counter");
            onPauseCount = savedInstanceState.getInt("onPause counter");
            onStopCount = savedInstanceState.getInt("onStop counter");
            onRestartCount = savedInstanceState.getInt("onRestart counter");
            onDestroyCount = savedInstanceState.getInt("onDestroy counter");
        }


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}

		private String updateStr(TextView txtView){
			String txt = null;
			if(txtView != null) {
				txt = txtView.getText().toString();
				txt = txt.substring(0, txt.indexOf(":") + 1);
			}

            return txt;
        }

        private void saveCount(View view){
			prefs = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();

			editor.putInt("OnCreateCount", onCreateCount);
			editor.putInt("OnStartCount", onStartCount);
			editor.putInt("OnResumeCount", onResumeCount);
			editor.putInt("OnPauseCount", onPauseCount);
			editor.putInt("OnStopCount", onStopCount);
			editor.putInt("OnRestartCount", onRestartCount);
			editor.putInt("OnDestroyCount", onDestroyCount);

			editor.commit();

		}

		private void getTextViews(View view){
			createTxt = (TextView)findViewById(R.id.create);
			startTxt = (TextView)findViewById(R.id.start);
			resumeTxt = (TextView)findViewById(R.id.resume);
			pauseTxt = (TextView)findViewById(R.id.pause);
			restartTxt = (TextView)findViewById(R.id.restart);
			stopTxt = (TextView)findViewById(R.id.stop);
			destroyTxt = (TextView)findViewById(R.id.destroy);
		}

		public void clearCounters(View view){
			onCreateCount = 0;
			onStartCount = 0;
			onResumeCount = 0;
			onPauseCount = 0;
			onStopCount = 0;
			onRestartCount = 0;
			onDestroyCount = 0;

			getTextViews(view);

			createTxt.setText(updateStr(createTxt)+" "+String.valueOf(onCreateCount));
			startTxt.setText(updateStr(startTxt)+" "+String.valueOf(onStartCount));
			resumeTxt.setText(updateStr(resumeTxt)+" "+String.valueOf(onResumeCount));
			pauseTxt.setText(updateStr(pauseTxt)+" "+String.valueOf(onPauseCount));
			stopTxt.setText(updateStr(stopTxt)+" "+String.valueOf(onStopCount));
			restartTxt.setText(updateStr(restartTxt)+" "+String.valueOf(onRestartCount));
			destroyTxt.setText(updateStr(destroyTxt)+" "+String.valueOf(onDestroyCount));
		}


}
