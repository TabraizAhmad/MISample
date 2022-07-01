package com.mobileinteraction.sampleapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mobileinteraction.sampleapp.R
import com.mobileinteraction.sampleapp.databinding.FragmentHomeBinding
import com.mobileinteraction.sampleapp.network.model.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val args by navArgs<HomeFragmentArgs>()


    val viewModel: HomeFragmentViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding = FragmentHomeBinding.bind(view)
        val user = args.loggedUser
        _binding?.apply {
            tvName.text = user.displayName
        }
        viewModel.articleResponse?.observe(viewLifecycleOwner) { response->
            when (response) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    _binding?.imageView?.let { iView ->
                        Glide.with(iView)
                            .asGif()
                            .load(response.result?.data?.images?.previewGif?.url)
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(iView)
                    }
                }
            }

        }

    }

}