// Generated by view binder compiler. Do not edit!
package com.example.jobhunt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.jobhunt.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemNewcomBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView expireDate;

  @NonNull
  public final ConstraintLayout itemRecent;

  @NonNull
  public final TextView recruitName;

  @NonNull
  public final TextView recruitTitle;

  private ItemNewcomBinding(@NonNull ConstraintLayout rootView, @NonNull TextView expireDate,
      @NonNull ConstraintLayout itemRecent, @NonNull TextView recruitName,
      @NonNull TextView recruitTitle) {
    this.rootView = rootView;
    this.expireDate = expireDate;
    this.itemRecent = itemRecent;
    this.recruitName = recruitName;
    this.recruitTitle = recruitTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemNewcomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemNewcomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_newcom, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemNewcomBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.expire_date;
      TextView expireDate = ViewBindings.findChildViewById(rootView, id);
      if (expireDate == null) {
        break missingId;
      }

      ConstraintLayout itemRecent = (ConstraintLayout) rootView;

      id = R.id.recruit_name;
      TextView recruitName = ViewBindings.findChildViewById(rootView, id);
      if (recruitName == null) {
        break missingId;
      }

      id = R.id.recruit_title;
      TextView recruitTitle = ViewBindings.findChildViewById(rootView, id);
      if (recruitTitle == null) {
        break missingId;
      }

      return new ItemNewcomBinding((ConstraintLayout) rootView, expireDate, itemRecent, recruitName,
          recruitTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
