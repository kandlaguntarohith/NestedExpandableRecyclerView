package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GiftCardRedeemSectionBinding

class RedeemSectionAdapter(
    private val redeemData: List<Redeem>,
    preExpandedViewPosition: Int = 1
) : RecyclerView.Adapter<RedeemSectionAdapter.RedeemSectionViewHolder>() {

    companion object {
        var expandedViewPosition = -1
    }

    init {
        expandedViewPosition = preExpandedViewPosition
    }

    class RedeemSectionViewHolder(
        private val binding: GiftCardRedeemSectionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            position: Int,
            redeemSection: Redeem,
            onClickCallBack: (index: Int) -> Unit
        ) {
            with(binding) {
                stepsRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
                stepsRecyclerView.adapter = RedeemStepsAdapter(redeemSteps = redeemSection.redeemSteps)
                sectionListDivider.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
                sectionHeader.text = redeemSection.sectionHeader
                val drawIcon =
                    if (expandedViewPosition == position) R.drawable.ic_up_arrow else R.drawable.ic_down_arrow
                sectionHeader.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawIcon, 0)
                stepsRecyclerView.visibility = if(position == expandedViewPosition) View.VISIBLE else View.GONE
            }
            binding.root.setOnClickListener {
//                binding.stepsRecyclerView.visibility = if( position == expandedViewPosition) View.GONE else View.VISIBLE
//                onClickCallBack(position)
                if (expandedViewPosition == position) {
                    expandedViewPosition = -1
                } else {
                    val currentExpandedItemPosition = expandedViewPosition
                    expandedViewPosition = position
                    if(currentExpandedItemPosition > -1)
                        onClickCallBack(currentExpandedItemPosition)
                }
                onClickCallBack(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedeemSectionViewHolder {
        val binding =
            GiftCardRedeemSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RedeemSectionViewHolder(binding)
    }

    override fun getItemCount() = redeemData.size

    override fun onBindViewHolder(holder: RedeemSectionViewHolder, position: Int) {
        holder.bind(position, redeemData[position]) { index: Int ->
            notifyItemChanged(index)
        }
    }
}