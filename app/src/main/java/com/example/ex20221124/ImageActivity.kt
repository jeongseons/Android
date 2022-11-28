package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {

    val imgArray = intArrayOf(R.drawable.pink, R.drawable.blue,
        R.drawable.black, R.drawable.yellow,R.drawable.red)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // View의 id값 다 찾아오기
        val img = findViewById<ImageView>(R.id.img)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)

//        img.setImageResource(R.drawable.pink)

        // 1. Pre버튼을 눌렀을 때! (setOnClickListner)
        // 1-1. index -1 감소
        // 해당 index에 있는 img의 id를 가져와서 imageView에 set
        // index의 조건 : 0보다 작으면 다시 index값을 size-1으로 돌리기

        // 2. Next버튼을 눌렀을 때
        // 2-1. index +1 증가
        // 해당 index에 있는 img의 id를 가져와서 imageView를 set
        // index의 조건 : size-1보다 크면 다시 index값을 0으로

        var index = 0
        img.setImageResource(imgArray[index])

//        btnPre.setOnClickListener {
//           if(index>0) {
//               index--
//           }else{
//               index = imgArray.size - 1
//           }
//            img.setImageResource(imgArray[index])
//        }
//
//        btnNext.setOnClickListener {
//            if(index< imgArray.size - 1 ) {
//                index++
//            }else{
//                index = 0
//            }
//            img.setImageResource(imgArray[index])
//        }


        btnPre.setOnClickListener {
            index--
            if(index<0) index = imgArray.size - 1
            img.setImageResource(imgArray[index])
        }

        btnNext.setOnClickListener {
            index++
            if(index> imgArray.size - 1 ) index = 0
            img.setImageResource(imgArray[index])
        }

        btnNext.setOnClickListener {  }
        btnNext.setOnClickListener(View.OnClickListener{

        })

    }
}