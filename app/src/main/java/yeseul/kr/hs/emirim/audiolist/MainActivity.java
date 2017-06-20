package yeseul.kr.hs.emirim.audiolist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay, butStop, butPause;
    TextView textMusic;
    ProgressBar progress;
    String[] musics = {"grandfather_11month_1", "grandfather_11month_2", "grandfather_11month_3"};
    int[] musicResIds = {R.raw.grandfather_11month_1, R.raw.grandfather_11month_2, R.raw.grandfather_11month_3};
    int selectedMusicId;
    boolean selectedPauseButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.List_music);
        butPlay = (Button)findViewById(R.id.but_play);
        butStop = (Button)findViewById(R.id.but_stop);
        butPause = (Button)findViewById(R.id.but_pause);
        textMusic = (TextView)findViewById(R.id.text_music);
        progress = (ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, musics);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setItemChecked(0,true);

        selectedMusicId=musicResIds[0];
        mediaPlayer=MediaPlayer.create(this, selectedMusicId);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer.stop();
                selectedMusicId=musicResIds[i];
                progress.setVisibility(View.INVISIBLE);
            }
        });

        butPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPauseButton) {
                    mediaPlayer.start();
                    selectedPauseButton=false;
                }

                else
                    mediaPlayer=MediaPlayer.create(MainActivity.this, selectedMusicId);
                mediaPlayer.start();
                progress.setVisibility(View.VISIBLE);

            }
        });

        butStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                progress.setVisibility(View.INVISIBLE);

            }
        });

        butPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPauseButton=true;
                mediaPlayer.pause();
                progress.setVisibility(View.INVISIBLE);

            }
        });

    }
}