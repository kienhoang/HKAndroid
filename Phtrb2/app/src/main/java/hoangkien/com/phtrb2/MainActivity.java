package hoangkien.com.phtrb2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.*;


public class MainActivity extends ActionBarActivity  implements MainActivityFragment.OnProcess{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private String x1;
    private String x2;
    /**
     * Process calc
     */
    @Override
    public void process(double a,double b,double c) {
        //Pt pt=new Pt(a,b,c);
        //x1=pt.getx1();
        //x2=pt.getx2();
        double d =b * b - 4 * a * c;
        double i;
        double r;
        if(a==0) {
            if (b == 0){
                if (c==0){
                    x1=x2="";
                    Toast.makeText(this,"Phương trình vô số nghiệm",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Phương trình vô nghiệm",Toast.LENGTH_LONG).show();
                }
            }else {
                x1=String.valueOf(-c/b);
                x2="";
            }
        }else {
            if(d >0){
                r =-b/(2*a);
                i =(Math.sqrt(d))/(2*a);
                x1=String.valueOf(r + i);
                x2=String.valueOf(r - i);

            }else if(d ==0){
                r =-b/(2*a);
                x1=x2=String.valueOf(r);
            }else {
                r=-b/(2*a);
                i= Math.sqrt(-d)/(2*a);
                x1=String.valueOf(r)+" + "+String.valueOf(i)+"i";
                x2=String.valueOf(r)+" - "+String.valueOf(i)+"i";
            }
        }
    }

    @Override
    public String getx1() {
        return x1;
    }

    @Override
    public String getx2() {
        return x2;
    }
}
/*class Pt{
    private String x1,x2;
    public String getx1(){
        return x1;
    }
    public String getx2(){
        return x2;
    }

    Pt(double a,double b, double c){

    }
}*/