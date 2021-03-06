package com.project.liverpool.utils.autocomplete;

import android.text.Spannable;

import com.otaliastudios.autocomplete.AutocompletePolicy;

public class SimplePolicy implements AutocompletePolicy {
    @Override
    public boolean shouldShowPopup(Spannable text, int cursorPos) {
        return text.length() > 0;
    }

    @Override
    public boolean shouldDismissPopup(Spannable text, int cursorPos) {
        return text.length() == 0;
    }

    @Override
    public CharSequence getQuery(Spannable text) {
        return text;
    }

    @Override
    public void onDismiss(Spannable text) {}
}
