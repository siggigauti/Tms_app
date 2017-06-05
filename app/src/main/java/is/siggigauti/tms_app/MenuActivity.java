package is.siggigauti.tms_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button storeInfoButton;
    private Button switchTerminalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        storeInfoButton = (Button) findViewById(R.id.storeInfoButton);
        switchTerminalButton = (Button) findViewById(R.id.faultyTermButton);

        storeInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStoreInfoActivity = new Intent(MenuActivity.this, StoreInfoActivity.class);
                startActivity(intentStoreInfoActivity);
            }
        });

        switchTerminalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFaultyTermActivity = new Intent(MenuActivity.this, FaultyTermActivity.class);
                startActivity(intentFaultyTermActivity);

            }
        });
    }
}
