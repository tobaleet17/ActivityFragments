package prueba.prueba.crgomez.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment1 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText missatgeEnviem;
    private Button boto1;
    private Button boto2;
    private TextView missatgeRebutjat;

    private ComunicaFragment1AmbActivity mListener;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment1, container, false);

        missatgeEnviem = (EditText)v.findViewById(R.id.meterName);
        boto1 = (Button) v.findViewById(R.id.botonF1);
        boto2 = (Button) v.findViewById(R.id.botonF2);
        missatgeRebutjat = (TextView) v.findViewById(R.id.missatgeRebutjat);
        boto1.setOnClickListener(this);
        boto2.setOnClickListener(this);
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicaFragment1AmbActivity) {
            mListener = (ComunicaFragment1AmbActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ComunicaFragment1AmbActivity");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==boto1.getId()){

            mListener.enviaMissatgeActivity(1,missatgeEnviem.getText().toString());
        }else{
            mListener.enviaMissatgeActivity(2,missatgeEnviem.getText().toString());

        }
    }

    public void escribirMensaje(String msg){

       if (missatgeRebutjat.getText().length()==0){
           missatgeRebutjat.setText("REBUTJATS:"+"\n"+missatgeRebutjat.getText().toString()+msg);
       }else{

           missatgeRebutjat.setText(missatgeRebutjat.getText().toString()+msg);
       }




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
    public interface ComunicaFragment1AmbActivity {
        // TODO: Update argument type and name
        void enviaMissatgeActivity(int numBoto, String msg);
    }
}
