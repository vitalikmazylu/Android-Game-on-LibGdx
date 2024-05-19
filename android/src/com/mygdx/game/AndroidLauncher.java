package com.mygdx.game;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


public class AndroidLauncher extends AndroidApplication {
	private RewardedAd mRewardedAd;
	//private final String TAG = "MainActivity";
	//private InterstitialAd interstitialAd;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useImmersiveMode = true;

		initialize(new Launch(), config);
		/*loadAd();
		if (interstitialAd != null) {
			interstitialAd.show(this);
		} else {
			Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
			startGame();
		}*/
}
	/*public void loadAd() {
		AdRequest adRequest = new AdRequest.Builder().build();
		InterstitialAd.load(
				this,
				"ca-app-pub-3940256099942544/1033173712",
				adRequest,
				new InterstitialAdLoadCallback() {
					@Override
					public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
						// The mInterstitialAd reference will be null until
						// an ad is loaded.
						AndroidLauncher.this.interstitialAd = interstitialAd;
						Log.i(TAG, "onAdLoaded");
						Toast.makeText(AndroidLauncher.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
						interstitialAd.setFullScreenContentCallback(
								new FullScreenContentCallback() {
									@Override
									public void onAdDismissedFullScreenContent() {
										// Called when fullscreen content is dismissed.
										// Make sure to set your reference to null so you don't
										// show it a second time.
										AndroidLauncher.this.interstitialAd = null;
										Log.d("TAG", "The ad was dismissed.");
									}

									@Override
									public void onAdFailedToShowFullScreenContent(AdError adError) {
										// Called when fullscreen content failed to show.
										// Make sure to set your reference to null so you don't
										// show it a second time.
										AndroidLauncher.this.interstitialAd = null;
										Log.d("TAG", "The ad failed to show.");
									}

									@Override
									public void onAdShowedFullScreenContent() {
										// Called when fullscreen content is shown.
										Log.d("TAG", "The ad was shown.");
									}
								});
					}

					@Override
					public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
						// Handle the error
						Log.i(TAG, loadAdError.getMessage());
						interstitialAd = null;

						String error =
								String.format(
										"domain: %s, code: %d, message: %s",
										loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
						Toast.makeText(
										AndroidLauncher.this, "onAdFailedToLoad() with error: " + error, Toast.LENGTH_SHORT)
								.show();
					}
				});
	}*/
	private void startGame() {
		// Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
	//	if (interstitialAd == null) {
	//		loadAd();
		}

		//retryButton.setVisibility(View.INVISIBLE);
		//resumeGame(GAME_LENGTH_MILLISECONDS);



}
