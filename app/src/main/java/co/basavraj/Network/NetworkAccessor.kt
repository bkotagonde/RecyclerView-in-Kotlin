package co.basavraj.Network

import android.content.Context
import android.util.Log
import co.basavraj.Interface.CommonResponseListener
import com.google.gson.JsonElement
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkAccessor
{
        private val TAG = "NetworkAccessor"
        fun commonNetworkCall(listener: CommonResponseListener, requestdata: JSONObject, context: Context, baseUrl: String, fromUrl: String) {

            //retrofit client
            val okHttpClient = OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            // prepare call in Retrofit 2.0
            val retroUrlApi = retrofit.create(RetrofitApi::class.java)
            //Prepare empty
            var call: Call<JsonElement>? = null

            call = retroUrlApi.getMovies()

            call.enqueue(object : Callback<JsonElement> {
                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                        listener.onSuccessResponse(response.body().toString(), fromUrl, response.code())
                        println("Result:-"+response.body().toString())
                }
                override fun onFailure(call: Call<JsonElement>, t: Throwable)
                {
                    Log.e(TAG, "" + t)
                    listener.onError("Error", fromUrl)
                }
            })
         }
      }