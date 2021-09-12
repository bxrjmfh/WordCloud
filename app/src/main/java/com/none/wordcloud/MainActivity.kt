package com.none.wordcloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.none.wordcloud.databinding.ActivityMainBinding
import java.lang.System.currentTimeMillis
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

        val binding_main=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_main.root)
        val wordcloudview:WordCloudView=binding_main.wordcloud

        val handler_1=object :Handler(Looper.getMainLooper()) {

            override fun handleMessage(msg: Message)
            {
                var s=currentTimeMillis().toString()
//                获取千位时间
                s=s.substring(random.nextInt(11))
                wordcloudview.addTextView(s,weight);
                if(--off==0)
                {
                    off=3;
                    if(weight>5)
                    {
                        weight--
                    }
                }
                sendEmptyMessageDelayed(0,1)
            }
        };
        handler_1.sendEmptyMessage(0)
    }
}