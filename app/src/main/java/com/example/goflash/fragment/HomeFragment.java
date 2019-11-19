package com.example.goflash.fragment;

import android.app.AlarmManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.goflash.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POSITION = "position";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int position;
    private Context act;
    private MyPagerAdapter adapter;
    private Handler handler;
    private int currentItem;
    private int NUM_PAGES;
    private Runnable update;
    private int currentPage = 0;
    private String level = "";
    private AlarmManager manager;
//    private DataBaseHandler db;
//    private SendShareLocation mTask;
    private LocationManager locationManager;
    private GetRekapLW321 mTaskGetRekap = null;
    private GetListRealisasi mTaskGetRealisasi = null;

    @Bind(R.id.view_pager) ViewPager pager;
//    @Bind(R.id.layout_pager) LinearLayout layout_pager;
    @Bind(R.id.head_layout) RelativeLayout head_layout;

    @Bind(R.id.prev)
    TextView prev;
    @Bind(R.id.pos) TextView pos;
    @Bind(R.id.next) TextView next;
//    @Bind(R.id.btn_pemasaran) LinearLayout btn_pemasaran;
//    @Bind(R.id.btn_prakarsa) LinearLayout btn_prakarsa;
//    @Bind(R.id.btn_pembinaan) LinearLayout btn_pembinaan;
//    @Bind(R.id.btn_penagihan) LinearLayout btn_penagihan;
//    @Bind(R.id.btn_pengelolaan_agunan) LinearLayout btn_pengelolaan_agunan;
//    @Bind(R.id.btn_restrukturisasi) LinearLayout btn_restrukturisasi;
//    @Bind(R.id.btn_maps) LinearLayout btn_maps;
//    @Bind(R.id.btn_akad_kredit) LinearLayout btn_akad_kredit;
//    @Bind(R.id.btn_lainnya) LinearLayout btn_lainnya;
//    @Bind(R.id.btn_monitoring) LinearLayout btn_monitoring;
//
//    @Bind(R.id.ll_saleskit) LinearLayout ll_saleskit;
//    @Bind(R.id.ll_reporting) LinearLayout ll_reporting;
//    @Bind(R.id.view_custom_progress_dialog_home) LinearLayout view_custom_progress_dialog_home;
//    @Bind(R.id.id_linear_layout_get_rekap) LinearLayout id_linear_layout_get_rekap;
//    @Bind(R.id.view_custom_progress_dialog_home_nonconnect) LinearLayout view_custom_progress_dialog_home_nonconnect;
//
//    @Bind(R.id.id_txt_total_os) TextView id_txt_total_os;
//    @Bind(R.id.id_txt_npl) TextView id_txt_npl;
//    @Bind(R.id.id_txt_dpk) TextView id_txt_dpk;
//    @Bind(R.id.id_txt_realisasi) TextView id_txt_realisasi;
//
//    @Bind(R.id.id_txt_total_os_deb) TextView id_txt_total_os_deb;
//    @Bind(R.id.id_txt_npl_deb) TextView id_txt_npl_deb;
//    @Bind(R.id.id_txt_realisasi_deb) TextView id_txt_realisasi_deb;
//
//    @Bind(R.id.id_npl_persen) TextView id_npl_persen;
//    @Bind(R.id.id_dpk_persen) TextView id_dpk_persen;
//
//    @Bind(R.id.text_realisasi) TextView text_realisasi;
//    @Bind(R.id.btn_pick_up_trx) LinearLayout btn_pick_up_trx;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(int position) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        act = rootView.getContext();
//        db = new DataBaseHandler(act);
//        db = new DataBaseHandler(getActivity());
//        sess = new SessionUser(getActivity());
//        level = sess.getString("level_user");
        adapter = new MyPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(currentItem);
        setNavigator();
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) { }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) { }
            @Override
            public void onPageScrollStateChanged(int position) { setNavigator();}
        });
        head_layout.setVisibility(View.GONE);
        prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() != 0) {
                    pager.setCurrentItem(pager.getCurrentItem() - 1);
                } else {
                    pager.setCurrentItem(pager.getAdapter().getCount());
                }
                setNavigator();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (pager.getCurrentItem() != (pager.getAdapter().getCount() - 1)) {
                    pager.setCurrentItem(pager.getCurrentItem() + 1);
                } else {
                    pager.setCurrentItem(0);
                }
                setNavigator();
            }
        });
        handler = new Handler();
        NUM_PAGES = (pager.getAdapter().getCount());
        update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = -1;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        return rootView;
    }

    public void setNavigator() {
        String navigation = "";
        for (int i = 0; i < adapter.getCount(); i++) {
            if (i == pager.getCurrentItem()) {
                navigation += getActivity().getString(R.string.material_point_full)
                        + "  ";
            } else {
                navigation += getActivity().getString(R.string.material_point_blank)
                        + "  ";
            }
        }
        pos.setText(navigation);
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fg = null;
            switch(position) {
                case 0 :
                    fg = SlideFragment.newInstance(position);
                    break;
                case 1 :
                    fg = SlideFragment.newInstance(position);
                    break;
                case 2 :
                    fg = SlideFragment.newInstance(position);
                    break;
                case 3 :
                    fg = SlideFragment.newInstance(position);
                    break;
                default :
                    fg = SlideFragment.newInstance(position);
                    break;
            }

            return fg;
        }
    }

    private class GetRekapLW321 {
    }

    private class GetListRealisasi {
    }
}
