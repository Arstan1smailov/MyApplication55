package com.example.myapplication55;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {
    private EditText textToSend;
    private Button buttonTextPass;
    public static final String KEY_FOR_TEXT = "KEY1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textToSend = view.findViewById(R.id.textToSend);
        buttonTextPass = view.findViewById(R.id.buttonTextPass);
        Bundle textForFragment = new Bundle();
        Fragment fragment = new TextFragment();


        buttonTextPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textForFragment.putString(KEY_FOR_TEXT, textToSend.getText().toString());
                fragment.setArguments(textForFragment);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new TextFragment()).addToBackStack("").commit();
            }
        });
    }
}