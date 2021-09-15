package com.none.wordcloud

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import com.none.wordcloud.databinding.ActivityMainBinding
import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
{
    var random =Random()
    var weight=30
    var off=2

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main_binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(main_binding.root)

        val editor_0=getSharedPreferences("excuse_data", Context.MODE_PRIVATE).edit()
//        从content中获取sharedpreference，且标记为只有该应用程序才可以对当前进行操作

        main_binding.button1.setOnClickListener(){
//          save
            val SDF=SimpleDateFormat()
            SDF.applyPattern("yyyyMMddHHmmss")
            val data=Date()
//            设置时间及其样例

            val inputtext=main_binding.textedit.text.toString()
            editor_0.putString(data.toString(),inputtext)
            editor_0.commit()
//            不要忘记提交！！！
            Toast.makeText(this,"saved:"+inputtext,Toast.LENGTH_SHORT).show()
        }

        main_binding.button2.setOnClickListener(){
            val intent=Intent(this,CloudMaker::class.java)
            startActivity(intent)
//            intent显式启动act
        }
        main_binding.button3.setOnClickListener(){
            editor_0.clear().commit()
        }


    }


}