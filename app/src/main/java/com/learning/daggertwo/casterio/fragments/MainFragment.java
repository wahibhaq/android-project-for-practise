package com.learning.daggertwo.casterio.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.models.Country;
import com.learning.daggertwo.casterio.network.PopulationCountListener;
import com.learning.daggertwo.casterio.network.RestCountryService;

import javax.inject.Inject;

import eu.restcountries.models.CountryInfo;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnFragmentInteractionListener mListener;

    private static final String TAG = MainFragment.class.getSimpleName();

    @Inject
    RestCountryService restCountryService;

    private TextView mTxtTitle;

    private Realm realm;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TaskoApplication.get(getActivity()).getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTxtTitle = (TextView) view.findViewById(R.id.txt_title);
        realm = Realm.getDefaultInstance();

        performFetchingData();
    }

    private void performFetchingData() {
        final String countryName = "Pakistan";
        restCountryService.getPopulatationCountFor(countryName, new PopulationCountListener() {
            @Override
            public void onPopulationCountLoaded(CountryInfo countryInfo) {

                if (countryInfo != null && countryInfo.getPopulation() != null) {
                    int populationCount = countryInfo.getPopulation();
                    mTxtTitle.setText("Population of " + countryName + " is : " + populationCount);
//                    Log.d(TAG, "Country Population : " + populationCount);

                    //Adding data but not retrieving for now.
                    realm.beginTransaction();
                    Country country = realm.createObject(Country.class);
                    country.setName(countryName);
                    country.setPopulationCount(populationCount);
                    realm.commitTransaction();

                }
            }

            @Override
            public void onPopulationCountFailed(Throwable e) {
                Log.d(TAG, "Country info failed : " + e.getMessage());
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        realm.close();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
