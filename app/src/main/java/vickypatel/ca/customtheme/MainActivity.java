package vickypatel.ca.customtheme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle =  getIntent().getExtras();
        if(bundle!= null){
            String ID = bundle.getString("ID");
            System.out.println(ID);
            switch (ID){
                case "T":
                    setTheme(R.style.TrainerPlusTheme);
                    break;
                case "L":
                    setTheme(R.style.LogItTheme);
                    break;
                case "S":
                    setTheme(R.style.SmoothPayTheme);
                    break;

            }
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });
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

        //finish activity and stat it again
        finish();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.trainer_plus:
                intent.putExtra("ID", "T");
                startActivity(intent);
                return true;
            case R.id.logIt:
                intent.putExtra("ID", "L");
                startActivity(intent);
                return true;
            case R.id.smooth_pay:
                intent.putExtra("ID", "S");
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
