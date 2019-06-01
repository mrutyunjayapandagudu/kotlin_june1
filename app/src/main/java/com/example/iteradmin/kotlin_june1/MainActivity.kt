package com.example.iteradmin.kotlin_june1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list=findViewById<ListView>(R.id.listview)
        val names= arrayOf("iron_man","Captain America","Thor","Hulk","Black Widow","Barton","ant man")
        val real_name= arrayOf("Robert Downy jr","Ress evens","Grass M Stone","mark proof","Scar Joo","Hawk eye","Scott lyn")
        val images= arrayOf(R.drawable.iron_man,R.drawable.captain_america,R.drawable.thor,R.drawable.hulk,R.drawable.black_widow,R.drawable.barton,R.drawable.ant_man)
        list.adapter=MyAdpter(this,names,real_name,images)

    }
    class MyAdpter(context:Context,names:Array<String>,real_name:Array<String>,images:Array<Int>):BaseAdapter(){
        private val mContext:Context
        private val names:Array<String>
        private val real_name:Array<String>
        private val images:Array<Int>
        init{
            mContext=context
            this.names=names
            this.real_name=real_name
            this.images=images
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layout:LayoutInflater=
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootview=layout.inflate(R.layout.resource,null,true)
            val im=rootview.findViewById<ImageView>(R.id.icon)
            val tt=rootview.findViewById<TextView>(R.id.name)
            val tt1=rootview.findViewById<TextView>(R.id.real_name)
            im.setImageResource(images[position])
            tt.text=names[position]
            tt1.text=real_name[position]
            im.setOnClickListener(){
                Toast.makeText(mContext,names[position],Toast.LENGTH_LONG).show()
            }
            return rootview
        }

        override fun getItem(position: Int): Any {
            return "any"
             }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }

    }
}
