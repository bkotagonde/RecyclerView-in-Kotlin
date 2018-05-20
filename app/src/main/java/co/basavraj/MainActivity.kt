package co.basavraj


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import co.basavraj.Adapter.MovieAdapter
import co.basavraj.Interface.CommonResponseListener
import co.basavraj.Model.MovieModel
import co.basavraj.Network.NetworkAccessor
import co.basavraj.Network.WebUrls
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(),CommonResponseListener
{
    private lateinit var arrList:Array<MovieModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMoviesData()
    }
    private fun getMoviesData() {
        var networkAccessor= NetworkAccessor()
         var jsoPayload = JSONObject()
         networkAccessor.commonNetworkCall(this@MainActivity,jsoPayload,this@MainActivity,WebUrls.BASE_URL,WebUrls.GET_MOVIES)
    }

    override fun onSuccessResponse(result: String, from: String, code: Int)
    {

            var gson = Gson()
            val movieModel = gson.fromJson(result, Array<MovieModel>::class.java)
            arrList = movieModel
            if (arrList.isNotEmpty()) {
                setDataToAdapter()
            }

    }
    override fun onError(msg: String, fromUrl: String) {
        println("Error Message:-$msg")
    }
    private fun setDataToAdapter()
    {
        var linearLayoutManager = LinearLayoutManager(this)
        var adapter = MovieAdapter(arrList)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}
