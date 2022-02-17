package com.example.myapplication55;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TextFragment2 extends Fragment {
    private TextView showText2;
    private Button buttonTextAccept2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showText2 = view.findViewById(R.id.showText2);
        buttonTextAccept2 = view.findViewById(R.id.buttonTextAccept2);
        Bundle textAccept = getArguments();
        buttonTextAccept2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new TextFragment2();
                fragment.setArguments(textAccept);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new TextFragment2()).addToBackStack("").commit();
            }
        });
    }
}