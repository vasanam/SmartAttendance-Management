package com.vasana.smartattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vasana.smartattendance.adapters.MenuRecycleAdapter;
import com.vasana.smartattendance.pojo.MenuOption;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfessorClassListActivity extends AppCompatActivity {

    @BindView(R.id.classListRv)
    RecyclerView classListRv;

    final private MenuRecycleAdapter adapter = new MenuRecycleAdapter();

    final private List<MenuOption> menuOptionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_class_list);
        ButterKnife.bind(this);
        configureClassList();
    }

    @OnClick(R.id.addClass)
    void addClass() {
        showAddClassDialog();
    }

    private void configureClassList() {
        menuOptionList.add(new MenuOption("First class", "You teach English"));
        menuOptionList.add(new MenuOption("Second class ", "You teach English"));
        menuOptionList.add(new MenuOption("Third class ", "You teach English"));
        menuOptionList.add(new MenuOption("Forth class", "You teach English"));
        menuOptionList.add(new MenuOption("Fifth class ", "You teach English"));

        classListRv.setAdapter(adapter);
        adapter.setMenuOptionList(menuOptionList);

        adapter.setRecyclerClickListener(position -> {
            switch (position) {
                case 0: {

                }
            }
        });
    }

    void showAddClassDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.add_class_dialog, null);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.show();
    }

}