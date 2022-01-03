package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddDietActivity extends AppCompatActivity {
    private EditText edtBreakfastName, edtBreakfastCal, edtSecondBreakfast, edtSecondBreakfastCal,
            edtLunch, edtLunchCal, edtTea, edtTeaCal, edtDinner, edtDinnerCal;
    private Button btnApplyDiet, btnEdit;
    private RoomDB database;
    private Date date;
    private Calendar calendar;
    private List<DietPlanDataMonday> dataList = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatterOnlyDay = new SimpleDateFormat("EEE");
    //TODO pomyslec jak sprawic, by stworzyc jeden (wlasnie co) DietPlan zamiast 7 roznych klas dla kazdego dnia
    private DietPlanDataMonday dataMonday;
    private DietPlanDataTuesday dataTuesday;
    private DietPlanDataWednesday dataWednesday;
    private DietPlanDataThursday dataThursday;
    private DietPlanDataFriday dataFriday;
    private DietPlanDataSaturday dataSaturday;
    private DietPlanDataSunday dataSunday;
    private String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    ArrayAdapter<String>daysAdapter;
    private Spinner spinner;
    private String usersDay, currentDate;
    private int currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet);
        initViews();
        initDataBase();
        initDate();

        btnApplyDiet = findViewById(R.id.btnApplyDiet);
        btnApplyDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // onclick method saves user's input to DietPlanXclass class
                boolean validate = validateUserInput();
                if (validate) {
                    switch (usersDay){
                        case "Monday":
                        if (database.mondayDAO().breakfastNameFinder(currentDate) == null) {
                            setMeals(usersDay);
                            Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                            startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Tuesday":
                            if (database.tuesdayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Wednesday":
                            if (database.wednesdayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Thursday":
                            if (database.thursdayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Friday":
                            if (database.fridayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Saturday":
                            if (database.saturdayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Sunday":
                            if (database.sundayDAO().breakfastNameFinder(currentDate) == null) {
                                setMeals(usersDay);
                                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(AddDietActivity.this, "Today's diet is already set, use EDIT instead", Toast.LENGTH_LONG).show();
                            }
                            break;
                    }
                }
                else {
                    Toast.makeText(AddDietActivity.this, "Please input all the information", Toast.LENGTH_SHORT).show();
                    }
                }
        });
        btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfFieldsAreEmpty(usersDay);
                Intent intent = new Intent(AddDietActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch ((int) l){
                    case 0:
                    usersDay = "Monday";
                    break;
                    case 1:
                    usersDay = "Tuesday";
                    break;
                    case 2:
                    usersDay = "Wednesday";
                    break;
                    case 3:
                    usersDay = "Thursday";
                    break;
                    case 4:
                    usersDay = "Friday";
                    break;
                    case 5:
                    usersDay = "Saturday";
                    break;
                    case 6:
                    usersDay = "Sunday";
                    break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initDataBase() {
        database = RoomDB.getInstance(this);
        dataList = database.mondayDAO().getAll();
    }

    private void initDate(){
        date = new Date();
        calendar = Calendar.getInstance();

        calendar.setTime(date);
        date = calendar.getTime();
        currentDate = formatter.format(date);


        currentDay = calendar.get(Calendar.DAY_OF_WEEK);

    }

    private void initViews() {
        // adapter for list of strings used to display current day of the week
        daysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);

        spinner = findViewById(R.id.DayOfTheWeekSpn);
        spinner.setAdapter(daysAdapter);

        edtBreakfastName = findViewById(R.id.edtBreakfastName);
        edtBreakfastCal = findViewById(R.id.edtBreakfastCal);
        edtSecondBreakfast = findViewById(R.id.edtSecondBreakfast);
        edtSecondBreakfastCal = findViewById(R.id.edtSecondBreakfastCal);
        edtLunch = findViewById(R.id.edtLunch);
        edtLunchCal = findViewById(R.id.edtLunchCal);
        edtTea = findViewById(R.id.edtTea);
        edtTeaCal = findViewById(R.id.edtTeaCal);
        edtDinner = findViewById(R.id.edtDinner);
        edtDinnerCal = findViewById(R.id.edtDinnerCal);

    }

    private boolean validateUserInput() {
        if (edtLunch.getText().toString().isEmpty()) {
            return false;
        }
        if (edtLunchCal.getText().toString().isEmpty()) {

            return false;
        }
        if (edtBreakfastName.getText().toString().isEmpty()) {
            return false;
        }
        if (edtBreakfastCal.getText().toString().isEmpty()) {
            return false;
        }
        if (edtSecondBreakfast.getText().toString().isEmpty()) {
            return false;
        }
        if (edtSecondBreakfastCal.getText().toString().isEmpty()) {
            return false;
        }
        if (edtTea.getText().toString().isEmpty()) {
            return false;
        }
        if (edtTeaCal.getText().toString().isEmpty()) {
            return false;
        }
        if (edtDinner.getText().toString().isEmpty()) {
            return false;
        }
        if (edtDinnerCal.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }
    // method is used to edit currently existing fields in database depending on users input in edittext
    private void checkIfFieldsAreEmpty(String day){
        switch (day) {
            case "Monday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.mondayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.mondayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.mondayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.mondayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.mondayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.mondayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.mondayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.mondayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.mondayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.mondayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Tuesday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.tuesdayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Wednesday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.wednesdayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Thursday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.thursdayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Friday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.fridayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.fridayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.fridayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.fridayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.fridayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.fridayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.fridayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.fridayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.fridayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.fridayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Satuday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.saturdayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
            case "Sunday":
                if (!edtBreakfastName.getText().toString().isEmpty()) {
                    database.sundayDAO().updateBreakfastName(edtBreakfastName.getText().toString().trim(), currentDate);
                }
                if (!edtBreakfastCal.getText().toString().isEmpty()) {
                    database.sundayDAO().updateBreakfastCalories(edtBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfast.getText().toString().isEmpty()) {
                    database.sundayDAO().updateBrunchName(edtSecondBreakfast.getText().toString().trim(), currentDate);
                }
                if (!edtSecondBreakfastCal.getText().toString().isEmpty()) {
                    database.sundayDAO().updateBrunchCalories(edtSecondBreakfastCal.getText().toString().trim(), currentDate);
                }
                if (!edtLunch.getText().toString().isEmpty()) {
                    database.sundayDAO().updateLunchName(edtLunch.getText().toString().trim(), currentDate);
                }
                if (!edtLunchCal.getText().toString().isEmpty()) {
                    database.sundayDAO().updateLunchCalories(edtLunchCal.getText().toString().trim(), currentDate);
                }
                if (!edtTea.getText().toString().isEmpty()) {
                    database.sundayDAO().updateTeaName(edtTea.getText().toString().trim(), currentDate);
                }
                if (!edtTeaCal.getText().toString().isEmpty()) {
                    database.sundayDAO().updateTeaCalories(edtTeaCal.getText().toString().trim(), currentDate);
                }
                if (!edtDinner.getText().toString().isEmpty()) {
                    database.sundayDAO().updateDinnerName(edtDinner.getText().toString().trim(), currentDate);
                }
                if (!edtDinnerCal.getText().toString().isEmpty()) {
                    database.sundayDAO().updateDinnerCalories(edtDinnerCal.getText().toString().trim(), currentDate);
                }
                break;
        }
    }
    // method is used to implement new record in database
    private void setMeals(String day) {
        String sbreakfastName = edtBreakfastName.getText().toString().trim();
        String sbreakfastCalories = edtBreakfastCal.getText().toString().trim();
        String sbrunchName = edtSecondBreakfast.getText().toString().trim();
        String sbrunchCalories = edtSecondBreakfastCal.getText().toString().trim();
        String slunchName = edtLunch.getText().toString().trim();
        String slunchCalories = edtLunchCal.getText().toString().trim();
        String steaName = edtTea.getText().toString().trim();
        String steaCalories = edtTeaCal.getText().toString().trim();
        String sdinnerName = edtDinner.getText().toString().trim();
        String sdinnerCalories = edtDinnerCal.getText().toString().trim();
        int daysTo;



        switch(day) {

            case "Monday":
                if (currentDay != Calendar.MONDAY){
                        if (Calendar.MONDAY > currentDay){
                            daysTo = Calendar.MONDAY - currentDay;
                            calendar.add(Calendar.DATE, daysTo);
                            date = calendar.getTime();
                            currentDate = formatter.format(date);
                        }
                        else if (Calendar.MONDAY < currentDay) {
                            daysTo = (7 - currentDay) + Calendar.MONDAY;
                            calendar.add(Calendar.DATE, daysTo);
                            date = calendar.getTime();
                            currentDate = formatter.format(date);
                        }
                }
                dataMonday = new DietPlanDataMonday();
                dataMonday.setBreakfastName(sbreakfastName);
                dataMonday.setBreakfastCaloriers(sbreakfastCalories);
                dataMonday.setBrunchName(sbrunchName);
                dataMonday.setBrunchCal(sbrunchCalories);
                dataMonday.setLunchName(slunchName);
                dataMonday.setLunchCal(slunchCalories);
                dataMonday.setTeaName(steaName);
                dataMonday.setTeaCal(steaCalories);
                dataMonday.setDinnerName(sdinnerName);
                dataMonday.setDinnerCal(sdinnerCalories);
                dataMonday.setCreatedAt(currentDate);
                database.mondayDAO().insert(dataMonday);
                System.out.println("Inserting monday");
                break;
            case "Tuesday":
                if (currentDay != Calendar.TUESDAY){
                    if (Calendar.TUESDAY > currentDay){
                        daysTo = Calendar.TUESDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.TUESDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.TUESDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataTuesday = new DietPlanDataTuesday();

                dataTuesday.setBreakfastName(sbreakfastName);
                dataTuesday.setBreakfastCaloriers(sbreakfastCalories);
                dataTuesday.setBrunchName(sbrunchName);
                dataTuesday.setBrunchCal(sbrunchCalories);
                dataTuesday.setLunchName(slunchName);
                dataTuesday.setLunchCal(slunchCalories);
                dataTuesday.setTeaName(steaName);
                dataTuesday.setTeaCal(steaCalories);
                dataTuesday.setDinnerName(sdinnerName);
                dataTuesday.setDinnerCal(sdinnerCalories);
                dataTuesday.setCreatedAt(currentDate);
                database.tuesdayDAO().insert(dataTuesday);
                System.out.println("Inserting tuesday");
                break;
            case "Wednesday":
                if (currentDay != Calendar.WEDNESDAY){
                    if (Calendar.WEDNESDAY > currentDay){
                        daysTo = Calendar.WEDNESDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.WEDNESDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.WEDNESDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataWednesday = new DietPlanDataWednesday();
                dataWednesday.setBreakfastName(sbreakfastName);
                dataWednesday.setBreakfastCaloriers(sbreakfastCalories);
                dataWednesday.setBrunchName(sbrunchName);
                dataWednesday.setBrunchCal(sbrunchCalories);
                dataWednesday.setLunchName(slunchName);
                dataWednesday.setLunchCal(slunchCalories);
                dataWednesday.setTeaName(steaName);
                dataWednesday.setTeaCal(steaCalories);
                dataWednesday.setDinnerName(sdinnerName);
                dataWednesday.setDinnerCal(sdinnerCalories);
                dataWednesday.setCreatedAt(currentDate);
                database.wednesdayDAO().insert(dataWednesday);
                System.out.println("Inserting wednesday");
                break;
            case "Thursday":
                if (currentDay != Calendar.THURSDAY){
                    if (Calendar.THURSDAY > currentDay){
                        daysTo = Calendar.THURSDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.THURSDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.THURSDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataThursday = new DietPlanDataThursday();
                dataThursday.setBreakfastName(sbreakfastName);
                dataThursday.setBreakfastCaloriers(sbreakfastCalories);
                dataThursday.setBrunchName(sbrunchName);
                dataThursday.setBrunchCal(sbrunchCalories);
                dataThursday.setLunchName(slunchName);
                dataThursday.setLunchCal(slunchCalories);
                dataThursday.setTeaName(steaName);
                dataThursday.setTeaCal(steaCalories);
                dataThursday.setDinnerName(sdinnerName);
                dataThursday.setDinnerCal(sdinnerCalories);
                dataThursday.setCreatedAt(currentDate);
                database.thursdayDAO().insert(dataThursday);
                System.out.println("Inserting thursday");
                break;

            case "Friday":
                if (currentDay != Calendar.FRIDAY){
                    if (Calendar.FRIDAY > currentDay){
                        daysTo = Calendar.FRIDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.FRIDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.FRIDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataFriday = new DietPlanDataFriday();
                dataFriday.setBreakfastName(sbreakfastName);
                dataFriday.setBreakfastCaloriers(sbreakfastCalories);
                dataFriday.setBrunchName(sbrunchName);
                dataFriday.setBrunchCal(sbrunchCalories);
                dataFriday.setLunchName(slunchName);
                dataFriday.setLunchCal(slunchCalories);
                dataFriday.setTeaName(steaName);
                dataFriday.setTeaCal(steaCalories);
                dataFriday.setDinnerName(sdinnerName);
                dataFriday.setDinnerCal(sdinnerCalories);
                dataFriday.setCreatedAt(currentDate);
                database.fridayDAO().insert(dataFriday);
                System.out.println("Inserting friday");
                break;
            case "Saturday":
                if (currentDay != Calendar.SATURDAY){
                    if (Calendar.SATURDAY > currentDay){
                        daysTo = Calendar.SATURDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.SATURDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.SATURDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataSaturday = new DietPlanDataSaturday();
                dataSaturday.setBreakfastName(sbreakfastName);
                dataSaturday.setBreakfastCaloriers(sbreakfastCalories);
                dataSaturday.setBrunchName(sbrunchName);
                dataSaturday.setBrunchCal(sbrunchCalories);
                dataSaturday.setLunchName(slunchName);
                dataSaturday.setLunchCal(slunchCalories);
                dataSaturday.setTeaName(steaName);
                dataSaturday.setTeaCal(steaCalories);
                dataSaturday.setDinnerName(sdinnerName);
                dataSaturday.setDinnerCal(sdinnerCalories);
                dataSaturday.setCreatedAt(currentDate);
                database.saturdayDAO().insert(dataSaturday);
                System.out.println("Inserting saturday");
                break;
            case "Sunday":
                if (currentDay != Calendar.SUNDAY){
                    if (Calendar.SUNDAY > currentDay){
                        daysTo = Calendar.SUNDAY - currentDay;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                    else if (Calendar.SUNDAY < currentDay) {
                        daysTo = (7 - currentDay) + Calendar.SUNDAY;
                        calendar.add(Calendar.DATE, daysTo);
                        date = calendar.getTime();
                        currentDate = formatter.format(date);
                    }
                }
                dataSunday = new DietPlanDataSunday();
                dataSunday.setBreakfastName(sbreakfastName);
                dataSunday.setBreakfastCaloriers(sbreakfastCalories);
                dataSunday.setBrunchName(sbrunchName);
                dataSunday.setBrunchCal(sbrunchCalories);
                dataSunday.setLunchName(slunchName);
                dataSunday.setLunchCal(slunchCalories);
                dataSunday.setTeaName(steaName);
                dataSunday.setTeaCal(steaCalories);
                dataSunday.setDinnerName(sdinnerName);
                dataSunday.setDinnerCal(sdinnerCalories);
                dataSunday.setCreatedAt(currentDate);
                database.sundayDAO().insert(dataSunday);
                System.out.println("Inserting sunday...");
                break;
            default:
                System.out.println("Poszedl default");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
