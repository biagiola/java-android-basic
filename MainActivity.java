package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // variables are also call fields in java
    private EditText userInput;
    private Button button;
    private TextView textView;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_layout);

        /* R = resources;
        *  the parenthesis in each field (variable) has its own widget identifier that behaves like a caster.
        * */
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        // textView by default does not supper scrolling
        // we also must to activate vertical scrolling on our blueprint
        textView.setMovementMethod(new ScrollingMovementMethod());

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTimesClicked = numTimesClicked + 1;
                String result = "The button got tapped " + numTimesClicked + " time";

                if (numTimesClicked !=1 ) {
                    result += "s"; // we add a s to the end;
                }

                textView.append(result);
                textView.append("\n");
            }
        };

        button.setOnClickListener(ourOnClickListener);
    }
}
