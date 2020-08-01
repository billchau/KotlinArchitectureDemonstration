package com.gamerbill.kotlinarchitecturedemo.demolibrary.client

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_client_dashboard.*
import javax.inject.Inject

class ClientDashboardFragment : Fragment(), ClientDashboardContract.View {
    @Inject
    lateinit var presenter: ClientDashboardContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_client_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView() {
        presenter.getClients()
    }

    override fun updateResult(client: List<Client>) {
        setupClientAdapter(client)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun loginResult(result: String) {
        Toast.makeText(activity, result, Toast.LENGTH_SHORT).show()
    }

    private fun setupClientAdapter (client: List<Client>) {
        listView.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = ClientAdapter(client.toTypedArray()) { position ->
                presenter.login(client[position])
            }
        }
    }

    inner class ClientAdapter(private val item: Array<Client>, private val itemClick: (Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ClientViewHolder(LayoutInflater.from(context).inflate(R.layout.item_client, parent, false))

        override fun getItemCount() = item.size

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as? ClientViewHolder)?.bindView(item[position])
        }

        inner class ClientViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bindView(item: Client) {
                val tvFullName = itemView.findViewById<TextView>(R.id.tvFullName)
                val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
                tvFullName.text = item.fullName
                tvEmail.text = item.email
                itemView.setOnClickListener {
                    itemClick(adapterPosition)
                }
            }
        }
    }

    companion object {
        fun newInstance() = ClientDashboardFragment()
    }
}