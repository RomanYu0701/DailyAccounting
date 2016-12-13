package tw.com.thinkpower.dailyaccounting;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SpendDaoImpl implements ISpendDao {
    @Override
    public void save(SQLiteDatabase database, Spend spend) {
        if(database.isOpen()){
            database.beginTransaction();
            try{
                ContentValues values = new ContentValues();
                values.put(Spend.ATT_DATE,spend.getDate());
                values.put(Spend.ATT_CATEGORY,spend.getCategory());
                values.put(Spend.ATT_ITEM,spend.getItem());
                values.put(Spend.ATT_AMOUNT,spend.getAmount());
                database.insert(Spend.TABLE_NAME,null,values);
                database.setTransactionSuccessful();
            }catch (Exception e){
                Log.e("SpendDaoImpl",e.getMessage(),e);
            }finally {
                database.endTransaction();
            }
        }
    }

    @Override
    public List<Spend> findAll(SQLiteDatabase database) {
        Cursor cursor = null;
        List<Spend>spends = new ArrayList<>();
        try{
            if(database.isOpen()){
                cursor = database.query(Spend.TABLE_NAME,null,null,null,null,null,null,null);
                int colDate = cursor.getColumnIndex(Spend.ATT_DATE);
                int colCategory = cursor.getColumnIndex(Spend.ATT_CATEGORY);
                int colItem = cursor.getColumnIndex(Spend.ATT_ITEM);
                int colAmount = cursor.getColumnIndex(Spend.ATT_AMOUNT);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Spend spend = new Spend();
                    spend.setDate(cursor.getString(colDate));
                    spend.setCategory(cursor.getString(colCategory));
                    spend.setItem(cursor.getString(colItem));
                    spend.setAmount(cursor.getInt(colAmount));
                    spends.add(spend);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }catch (Exception e){
            Log.e("SpendDaoImpl",e.getMessage(),e);
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return spends;
    }
}
