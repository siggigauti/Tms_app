package is.siggigauti.tms_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import is.siggigauti.tms_app.networking.apiHandler;

public class StoreInfoActivity extends AppCompatActivity {
    private EditText mSearchByEditText;
    private Button mSearchButton;
    private String searchString;
    private TextView mStoreNameTextView;
    private TextView mStoreSSNTextView;
    private TextView mStoreLocationTextView;
    private TextView mStoreNrOfTermTextView;
    private apiHandler api = new apiHandler();
    private JSONObject storeJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_info);
        mSearchByEditText = (EditText) findViewById(R.id.searchByEditText);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        searchString = mSearchByEditText.getText().toString();
        mStoreLocationTextView = (TextView) findViewById(R.id.storeLocationTextView);
        mStoreNameTextView = (TextView) findViewById(R.id.storeNameTextView);
        mStoreNrOfTermTextView = (TextView) findViewById(R.id.storeNrOfTermTextView);
        mStoreSSNTextView = (TextView) findViewById(R.id.storeSSNTextView);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    try{
                        //Reynum að converta inntaki í tölu
                        //Þarf að passa að þetta sé "kennitala"
                        storeJson = api.getStoreByKennitala(Integer.parseInt(searchString));
                    } catch(NumberFormatException e){
                        //Annars grípum við villuna og köllum á eitthvað default.
                        storeJson = api.getStoreByKennitala(1111932525);
                    }
                    updateView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Fall sem notar víðværu (global) breytuna storeJson til að uppfæra upplýsingar á skjá.
    private void updateView(){
        try {
            mStoreSSNTextView.setText(storeJson.getString("kt"));
            mStoreLocationTextView.setText(storeJson.getString("location"));
            mStoreNameTextView.setText(storeJson.getString("storeName"));
            mStoreNrOfTermTextView.setText(storeJson.getString("no_of_terms"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
