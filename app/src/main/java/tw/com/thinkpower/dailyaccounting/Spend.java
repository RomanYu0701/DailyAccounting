package tw.com.thinkpower.dailyaccounting;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Spend {

    @Id(autoincrement = true)
    @Property(nameInDb = "ID")
    private Long id;
    @NotNull
    @Property(nameInDb = "DATE")
    private String date = null;
    @NotNull
    @Property(nameInDb = "CATEGORY")
    private String category = null;
    @NotNull
    @Property(nameInDb = "ITEM")
    private String item = null;
    @NotNull
    @Property(nameInDb = "AMOUNT")
    private int amount = 0;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public static final String ATT_ID = "ID";
    public static final String ATT_DATE = "DATE";
    public static final String ATT_CATEGORY = "CATEGORY";
    public static final String ATT_ITEM = "ITEM";
    public static final String ATT_AMOUNT = "AMOUNT";

    public static final String TABLE_NAME = "SPEND";

    @Generated(hash = 1212527477)
    public Spend(Long id, @NotNull String date, @NotNull String category,
            @NotNull String item, int amount) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.item = item;
        this.amount = amount;
    }

    @Generated(hash = 698462423)
    public Spend() {
    }

    public static String getCreateSpendStatement(){
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ATT_ID + " INTEGER primary key autoincrement,"
                + ATT_DATE + " VARCHAR, " + ATT_CATEGORY + " VARCHAR, "
                + ATT_ITEM + " VARCHAR,"+ATT_AMOUNT+" INT)";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
