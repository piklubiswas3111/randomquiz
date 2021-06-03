package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ExemModal> allqurstion;
    private TextView Qurstion, A, B, C, D, total;
    private CardView OptionA, OptionB, OptionC, OptionD;
    private ImageView imageView;
    private Button fast, last;
    private int i, counter, Score, Check, qurtionumb = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casting();
        allqurtionanget();
        function();

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atextclick();


            }
        });
        OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btextclick();


            }
        });
        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctextclick();


            }
        });
        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dtextclick();


            }
        });
        total.setText(1 + "/" + 10);


        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Check == 1) {
                    qurtionumb++;
                    imageView.setImageResource(0);
                    increment();
                    function();
                    total.setText(String.valueOf(qurtionumb + "/" + 10));
                    if (counter == 10) {
                        last.setText("Finish");
                    } else if (counter == 11) {
                        finish();
                        if (Score >= 6) {
                            Intent intent = new Intent(MainActivity.this, EResult.class);
                            intent.putExtra("SCore", String.valueOf(Score));
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                        }
                    }
                    Check = 0;

                } else {
                    Toast.makeText(getApplicationContext(), "Please Select any option", Toast.LENGTH_LONG).show();
                }

            }
        });

        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });


    }

    private void increment() {
        i = (i + 1) % allqurstion.size();
    }

    private void dtextclick() {
        Check++;
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        if (D.getText().toString().equals(allqurstion.get(i).getAns())) {
            Score++;
        }
        Disable();
    }

    private void ctextclick() {
        Check++;
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        if (C.getText().toString().equals(allqurstion.get(i).getAns())) {
            Score++;
        }
        Disable();
    }

    private void btextclick() {
        Check++;
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        if (B.getText().toString().equals(allqurstion.get(i).getAns())) {
            Score++;
        }
        Disable();
    }

    private void atextclick() {
        Check++;
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        if (A.getText().toString().equals(allqurstion.get(i).getAns())) {
            Score++;
        }
        Disable();
    }


    public void function() {

        enable();
        counter++;
        Collections.shuffle(allqurstion);
        Qurstion.setText(allqurstion.get(i).getQurtion());
        A.setText(allqurstion.get(i).getA());
        B.setText(allqurstion.get(i).getB());
        C.setText(allqurstion.get(i).getC());
        D.setText(allqurstion.get(i).getD());
        try {
            imageView.setImageResource(allqurstion.get(i).getImag());
        } catch (Exception e) {
        }
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));


//
    }

    private void casting() {
        OptionA = (CardView) findViewById(R.id.opationA);
        OptionB = (CardView) findViewById(R.id.opationB);
        OptionC = (CardView) findViewById(R.id.opationC);
        OptionD = (CardView) findViewById(R.id.opationD);

        Qurstion = (TextView) findViewById(R.id.qurtion);
        A = (TextView) findViewById(R.id.A);
        B = (TextView) findViewById(R.id.B);
        C = (TextView) findViewById(R.id.C);
        D = (TextView) findViewById(R.id.D);
        imageView = (ImageView) findViewById(R.id.imq);
        total = (TextView) findViewById(R.id.total);

        fast = (Button) findViewById(R.id.Previous);
        last = (Button) findViewById(R.id.next);


    }

    private void enable() {
        OptionA.setClickable(true);
        OptionB.setClickable(true);
        OptionC.setClickable(true);
        OptionD.setClickable(true);
    }

    private void Disable() {
        OptionA.setClickable(false);
        OptionB.setClickable(false);
        OptionC.setClickable(false);
        OptionD.setClickable(false);
    }

    private void allqurtionanget() {
        allqurstion = new ArrayList<>();
        ExemModal Q1 = new ExemModal();
        Q1.setQurtion("উল্লিখিত গাড়ির ক্ষেত্রে , রাস্তা করে দিতে হবে");
        Q1.setA("1 দ্রুত,অতিদ্রুত গামী বাস");
        Q1.setB("2 পুলিশের গাড়ি");
        Q1.setC("3 যেকোনো গাড়ির ক্ষেত্রে");
        Q1.setD("4 আপদকালীন সংকেত যুক্ত গাড়ি");
        Q1.setAns("4 আপদকালীন সংকেত যুক্ত গাড়ি");
        allqurstion.add(Q1);

        ExemModal Q2 = new ExemModal();
        Q2.setQurtion("নিচের চিহ্নটির মানে হচ্ছে");
        Q2.setA("1 গাড়ী পার্ক করে রাখা যাবেনা");
        Q2.setB("2 সামনে হাসপাতাল");
        Q2.setC("3 থামুন");
        Q2.setD("4 চলুন");
        Q2.setImag(R.drawable.ic_launcher_background);
        Q2.setAns("3 থামুন");
        allqurstion.add(Q2);


        ExemModal Q3 = new ExemModal();
        Q3.setQurtion("ফুটপাথ বিহীন রাস্তায় পদচারীরা ");
        Q3.setA("1 রাস্তায় ডানদিক দিয়ে হাঁটবেন রাস্তার ");
        Q3.setB("2 যেকোনাে দিক দিয়েই হাটতে পারেন");
        Q3.setC("3 রাস্তায় বাদিক দিয়ে হাঁটবেন");
        Q3.setD("4 রাস্তায় হাঁটা বারণ");
        Q3.setAns("3 রাস্তায় বাদিক দিয়ে হাঁটবেন");
        allqurstion.add(Q3);

        ExemModal Q4 = new ExemModal();
        Q4.setQurtion("নিচের চিহ্নটির  মানে হচ্ছে");
        Q4.setA("1 ট্রাফিক আইন সামনে ");
        Q4.setB("2 রাস্তা দিন");
        Q4.setC("3 সামনে হাসপাতাল");
        Q4.setD("4 দ্রুত চালান");
        Q4.setImag(R.drawable.ic_launcher_foreground);
        Q4.setAns("2 রাস্তা দিন");
        allqurstion.add(Q4);

        ExemModal Q5 = new ExemModal();
        Q5.setQurtion("যখন পদচারীরা , পদচারীদের রাস্তা পারাপারের জন্য নির্দিষ্ট স্থানে অপেক্ষা করছেন , তখন আপনি");
        Q5.setA("1 হর্ন বাজান এবং এগিয়ে চলুন ");
        Q5.setB("2 গাড়ীর গতি কমান , হর্ন বাজান এবং পার হয়ে যান । ");
        Q5.setC("3 গাড়ী থামান , পদচারীরা রাস্তা পার হওয়া অবধি অপেক্ষা করুন এবং তারপরে এগােন");
        Q5.setD("4 গাড়ি আস্তে চালান");
        Q5.setAns("3 গাড়ী থামান , পদচারীরা রাস্তা পার হওয়া অবধি অপেক্ষা করুন এবং তারপরে এগােন");
        allqurstion.add(Q5);

        ExemModal Q6 = new ExemModal();
        Q6.setQurtion("আপনি একটি সংকীর্ণ সেতুর দিকে গাড়ী নিয়ে এগােচ্ছেন , অন্য একটি গাড়ী , উল্টোদিক থেকে সেতুতে ঢােকবার মুখে , তখন আপনি");
        Q6.setA("1 গাড়ীর গতি বাড়ান এবং যত দ্রুত সম্ভব সেতু পার হওয়ার চেষ্টা করুন ");
        Q6.setB("2 গাড়ীর হেড লাইট জালান এবং সেতু পার যান ");
        Q6.setC("3 অন্য গাড়িটি সেতু পার হয়ে আসা অবধি অপেক্ষা করুন এবং তারপর এগােন");
        Q6.setD("4 গাড়ীর গতি কমান , হর্ন বাজান এবং পার হয়ে যান ।");
        Q6.setAns("3 অন্য গাড়িটি সেতু পার হয়ে আসা অবধি অপেক্ষা করুন এবং তারপর এগােন");
        allqurstion.add(Q6);


        ExemModal Q7 = new ExemModal();
        Q7.setQurtion("নিচের চিহ্নটির  মানে হচ্ছে ");
        Q7.setA("1 বাঁ দিকে গাড়ী রাখুন ");
        Q7.setB("2 বাঁ দিকে কোনাে রাস্তা নেই");
        Q7.setC("3 বাধ্যতামুলক ভাবে গাড়ী বা দিকে ঘােরান");
        Q7.setD("4 থামুন");
        Q7.setImag(R.drawable.ic_launcher_foreground);
        Q7.setAns("3 বাধ্যতামুলক ভাবে গাড়ী বা দিকে ঘােরান");
        allqurstion.add(Q7);


        ExemModal Q8 = new ExemModal();
        Q8.setQurtion("যখন একটি গাড়ী দুরঘটনাগ্রস্থ হয়ে কোনাে মানুষ আহত হয়েছেন ");
        Q8.setA("1 গাড়ীটি সব থেকে কাছের থানায় নিয়ে গিয়ে দুর্ঘটনাটি জানান ");
        Q8.setB("2 গাড়ীটি চালানাে বন্ধ রাখুন এবং থানায় জানান ");
        Q8.setC("3 আহত মানুষ্টির চিকিতসার জন্য সকল প্রকার প্রয়ােজনিয় পদক্ষেপ নিন এবং ২৪ ঘন্টার মধ্যে সবচেয়ে কাছের থানায় জানান");
        Q8.setD("4 ওখান থেকে পালন");
        Q8.setAns("3 আহত মানুষ্টির চিকিতসার জন্য সকল প্রকার প্রয়ােজনিয় পদক্ষেপ নিন এবং ২৪ ঘন্টার মধ্যে সবচেয়ে কাছের থানায় জানান");
        allqurstion.add(Q8);

        ExemModal Q9 = new ExemModal();
        Q9.setQurtion("যে রাস্তা এক্সখি যান চলাচলের জন্য নির্দিষ্ট ");
        Q9.setA("1 গাড়ী পার্কিং নিষিদ্ধ ");
        Q9.setB("2 সামনের গাড়ীকে অতিক্রম করা ( ওভারটেক ) নিষিদ্ধ ");
        Q9.setC("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        Q9.setD("4 দ্রুত চালানর জন্য");
        Q9.setAns("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        allqurstion.add(Q9);

        ExemModal Q10 = new ExemModal();
        Q10.setQurtion("আপনি সামনের গাড়ীটিকে অতিক্রম এ করতে পারেন ");
        Q10.setA("1 ঐ গাড়ীটির ডানদিক দিয়ে");
        Q10.setB("2 ঐ গাড়ীটির বাঁ দিক দিয়ে ");
        Q10.setC("3 যদি রাস্তা চওড়া থাকে , তবে বাঁ দিক দিয়ে");
        Q10.setD("4 ওখান থেকে পালন");
        Q10.setAns("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        allqurstion.add(Q10);

        ExemModal Q11 = new ExemModal();
        Q11.setQurtion("যে রাস্তা এক্সখি যান চলাচলের জন্য নির্দিষ্ট ");
        Q11.setA("1 গাড়ী পার্কিং নিষিদ্ধ ");
        Q11.setB("2 সামনের গাড়ীকে অতিক্রম করা ( ওভারটেক ) নিষিদ্ধ ");
        Q11.setC("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        Q11.setD("4 দ্রুত চালানর জন্য");
        Q11.setAns("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        allqurstion.add(Q11);

        ExemModal Q12 = new ExemModal();
        Q12.setQurtion("যে রাস্তা এক্সখি যান চলাচলের জন্য নির্দিষ্ট ");
        Q12.setA("1 গাড়ী পার্কিং নিষিদ্ধ ");
        Q12.setB("2 সামনের গাড়ীকে অতিক্রম করা ( ওভারটেক ) নিষিদ্ধ ");
        Q12.setC("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        Q12.setD("4 দ্রুত চালানর জন্য");
        Q12.setAns("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        allqurstion.add(Q12);

        ExemModal Q13 = new ExemModal();
        Q13.setQurtion("যে রাস্তা এক্সখি যান চলাচলের জন্য নির্দিষ্ট ");
        Q13.setA("1 গাড়ী পার্কিং নিষিদ্ধ ");
        Q13.setB("2 সামনের গাড়ীকে অতিক্রম করা ( ওভারটেক ) নিষিদ্ধ ");
        Q13.setC("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        Q13.setD("4 দ্রুত চালানর জন্য");
        Q13.setAns("3 রিভার্স বা ব্যক গিয়ারে গাড়ী চালানাে যাবেনা");
        allqurstion.add(Q13);

    }
}