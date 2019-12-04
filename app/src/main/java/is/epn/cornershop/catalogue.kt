package `is`.epn.cornershop

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_catalogue.*
import kotlinx.android.synthetic.main.content_catalogue.*
import kotlinx.android.synthetic.main.item_producto.view.*


class catalogue : AppCompatActivity() {
    var adapter: ProductoAdapter? = null
    var productsList = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)
        setSupportActionBar(toolbar)
        val categorias = resources.getStringArray(R.array.Categorias)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
            spinner.adapter = adapter
        }
        productsList.add(Producto("Coca Cola", R.drawable.aguaguitig,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.caffelatomocaccino,"coca cola 350ml",0.75))
        productsList.add(Producto("Agua", R.drawable.canpepsi,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.dasinisingaschico,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.sevenup,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.aguaguitig,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.caffelatomocaccino,"coca cola 350ml",0.75))
        productsList.add(Producto("Coffee", R.drawable.canpepsi,"coca cola 350ml",0.75))
        adapter = ProductoAdapter(this, productsList)

        gvProducts.adapter = adapter
        gvProducts.setOnItemClickListener{_,_,position,_ ->
            Toast.makeText(this,"posicion: $position",Toast.LENGTH_LONG).show()
            val newFragment = NumberPickerDialog()
            newFragment.show(supportFragmentManager, "agregar")
        }
        fab.setOnClickListener { view ->
            val intento2 = Intent(this, car_shop::class.java)
            startActivity(intento2)
        }
    }
    class ProductoAdapter(context: Context, var productosList: ArrayList<Producto>) :
        BaseAdapter() {
        var context: Context? = context

        override fun getCount(): Int {
            return productosList.size
        }

        override fun getItem(position: Int): Any {
            return productosList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val product = this.productosList[position]

            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val productView = inflator.inflate(R.layout.item_producto, null)
            productView.imgFood.setImageResource(product.image!!)
            productView.tvName.text = product.nombre!!

            return productView
        }
    }
    class NumberPickerDialog : DialogFragment() {
        var valueChangeListener: OnValueChangeListener? = null

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val numberPicker = NumberPicker(activity)
            numberPicker.minValue = 20
            numberPicker.maxValue = 60
            val builder =
                AlertDialog.Builder(activity)
            builder.setTitle("Producto")
            builder.setMessage("Cantidad :")
            builder.setPositiveButton(
                "OK"
            ) { dialog, which ->

            }
            builder.setNegativeButton(
                "CANCEL"
            ) { dialog, which ->

            }
            builder.setView(numberPicker)
            return builder.create()
        }

    }

}


