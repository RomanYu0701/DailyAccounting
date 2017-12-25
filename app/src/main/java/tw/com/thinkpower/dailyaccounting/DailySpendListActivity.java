package tw.com.thinkpower.dailyaccounting;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class DailySpendListActivity extends AppCompatActivity {

    private ListView spendList = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daily_spend_list);

        spendList = (ListView) findViewById(R.id.list_daily_spend);

//        DatabaseHelper helper = new DatabaseHelper(getBaseContext());
//        SQLiteDatabase database = helper.getReadableDatabase();

        ISpendDao dao = new SpendDaoImpl(getBaseContext());
        List<Spend> spends= dao.findAll();

        spendList.setAdapter(new DailySpendAdapter(spends));

//        database.close();
    }
}
