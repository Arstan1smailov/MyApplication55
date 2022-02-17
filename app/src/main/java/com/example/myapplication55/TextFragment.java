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

public class TextFragment extends Fragment {
    private TextView showText1;
    private Button buttonTextAccept1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.text_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showText1 = view.findViewById(R.id.showText1);
        buttonTextAccept1 = view.findViewById(R.id.buttonTextAccept1);
        Bundle textAccept = getArguments();
        String text = textAccept.getString(MainFragment.KEY_FOR_TEXT);
        showText1.setText(text);
        buttonTextAccept1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textAccept.putString(MainFragment.KEY_FOR_TEXT, text);
                Fragment fragment = new TextFragment2();
                fragment.setArguments(textAccept);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("").commit();

            }
        });

    }
}

