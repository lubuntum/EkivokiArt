package com.pavel.ekivoki.ui.manual.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

import com.pavel.ekivoki.R;
import com.pavel.ekivoki.data.entity.Category;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private final LayoutInflater inflater;
    private final int resource;
    private List<Category> categories;

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Category> categories) {
        super(context, resource, categories);
        this.categories = categories;
        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(resource,parent,false);
        }
        Category category = categories.get(position);
        TextView categoryText = convertView.findViewById(R.id.categoryText);
        ImageView categoryIcon = convertView.findViewById(R.id.categoryIcon);

        categoryText.setText(category.getCategoryName());
        categoryIcon.setImageDrawable(AppCompatResources.getDrawable(getContext(),category.getImageResourceId()));

        return convertView;
    }

}
