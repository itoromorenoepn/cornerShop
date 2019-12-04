package `is`.epn.cornershop

class Producto {
    var nombre: String? = null
    var image: Int? = null
    var descripcion: String? = null
    var precio: Double? = null

    constructor(nombre: String, image: Int,descripcion:String,precio:Double) {
        this.nombre = nombre
        this.image = image
        this.descripcion = descripcion
        this.precio = precio
    }

    fun getAllProducts():ArrayList<Producto>{
        val productos = ArrayList<Producto>()
        productos.add(Producto("Coca cola",R.drawable.canpepsi,"350ml",0.75))
        productos.add(Producto("Guitig",R.drawable.aguaguitig,"350ml",0.55))
        productos.add(Producto("7 UP",R.drawable.sevenup,"350ml",0.45))
        productos.add(Producto("Caffe",R.drawable.caffelatomocaccino,"350ml",0.95))
        return productos
    }
}