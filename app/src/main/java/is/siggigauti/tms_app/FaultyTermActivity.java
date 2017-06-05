package is.siggigauti.tms_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FaultyTermActivity extends AppCompatActivity {
    private EditText mOldTermEditText;
    private EditText mNewTermEditText;
    private Button mSwitchButton;
    private EditText mUserKeyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faulty_term);
    }
}
