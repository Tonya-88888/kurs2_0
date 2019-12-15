package com.example.kurs2_0;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    private static final String TIME_FORMAT = "HH:mm";
    private static final String TWITTER_RESPONSE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy"; // Thu Oct 26 07:31:08 +0000 2017


    private List<Habit> habitList = new ArrayList<>();

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.habit_item_view, viewGroup, false);
        return new HabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder habitViewHolder, int i) {
        habitViewHolder.bind(habitList.get(i));
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public void setItems(Collection<Habit> habits) {
        habitList.addAll(habits);
        notifyDataSetChanged();
    }

    public void clearItems() {
        habitList.clear();
        notifyDataSetChanged();
    }

    class HabitViewHolder extends RecyclerView.ViewHolder {
        // Ваш ViewHolder должен содержать переменные для всех
        // View-компонентов, которым вы хотите задавать какие-либо свойства
        // в процессе работы пользователя со списком

        private TextView name;
        private TextView notification;
        private TextView time;
        private TextView day;
        private CheckBox checkBox;

        // Мы также создали конструктор, который принимает на вход View-компонент строкИ
        // и ищет все дочерние компоненты
        public HabitViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.habitRecyclerViewName);
            notification = itemView.findViewById(R.id.habitRecyclerViewNotification);
            time = itemView.findViewById(R.id.habitRecyclerViewTime);
            day = itemView.findViewById(R.id.habitRecyclerViewDay);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        public void bind(Habit habit) {
            name.setText(habit.getName());
            notification.setText(habit.getNotificationText());
            day.setText(Integer.toString(habit.getDay()));

            time.setText(getFormattedDate(habit.getNotificationTime()));
            // time.setText(getFormattedDate(Long.toString(habit.getNotificationTime())));
            // time.setText(String.valueOf(habit.getRetweetCount()));
           //  tweetImageView.setVisibility(tweetPhotoUrl != null ? View.VISIBLE : View.GONE);

        }

        private String getFormattedDate(long notiTime) {

            Date date = new Date(notiTime);
            SimpleDateFormat formatForDateNow = new SimpleDateFormat(TIME_FORMAT);
            return formatForDateNow.format(date);

            /*SimpleDateFormat utcFormat = new SimpleDateFormat(TWITTER_RESPONSE_FORMAT, Locale.ROOT);
            SimpleDateFormat displayedFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
            try {
                Date date = utcFormat.parse(rawDate);
                return displayedFormat.format(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}
