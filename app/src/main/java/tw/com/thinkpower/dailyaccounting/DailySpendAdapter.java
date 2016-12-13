package tw.com.thinkpower.dailyaccounting;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class DailySpendAdapter extends BaseAdapter {

    private List<Spend>spends = null;

    public DailySpendAdapter(List<Spend> spends){
        this.spends = spends;
    }

    @Override
    public int getCount() {
        return spends.size();
    }

    @Override
    public Object getItem(int position) {
        return spends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView =
                inflater.inflate(R.layout.item_daily_spend,parent,false);
        TextView date = (TextView)convertView.findViewById(R.id.item_value_date);
        TextView category = (TextView) convertView.findViewById(R.id.item_value_category);
        TextView item = (TextView) convertView.findViewById(R.id.item_value_item);
        TextView amount = (TextView) convertView.findViewById(R.id.item_value_amount);
        Spend spend = (Spend)getItem(position);

        date.setText(spend.getDate());
        category.setText(spend.getCategory());
        item.setText(spend.getItem());
        amount.setText(String.valueOf(spend.getAmount()));

        return convertView;
    }
}
