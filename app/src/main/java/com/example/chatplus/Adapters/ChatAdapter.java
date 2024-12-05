package com.example.chatplus.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatplus.Models.MassagesModel;
import com.example.chatplus.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MassagesModel> massagesModels;
    Context context;

    int SENDER_VIEW_TYPE = 1 ;
    int RECEIVER_VIEW_TYPE = 2 ;

    public ChatAdapter(ArrayList<MassagesModel> massagesModels, Context context) {
        this.massagesModels = massagesModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SENDER_VIEW_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new SenderViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_receiver,parent,false);
            return new RecieverViewHolder(view) {
            };
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (massagesModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid()))
        {
            return SENDER_VIEW_TYPE;
        }
        else {
            return RECEIVER_VIEW_TYPE;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MassagesModel massagesModel = massagesModels.get(position);

        if (holder.getClass() == SenderViewHolder.class) {
            ((SenderViewHolder)holder).senderMassage.setText(massagesModel.getMassage());
        }
        else {
            ((RecieverViewHolder)holder).receverMassage.setText(massagesModel.getMassage());
        }
    }

    @Override
    public int getItemCount() {
        return massagesModels.size();
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder {

        TextView receverMassage, receverTime;

        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);
            receverMassage = itemView.findViewById(R.id.receiverText);
//            receverTime = itemView.findViewById(R.id.receiversTime);
        }
    }




    public class SenderViewHolder extends RecyclerView.ViewHolder {

        TextView senderMassage, senderTime;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMassage = itemView.findViewById(R.id.senderMassage);
//            senderTime = itemView.findViewById(R.id.senderTime);
        }
    }

}
