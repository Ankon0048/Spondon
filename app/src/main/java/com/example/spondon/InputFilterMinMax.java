package com.example.spondon;
import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMinMax implements InputFilter {
    private final int minValue;
    private final int maxValue;

    public InputFilterMinMax(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            String inputString = dest.toString() + source.toString();
            int input = Integer.parseInt(inputString);
            if (isInRange(minValue, maxValue, input)) {
                return null;
            }
        } catch (NumberFormatException ignored) {
        }
        return "";
    }

    private boolean isInRange(int minValue, int maxValue, int value) {
        return value >= minValue && value <= maxValue;
    }
}
