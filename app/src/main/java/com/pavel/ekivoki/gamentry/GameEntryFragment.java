package com.pavel.ekivoki.gamentry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pavel.ekivoki.databinding.FragmentGameEntryBinding;

public class GameEntryFragment extends Fragment {
    FragmentGameEntryBinding binding;
    public static GameEntryFragment getInstance(){
        Bundle args = new Bundle();
        GameEntryFragment gameEntryFragment = new GameEntryFragment();
        gameEntryFragment.setArguments(args);
        return  gameEntryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGameEntryBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.continueGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
