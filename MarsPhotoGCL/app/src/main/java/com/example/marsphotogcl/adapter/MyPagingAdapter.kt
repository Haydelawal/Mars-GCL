package com.example.marsphotogcl.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import  com.example.marsphotogcl.adapter.MyPagingAdapter.MyViewHolder
import com.example.marsphotogcl.databinding.MyLayoutBinding
import com.example.marsphotogcl.model.MarsResponseItem


class MyPagingAdapter : PagingDataAdapter<MarsResponseItem, MyViewHolder>(diffCallBack) {

    inner class MyViewHolder( val binding: MyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<MarsResponseItem>() {
            override fun areItemsTheSame(oldItem: MarsResponseItem, newItem: MarsResponseItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MarsResponseItem, newItem: MarsResponseItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            textView.text = currentItem?.id

            val imageLink = currentItem?.imgSrc

            imageView.load(imageLink){
                crossfade(true)
                crossfade(1000)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MyLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}