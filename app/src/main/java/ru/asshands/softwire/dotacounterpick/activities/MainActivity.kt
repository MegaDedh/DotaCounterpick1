package ru.asshands.softwire.dotacounterpick.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import ru.asshands.softwire.dotacounterpick.R
import ru.asshands.softwire.dotacounterpick.adapters.HeroAdapter
import ru.asshands.softwire.domain.models.Hero
import ru.asshands.softwire.dotacounterpick.presenters.HeroListPresenter
import ru.asshands.softwire.dotacounterpick.views.HeroListView

class MainActivity : MvpAppCompatActivity(), HeroListView {

    private val mAdapter = HeroAdapter()
    @InjectPresenter
    lateinit var heroListPresenter: HeroListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()

        heroListPresenter.fetchHeroes()
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL, false)
        recyclerHeroList.layoutManager = layoutManager
        recyclerHeroList.adapter = mAdapter
    }

    //View implementation
    override fun presentHeroes(data: List<Hero>) {
        txtHeroListLoading.visibility = View.GONE
        recyclerHeroList.visibility = View.VISIBLE

        mAdapter.setData(data)
    }

    override fun presentLoading() {
        recyclerHeroList.visibility = View.GONE
        txtHeroListLoading.visibility = View.VISIBLE
    }

}
