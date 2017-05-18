package testing.mvp.ui.main;

import testing.mvp.domain.usecase.FirstUseCaseImpl;
import testing.mvp.model.Sample;

/**
 * Created by eretamero on 09/05/2017.
 */

public class MainPresenter {

    private FirstUseCaseImpl firstUseCaseImpl;
    private MainView mainView;

    public MainPresenter(MainView mainView, FirstUseCaseImpl firstUseCaseImpl) {
        this.firstUseCaseImpl = firstUseCaseImpl;
        this.mainView = mainView;
    }

    public void test(){
        mainView.getData();
    }

    public Sample getData(){
        this.firstUseCaseImpl.getData();
        return null;
    }
}
