package com.example.dietapp;
// app manages user's diet plan
// user inputs his diet plan for the upcoming day, typing calories
// app reminds  user of his meals half an hour before it's time to eat, shows diet plan for a week and prepares ingredients' list for an upcoming week

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    public Calendar calRightNow;
    public Integer currentHourIn24Format;
    public TextView txtDate;
    public Integer minutes;
    public DateFormat dateFormat, dateFormatDataBase;
    public String currentDate;
    public TextView txtBreakfastDesc, txtBrunchDesc, txtLunchDesc, txtTeaDesc, txtDinnerDesc, txtBreakfastCal, txtBrunchCal, txtLunchCal, txtTeaCal, txtDinnerCal, txtCalSummed;
    public TextClock txtClock;
    public List<DietPlanDataMonday> dataList;
    private RoomDB roomDB;
    private String currentDateDataBase;
    private Date date;
    private Calendar calendar;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnAdd) {
                Intent intent = new Intent(MainActivity.this, AddDietActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initViews();
        displayDiet();

    }
    private void initViews() {
        txtBreakfastDesc = findViewById(R.id.txtBreakfastDesc);
        txtBrunchDesc = findViewById(R.id.txtBrunchDesc);
        txtLunchDesc = findViewById(R.id.txtLunchDesc);
        txtTeaDesc = findViewById(R.id.txtTeaDesc);
        txtDinnerDesc = findViewById(R.id.txtDinnerDesc);

        txtBreakfastCal = findViewById(R.id.txtBreakfastCal);
        txtBrunchCal = findViewById(R.id.txtBrunchCal);
        txtLunchCal = findViewById(R.id.txtLunchCal);
        txtTeaCal = findViewById(R.id.txtTeaCal);
        txtDinnerCal = findViewById(R.id.txtDinnerCal);

        txtClock = findViewById(R.id.txtClock);

        // displays current Date in a TextView
        txtDate = findViewById(R.id.txtDate);
        txtDate.setText(currentDate);
    }
    // creates a variable in which the program saves current Date and initialises it
    private void initDate() {
        calendar = Calendar.getInstance();
        date = new Date();


        dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        currentDate = dateFormat.format(Calendar.getInstance().getTime());

        dateFormatDataBase = new SimpleDateFormat("dd/MM/yyyy");
        calendar.setTime(date);
        // adds X days to current date
//        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        currentDateDataBase = dateFormatDataBase.format(date);
    }
    // displays date using data from the database
    private void displayDiet() {

        roomDB = RoomDB.getInstance(this);
        if (roomDB.mondayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.mondayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.mondayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.mondayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.mondayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.mondayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.mondayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.mondayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.mondayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.mondayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.mondayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.tuesdayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.tuesdayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.tuesdayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.tuesdayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.tuesdayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.tuesdayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.tuesdayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.tuesdayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.tuesdayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.tuesdayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.tuesdayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.wednesdayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.wednesdayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.wednesdayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.wednesdayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.wednesdayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.wednesdayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.wednesdayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.wednesdayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.wednesdayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.wednesdayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.wednesdayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.thursdayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.thursdayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.thursdayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.thursdayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.thursdayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.thursdayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.thursdayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.thursdayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.thursdayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.thursdayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.thursdayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.fridayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.fridayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.fridayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.fridayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.fridayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.fridayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.fridayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.fridayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.fridayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.fridayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.fridayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.saturdayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.saturdayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.saturdayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.saturdayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.saturdayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.saturdayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.saturdayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.saturdayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.saturdayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.saturdayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.saturdayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        if (roomDB.sundayDAO().checkIfGivenDataEntryExists(currentDateDataBase)){
            // takes data from database and puts them into txt fields
            txtBreakfastDesc.setText(roomDB.sundayDAO().breakfastNameFinder(currentDateDataBase));
            txtBreakfastCal.setText(roomDB.sundayDAO().breakfastCaloriesFinder(currentDateDataBase));
            txtBrunchDesc.setText(roomDB.sundayDAO().brunchNameFinder(currentDateDataBase));
            txtBrunchCal.setText(roomDB.sundayDAO().brunchCaloriesFinder(currentDateDataBase));
            txtLunchDesc.setText(roomDB.sundayDAO().lunchNameFinder(currentDateDataBase));
            txtLunchCal.setText(roomDB.sundayDAO().lunchCaloriesFinder(currentDateDataBase));
            txtTeaDesc.setText(roomDB.sundayDAO().teaNameFinder(currentDateDataBase));
            txtTeaCal.setText(roomDB.sundayDAO().teaCaloriesFinder(currentDateDataBase));
            txtDinnerDesc.setText(roomDB.sundayDAO().dinnerNameFinder(currentDateDataBase));
            txtDinnerCal.setText(roomDB.sundayDAO().dinnerCaloriesFinder(currentDateDataBase));
        }
        txtCalSummed = findViewById(R.id.txtCalSummed);
        txtCalSummed.setText(sumCalories());

    }
    private String sumCalories(){
        int result;
        try {
            result = Integer.parseInt(txtBreakfastCal.getText().toString())
                    + Integer.parseInt(txtBrunchCal.getText().toString())
                    + Integer.parseInt(txtLunchCal.getText().toString())
                    + Integer.parseInt(txtTeaCal.getText().toString())
                    + Integer.parseInt(txtDinnerCal.getText().toString());
        }
        catch (NumberFormatException e){
            result = -1;
        }
        if (result == 0) {
            return "brak kalorii";
        } else if (result == -1){
            return "brak kalorii";
        }
        else {
            return Integer.toString(result);
        }
    }
}