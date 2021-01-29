package com.example.testtask.ui.main

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.MainActivity
import com.example.testtask.R
import com.example.testtask.data.models.Civilization
import com.example.testtask.ui.adapters.CivilizationsListAdapter
import com.example.testtask.ui.global.BaseFragment
import com.example.testtask.ui.global.BaseViewModelFactory
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class ListFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory

    private lateinit var viewAdapter: CivilizationsListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val gridItemCount: Int = 2

    private var gutter: Int = 0

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun layoutRes(): Int {
        return R.layout.main_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        gutter = (resources.getDimension(R.dimen.images_gutter) / 2).toInt()

        if(!this::viewManager.isInitialized) {
            viewManager = GridLayoutManager(requireActivity(), gridItemCount)
        }

        if(!this::viewAdapter.isInitialized) {
            viewAdapter = CivilizationsListAdapter(requireActivity().applicationContext) { civilization: Civilization ->
                val bundle = Bundle()
                bundle.putSerializable("civilization", civilization)
                val fragment = DetailFragment.newInstance()
                fragment.arguments = bundle

                activity?.let {
                    it.supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCivilizations()
        viewModel.civilizationsList.observe(viewLifecycleOwner, {
            viewAdapter.setItems(it)
        })

        setListParameters()
    }

    /**
     * Apply necessary things to recycle view such as layout manager, adapter, styles, etc
     */
    private fun setListParameters() {
        civilization_list.apply {
            setHasFixedSize(true)

            if(layoutManager == null) {
                layoutManager = viewManager

                this.addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                    ) {
                        super.getItemOffsets(outRect, view, parent, state)

                        val position = parent.getChildAdapterPosition(view) // item position
                        val column: Int = position % gridItemCount // item column

                        outRect.bottom = (gutter) * 2

                        // First column doesn't have left padding
                        if (column != 0) {
                            outRect.left = (gutter)
                        }

                        // Last column doesn't nave right padding
                        if (column != (gridItemCount - 1)) {
                            outRect.right = (gutter)
                        }
                    }
                })
            }

            if(adapter == null || adapter!! != viewAdapter) {
                adapter = viewAdapter
            }
        }
    }



}