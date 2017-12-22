package tw.com.thinkpower.dailyaccounting;

import java.util.List;

public interface ISpendDao {

    void save(Spend spend);
    List<Spend> findAll();
}
