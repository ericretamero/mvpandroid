package testing.mvp.application;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eretamero on 18/05/2017.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    Context provideContext(){
        return app.getApplicationContext();
    };
}
