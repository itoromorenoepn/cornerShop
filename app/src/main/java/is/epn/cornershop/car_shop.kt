package `is`.epn.cornershop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_car_shop.*

class car_shop : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_shop)
        setSupportActionBar(toolbar)
        listView = findViewById(R.id.list_car_shop)

        val recipeList = Producto("",0,"",0.0).getAllProducts()
// 2
        val listItems = arrayOfNulls<String>(recipeList.size)
// 3
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.nombre
        }
// 4
        val adapter = RecipeAdapter(this,Producto("",0,"",0.0).getAllProducts())
        listView.adapter = adapter
        fab.setOnClickListener { view ->
            val intento2 = Intent(this, metod_pay::class.java)
            startActivity(intento2)
        }
    }
    class RecipeAdapter(private val context: Context,
                        private val dataSource: ArrayList<Producto>) : BaseAdapter() {

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //1
        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val rowView = inflater.inflate(R.layout.itemcarshop, parent, false)
            val titleTextView = rowView.findViewById(R.id.title_item) as TextView
            val detailTextView = rowView.findViewById(R.id.price_item_shop) as TextView
            val thumbnailImageView = rowView.findViewById(R.id.image_item_shop) as ImageView
            val recipe = getItem(position) as Producto
            titleTextView.text = recipe.nombre
            detailTextView.text = recipe.precio.toString()
            thumbnailImageView.setImageResource(recipe.image.hashCode())
            return rowView
        }
    }

}
