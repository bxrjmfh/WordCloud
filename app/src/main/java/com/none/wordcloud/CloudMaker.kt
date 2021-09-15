package com.none.wordcloud

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.none.wordcloud.databinding.ActivityCloudMaker2Binding

import java.lang.System.currentTimeMillis
import java.util.*

class CloudMaker : AppCompatActivity()
{
    var temps =LinkedList<String>()
    var weight=30
    var off=5
    var order=0

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cloud_maker2)
        val binding_cloudmaker=ActivityCloudMaker2Binding.inflate(layoutInflater)
        setContentView(binding_cloudmaker.root)

        val editor_0=getSharedPreferences("excuse_data", Context.MODE_PRIVATE)
//        获取editor
        val temp_map=editor_0.all
        for(temp in temp_map)
        {
//            Log.d("alo","is :"+temp.toString())
            temps.add(reformat(temp.toString()))
            Log.d("lo","temps.add(temp.toString())")
        }
        order=temps.size
        val wordcloudview:WordCloudView=binding_cloudmaker.wordcloud
        Log.d("lo","val wordcloudview:WordCloudView=binding_cloudmaker.wordcloud")
        val handler_1=object : Handler(Looper.getMainLooper()) {

            override fun handleMessage(msg: Message)
            {
                Log.d("lo","var s= "+order)
                var s= temps[order-1]
               if(order>1)
               {
                   order--
                   Log.d("lo",""+order)
               }
                else
               {
                   order=temps.size
                   Log.d("lo","order="+temps.size)
               }
                wordcloudview.addTextView(s,weight);
                Log.d("lo","wordcloudview.addTextView(s,weight);")
                if(--off==0)
                {
                    off=3;
                    Log.d("lo","off=3;")
                    if(weight>5)
                    {
                        weight--
                        Log.d("lo","weight--")
                    }
                }
                sendEmptyMessageDelayed(0,1)
                Log.d("lo","sendEmptyMessageDelayed(0,1)")
            }
        };
        handler_1.sendEmptyMessage(0)
        Log.d("lo","handler_1.sendEmptyMessage(0)")
    }

    private fun reformat(toString: String): String
    {
        var i=0
        while (toString[i]!=='=')
            i++

        Log.d("lo",toString.substring(i))
        return toString.substring(i+1)
    }
}