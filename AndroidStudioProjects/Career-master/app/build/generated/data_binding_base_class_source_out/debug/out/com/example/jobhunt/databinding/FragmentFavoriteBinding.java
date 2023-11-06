// Generated by view binder compiler. Do not edit!
package com.example.jobhunt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.jobhunt.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFavoriteBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final LinearLayout favoriteHeader;

  @NonNull
  public final RecyclerView rvBookmarkView;

  private FragmentFavoriteBinding(@NonNull ScrollView rootView,
      @NonNull LinearLayout favoriteHeader, @NonNull RecyclerView rvBookmarkView) {
    this.rootView = rootView;
    this.favoriteHeader = favoriteHeader;
    this.rvBookmarkView = rvBookmarkView;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_favorite, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFavoriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.favorite_header;
      LinearLayout favoriteHeader = ViewBindings.findChildViewById(rootView, id);
      if (favoriteHeader == null) {
        break missingId;
      }

      id = R.id.rv_bookmarkView;
      RecyclerView rvBookmarkView = ViewBindings.findChildViewById(rootView, id);
      if (rvBookmarkView == null) {
        break missingId;
      }

      return new FragmentFavoriteBinding((ScrollView) rootView, favoriteHeader, rvBookmarkView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
