package com.example.drawsoftware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //保存抽奖名单
    var names= listOf<String>("张三","李四","老王")
    //设置定时器
    lateinit var timer: Timer
    //记录索引
    var index=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        //设置默认显示第一个人
        mNameTextView.text=names[0]

        //给按钮添加点击事件
        mStartButton.setOnClickListener{
            //判断标题是start还是stop
            if(mStartButton.text.toString()=="Strat")  {
            mStartButton.text="Stop"
                //创建定时器
                timer= Timer()
                timer.schedule(object:TimerTask(){
                    override fun run() {
                        //判断是否越界
                       index=if(index+1>names.size-1) 0 else index++
                        //取出对应名字
                        mNameTextView.text=names[index]


                    }

                },0,100)
            }else{
                mStartButton.text="Strat"
                timer.cancel()
            }
        }
    }
}