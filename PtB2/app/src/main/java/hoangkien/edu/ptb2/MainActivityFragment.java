package hoangkien.edu.ptb2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityFragment extends Fragment {
    private EditText et_a;
    private EditText et_b;
    private EditText et_c;
    private Button btn_tinh;
    private TextView tv_x1;
    private TextView tv_x2;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        this.et_a=(EditText) getView().findViewById(R.id.et_a);
        this.et_b=(EditText) getView().findViewById(R.id.et_b);
        this.et_c=(EditText) getView().findViewById(R.id.et_c);
        this.btn_tinh=(Button) getView().findViewById(R.id.btn_tinh);
        this.tv_x1=(TextView) getView().findViewById(R.id.tv_x1);
        this.tv_x2=(TextView) getView().findViewById(R.id.tv_x2);
        btn_tinh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Pt pt=new Pt(Float.parseFloat(et_a.getText().toString()),
                        Float.parseFloat(et_b.getText().toString()),
                        Float.parseFloat(et_c.getText().toString()));
                tv_x1.setText(pt.getX1());
                tv_x2.setText(pt.getX2());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
class Pt{
    private float a,b,c,d;
    private String x1,x2;

    public String getX1(){
        return x1;
    }
    public String getX2(){
        return x2;
    }

    Pt(float ai,float bi,float ci){
        this.a=ai;
        this.b=bi;
        this.c=ci;
        d=b*b-4*a*c;
        if(d<0){
            float r=-b/(2*a);
            double i= Math.sqrt(-d)/(2*a);
            x1=String.valueOf(r)+" + "+String.valueOf(i)+"i";
            x2=String.valueOf(r)+" - "+String.valueOf(i)+"i";
        }else if(d==0){
            float r=-b/(2*a);
            x1=x2=String.valueOf(r);
        }else if(d>0){
            float r=-b/(2*a);
            double i=Math.sqrt(d)/(2*a);
            x1=String.valueOf(r+i);
            x2=String.valueOf(r-i);
        }
    }
}