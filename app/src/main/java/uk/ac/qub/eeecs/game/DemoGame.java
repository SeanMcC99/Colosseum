package uk.ac.qub.eeecs.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.ac.qub.eeecs.gage.Game;

/**
 * Sample demo game that is create within the MainActivity class
 *
 * @version 1.0
 */
public class DemoGame extends Game {

    /**
     * Create a new demo game
     */
    public DemoGame() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see uk.ac.qub.eeecs.gage.Game#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Going with 60 UPS/FPS, testing out the fps counter and it works smoothly.
        setTargetFramesPerSecond(60);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Call the Game's onCreateView to get the view to be returned.
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // Create and add a stub game screen to the screen manager. 
        SplashScreen stubSplashScreen = new SplashScreen(this);
        mScreenManager.addScreen(stubSplashScreen);

        return view;
    }

    @Override
    public boolean onBackPressed() {
        // If we are already at the menu screen or the splash screen then exit
        if (mScreenManager.getCurrentScreen().getName().equals("MenuScreen"))
            return false;
        else if (mScreenManager.getCurrentScreen().getName().equals("SplashScreen"))
            return false;



        // Stop any playing music
        if(mAudioManager.isMusicPlaying())
            mAudioManager.stopMusic();

        // Go back to the menu screen
        getScreenManager().removeAllScreens();
        MenuScreen menuScreen = new MenuScreen(this);
        getScreenManager().addScreen(menuScreen);
        return true;
    }
}