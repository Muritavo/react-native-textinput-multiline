
package com.reactlibrary;

import android.content.Context;
import android.text.InputType;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.views.textinput.ReactEditText;

public class RNReactNativeTextinputMultiline extends ReactEditText {
    public RNReactNativeTextinputMultiline(Context context) {
        super(context);
    }

    @Override
    public void setInputType(int type) {
        super.setInputType(type);
        if ((getInputType() & InputType.TYPE_TEXT_FLAG_MULTI_LINE) != 0)
            this.setSingleLine(false);
    }
}