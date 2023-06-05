package me.aemo.notifyeffect;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import com.gitonway.lee.niftynotification.lib.Configuration;
import com.gitonway.lee.niftynotification.lib.Effects;
import com.gitonway.lee.niftynotification.lib.NiftyNotificationView;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.MediaUtil;

import java.io.IOException;

public class NotifyEffect extends AndroidNonvisibleComponent {

  private ComponentContainer container;

  public NotifyEffect(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }

  @SimpleProperty
  public Object STANDER_EFFECT(){
    return Effects.standard;
  }

  @SimpleProperty
  public Object SLIDE_ON_TOP_EFFECT(){
    return Effects.slideOnTop;
  }

  @SimpleProperty
  public Object FLIP_EFFECT(){
    return Effects.flip;
  }

  @SimpleProperty
  public Object SLIDE_IN_EFFECT(){
    return Effects.slideIn;
  }

  @SimpleProperty
  public Object JELLY_EFFECT(){
    return Effects.jelly;
  }

  @SimpleProperty
  public Object THUMB_SLIDER_EFFECT(){
    return Effects.thumbSlider;
  }

  @SimpleProperty
  public Object SCALE_EFFECT(){
    return Effects.scale;
  }


  View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      OnClick();
    }
  };


  @SimpleFunction
  public void Initialize(String iconPath,String msg,Object effect){
    RelativeLayout rl = new RelativeLayout((Context) container);
    rl.setLayoutParams(new RelativeLayout.LayoutParams(-2,-2));
    rl.setClipChildren(true);

    Drawable drawable = getDrawable(iconPath);
    NiftyNotificationView.build((Activity) container, msg, (Effects) effect,rl.getId())
            .setIcon(iconPath.isEmpty() ? null : drawable)
            .setOnClickListener(onClickListener)
            .show();
  }

  @SimpleProperty
  public int CENTER_TEXT_GRAVITY(){
    return Gravity.CENTER;
  }
  @SimpleProperty
  public int CENTER_VERTICAL_TEXT_GRAVITY(){
    return Gravity.CENTER_VERTICAL;
  }




  @SimpleProperty
  public String DEFAULT_AnimDurationStr(){
    return String.valueOf(700L);
  }
  @SimpleProperty
  public String DEFAULT_DisplayDurationStr(){
    return String.valueOf(1500L);
  }
  @SimpleProperty
  public String DEFAULT_BgColorStr(){
    return "#FFBDC3C7";
  }
  @SimpleProperty
  public String DEFAULT_IconBgColorStr(){
    return "#FFFFFFFF";
  }
  @SimpleProperty
  public String DEFAULT_TextColorStr(){
    return "#FF444444";
  }
  @SimpleProperty
  public int DEFAULT_TextGravity(){
    return 17;
  }
  @SimpleProperty
  public int DEFAULT_TextLines(){
    return 2;
  }
  @SimpleProperty
  public int DEFAULT_TextPadding(){
    return 5;
  }
  @SimpleProperty
  public int DEFAULT_ViewHeight(){
    return 48;
  }
  @SimpleProperty
  public boolean DEFAULT_Repeat(){
    return false;
  }


  @SimpleFunction
  public void CustomInitialize(String iconPath,String msg,Object effect,
                               String animDurationStr, String displayDurationStr,
                               String bgColorStr, String iconBgColorStr,
                               String textColorStr, int textGravity,
                               int textLines, int textPadding,
                               int viewHeight, boolean repeat){

    RelativeLayout rl = new RelativeLayout((Context) container);
    rl.setLayoutParams(new RelativeLayout.LayoutParams(-2,-2));
    rl.setClipChildren(true);

    Drawable drawable = getDrawable(iconPath);

    Configuration cfg = new Configuration.Builder()
            .setAnimDuration(Long.parseLong(animDurationStr))
            .setDispalyDuration(Long.parseLong(displayDurationStr))
            .setBackgroundColor(bgColorStr)
            .setIconBackgroundColor(iconBgColorStr)
            .setTextColor(textColorStr)
            .setTextGravity(textGravity)
            .setTextLines(textLines)
            .setTextPadding(textPadding)
            .setViewHeight(viewHeight)
            .build();

    NiftyNotificationView.build((Activity) container, msg, (Effects) effect,rl.getId(),cfg)
            .setIcon(iconPath.isEmpty() ? null : drawable)
            .setOnClickListener(onClickListener)
            .show(repeat);
  }

  @SimpleEvent
  public void OnClick() {
    EventDispatcher.dispatchEvent(this,"OnClick");
  }


  private Drawable getDrawable(String path){
    try {
      return MediaUtil.getBitmapDrawable(form,path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }



}
