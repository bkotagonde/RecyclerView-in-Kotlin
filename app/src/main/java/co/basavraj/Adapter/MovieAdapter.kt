package co.basavraj.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.basavraj.Model.MovieModel
import co.basavraj.R

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singlerow_layout_movie_details.view.*

class MovieAdapter(private val arrList: Array<MovieModel>) : RecyclerView.Adapter<CustomViewHolder>()
{

    override fun getItemCount()=arrList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val cellRow=layoutInflater.inflate(R.layout.singlerow_layout_movie_details,parent,false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int)
    {
            holder.bindItems(arrList[position])
    }
}
class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    fun bindItems(movieModel: MovieModel)
    {
        try {

            itemView.textView_title.text = "Name: "+movieModel.title
            itemView.textView_rating.text = "Ratings: " + movieModel.rating
            itemView.textView_action.text = movieModel.genre!![0]
            itemView.textView_time.text= movieModel.releaseYear.toString()

            Picasso.get().load(movieModel.image).into(itemView.imageView_movie)


            itemView.setOnClickListener({
                Toast.makeText(itemView.context, "Clicked Position $position", Toast.LENGTH_SHORT).show()
            })


        }catch (e:Exception){
            println(e.message)
        }
    }

}