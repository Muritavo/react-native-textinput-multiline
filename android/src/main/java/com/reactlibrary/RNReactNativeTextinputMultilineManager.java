
package com.reactlibrary;

import android.text.InputType;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewDefaults;
import com.facebook.react.views.textinput.ReactEditText;
import com.facebook.react.views.textinput.ReactTextInputManager;

public class RNReactNativeTextinputMultilineManager extends ReactTextInputManager {
  public static final String REACT_CLASS = "RNReactNativeTextinputMultiline";

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public ReactEditText createViewInstance(ThemedReactContext context) {
    RNReactNativeTextinputMultiline editText = new RNReactNativeTextinputMultiline(context);
    int inputType = editText.getInputType();
    editText.setInputType(inputType & (~InputType.TYPE_TEXT_FLAG_MULTI_LINE));
    editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
    editText.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            (int) Math.ceil(PixelUtil.toPixelFromSP(ViewDefaults.FONT_SIZE_SP)));
    return editText;
  }
}