package com.example.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<ItemModel>
{
    public GridViewAdapter(@NonNull Context context, ArrayList<ItemModel> resource)
    {
        super(context, 0,resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listitemView = convertView;
        if (listitemView == null)
        {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_item_layout, parent, false);
        }

        ItemModel itemModel = getItem(position);
        TextView itmTV = listitemView.findViewById(R.id.idTVitem);
        ImageView itmIV = listitemView.findViewById(R.id.idIVitem);

        itmTV.setText(itemModel.getItem_name());
        itmIV.setImageResource(itemModel.getItem_image());
        return listitemView;
    }
}
