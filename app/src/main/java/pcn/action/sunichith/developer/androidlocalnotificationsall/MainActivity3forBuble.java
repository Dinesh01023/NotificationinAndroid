package pcn.action.sunichith.developer.androidlocalnotificationsall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity3forBuble extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3for_buble);
        ImageButton voiceCall = (ImageButton) findViewById(R.id.voice_call);
        voiceCall.setOnClickListener(this);
        ImageButton sendMessage = (ImageButton) findViewById(R.id.send);
        sendMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.voice_call:
                Toast.makeText(MainActivity3forBuble.this, "Calling contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.send:
                Toast.makeText(MainActivity3forBuble.this, "Sending message", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}