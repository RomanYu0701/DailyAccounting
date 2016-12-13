package tw.com.thinkpower.dailyaccounting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DAILY_ACCOUNTING";
    private static final int INITIAL_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, INITIAL_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(Spend.getCreateSpendStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

    }
}
