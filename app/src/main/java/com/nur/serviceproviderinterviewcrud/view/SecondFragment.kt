package com.nur.serviceproviderinterviewcrud.view

import UsersViewmodelFactory
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nur.serviceproviderinterviewcrud.R
import com.nur.serviceproviderinterviewcrud.adapters.UserAdapterInactive
import com.nur.serviceproviderinterviewcrud.adapters.UsersAdapter
import com.nur.serviceproviderinterviewcrud.api.ApiInterface
import com.nur.serviceproviderinterviewcrud.repository.UserRepository
import com.nur.serviceproviderinterviewcrud.viewmodel.UsersViewModel

class SecondFragment : Fragment() {




    private lateinit var viewModel: UsersViewModel
    private lateinit var factory: UsersViewmodelFactory
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.second_fragment, container, false)

        recyclerView = view.findViewById(R.id.recyclerviewfragment_inactive)

        recyclerView.layoutManager =  LinearLayoutManager(activity)

        return  view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = ApiInterface()
        val repo = UserRepository(api)
        factory = UsersViewmodelFactory(repo)
        viewModel = ViewModelProvider(this,factory).get(UsersViewModel::class.java)
        viewModel.getUsers()

        viewModel.users.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                Log.d("inside fragment", "onActivityCreated: user data found${it}")

                recyclerView.setAdapter(activity?.let { it1 ->
                    UserAdapterInactive(it,
                        it1.applicationContext)
                })
            }
        })
    }

}