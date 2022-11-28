package com.example.ex20221124

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// : Kotlin에서 상속
class ConstraintActivity : AppCompatActivity() {
    // OnCreate()는 Activity가 실행될 때
    // 최초 딱 한 번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기

    // 전역변수(뷰)로 만들기
    lateinit var tvResult: TextView
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    // 뷰에 대해서는 선언만 하는 거는 불가능 초기화가 꼭 이루어져야 한다
    // 그런데 lateinit이라는 키워드로 나중에 꼭 초기화를 하겠다
    // 라는 약속을 할 수 있다!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml이랑 ktclass랑 연결하는 코드
        // 없으면 화면 안 뜸
        setContentView(R.layout.activity_constraint)

        // 1. xml의 View에 id를 지정
        // 2. id값을 이용해서 view를 찾아온다 (findViewById)
        tvResult = findViewById<TextView>(R.id.tvResult)
        // val tvResult = findViewById<TextView>(R.id.tvResult)
        // val tvResult:TextView = findViewById<TextView>(R.id.tvResult)
        // id값은 문자열로 정해줬는데 받아오는 값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id값이 저장이 되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다 (Int)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        etNum1 = findViewById<EditText>(R.id.etNum1)
        etNum2 = findViewById<EditText>(R.id.etNum2)

        // ** setContentView 위로 find할 수 없다!!
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor(Color.parseColor("#ff9999"))

        // textSize에는 Float자료형이 들어가야 한다! (f: 형변환)
        tvResult.textSize = 40.0f
        //s et도 되고 get도 됨

        tvResult.text = "안녕하세요!"
        // CharSequence 인터페이스 -
        // string은 CharSequence 인터페이스 상속받는 중

        // - 더하기 버튼을 눌렀을 때 "더하기 버튼이 눌렸습니다" 라는
        // Toast를 띄워 주자!
        // 이벤트를 주는 방법
        // 1) 이벤트 메소드 설계 후 뷰에 연결하기
        // 2) innerClass (Listener OnClick 구현)

//        btnPlus.setOnClickListener {
//            val num1 = etNum1.text.toString().toInt()
//            val num2 = etNum2.text.toString().toInt()
//            tvResult.text = "연산결과 : " + (num1+num2).toString()
//        }

        btnMinus.setOnClickListener {
            // {}안에다가 기능 구현만 하면 됨 !
            // 버튼을 눌렀을 때 "마이너스 버튼이 눌렸습니다" 토스트 띄우기
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            tvResult.text = "연산 결과 : ${num1-num2}"

            Toast.makeText(this, "빼기 버튼이 눌렸습니다.",
            Toast.LENGTH_SHORT).show()

            // 1. EditText에 적혀있는 내용 가져오기
            // etNum1, etNum2에 있는 내용 변수 num1, num2에 저장
            // 실제로 getText --> Editable ---> 문자열로 형변환 ---> 정수형
            // 2. num1, num2 연산 결과를 tvResult에 set해주세요!
            // : num1, num2 연산결과를 문자열로 바꿔서 set해주세요

        }

        btnMul.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            tvResult.text = "연산 결과 : ${num1*num2}"
        }

        btnDiv.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            tvResult.text = "연산 결과 : ${num1/num2}"
        }

        // 3) interface를 상속받게 만들어서 OnClick 구현

    }// oncreate 밖

    // 이벤트 리스너는 무조건 View 매개변수를 가지고 있어야한다.
    fun myClick(view: View){
        // Toast 띄우기!
        // 1) this , ConstraintActivity.this : Toast를 띄울 화면 정보
        // 2) 문구 (무조건 String, Int가 허용되는 경우는 id값만)
        // 3) Toast에 Short(3초), Long(5초) 속성 사용 : 지속시간
        Toast.makeText(this,"더하기 버튼이 눌렸습니다",
            Toast.LENGTH_SHORT).show()

        var num1 = etNum1.text.toString().toInt()
        // Emulator를 처음 실행시키면 EditText에는 아무 값도 없음
        // "".toInt() NumberFormatException
        // 버튼을 눌렀을 때 적혀있는 값을 가지고 와줘야 함 !!!
        var num2 = etNum2.text.toString().toInt()
        var result = num1 + num2
        tvResult.text = "연산 결과 : $result"

    }



}