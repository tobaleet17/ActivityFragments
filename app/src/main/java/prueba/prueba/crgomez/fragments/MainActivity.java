package prueba.prueba.crgomez.fragments;


import android.net.Uri;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ComunicaFragment1AmbActivity, fragment2.ComunicaFragment2AmbActivity{

    Fragment1 f1;
    fragment2 f2,f3;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        f1 = (Fragment1) fm.findFragmentById(R.id.fragment1);
        f2 = (fragment2) fm.findFragmentById(R.id.fragment2);
        f3 = (fragment2) fm.findFragmentById(R.id.fragment3);
        //f1=(Fragment1) findViewById(R.id.fragment1);
    }




    @Override
    public void enviaMissatgeActivity(int numBoto, String msg) {

        if (numBoto==1){

            f2.escriuMissatge(msg);


        }
        if (numBoto==2){

            f3.escriuMissatge(msg);
        }

    }

    @Override
    public void enviaMissatgeActivity2(int numFragment, String msg) {

        if (f2.getId()==numFragment){


            f1.escribirMensaje("F2: "+msg+"\n");

        }
        if (f3.getId()==numFragment){


            f1.escribirMensaje("F3: "+msg+"\n");

        }



    }
}
