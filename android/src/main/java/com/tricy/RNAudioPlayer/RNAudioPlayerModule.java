package com.tricy.RNAudioPlayer;

import java.util.Map;
import java.util.HashMap;
import java.lang.Exception;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.Callback;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class RNAudioPlayerModule extends ReactContextBaseJavaModule {
  ReactApplicationContext reactContext;
  MediaPlayer mp;
  Map<String,MediaPlayer> sounds;
  public static final String TAG = "-- SOUNDPAD --";

  public RNAudioPlayerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    sounds = new HashMap<>();
  }

  @Override
  public String getName() {
    return "RNAudioPlayer";
  }

  @ReactMethod
  public void prepare(String audio) {
    String fname = audio.toLowerCase();
    int resID = this.reactContext.getResources().getIdentifier(fname, "raw", this.reactContext.getPackageName());
    try {
      mp = MediaPlayer.create(this.reactContext, resID);
      sounds.put(audio, mp);
    } catch(Exception e) {

    }
  }

  @ReactMethod
  public void play(final String audio) {
    mp = sounds.get(audio);
    if (mp != null) {
      try {
        mp = sounds.get(audio);

        mp.start();
        mp.setOnCompletionListener(new OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mp) {
            RNAudioPlayerModule.this.stop(audio);
          }
        });
      } catch (Exception e) {

      }
    }
  }

  @ReactMethod
  public void pause(String audio) {
    mp = sounds.get(audio);
    if (mp != null) try {
      mp.pause();
    } catch (Exception e) {

    }
  }

  @ReactMethod
  public void stop(String audio) {
    mp = sounds.get(audio);
    if (mp != null) {

      try {
        mp = sounds.get(audio);
        mp.reset();
        mp.release();

        this.prepare(audio);
      } catch (Exception e) {

      }
    }
  }
}
