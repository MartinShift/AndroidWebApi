package com.example.lesson06;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {
    private Context context;
    private int resource;
    private List<User> users;
    private LayoutInflater inflater;
    private int countHolder;
    public NumberAdapter(Context context, int resource, List<User> users) {
        this.context = context;
        this.resource = resource;
        this.users = users;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(resource, parent, false);
        NumberViewHolder holder = new NumberViewHolder(item, users);
        holder.tvHolder.setText("holder#" + ++countHolder);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        User user = users.get(position);
        String name = user.getName();
        String lastName = user.getLastName();
        holder.tvHolder.setText(name);
        holder.tvData.setText(lastName);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView tvHolder;
        TextView tvData;
        public NumberViewHolder(@NonNull View itemView, List<User> users) { // Add users parameter
            super(itemView);
            tvHolder = itemView.findViewById(R.id.tvHolder);
            tvData = itemView.findViewById(R.id.tvData);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User clickedUser = users.get(position);
                    Intent intent = new Intent(v.getContext(), UserInfoActivity.class);
                    intent.putExtra("USER", clickedUser);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
