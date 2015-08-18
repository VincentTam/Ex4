package com.example.bsd_16.ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PostListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        // Get the message from the intent
        Intent intent = getIntent();
        String user_name = intent.getStringExtra(MainActivity.USER_NAME);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView1 = new TextView(this);  // Contain the user name
        textView1.setText(user_name);
        TextView textView2 = new TextView(this);  // Contain the message
        textView2.setText(message);
        Button button = new Button(this);  // Return to MainActivity.java
        button.setText(R.string.back_lbl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Jump to function nav2Main()
                 * Why don't I just paste the function body of nav2Main() here?
                 */
                nav2Main();
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rootlayout);
        linearLayout.addView(textView1);
        linearLayout.addView(textView2);
        linearLayout.addView(button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void nav2Main() {
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }
}
