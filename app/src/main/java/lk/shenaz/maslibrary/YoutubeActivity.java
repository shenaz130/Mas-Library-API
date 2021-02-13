package lk.shenaz.maslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class YoutubeActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerFragment youTubePlayerFragment;
    private static final String API_KEY = "AIzaSyCb6lv9a8EAH2aeJQ2NOmkWOtarEJAB_QQ";

    private String videoURL = "71xBu_VHTfY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        if(getIntent().getStringExtra("url") != null){
            videoURL =  getIntent().getStringExtra("url");
        }

        youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.playerYouTube);
        youTubePlayerFragment.initialize(API_KEY,this);
}

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(videoURL);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
