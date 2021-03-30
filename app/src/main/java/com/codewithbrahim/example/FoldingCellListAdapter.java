package com.codewithbrahim.example;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;

        ViewHolder viewHolder;
        if (cell == null){
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            //binding the view to view holder
            viewHolder.price = cell.findViewById(R.id.title_price);
            viewHolder.time = cell.findViewById(R.id.title_time_label);
            viewHolder.date = cell.findViewById(R.id.title_date_label);
            viewHolder.fromAddress = cell.findViewById(R.id.title_from_address);
            viewHolder.toAddress = cell.findViewById(R.id.title_to_address);
            viewHolder.requestCount = cell.findViewById(R.id.title_requests_count);
            viewHolder.pledgePrice = cell.findViewById(R.id.title_pledge);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        }else {
            if (unfoldedIndexes.contains(position)){
                cell.unfold(true);
            }else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }
        if (null == item) return cell;

        // bind data from selected element to view through view holder
        viewHolder.price.setText(item.getPrice());
        viewHolder.time.setText(item.getTime());
        viewHolder.date.setText(item.getDate());
        viewHolder.fromAddress.setText(item.getFromAddress());
        viewHolder.toAddress.setText(item.getToAddress());
        viewHolder.requestCount.setText(String.valueOf(item.getRequestCount()));
        viewHolder.pledgePrice.setText(item.getPledgePrice());

        //set custom btn handle for list from that item
        if (item.getRequestBtnClickListener() != null){
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        }else {
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }
        return cell;
    }


    // cell state change
    public void registerToggle(int position){
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnFold(position);
    }

    private void registerUnFold(int position) {
        unfoldedIndexes.add(position);
    }

    private void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener(){
        return defaultRequestBtnClickListener;
    }
    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener){
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // view lookup cache
    private static class ViewHolder {
        TextView price, contentRequestBtn, pledgePrice, fromAddress, toAddress, requestCount, date, time;
    }

}
