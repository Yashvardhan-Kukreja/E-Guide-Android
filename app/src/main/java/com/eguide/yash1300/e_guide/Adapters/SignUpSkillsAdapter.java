package com.eguide.yash1300.e_guide.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.eguide.yash1300.e_guide.Listeners.SignUpSkillUpdateListener;
import com.eguide.yash1300.e_guide.Models.SkillModel;
import com.eguide.yash1300.e_guide.R;

import java.util.List;

public class SignUpSkillsAdapter extends RecyclerView.Adapter<SignUpSkillsAdapter.ViewHolder> {

    Context context;
    List<SkillModel> skills;

    public SignUpSkillsAdapter(Context context, List<SkillModel> skills) {
        this.context = context;
        this.skills = skills;
    }

    @NonNull
    @Override
    public SignUpSkillsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.adapter_sign_up_skills, parent, false);
        return (new ViewHolder(rootView));
    }

    @Override
    public void onBindViewHolder(@NonNull SignUpSkillsAdapter.ViewHolder holder, int position) {
        final SkillModel currentSkill = skills.get(position);
        holder.skillName.setText(currentSkill.getName());
        holder.skillCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SignUpSkillUpdateListener skillUpdateListener = (SignUpSkillUpdateListener) context;
                if (isChecked)
                    skillUpdateListener.includeSkill(currentSkill.getId());
                else
                    skillUpdateListener.excludeSkill(currentSkill.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView skillName;
        CheckBox skillCheckbox;

        public ViewHolder(View itemView) {
            super(itemView);

            skillName = itemView.findViewById(R.id.adapter_sign_up_skills_skill_name);
            skillCheckbox = itemView.findViewById(R.id.adapter_sign_up_skills_checkbox);

        }
    }
}
