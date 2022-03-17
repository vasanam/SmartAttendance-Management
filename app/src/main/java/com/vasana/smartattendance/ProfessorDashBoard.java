package com.vasana.smartattendance;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.vasana.smartattendance.adapters.MenuRecycleAdapter;
import com.vasana.smartattendance.pojo.MenuOption;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfessorDashBoard extends BaseActivity {

    @BindView(R.id.menu_rv)
    RecyclerView menuRow;

    MenuRecycleAdapter adapter = new MenuRecycleAdapter();

    List<MenuOption> menuOptionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_dash_board);
        ButterKnife.bind(this);

        configureMenuOptions();
    }

    private void configureMenuOptions() {
        menuOptionList.add(new MenuOption("Class list", "View class List."));
        menuOptionList.add(new MenuOption("Student list", "View Student list."));
        menuOptionList.add(new MenuOption("Attendance list", "View attendance List."));
        menuOptionList.add(new MenuOption("Generate barcode", "Create new barcode for students."));
        menuOptionList.add(new MenuOption("Settings ", "Configure application."));

        menuRow.setAdapter(adapter);
        adapter.setMenuOptionList(menuOptionList);

        adapter.setRecyclerClickListener(position -> {
            switch (position){
                case 0:{
                    Intent switcher = new Intent(this, ProfessorClassListActivity.class);
                    startActivity(switcher);
                }
            }
        });

    }
}