package testing.mvp.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import testing.mvp.R;
import testing.mvp.application.App;
import testing.mvp.common.BaseActiviy;

import testing.mvp.di.component.DaggerMainComponent;
import testing.mvp.di.component.MainComponent;
import testing.mvp.di.module.MainModule;

public class MainActivity extends BaseActiviy implements MainView{

    private TextView mTextMessage;

    @Inject
    MainPresenter mainPresenter;

    MainComponent mainComponent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new MainFragment())
                        .commit();

                    return true;
                case R.id.navigation_dashboard:
                   mainPresenter.test();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void invoke() {
        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();
        mainComponent.inject(this);
        //Log.i("mainComponent", mainComponent.toString());
    }

    @Override
    public void getData() {
        mTextMessage.setText("getData");
    }
}
