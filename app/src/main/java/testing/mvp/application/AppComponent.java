package testing.mvp.application;

import android.content.Context;

import dagger.Component;

/**
 * Created by eretamero on 18/05/2017.
 */
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {

    Context provideContext();
}
