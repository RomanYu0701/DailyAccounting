package tw.com.thinkpower.dailyaccounting;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText field_date = null;
    private EditText field_category = null;
    private EditText field_item = null;
    private EditText field_amount = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_daily_spend);

        field_date = (EditText) findViewById(R.id.field_date);
        field_category = (EditText) findViewById(R.id.field_category);
        field_item = (EditText) findViewById(R.id.field_item);
        field_amount = (EditText) findViewById(R.id.field_amount);
    }

    public void addDailySpend(View view) {
        String date = field_date.getText().toString();
        String category = field_category.getText().toString();
        String item = field_item.getText().toString();
        String amount = field_amount.getText().toString();

        Log.v("addDailySpend","date  : "+date);
        Log.v("addDailySpend","category : "+category);
        Log.v("addDailySpend","item : "+item);
        Log.v("addDailySpend","amount : "+amount);

        // save into sqlite database
        DatabaseHelper helper = new DatabaseHelper(getBaseContext());
        SQLiteDatabase database = helper.getWritableDatabase();

        Spend spend = new Spend();
        spend.setDate(date);
        spend.setCategory(category);
        spend.setItem(item);
        spend.setAmount(Integer.valueOf(amount));

        ISpendDao dao = new SpendDaoImpl();
        dao.save(database,spend);

        database.close();

        // clear form (EditText)
        field_date.setText(null);
        field_category.setText(null);
        field_item.setText(null);
        field_amount.setText(null);

        // set
        field_date.requestFocus();

        Intent intent = new Intent();
        intent.setClass(getBaseContext(),DailySpendListActivity.class);
        startActivity(intent);

    }
}
