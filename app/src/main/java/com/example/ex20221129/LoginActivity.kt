package com.example.ex20221129

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etId = findViewById<EditText>(R.id.etId)
        val etPw = findViewById<EditText>(R.id.etPw)

        btnLogin.setOnClickListener {
            // EditText에 적혀있는 내용을 가져온다 (변수에 저장)
            val id = etId.text.toString()
            val pw = etPw.text.toString()

            val intent = Intent()

//            intent.putExtra("content","로그인 성공")
//            setResult(RESULT_OK, intent)
            // id, pw가 test, 1234인지 확인(판단)

            if(id=="test"&&pw=="1234"){
                setResult(RESULT_OK, intent)}
            else{
                setResult(RESULT_CANCELED, intent)
            }

            finish()
        }
    }
}