package com.ic.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    LinearLayout bottom_sheet;
    TextView state_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        state_tv = findViewById(R.id.state_tv);
        bottom_sheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        state_tv.setOnClickListener(v ->
               bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));

        // change the state of the bottom sheet
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        // set the peek height
        //bottomSheetBehavior.setPeekHeight(340);
        // set hideable or not
        //bottomSheetBehavior.setHideable(false);

        // set callback for changes

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        state_tv.setText(getString(R.string.STATE_DRAGGING));
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        state_tv.setText(getString(R.string.STATE_EXPANDED));
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        state_tv.setText(getString(R.string.STATE_COLLAPSED));
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        state_tv.setText(getString(R.string.STATE_HALF_EXPANDED));
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        state_tv.setText(getString(R.string.STATE_HIDDEN));
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        state_tv.setText(getString(R.string.STATE_SETTLING));
                        break;
                }


            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                updateBottomSheetStateText();
            }
        });
    }

    private void updateBottomSheetStateText() {

    }
}