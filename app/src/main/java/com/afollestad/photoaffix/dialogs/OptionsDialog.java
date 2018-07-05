package com.afollestad.photoaffix.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.afollestad.photoaffix.R;

public class OptionsDialog extends DialogFragment {

    public interface OptionsDialogCallback {
        void onDialogPositiveClick(DialogFragment dialogFragment);
    }

    OptionsDialogCallback mListener;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            mListener = (OptionsDialogCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OptionsDialogCallback");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder options = new AlertDialog.Builder(getActivity());

        options.setTitle("Sure About That??");
        options.setMessage("You Sure You Want to Stitch These, Bro? (or Bra - We're Inclusive)");
        options.setPositiveButton(R.string.stitch_photos, (DialogInterface dialog, int id) ->
                mListener.onDialogPositiveClick(OptionsDialog.this));

        return options.create();
    }
}
