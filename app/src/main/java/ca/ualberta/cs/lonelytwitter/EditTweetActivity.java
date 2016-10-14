package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Intent intent = getIntent();
        String tweet = intent.getStringExtra(LonelyTwitterActivity.INTENT_KEY_TWEET);

        TextView tv = (TextView) findViewById(R.id.activity_edit_tweet_tweet_text);
        tv.setText(tweet);
    }
}