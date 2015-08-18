package com.example.bsd_16.ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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
        textView1.setTextAppearance(this, android.R.style.TextAppearance_Large);
        textView1.setId(1);
        TextView textView2 = new TextView(this);  // Contain the message
        textView2.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        textView2.setText(message);
        textView2.setId(2);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rootlayout);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        relativeLayout.addView(textView1, layoutParams1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams2.addRule(RelativeLayout.BELOW, textView1.getId());
        layoutParams2.addRule(RelativeLayout.ALIGN_LEFT, textView1.getId());
        relativeLayout.addView(textView2, layoutParams2);

        Button button = (Button) findViewById(R.id.button);  // The back button to MainActivity.java
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
