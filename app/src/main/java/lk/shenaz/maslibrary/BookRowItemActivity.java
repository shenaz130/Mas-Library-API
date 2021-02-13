package lk.shenaz.maslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookRowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_row_item);
        Button btnyoutube = (Button) findViewById(R.id.btnyoutube);

        btnyoutube.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent YoutubeIntent = new Intent(getApplicationContext(),YoutubeActivity.class);
                startActivity(YoutubeIntent);

            }
        });

    }
}
