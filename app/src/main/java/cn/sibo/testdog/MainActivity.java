package cn.sibo.testdog;



import com.wc.WatchDogNative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("==============apps===============");
    }

    boolean mFlag = false;
	ReadPackageThread rp;
	
	

	public class ReadPackageThread extends Thread {
		public void run() {
			super.run();
			WatchDogNative.opendev();
		}
	}
	
	
    

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mFlag = false;
		if (rp != null) {
			rp.interrupt();
			rp = null;
		}
		System.out.println("onDestroy");
	}

    
    public void openwc(View v){
    	   mFlag = true;
   		if (rp != null) {
   			rp.interrupt();
   			rp = null;
   		}
   		rp = new ReadPackageThread();
   		rp.start();
   		System.out.println("open");
    }
       
    
    public void closewc(View v){
    	WatchDogNative.closedev();
    }

    public void systemExit(View v){
		System.out.println("System exit 0");
		System.exit(0);
	}

	public void finishAct(View v){
		System.out.println("Activity Finish");
		this.finish();
	}
}
