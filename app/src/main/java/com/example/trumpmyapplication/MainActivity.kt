package com.example.trumpmyapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trumpmyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    var handInit = Hand();
    var checkLimit = 3;
    var koukanLimit = 2;
    var checkCount = 0;
    var koukanCount = 0;

    var koukanCards: MutableList<Int> = mutableListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);
        binding.role.text = "ポーカー";
        binding.roleMid.text = "ポーカー";

        binding.koukan.isEnabled = false;
        binding.kakutei.isEnabled = false;
        CheckboxEnabledSwitch(false);


        binding.kubaru.setOnClickListener {
            binding.result.text = "判定...";
            binding.role.text = "...";
            binding.roleMid.text = "...";
            koukanCount = 0;
            binding.kakutei.isEnabled = true;
            CheckboxEnabledSwitch(true);

            val hand = handInit.Kubaru();
            binding.card1.setImageResource(hand[0]);
            binding.card2.setImageResource(hand[1]);
            binding.card3.setImageResource(hand[2]);
            binding.card4.setImageResource(hand[3]);
            binding.card5.setImageResource(hand[4]);
            binding.cardMid1.setImageResource(R.drawable.z02);
            binding.cardMid2.setImageResource(R.drawable.z02);
            binding.cardMid3.setImageResource(R.drawable.z02);
            binding.cardMid4.setImageResource(R.drawable.z02);
            binding.cardMid5.setImageResource(R.drawable.z02);

        }

        binding.koukan.setOnClickListener {
            koukanCards.clear();
            if(binding.checkBox1.isChecked) {

                koukanCards.add(0);
            }
            if(binding.checkBox2.isChecked) {
                koukanCards.add(1);
            }
            if(binding.checkBox3.isChecked) {
                koukanCards.add(2);
            }
            if(binding.checkBox4.isChecked) {
                koukanCards.add(3);
            }
            if(binding.checkBox5.isChecked) {
                koukanCards.add(4);
            }

            val handKouKan: MutableList<Int> = handInit.Koukan(koukanCards);

            for(i in 0 until koukanCards.count()) {
                when {
                    koukanCards[i] == 0 -> binding.card1.setImageResource(handKouKan[0]);
                    koukanCards[i] == 1 -> binding.card2.setImageResource(handKouKan[0]);
                    koukanCards[i] == 2 -> binding.card3.setImageResource(handKouKan[0]);
                    koukanCards[i] == 3 -> binding.card4.setImageResource(handKouKan[0]);
                    koukanCards[i] == 4 -> binding.card5.setImageResource(handKouKan[0]);
                }
                handKouKan.removeAt(0);
            }

            CheckboxCheckedSwitch(false);
            koukanCount++;

            if(koukanCount >= koukanLimit) {
                CheckboxEnabledSwitch(false);
                binding.koukan.isEnabled = false;
            }

        }

        binding.kakutei.setOnClickListener {
            binding.role.text = handInit.Kakutei();
            binding.kakutei.isEnabled = false;
            binding.koukan.isEnabled = false;
            CheckboxCheckedSwitch(false);
            CheckboxEnabledSwitch(false);

            var handMid = handInit.Kubaru(true);
            binding.cardMid1.setImageResource(handMid[0]);
            binding.cardMid2.setImageResource(handMid[1]);
            binding.cardMid3.setImageResource(handMid[2]);
            binding.cardMid4.setImageResource(handMid[3]);
            binding.cardMid5.setImageResource(handMid[4]);
            binding.roleMid.text = handInit.Kakutei(true);
            ResultMgr();
        }

        binding.checkBox1.setOnCheckedChangeListener {
                buttonView, isChecked ->
            KoukanCheck(isChecked);
        }

        binding.checkBox2.setOnCheckedChangeListener {
                buttonView, isChecked ->

            KoukanCheck(isChecked);
        }

        binding.checkBox3.setOnCheckedChangeListener {
                buttonView, isChecked ->

            KoukanCheck(isChecked);
        }

        binding.checkBox4.setOnCheckedChangeListener {
                buttonView, isChecked ->

            KoukanCheck(isChecked);
        }

        binding.checkBox5.setOnCheckedChangeListener {
                buttonView, isChecked ->
            KoukanCheck(isChecked);

        }


    }

    fun KoukanCheck(isChecked: Boolean) {
        if(isChecked) {
            checkCount += 1;
        } else if(!isChecked) {
            checkCount -= 1;
        }

        binding.koukan.isEnabled = checkCount != 0

        binding.koukan.isEnabled = checkCount <= checkLimit && checkCount != 0
    }

    fun ResultMgr() {
        val result = handInit.Result();
        binding.result.text = result;
        when(result) {
            "勝利" -> binding.result.setTextColor(Color.RED);
            "敗北" -> binding.result.setTextColor(Color.BLUE);
            "引き分け" -> binding.result.setTextColor(Color.GREEN);
        }
    }

    fun CheckboxEnabledSwitch(isEnabled: Boolean) {
        binding.checkBox1.isEnabled = isEnabled;
        binding.checkBox2.isEnabled = isEnabled;
        binding.checkBox3.isEnabled = isEnabled;
        binding.checkBox4.isEnabled = isEnabled;
        binding.checkBox5.isEnabled = isEnabled;
    }

    fun CheckboxCheckedSwitch(isChecked: Boolean) {
        binding.checkBox1.isChecked = isChecked;
        binding.checkBox2.isChecked = isChecked;
        binding.checkBox3.isChecked = isChecked;
        binding.checkBox4.isChecked = isChecked;
        binding.checkBox5.isChecked = isChecked;
    }






}