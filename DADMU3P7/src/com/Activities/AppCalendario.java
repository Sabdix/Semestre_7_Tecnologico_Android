
package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import java.util.Calendar;

/**
 *
 * @author sabdi
 */
public class AppCalendario extends Activity {
    CalendarView calView;

    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.app_calendario);
        
        calView = (CalendarView)findViewById(R.id.calView);
        Calendar cal = Calendar.getInstance();
        calView.setDate(cal.getTime().getTime());
        
               
    }
    
}
