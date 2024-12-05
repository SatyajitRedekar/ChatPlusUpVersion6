package com.example.chatplus.Fragments;

import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chatplus.GroupChatActivity;
import com.example.chatplus.databinding.FragmentGroupBinding;


public class GroupFragment extends Fragment {
    FragmentGroupBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding = FragmentGroupBinding.inflate(inflater,container,false);

    binding.tvName.setText("Mini Project");

    binding.userNameList.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), GroupChatActivity.class);
            getActivity().startActivity(intent);
        }
    });

    return binding.getRoot();
    }
}