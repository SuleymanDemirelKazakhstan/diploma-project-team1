package com.example.diploma.ui.dashboard.vacancies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diploma.data.model.Vacancy
import com.example.diploma.databinding.ItemVacancyBinding


class VacanciesAdapter(
    private val listener: ClickListener
) : RecyclerView.Adapter<VacanciesAdapter.ViewHolder>() {

    var vacancies = mutableListOf<Vacancy?>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(vacancies: List<Vacancy?>) {
        this.vacancies = vacancies.toMutableList()
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(vacancy: Vacancy)
    }

    inner class ViewHolder(
        private val binding: ItemVacancyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(vacancy: Vacancy) = with(binding) {
            root.setOnClickListener {
                listener.onClick(vacancy)
            }

            vacancyTitle.text = vacancy.title
            companyName.text = vacancy.companyName
            vacancyDetail.text = "${vacancy.location} - ${vacancy.jobType}"
            salary.text = vacancy.final_salary.toString()

            Glide
                .with(vacancyImage.context)
                .load(vacancy.imageUrl)
                .centerCrop()
                .into(vacancyImage)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vacancy = vacancies[position]
        vacancy?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemVacancyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return vacancies.size
    }

}