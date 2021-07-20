package com.example.trumpmyapplication

class RoleMgr(var cards: List<Card>) {

    private var nums: MutableList<Int> = mutableListOf(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    private var marks: MutableList<Int> = mutableListOf(-1, 0, 0, 0, 0);

    init {
        SetCard();
    }

    private fun SetCard() {
        cards.forEach {
            nums[it.num] += 1;
            marks[it.mark] += 1;

        }
    }

    fun Role(): String{
        var _M: Int = 0;
        var _S: Int = 0;
        var _P: Int = 0;

        _M = FindMaxByList(marks);
        _S = FindMaxByList(nums);

        var tempIndex: Int = nums.indexOf(_S);
        nums[tempIndex] = -1;
        _P = FindMaxByList(nums);
        nums[tempIndex] = _S;

        if(_M == 5 && _S == 1 && FindStraightByList(nums) != "") {
            return FindStraightByList(nums) + "フラッシュ";

        }

        if(_S == 4) {
            return "フォーカード";
        }

        if(_S == 3 && _P == 2) {
            return "フルハウス";
        }

        if(_M == 5) {
            return "フラッシュ";
        }

        var straight: String = FindStraightByList(nums);
        if(_S == 1 && straight != "" && (straight == "ロイヤル" || straight == "ストレート")) {
            return "ストレート";
        }

        if(_S == 3 && _P == 1) {
            return "スリーカード";
        }

        if(_S == 2 && _P == 2) {
            return "ツーペア";
        }

        if(_S == 2 && _P == 1) {
            return "ワンペア";
        }




        return "ノーハンド";
    }

    private fun FindMaxByList(a: MutableList<Int>): Int {
        var max: Int = -1;
        a.forEach {
            if(it > max) {
                max = it;
            }
        }
        return max;

    }

    private fun FindStraightByList(a: MutableList<Int>): String {

        var straight: Int = 0;
        a.forEach {
            if(it > 1) {
                return "";
            }

            if(it == 1) {
                straight += 1;
            } else if(it != 1 && straight != 5) {
                straight = 0;
            }

        }


        if(a[10] == 1 && a[11] == 1 && a[12] == 1 && a[13] == 1 && a[1] == 1) {
            return "ロイヤル";
        } else if(straight == 5) {
            return "ストレート";
        }
        return "";
    }


}


class Card {
    var mark: Int = 0;
    var num: Int = 0;
}

