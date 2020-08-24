package com.miharu.designpatterncomparison

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miharu.designpatterncomparison.databinding.ItemFlowerBinding
import com.miharu.designpatterncomparison.model.Flower

class FlowerAdapter(val context : Context) : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    private var _flowerList = listOf<Flower>()
    private val flowerList = _flowerList
    private var listener : ((Flower) -> Unit?)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val binding = ItemFlowerBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return FlowerViewHolder(binding, adapter = this)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.setItemData(flowerList[position])
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    fun setFlowerList(flowerList : List<Flower>) {
        this._flowerList = flowerList
    }

    fun setOnFlowerClick(listener : (Flower) -> Unit) {
        this.listener = listener
    }


    inner class FlowerViewHolder(private val binding: ItemFlowerBinding,val adapter: FlowerAdapter)
        : RecyclerView.ViewHolder(binding.root){

        private var flowerItem : Flower? = null

        init {
            flowerItem?.let { flower ->
                itemView.setOnClickListener {
                    listener?.invoke(flower)
                }
            }
        }

        fun setItemData(data : Flower){
            flowerItem = data

            Glide.with(context)
                .load(flowerItem?.url)
                .into(binding.flowerImageView)
        }
    }

}
