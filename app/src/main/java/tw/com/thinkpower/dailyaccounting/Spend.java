package tw.com.thinkpower.dailyaccounting;

public class Spend {

    public static final String ATT_ID = "ID";
    public static final String ATT_DATE = "DATE";
    public static final String ATT_CATEGORY = "CATEGORY";
    public static final String ATT_ITEM = "ITEM";
    public static final String ATT_AMOUNT = "AMOUNT";

    public static final String TABLE_NAME = "SPEND";

    public static String getCreateSpendStatement(){
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ATT_ID + " INTEGER primary key autoincrement,"
                + ATT_DATE + " VARCHAR, " + ATT_CATEGORY + " VARCHAR, "
                + ATT_ITEM + " VARCHAR,"+ATT_AMOUNT+" INT)";
    }

    private int id = 0;
    private String date = null;
    private String category = null;
    private String item = null;
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
}
