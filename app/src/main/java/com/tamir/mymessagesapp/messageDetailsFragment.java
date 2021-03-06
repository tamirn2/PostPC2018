package com.tamir.mymessagesapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tamir.mymessagesapp.message.Message;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MessageDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MessageDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageDetailsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Message mMsg;

    public MessageDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MessageDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageDetailsFragment newInstance(Message msg) {
        MessageDetailsFragment fragment = new MessageDetailsFragment();
        fragment.mMsg = msg;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mRootView = inflater.inflate(R.layout.fragment_message_details,
                container, false);

        TextView mainText = mRootView.findViewById(R.id.message_details_fragment_main_text_view);
        mainText.setText(this.mMsg.toString());

        Button deleteMsgButton = mRootView.findViewById(R.id.message_details_fragment_delete_button);
        View.OnClickListener deleteListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mListener.deleteMessage(mMsg.getIndex());
            }
        };
        deleteMsgButton.setOnClickListener(deleteListener);

        Button shareMsgButton = mRootView.findViewById(R.id.message_details_fragment_share_button);
        View.OnClickListener shareListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mListener.shareMessage(mMsg.getShareString());
            }
        };
        shareMsgButton.setOnClickListener(shareListener);


        return mRootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        void deleteMessage(int index);
        void shareMessage(String msg);
    }
}
