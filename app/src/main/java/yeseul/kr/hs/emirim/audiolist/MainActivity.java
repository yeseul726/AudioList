package yeseul.kr.hs.emirim.audiolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay, butStop;
    TextView textMusic;
    ProgressBar progress;
    String[] musics = {"grandfather_11month_1", "grandfather_11month_2", "grandfather_11month_3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.List_music);
        butPlay = (Button)findViewById(R.id.but_play);
        butStop = (Button)findViewById(R.id.but_stop);
        textMusic = (TextView)findViewById(R.id.text_music);
        progress = (ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, musics);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setItemChecked(0, true);
    }
}
