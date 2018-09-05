package frank.com.kotlinapp

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import frank.com.kotlinapp.bean.ItemBean
import frank.com.kotlinapp.bean.Person
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ThirdActivity : AppCompatActivity(), View.OnClickListener {
    private var list: ArrayList<ItemBean>? = null
    private var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        mContext = this
        initData()
    }

    private fun initData() {
        if (list == null) {
            list = ArrayList()
        }
        for (i in 0..9) {
            var itemBean = ItemBean("name" + i, i)
            list!!.add(itemBean)
        }
        list = null
        val adapter = ThirdAdapter()
        recycle!!.adapter = adapter
        recycle!!.layoutManager = LinearLayoutManager(this)

    }

    override fun onClick(v: View) {
        var y = 0
        for (i in 0..2) {
            y = if (i == 0) 1 else 3
        }
    }

    internal inner class ThirdAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val holder = ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_third, parent, false))
            return holder
        }

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is ViewHolder) {
                holder.tv_id.text = list?.get(position)?.id.toString()
                holder.tv_name.text = list?.get(position)?.name
                holder.itemView.background = resources.getDrawable(R.color.colorAccent)
            }
        }

        override fun getItemCount(): Int {
            return list?.size ?: 0
//            return if (list == null) 0 else list!!.size
        }

        internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            internal var tv_id: TextView = itemView.findViewById(R.id.tv_id)
            internal var tv_name: TextView = itemView.findViewById(R.id.tv_name)
        }
    }

}
