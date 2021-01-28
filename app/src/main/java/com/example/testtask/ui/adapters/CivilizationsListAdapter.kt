package com.example.testtask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.data.models.Civilization
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.civilization_grid_item.view.*


class CivilizationsListAdapter(
    private val context: Context,
    private val clickEvent: (Civilization) -> Unit
) : RecyclerView.Adapter<CivilizationsListAdapter.CivilizationViewHolder>() {
    private var civilizations: List<Civilization> = listOf()

    fun setItems(items: List<Civilization>) {
        if(items == civilizations) {
            return
        }
        val mediaSize = civilizations.size
        civilizations = items

        if(mediaSize == 0) {
            notifyDataSetChanged()
            return
        }

        val countDiff = items.size - mediaSize

        when {
            countDiff > 1 -> notifyItemRangeInserted(civilizations.size - 1, countDiff)
            countDiff == 1 -> notifyItemInserted(civilizations.size - 1)
            else -> notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CivilizationViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.civilization_grid_item, parent, false)
        return CivilizationViewHolder(view, viewType)
    }

//    override fun getItemViewType(position: Int): Int {
//        return civilizations[position].type
//    }

    override fun getItemCount(): Int = civilizations.size

    override fun onBindViewHolder(holder: CivilizationViewHolder, position: Int) = holder.bind(civilizations[position], clickEvent)

    inner class CivilizationViewHolder(private val mView: View, val viewType: Int) : RecyclerView.ViewHolder(mView) {
        private val mImageView: ImageView = mView.image_civilization
        private val mTextView: TextView = mView.name_civilization

        fun bind(item: Civilization, clickEvent: (Civilization) -> Unit) {
            Picasso.Builder(context).build().load(R.drawable.poster)
                .fit()
                .placeholder(R.drawable.ic_image_placeholder)
                .error(R.drawable.ic_image_placeholder)
                .into(mImageView)

            mTextView.text = item.name

            mView.setOnClickListener {
                clickEvent(item)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(civilization: Civilization)
}