package win10.example.com.recyclerviewcheckbox

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val imageList = arrayListOf("https://techviral.net/wp-content/uploads/2016/03/HD-GAMES.png",
            "https://wallpapersite.com/images/pages/pic_w/1333.jpg",
            "https://stmed.net/sites/default/files/pc-gaming-hd-wallpapers-33488-4650955.jpg",
            "https://wallpapersite.com/images/pages/ico_n/16808.jpg",
            "https://freedomapkdownload.online/wp-content/uploads/2018/08/Freedom-Game-List-Over-250-Hackable-Android-Games-and-Apps.jpg",
            "https://cdn.allwallpaper.in/wallpapers/1920x1080/4320/deadpool-game-1920x1080-wallpaper.jpg",
            "https://c1.staticflickr.com/5/4049/4499462704_4f24d270ae_b.jpg",
            "http://a2zhdimages.com/wp-content/uploads/2018/09/Top-Most-Popular-PUBG-Game-HD-Wallpapers.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3gxIc2TXZdY-8uhhyyx7AneNlYg9nLn1VeihY4bjB3eYnINJxHA",
            "https://stmed.net/sites/default/files/tom-clancy%27s-rainbow-six%3A-siege-hd-wallpapers-33829-3217052.jpg")


    var list= ArrayList<DataClass>()
    private var adapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list!!.clear()
        for ((i, e) in imageList.withIndex()) {
            list!!.add(DataClass(imageList[i]))
        }
        post_list.layoutManager = GridLayoutManager(this, 2)

        val checkItemListener = object : CustomAdapter.ItemChecked{
            override fun checkBoxChecked(position: Int, isChecked: Boolean) {
                list[position].checked=isChecked
            }
        }

        adapter = CustomAdapter(this, list!!,checkItemListener)
        post_list.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            R.id.menu_next->{
                val intent = Intent(this,ShowImageActivity::class.java)
                intent.putExtra("list",Gson().toJson(list))
                startActivity(intent)
            }
        }
        return true
    }
}

