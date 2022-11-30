package com.example.ex20221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var phoneList = ArrayList<PhoneVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.lv)
        // 1. 화면에서 ListView의 위치 정해주기 (xml파일)
        // 2. ListView 한 칸에 들어갈 디자인 정해주기 (xml 파일)
        // 3. ListView에 들어갈 데이터 만들기 -> 하나의 자료형 (PhoneVO)
        // 이미지뷰에 들어갈 Image의 ID값 (Int)
        // 이름, 전화번호 (String)
        val p1 = PhoneVO(R.drawable.yejin, "강예진","010-1234-5678")
        val p2 = PhoneVO(R.drawable.ho,"나예호","010-1234-5678")
        val p3 = PhoneVO(R.drawable.zero,"선영표","010-1234-5678")
        val p4 = PhoneVO(R.drawable.nature,"조자연","010-1234-5678")
        val p5 = PhoneVO(R.drawable.sumin,"채수민","010-1234-5678")

        phoneList.add(p1)
        // phoneList.add(PhoneVO(R.drawable.yejin, "강예진","010-1234-5678"))
        // 보통은 이렇게 따로 메모리 할당해주지 않고 바로 add로 넣음
        phoneList.add(p2)
        phoneList.add(p3)
        phoneList.add(p4)
        phoneList.add(p5)

        // ~여기까지 준비과정~

        // 4. Adapter View 만들기
        // 데이터의 자료형이 내가 만든 자료형(VO)이기 때문에
        // 안드로이드에서 기본적으로 제공하는 ArrayAdapter는 사용불가능
        // Adapter : 데이터랑 템프릿을 합쳐서 ListView에 적재시켜주는 역할
        val adapter = PhoneAdapter(applicationContext, R.layout.phone_list, phoneList)
        // 5. ListView에 Adapter 적용
        lv.adapter = adapter
        // 6. 이벤트 달아주기


    }
}