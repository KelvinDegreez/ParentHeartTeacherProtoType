package com.kelvindegrez.parentheartteacher.impl.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kelvindegrez.parentheartteacher.R;
import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.objects.Rating;
import com.kelvindegrez.parentheartteacher.objects.Subject;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.List;


public class TeacherRecyclerViewAdapter extends RecyclerView.Adapter<TeacherRecyclerViewAdapter.ViewHolder> {

    private final List<Teacher> teacherList;

    public TeacherRecyclerViewAdapter(List<Teacher> items) {
        teacherList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_teacher, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Teacher teacher = teacherList.get(position);

        holder.mItem = teacherList.get(position);
        holder.nameText.setText(teacher.getFirstName()+" "+teacher.getLastName());

        String rating = "Ratings:\n";
        for(Rating rate : teacher.getRatings().keySet()){
            rating = rating + rate.name()+": "+teacher.getRatings().get(rate)+"\n";
        }

        holder.ratingText.setText(rating);

        String subject = "Subjects:\n";
        for(Subject subj : teacher.getSubjectExpertise()){
            subject = subject + subj.name()+"\n";
        }

        holder.subjectText.setText(subject);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainApp.getDaggerComponent().provideApplication(),
                        "You selected "+teacher.getLastName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView profilePic;
        public final TextView nameText;
        public final TextView ratingText;
        public final TextView subjectText;
        public Teacher mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            profilePic = (ImageView) view.findViewById(R.id.profilePic);
            nameText = (TextView) view.findViewById(R.id.name);
            ratingText = (TextView) view.findViewById(R.id.rating);
            subjectText = (TextView) view.findViewById(R.id.subjects);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
