package d0289570.android_hw2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(greet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_reset:
                editText.setText("");
                break;
            case R.id.action_about:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("About this APP");
                ad.setMessage("Author: LFJ");

                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };

                ad.setPositiveButton("OK",listener);
                ad.show();
                break;
        }
        return true;
    }

    public View.OnClickListener greet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String input_str = editText.getText().toString();

            if(input_str.isEmpty()){
                Toast.makeText(MainActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Hello "+input_str, Toast.LENGTH_SHORT).show();
            }
        }
    };
}
