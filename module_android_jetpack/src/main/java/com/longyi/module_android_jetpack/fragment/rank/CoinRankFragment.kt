package com.longyi.module_android_jetpack.fragment.rank

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment

import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.coin_rank_fragment.*

class CoinRankFragment : Fragment() {

    companion object {
        fun newInstance() = CoinRankFragment()
    }

    private lateinit var viewModel: CoinRankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.coin_rank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoinRankViewModel::class.java)
        // TODO: Use the ViewModel
        btn_to_mine.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            if (navController.currentDestination?.id == R.id.coinRankFragment) {
                navController.navigate(R.id.action_1)
            }else{
                Log.e("222","=====onActivityCreated=======")
            }
        }
    }

}
