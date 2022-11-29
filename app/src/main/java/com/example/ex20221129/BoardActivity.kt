package com.example.ex20221129

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class BoardActivity : AppCompatActivity() {

    // 초기화를 나중에 하겠습니다 : lateinit
    // 전역 View로 사용이 가능한 상태
    lateinit var tvContent : TextView
    lateinit var btnWrite : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        val btnLogin1 = findViewById<Button>(R.id.btnLogin1)
        btnWrite = findViewById<Button>(R.id.btnWrite)
        tvContent = findViewById<TextView>(R.id.tvContent)

        val lv = findViewById<ListView>(R.id.lv)

        // 1. 로그인 버튼을 누르면 LoginActivity로 이동
        // ( 단, LoginActivity에서 받아올 결과 값이 있음 양방향)
        btnLogin1.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            //양방향 통신
            result.launch(intent)
        }

        lv.setOnItemClickListener { adapterView, view, i, l ->
            // adapterView : ListView에 대한 정보
            // view : ListView가 있는 현재 페이지에 대한 정보
            // i (position) -> 내가 클릭한 item위치 (index 0~
            // l (id) : long -> 내가 클릭한 item의 고유한 값
            //parent.adapter.getItem(position)
            if(i==0){
                Toast.makeText(this, adapterView.adapter.getItem(i).toString(),Toast.LENGTH_SHORT).show()
            }

        }

    }
    // intent 데이터 받아주는 콜백함수 생성
    val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        // it : resultCode, Intent
        // resultCode 상태를 확인하자 ok, canceled
        if (it.resultCode == RESULT_OK){
            tvContent.text = "로그인 성공"
            btnWrite.isEnabled = true
        }else{
            tvContent.text = "로그인 실패"
            btnWrite.isEnabled = false
        }


    }
}