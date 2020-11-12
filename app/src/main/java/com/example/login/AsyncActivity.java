package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncActivity extends AppCompatActivity {
    private static final String TAG = AsyncActivity.class.getSimpleName();
    ProgressBar progressBar;
    EditText mBookInput;
    TextView mTitleText, mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
        //String queryString = mBookInput.getText().toString();
        mBookInput = findViewById(R.id.bookInput);
        String queryString = mBookInput.getText().toString();
    }

    public void handleClick(View view) {
        Log.i(TAG, "handleClick");
//        //download something from internet
//        //show the download progress on the progressbar
//        DownloadTask downloadTask = new DownloadTask(progressBar);
//        downloadTask.execute("https://urlForimagetobedownloaded");
        String queryString = mBookInput.getText().toString();

        new FetchBook(mTitleText, mAuthorText).execute(queryString);


    }

    public void serviceHandler(View view) {

        Intent serviceIntent = new Intent(AsyncActivity.this, MusicService.class);
        switch (view.getId()) {
            case R.id.buttonstart:
                //start a service/music
                startService(serviceIntent);
                break;
            case R.id.buttonstop:
                //stop a service/music
                stopService(serviceIntent);
                break;

        }

    }
}