package hoangkien.com.phtrb2;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // Variables widgets
    private EditText et_a;
    private EditText et_b;
    private EditText et_c;
    private Button btn_calc;
    private TextView tv_x1_calc;
    private TextView tv_x2_calc;
    //End of Variables widgets

    /**
     * Interface to links Fragment
     */
    public interface OnProcess{
        void process(double a,double b,double c);
        String getx1();
        String getx2();
    }
    private OnProcess mOnProcess;
    /**
     * Init widgets with variables
     * @param v
     */
    private void initUI(View v){
        this.et_a=(EditText) v.findViewById(R.id.et_a);
        this.et_b=(EditText) v.findViewById(R.id.et_b);
        this.et_c=(EditText) v.findViewById(R.id.et_c);
        this.btn_calc=(Button) v.findViewById(R.id.btn_calc);
        this.tv_x1_calc=(TextView) v.findViewById(R.id.tv_x1_calc);
        this.tv_x2_calc=(TextView) v.findViewById(R.id.tv_x2_calc);
    }
    //End of initUI

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        initUI(view);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnProcess.process(Double.valueOf(et_a.getText().toString()),
                        Double.valueOf(et_b.getText().toString()),
                        Double.valueOf(et_c.getText().toString()));
                tv_x1_calc.setText(mOnProcess.getx1());
                tv_x2_calc.setText(mOnProcess.getx2());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        mOnProcess=(OnProcess) activity;
        super.onAttach(activity);
    }
}
