package com.example.kurs2_0;

        import android.content.Context;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.RadioButton;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

public class NotificationFragment extends Fragment {
    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main, null);

        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setBackgroundColor(Color.GRAY);

        TextView notification =  new TextView(context);
        RadioButton rb = new RadioButton(context);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        rb.setLayoutParams(params);

        notification.setText("notification"+ "\n"+ "name" );

        layout.addView(notification);
        layout.addView(rb);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
