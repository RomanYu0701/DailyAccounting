package tw.com.thinkpower.dailyaccounting;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public interface ISpendDao {

    void save(SQLiteDatabase database, Spend spend);
    List<Spend> findAll(SQLiteDatabase database);
}
