package com.example.bsd_16.ex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String USER_NAME = "com.example.bsd_16.NAME";
    public final static String EXTRA_MESSAGE = "com.example.bsd_16.myfirstapp.MESSAGE";
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * This method must be public.
     * Clear button clicked
     */
    public void buttonClicked(View view) {
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(null);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setText(null);
    }

    /* Jump to the post list */
    public void button2Clicked(View view) {
        // Jump to another page while passing the input of this page
        // So an Intent object is needed
        Intent intent = new Intent(this, PostListActivity.class);
        try {
            editText = (EditText) findViewById(R.id.editText);
            editText2 = (EditText) findViewById(R.id.editText2);
            String message = editText.getText().toString().trim();
            String user_name = editText2.getText().toString().trim();

            // Forbid empty input in any fields
            // The Strings message and user_name are never null
            if (message.equals("") || user_name.equals("")) {
                throw new IllegalArgumentException("Input should be non-empty.");
            }

            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(USER_NAME, user_name);
            startActivity(intent);
        } catch (IllegalArgumentException e) {
            Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
