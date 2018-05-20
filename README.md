#RecyclerView-in-Kotlin

#Creating a new Android Project with Kotlin in Android Studio.

#Add Dependencies in build.gradle file 

//picasso is an image loading/processing library
implementation 'com.squareup.picasso:picasso:2.71828'

//Retrofit Networking library
implementation "com.squareup.retrofit2:retrofit:2.3.0"

//Gson is a  library that can be used to convert Java Objects into their JSON representation
implementation "com.squareup.retrofit2:converter-gson:2.3.0" 

//RecyclerView
implementation 'com.android.support:recyclerview-v7:27.1.1'

    
#Adding User Interface in your main Layout file

<android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical"/>

#Create a single row item for your RecyclerView.

#Create a Model Class

data class MovieModel(
        @SerializedName("title")
        @Expose
        var title: String? = null,
        @SerializedName("image")
        @Expose
        var image: String? = null,
        @SerializedName("rating")
        @Expose
        var rating: Double? = null,
        @SerializedName("releaseYear")
        @Expose
        var releaseYear: Int? = null,
        @SerializedName("genre")
        @Expose
        var genre: List<String>? = null)

#Create a Adapter class

Here, I created a custom adapter name MovieAdapter with ViewHolder.

The Holder contains the members of the layout to bind viewItems.

Hear I used Picasso library for image loading.
Picasso.get().load(movieModel.image).into(itemView.imageView_movie)


#Creating RecyclerView And Set Data To Adapter Class

        
        var linearLayoutManager = LinearLayoutManager(this)
        var adapter = MovieAdapter(arrList)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        
        
   ![screenshot_20180520-152947](https://user-images.githubusercontent.com/39271929/40281068-09d97e92-5c7a-11e8-8df2-df00c1d3a88c.png)
        
