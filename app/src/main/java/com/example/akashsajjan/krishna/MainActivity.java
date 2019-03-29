package com.example.akashsajjan.krishna;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        TextView textView = (TextView)findViewById(R.id.textView2);
    }

    public static class FireMissilesDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Krishna Assignment");
            builder.setMessage("Dialog PopUp")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            Log.d("FlowCheck","hello u clicked yes.");
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                            Log.d("FlowCheck","hello u clicked no.");
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        DialogFragment dialogFragment = new FireMissilesDialogFragment();
        dialogFragment.show(getSupportFragmentManager()
                ,"");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FlowCheck","Inside onStop method ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FlowCheck","Inside onDestroy method ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FlowCheck","Inside onPause method ");
        count++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FlowCheck","Inside onResume method ");
        Log.d("FlowCheck",String.valueOf(count));
    }
}
