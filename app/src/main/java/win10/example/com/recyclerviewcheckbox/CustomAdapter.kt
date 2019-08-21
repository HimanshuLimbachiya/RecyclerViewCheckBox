package win10.example.com.recyclerviewcheckbox

import android.content.Context
import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

/**
 * Created by Abhin.
 */
class CustomAdapter(val mContext: Context, private val imageList: List<DataClass>, private val itemCheckListner : ItemChecked) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<AppCompatImageView>(R.id.img_ImageView)!!
        val checkBox = itemView.findViewById<AppCompatCheckBox>(R.id.checkbox)!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomAdapter.MyViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        Picasso.get().load(imageList[p1].imageUrl).into(p0.imageView)

        p0.checkBox.setOnCheckedChangeListener { _, isChecked ->
            itemCheckListner.checkBoxChecked(p1,isChecked)
        }
    }

    interface ItemChecked {
        fun checkBoxChecked(position: Int, isChecked: Boolean)
    }
}