package com.example.cardvew;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<Persons> persons = new ArrayList<>();


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView personName;
        private final TextView personAge;
        private final ImageView personPhoto;
        private final Button btn;

        public ViewHolder(View v) {
            super(v);
            personName = v.findViewById(R.id.person_name);
            personAge = v.findViewById(R.id.person_age);
            personPhoto = v.findViewById(R.id.person_photo);
            btn = v.findViewById(R.id.button);
        }

        public TextView getPersonName() {
            return personName;
        }

        public TextView getPersonAge() {
            return personAge;
        }

        public ImageView getPersonImage() {
            return personPhoto;
        }

        public Button getBtn() {
            return btn;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @SuppressLint("NotifyDataSetChanged")
    public void addItem(String name, int age, int photoId) {
        persons.add(new Persons(name, age, photoId));
        notifyDataSetChanged();
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getPersonName().setText(persons.get(position).getName());
        viewHolder.getPersonAge().setText(String.valueOf(persons.get(position).getAge()));
        viewHolder.getPersonImage().setImageResource(persons.get(position).getPhotoId());
        viewHolder.getBtn().setOnClickListener(v -> {
            persons.remove(viewHolder.getAdapterPosition());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
