package com.vasana.smartattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.vasana.smartattendance.adapters.MenuRecycleAdapter;
import com.vasana.smartattendance.adapters.PrimaryMenuRecycleAdapter;
import com.vasana.smartattendance.pojo.MenuOption;
import com.vasana.smartattendance.pojo.MenuOptionPrimary;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfessorDashBoard extends BaseActivity {

    @BindView(R.id.menu_rv)
    RecyclerView menuRow;

    PrimaryMenuRecycleAdapter adapter = new PrimaryMenuRecycleAdapter();

    List<MenuOptionPrimary> menuOptionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_dash_board);
        ButterKnife.bind(this);

        configureMenuOptions();
    }

    private void configureMenuOptions() {
        menuOptionList.add(new MenuOptionPrimary("Class list", "View class List.",R.drawable.claa_icon));
        menuOptionList.add(new MenuOptionPrimary("Student list", "View Student list.",R.drawable.list));
        menuOptionList.add(new MenuOptionPrimary("Attendance list", "View attendance List.",R.drawable.att_list));
        menuOptionList.add(new MenuOptionPrimary("Generate barcode", "Create new barcode for students.",R.drawable.qr_icon));
        menuOptionList.add(new MenuOptionPrimary("Settings ", "Configure application.",R.drawable.settings));

        menuRow.setAdapter(adapter);
        adapter.setMenuOptionList(menuOptionList);

        adapter.setRecyclerClickListener(position -> {
            switch (position) {
                case 0: {
                    Intent switcher = new Intent(this, ProfessorClassListActivity.class);
                    startActivity(switcher);
                    break;
                }
                case 1: {
                    showCLassList(ProfessorStudentList.class);
                    break;
                }
                case 2: {
                    showCLassList(ProfessorAttendanceList.class);
                    break;
                }
                case 3: {
                    showCLassList(ProfessorBarCodeGeneratorActivity.class);
                    break;
                }
                case 4: {
                    Intent switcher = new Intent(this, ProfessorSettingsActivity.class);
                    startActivity(switcher);
                    break;
                }
            }
        });

    }


    final private MenuRecycleAdapter classAdapter = new MenuRecycleAdapter();
    final private List<MenuOption> classList = new ArrayList<>();

    private void showCLassList(Class destination) {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.class_list_dialog, null);
        RecyclerView list = view.findViewById(R.id.dialog_class_list_rv);
        classList.add(new MenuOption("First class", "You teach English"));
        classList.add(new MenuOption("Second class ", "You teach English"));
        classList.add(new MenuOption("Third class ", "You teach English"));
        classList.add(new MenuOption("Forth class", "You teach English"));
        classList.add(new MenuOption("Fifth class ", "You teach English"));

        list.setAdapter(classAdapter);
        classAdapter.setMenuOptionList(classList);
        classAdapter.setRecyclerClickListener(position -> {
            dialog.dismiss();
            Intent switcher = new Intent(this, destination);
            startActivity(switcher);
        });
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.show();
    }
}