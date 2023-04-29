package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GiftCardRedeemStepBinding

class RedeemStepsAdapter(private val redeemSteps: List<String>) : RecyclerView.Adapter<RedeemStepsAdapter.RedeemStepsViewHolder>() {

    class RedeemStepsViewHolder(
        private val binding: GiftCardRedeemStepBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, redeemStep: String, isFirstStep: Boolean, isLastStep: Boolean) {
            with(binding) {
                if (isFirstStep) {
                    stepDividerTop.visibility = View.GONE
                }
                if (isLastStep) {
                    stepDividerBottom.visibility = View.GONE
                }

                stepCount.text = position.toString()
                stepText.text = redeemStep
            }
        }

        companion object {
            fun from(parent: ViewGroup): RedeemStepsViewHolder {
                val binding = GiftCardRedeemStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return RedeemStepsViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RedeemStepsViewHolder.from(parent)

    override fun onBindViewHolder(holder: RedeemStepsViewHolder, position: Int) = holder.bind(position + 1, redeemSteps[position], position == 0, position == redeemSteps.lastIndex)

    override fun getItemCount() = redeemSteps.size

}