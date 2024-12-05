package com.example.chatplus.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatplus.Models.Chatlist;
import com.example.chatplus.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {

    private List<Chatlist> list;
    private Context context;

    public ChatListAdapter(List<Chatlist> list, Context context ) {
        this.list = list ;
        this.context = context ;
    }

    @NonNull
    @Override
    public ChatListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Chatlist chatlist = list.get(position);

        holder.tvName.setText(chatlist.getUserName());
        holder.tvLastMassage.setText(chatlist.getLastMassage());
        holder.tvDateMassage.setText(chatlist.getDateMassage());

//        Glide.with(context).load(chatlist.getProfileEpic()).into(holder.profile);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvName, tvLastMassage, tvDateMassage;
        private CircleImageView profile;
        public Holder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
//            tvDateMassage = itemView.findViewById(R.id.tvdateMe);
            tvLastMassage = itemView.findViewById(R.id.tvLastMassage);
            profile = itemView.findViewById(R.id.tvProfile);
        }
    }
}
