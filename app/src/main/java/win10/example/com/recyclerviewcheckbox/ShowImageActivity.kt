package win10.example.com.recyclerviewcheckbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_image.*
import java.io.File

class ShowImageActivity : AppCompatActivity() {

    private var adapter: CustomAdapter? = null
    var list = ArrayList<DataClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)

        list.clear()
        post_list_show.layoutManager = GridLayoutManager(this, 2)
        val checkItemListener = object : CustomAdapter.ItemChecked {
            override fun checkBoxChecked(position: Int, isChecked: Boolean) {
                list[position].checked = isChecked
            }
        }
        list = getArrayList(intent.getStringExtra("list"))
        val list2=ArrayList<DataClass>()
        for ((i,e) in list.withIndex())
        {
            if (list[i].checked)
            {
                list2.add(list[i])
            }
        }

        if (list2.isNotEmpty()) {
            adapter = CustomAdapter(this, list2, checkItemListener)
            post_list_show.adapter = adapter
        }
    }

    private fun getArrayList(json: String): ArrayList<DataClass> {
        val type = object : TypeToken<ArrayList<DataClass>>() {}.type
        var teamDataList: ArrayList<DataClass> = ArrayList()
        teamDataList = Gson().fromJson(json, type)
        return teamDataList
    }
}
