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

public class TextFragment3 extends Fragment {
    private TextView showText3;
    private Button buttonTextAccept3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text3, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showText3 = view.findViewById(R.id.showText2);
        buttonTextAccept3 = view.findViewById(R.id.buttonTextAccept2);
        Bundle textAccept = getArguments();
        String text = textAccept.getString(MainFragment.KEY_FOR_TEXT);
        showText3.setText(text);
        buttonTextAccept3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textAccept.putString(MainFragment.KEY_FOR_TEXT, text);
                Fragment fragment = new TextFragment4();
                fragment.setArguments(textAccept);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("").commit();
            }
        });
    }
}