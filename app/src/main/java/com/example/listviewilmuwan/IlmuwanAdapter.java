package com.example.listviewilmuwan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class IlmuwanAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Ilmuwan> scientist;

    void setscientist(ArrayList<Ilmuwan> scientist) {
        this.scientist = scientist;
    }

    IlmuwanAdapter(Context context) {
        this.context = context;
        scientist = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return scientist.size();
    }

    @Override
    public Object getItem(int i) {
        return scientist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_scientist, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Ilmuwan Ilmuwan = (Ilmuwan) getItem(i);
        viewHolder.bind(Ilmuwan);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Ilmuwan Ilmuwan) {
            txtName.setText(Ilmuwan.getName());
            txtDescription.setText(Ilmuwan.getDescription());
            imgPhoto.setImageResource(Ilmuwan.getPhoto());
        }
    }
}
