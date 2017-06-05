package is.siggigauti.tms_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import is.siggigauti.tms_app.networking.apiHandler;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private Button loginButton;
    private String userKey;
    private apiHandler api = new apiHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.userInputEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        userKey = userInput.getText().toString();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeVerification();
            }
        });
    }
    private void makeVerification(){
        if (userKey == null){
            userKey = "";
        }
        if(api.verifyUserKey(userKey)){
            Intent intentMenuActivity = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intentMenuActivity);
        }
        else{
            Toast.makeText(getApplicationContext(), "Could not verify userKey.", Toast.LENGTH_LONG).show();
        }

    }
}
