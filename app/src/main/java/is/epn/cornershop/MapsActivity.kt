package `is`.epn.cornershop

import android.os.Bundle
import android.support.v4.app.FragmentActivity


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener,
    GoogleMap.OnMarkerDragListener {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps3)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //clic sobre el mapa
        mMap!!.setOnMapClickListener(this)

        //evento
        mMap!!.setOnMarkerDragListener(this)


        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-0.212698, -78.487963)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("MiniMarket Floresta"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap!!.mapType = GoogleMap.MAP_TYPE_SATELLITE
    }


    override fun onMapClick(latLng: LatLng) {
        mMap!!.addMarker(
            MarkerOptions().position(latLng).title("Nuevo Marcador").draggable(true)
        )
    }

    override fun onMarkerDragStart(marker: Marker) {

    }

    override fun onMarkerDrag(marker: Marker) {

    }

    override fun onMarkerDragEnd(marker: Marker) {
        // establecer aqui el intent +++++++++++++++++++++++++++++++++++++++++++++++++++
    }
}

