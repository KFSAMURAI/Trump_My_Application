package com.example.trumpmyapplication

class Deck {

    val cardImageIds =  arrayOf(R.drawable.c01, R.drawable.c02, R.drawable.c03,
        R.drawable.c04, R.drawable.c05, R.drawable.c06, R.drawable.c07, R.drawable.c08,
        R.drawable.c09, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13,
        R.drawable.d01, R.drawable.d02, R.drawable.d03,
        R.drawable.d04, R.drawable.d05, R.drawable.d06, R.drawable.d07, R.drawable.d08,
        R.drawable.d09, R.drawable.d10, R.drawable.d11, R.drawable.d12, R.drawable.d13,
        R.drawable.h01, R.drawable.h02, R.drawable.h03,
        R.drawable.h04, R.drawable.h05, R.drawable.h06, R.drawable.h07, R.drawable.h08,
        R.drawable.h09, R.drawable.h10, R.drawable.h11, R.drawable.h12, R.drawable.h13,
        R.drawable.s01, R.drawable.s02, R.drawable.s03,
        R.drawable.s04, R.drawable.s05, R.drawable.s06, R.drawable.s07, R.drawable.s08,
        R.drawable.s09, R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13
    )

    val roleList: List<String> = listOf("ノーハンド", "ワンペア", "ツーペア", "スリーカード", "ストレート", "フラッシュ", "フルハウス", "フォーカード", "ストレートフラッシュ", "ロイヤルフラッシュ");

    var deck: MutableList<Int> = mutableListOf();
    init {
        for(i in 0 until 52) {

            deck.add(i);

        }

        deck.shuffle();

    }



}