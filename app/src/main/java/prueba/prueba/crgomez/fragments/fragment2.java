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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment2 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button rechazar;

    private TextView mostrarMissatge; //es ón mostrem el missatge
    private fragment2.ComunicaFragment2AmbActivity mListener;

    public fragment2() {
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
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
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

        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        mostrarMissatge= (TextView) v.findViewById(R.id.missatge2);
        rechazar=(Button) v.findViewById(R.id.Rechazar);
        rechazar.setOnClickListener(this);

        return v;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fragment2.ComunicaFragment2AmbActivity) {
            mListener = (fragment2.ComunicaFragment2AmbActivity) context;
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

    public void escriuMissatge(String msg){

        mostrarMissatge.setText(msg);

    }

    @Override
    public void onClick(View v) {



            mListener.enviaMissatgeActivity2(this.getId(),mostrarMissatge.getText().toString());
            mostrarMissatge.setText("");





    }


    public interface ComunicaFragment2AmbActivity {
        // TODO: Update argument type and name
        void enviaMissatgeActivity2(int numFragment,String msg);
    }
}
