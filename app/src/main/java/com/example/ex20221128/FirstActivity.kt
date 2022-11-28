package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView

class FirstActivity : AppCompatActivity() {

    var color : String = "white"
    // 배경 색상을 저장해 Second Acitivity로 보내자!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

//        val btnNext = findViewById<Button>(R.id.btnNext)

        // btnNext를 클릭했을 때, SecondActivity로 이동
//        btnNext.setOnClickListener {
//            // Activity로 이동하는 Intent(명시적 인텐트)
//            // (시작Activity, 도착Activity)
//            // (this, java class)
//            // Kclass로 만들어진 Activity를 java class로 바꿔줘야 한다
//            // 액티비티명::class.java
//           var intent = Intent(this,
//               SecondActivity::class.java)
//
//            //실행
//            startActivity(intent)
//        }


        // Android 4대 구성요소
        // Activity 화면을 구성
        // Service (Background에서 동작) Activity에서 화면만 뺀 거
        // BR(Broadcast Receiver)
        // CP(Content Provider)
        // 카카오톡에서 다른 사람에게 연락처를 전송하고자 할 때
        // 연락처 어플리케이션에서 연락처 정보를 카톡으로 넘김

        // 4대 구성요소간 정보를 매개하는
        // Intent

        // 명시적, 묵시적
        // explicit, implicit

        val btnNext = findViewById<Button>(R.id.btnNext)

        val lv = findViewById<ListView>(R.id.lv)

        lv.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // p2 : position
                // p3 : id

                // 너, p0가 null이면 어떡할래?
                if(p0 != null){
                    color = p0.adapter.getItem(p2).toString()
                }

                Log.d("찍어보자", color)
            }
        })

        // inner class
        // 익명 클래스 anonymous
//        btnNext.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                TODO("Not yet implemented")
//            }
//        })
//        // ↑ 이게 원형
//        btnNext.setOnClickListener { v-> }
        // 람다식으로 축약해도 가능

        // 버튼 클릭을 감지하는 리스너를 장착
        // setOnClickListener

        // btnNext를 누르면 SecondActivity로 color코드를 가지고 넘어간다
        btnNext.setOnClickListener {
            var intent = Intent(this@FirstActivity,
                SecondActivity::class.java)
            intent.putExtra("color",color)
            // 단방향 호출 - second에서 끝나는 형태로 되어있음
            startActivity(intent)
        }
    }

    // Ctrl + o (overriding)
    // 혹은 마우스 우클릭 + generate-> override methods
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("생명주기", "onStart입니다")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("생명주기", "onStop입니다")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("생명주기", "onResume입니다")
//
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("생명주기", "onPause입니다")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("생명주기", "onRestart입니다")
//    }


}