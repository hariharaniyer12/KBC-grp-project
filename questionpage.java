package com.example.javaproject;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView question, optiona, optionb, optionc, optiond, money;
    RadioGroup radioGroup;
    RadioButton A, B, C, D;
    String[] questions = {"Where was the first Constituent Assembly held ?", "Which planet looks reddish in the night sky ?", "Which bank is the banker of the banks ?", "'Gobar gas' contains mainly which gas ?", "Which is the biggest lake in india ?", "With which does the power to extend or restrict the jurisdiction of the High Court rest?", "Who said “I therefore want freedom immediately, this very night, before dawn if it can be had”?", "A temperature at which both the Fahrenheit and the centigrade scales have the same value?", "Which of the following is the capital of Arunachal Pradesh?", "‘Gobar gas’ contains mainly which gas?", "First Indian Army Mountaineering Expedition held in which Mountain?", "Recently, N.K. Singh launched the book Indian Fiscal Federalism", "Recently, N.K. Singh launched the book \"Indian Fiscal Federalism\". Who is the author of the book?", "Tashigang becomes the highest polling station in the world. It belongs to which Indian state?", "Who has been conferred with the prestigious Bodley Medal by the University of Oxford's world-famous Bodleian Libraries?", "How many members were newly-appointed for anti-corruption ombudsman Lokpal?"};
    char[] answers = {'B', 'D', 'C', 'A', 'B', 'A', 'A', 'C', 'B', 'D', 'C', 'B', 'D', 'C', 'B'};
    String[] Optiona = {"LUCKNOW", "JUPITER", "SBI", "METHANE", "GANGA", "With the Parliament", "Mahatma Gandhi", "10 degree", "Dispur", "Silicon", "Mt Kamet", "Viral Acharya", "Karnataka", "Joseph Stiglitz", "6"};
    String[] Optionb = {"DELHI", "SUN", "BOB", "NITROGEN", "CHILKA LAKE", "With the Legislative", "Jawahar Lal Nehru", "20 degree", "Itanagar", "Hydrogen", "Mt Kangchenjunga", "Yaga Venugopal Reddy", "Arunachal Pradesh", "Jean-Paul Fitoussi", "8"};
    String[] Optionc = {"KANPUR", "VENUS", "RBI", "OXYGEN", "NILE", "With the Council of Minister", "Ravindra Nath Tagore", "-40 degree", "Imphal", "Oxygen", "Mt Makalu", "Bimal Jalan", "Haryana", "Amartya Sen", "4"};
    String[] Optiond = {"BANARAS", "MARS", "CBI", "HYDROGEN", "TAPU", "With the Rajya Sabha", "Bal Gangadhar Tilak", "40 degree", "Panaji", "Methane", "Mt Nanda Devi", "Arvind Subramanian", "Himachal Pradesh", "Martha Nussbaum", "7"};
    String[] moneyarr = {"1,000", "2,000", "3,000", "5,000", "10,000", "20,000", "40,000", "80,000", "1,60,000", "3,20,000", "6,40,000", "12,50,000", "25,00,000", "50,00,000", "1 crore"};
    byte track=0,chp=0;
    int clicked = 0;
    String[] checkpoint={"0","3,000","40,000","6,40,000"};
    boolean llch = false, llff = false, llcg = false,llcg2=false;
    char checkanswer;
    String finalpricewon="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.RadioGroup);
        A = findViewById(R.id.radioButton);
        B = findViewById(R.id.radioButton2);
        C = findViewById(R.id.radioButton3);
        D = findViewById(R.id.radioButton4);
        optiona = findViewById(R.id.textView4);
        optionb = findViewById(R.id.textView6);
        optionc = findViewById(R.id.textView3);
        optiond = findViewById(R.id.textView2);
        question = findViewById(R.id.textView);
        money = findViewById(R.id.textView7);
        question.setText(questions[track]);
        optiona.setText(Optiona[track]);
        optionb.setText(Optionb[track]);
        optionc.setText(Optionc[track]);
        optiond.setText(Optiond[track]);
        money.setText(moneyarr[track]);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton: {
                        checkanswer = 'A';
                    }
                    break;
                    case R.id.radioButton2: {
                        checkanswer = 'B';
                    }
                    break;
                    case R.id.radioButton3: {
                        checkanswer = 'C';
                    }
                    break;
                    case R.id.radioButton4: {
                        checkanswer = 'D';
                    }
                    break;
                }
            }
        });
    }

    void nextquestion() {
        track++;
        question.setText(questions[track]);
        optiona.setText(Optiona[track]);
        optionb.setText(Optionb[track]);
        optionc.setText(Optionc[track]);
        optiond.setText(Optiond[track]);
        money.setText(moneyarr[track]);
        if(track==3 || track==7 || track==11){
            chp++;
        }
    }

    public void submitans(View view){
        if (answers[track] == checkanswer) {
            if(track==answers.length-1){
                finalpricewon=moneyarr[track];
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                intent.putExtra("finalmoney",finalpricewon);
                startActivity(intent);
            }
            nextquestion();
            if(llcg==true){
                llcg2=true;
            }
        }
        else {
            finalpricewon=checkpoint[chp];
            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
            intent.putExtra("finalmoney",finalpricewon);
            startActivity(intent);
        }
    }

    public void leave(View view){
        finalpricewon = moneyarr[track - 1];
        Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
        intent.putExtra("finalmoney",finalpricewon);
        startActivity(intent);
    }

    public void fiftyfifty(View view){
        if (!llff) {
            int opt1, opt2, ca = 0;
            if (answers[track] == 'A') {
                ca = 1;
            }
            else if (answers[track] == 'B') {
                ca = 2;
            }
            else if (answers[track] == 'C') {
                ca = 3;
            }
            else {
                ca = 4;
            }
            Random random = new Random();
            do {
                opt1 = 1 + random.nextInt(4);
                if(opt1!=ca){
                    break;
                }
            } while (!llff);
            do {
                opt2 = 1 + random.nextInt(4);
                if(opt2!=ca && opt2!=opt1){
                    break;
                }
            } while (!llff);

            if (opt1 == 1 || opt2 == 1) {
                String temp = "Wrong option";
                optiona.setText(temp);
            }
            if (opt1 == 2 || opt2 == 2) {
                String temp = "Wrong option";
                optionb.setText(temp);
            }
            if (opt1 == 3 || opt2 == 3) {
                String temp = "Wrong option";
                optionc.setText(temp);
            }
            if (opt1 == 4 || opt2 ==4) {
                String temp = "Wrong option";
                optiond.setText(temp);
            }
            llff = true;
        } else {
            Toast.makeText(this, "This lifeline has been used", Toast.LENGTH_SHORT).show();
        }
    }

    public void Check(View view){
        if (!llch) {
            if (answers[track] == checkanswer ) {
                Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
            }
            llch = true;
        } else {
            Toast.makeText(this, "This lifeline has been used", Toast.LENGTH_SHORT).show();
        }
    }

    public void Change(View view){

        char cq='m';
        if(!llcg2) {
            if (clicked % 2 == 0) {
                String q = "Which of the following became the first Indian port operator to record 200 million tonnes cargo movement in 2018-19?";
                String opta = "Mundra Port";
                String optb = "Paradip Port";
                String optc = "Mercator Limited";
                String optd = "Adani Ports and Special Economic Zone";
                question.setText(q);
                optiona.setText(opta);
                optionb.setText(optb);
                optionc.setText(optc);
                optiond.setText(optd);
                cq = answers[track];
                answers[track] = 'D';
                llcg = true;
                clicked++;
            } else {
                question.setText(questions[track]);
                optiona.setText(Optiona[track]);
                optionb.setText(Optionb[track]);
                optionc.setText(Optionc[track]);
                optiond.setText(Optiond[track]);
                answers[track] = cq;
                clicked++;
            }
        }
        else{
            Toast.makeText(this, "This lifeline has been used", Toast.LENGTH_SHORT).show();
        }

    }

}
