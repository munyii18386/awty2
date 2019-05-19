package edu.washington.lmburu.awty

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_toast.view.*


class ToastFragment : Fragment() {
    private  var callback:OnClick? = null

    interface OnClick{
        fun onClick()
    }

    companion object{
        fun newInstance(): ToastFragment{
            return ToastFragment()
        }
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as? OnClick
        if(callback == null){
            throw ClassCastException("$context must implement OnClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_toast, container, false)


        return rootView
    }



}
