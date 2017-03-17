package com.mauriciotogneri.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.mauriciotogneri.uibinder.UiBinder;
import com.mauriciotogneri.uibinder.annotations.BindView;
import com.mauriciotogneri.uibinder.annotations.OnCheckedChanged;
import com.mauriciotogneri.uibinder.annotations.OnClick;
import com.mauriciotogneri.uibinder.annotations.OnItemClick;
import com.mauriciotogneri.uibinder.annotations.OnItemLongClick;
import com.mauriciotogneri.uibinder.annotations.OnItemSelected;
import com.mauriciotogneri.uibinder.annotations.OnLongClick;
import com.mauriciotogneri.uibinder.annotations.OnTextChanged;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private final UiBinder uiBinder = new UiBinder();

    @BindView(R.id.edit_test)
    public EditText editText;

    @BindView(R.id.button_test)
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add("Summer");
        spinnerItems.add("Autumn");
        spinnerItems.add("Winter");
        spinnerItems.add("Spring");

        Spinner spinner = (Spinner) findViewById(R.id.spinner_test);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        List<String> listViewItems = new ArrayList<>();
        listViewItems.add("January");
        listViewItems.add("February");
        listViewItems.add("March");
        listViewItems.add("April");
        listViewItems.add("May");
        listViewItems.add("June");
        listViewItems.add("July");
        listViewItems.add("August");
        listViewItems.add("September");
        listViewItems.add("October");
        listViewItems.add("November");
        listViewItems.add("December");

        ListView listview = (ListView) findViewById(R.id.listview_test);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listViewItems);
        listview.setAdapter(listViewAdapter);

        uiBinder.bind(this);
    }

    @OnClick(R.id.button_test)
    public void onClickButton()
    {
        Toast.makeText(this, String.format("It says: %s!", editText.getText().toString()), Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button_test)
    public void onLongClickButton()
    {
        Toast.makeText(this, "Long click in a button!", Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(R.id.edit_test)
    public void onTextChanged(String newText)
    {
        Toast.makeText(this, newText, Toast.LENGTH_SHORT).show();

        button.setEnabled(!newText.isEmpty());
    }

    @OnCheckedChanged(R.id.checkbox_test)
    public void onCheckboxChanged(boolean checked)
    {
        Toast.makeText(this, String.format("Checked: %s", checked), Toast.LENGTH_SHORT).show();
    }

    @OnItemSelected(R.id.spinner_test)
    public void onItemSelected(String item)
    {
        Toast.makeText(this, String.format("Selected: %s", item), Toast.LENGTH_SHORT).show();
    }

    @OnItemClick(R.id.listview_test)
    public void onItemClick(String item)
    {
        Toast.makeText(this, String.format("Item click: %s", item), Toast.LENGTH_SHORT).show();
    }

    @OnItemLongClick(R.id.listview_test)
    public void onItemLongClick(String item)
    {
        Toast.makeText(this, String.format("Item long click: %s", item), Toast.LENGTH_SHORT).show();
    }
}