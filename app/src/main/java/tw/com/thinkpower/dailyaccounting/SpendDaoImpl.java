package tw.com.thinkpower.dailyaccounting;

import android.content.Context;

import java.util.List;

public class SpendDaoImpl implements ISpendDao {

    private SpendDaoImpl(){}

    private DaoSession daoSession;

    public SpendDaoImpl(Context context){
        this();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, Spend.TABLE_NAME);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    @Override
    public void save(Spend spend) {
        daoSession.getSpendDao().insert(spend);
    }

    @Override
    public List<Spend> findAll() {
        return daoSession.getSpendDao().loadAll();
    }
}
